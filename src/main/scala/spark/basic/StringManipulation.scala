package spark.basic

import org.apache.spark.sql.{ Column, DataFrame }
import spark.SparkApplication

object StringManipulation extends SparkApplication {

  import spark.implicits._

  //  INPUT
  //+-------------------+
  //|             VALUES|
  //+-------------------+
  //|       50000.0#0#0#|
  //|          0@1000.0@|
  //|                 1$|
  //|1000.00^Test_string|
  //+-------------------+
  //  Result
  // +-------------------+---------+----------------------+
  //|VALUES             |split_values          |
  //+-------------------+----------------------+
  //|50000.0#0#0#       |[50000.0, 0, 0, ]     |
  //|0#1000.0#          |[0, 1000.0, ]         |
  //|1#                 |[1, ]                 |
  //|1000.00#Test_string|[1000.00, Test_string]|
  //+-------------------+---------+----------------------+
  val simpleSplitDf = Seq(("50000.0#0#0#"), ("0#1000.0#"), ("1#"), ("1000.00#Test_string")).toDF("VALUES")

  def simpleSplit(sep: String)(df: DataFrame): DataFrame = ???

  def replaceCharsInString(stringColName: String, charMapping: Map[Char, Char])(df: DataFrame): DataFrame = ???

  def makeStringColumnUpperCase(stringColName: String)(df: DataFrame): DataFrame = ???

}
