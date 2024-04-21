package com.myorg.data.io

import com.myorg.data.domain.Data
import com.myorg.data.domain.Data.DataPath
import com.myorg.data.error.{IOError, IOFailure}
import org.apache.spark.sql.{DataFrame, SparkSession}

import scala.util.{Failure, Success, Try}

case class SparkWriterAdapter(sparkSession: SparkSession){
  def write(data: Data, df: DataFrame, givenDate: String, dateFormat: String): Either[IOError, DataPath] = {
    val writeOptions = data.dataSource.writeOptions match {
      case None           => Map.empty[String, String]
      case Some(readOpts) => readOpts
    }
    val dataPath = data.getDataPath(givenDate, dateFormat)
    Try(
      df
        .write
        .format(data.dataSource.sourceFormat)
        .options(writeOptions)
        .save(dataPath)
    ) match {
      case Success(_) => Right(dataPath)
      case Failure(exception: Exception) => Left(IOFailure(exception))
      case Failure(exception)            => throw exception
    }
  }
}
