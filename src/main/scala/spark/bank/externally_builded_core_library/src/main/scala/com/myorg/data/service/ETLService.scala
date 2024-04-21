package com.myorg.data.service

import com.myorg.data.io.{SparkReaderAdapter, SparkWriterAdapter}
import org.apache.spark.sql.SparkSession

case class ETLService(
    spark: SparkSession,
    runDate: String,
    dateFormat: String
) {

  val sparkReader = SparkReaderAdapter(spark)
  val sparkWriter = SparkWriterAdapter(spark)

}
