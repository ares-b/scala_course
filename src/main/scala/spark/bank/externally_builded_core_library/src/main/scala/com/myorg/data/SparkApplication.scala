package com.myorg.data

import org.apache.spark.sql.SparkSession

trait SparkApplication extends App {

  protected val spark: SparkSession = SparkSession
    .builder()
    .getOrCreate()

  protected val params: Map[String, String] = (for {
    arg <- args
    arr = arg.split("=") match {
      case Array(k, v) => Array(k, v)
      case Array(k)    => Array(k, "")
    }
  } yield (arr(0) -> arr(1))).toMap

  protected val runDate    = params.get("RUN_DATE")
  protected val dateFormat = params.get("DATE_FORMAT")
}
