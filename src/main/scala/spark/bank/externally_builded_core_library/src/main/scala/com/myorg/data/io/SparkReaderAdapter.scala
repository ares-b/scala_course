package com.myorg.data.io

import com.myorg.data.domain.Data
import com.myorg.data.error.{ FileNotFound, IOError, IOFailure }
import org.apache.spark.SparkException
import org.apache.spark.sql.{ AnalysisException, DataFrame, Dataset, Encoder, SparkSession }

import scala.util.{ Failure, Success, Try }

case class SparkReaderAdapter(sparkSession: SparkSession) {
  import sparkSession.implicits._

  def readAsDataFrame(data: Data, givenDate: String, dateFormat: String): Either[IOError, DataFrame] = {
    val readOptions = data.dataSource.readOptions match {
      case None           => Map.empty[String, String]
      case Some(readOpts) => readOpts
    }

    Try(
      sparkSession.read
        .format(data.dataSource.sourceFormat)
        .options(readOptions)
        .load(data.getDataPath(givenDate, dateFormat))
    ) match {
      case Success(df) => Right(df)
      case Failure(exception: AnalysisException) =>
        if (exception.getMessage.toLowerCase contains "not exist") Left(FileNotFound(exception))
        else Left(IOFailure(exception))
      case Failure(exception: Exception) => Left(IOFailure(exception))
      case Failure(exception)            => throw exception
    }
  }

  def readAsDataset[Domain](data: Data, givenDate: String, dateFormat: String)(
      implicit encoder: Encoder[Domain]
  ): Either[IOError, Dataset[Domain]] =
    readAsDataFrame(data, givenDate, dateFormat) match {
      case Left(ioError) => Left(ioError)
      case Right(df)     => Right(df.as[Domain].map(identity))
    }
}
