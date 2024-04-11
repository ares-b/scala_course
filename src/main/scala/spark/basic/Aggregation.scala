package spark.basic

import org.apache.spark.sql.DataFrame
import spark.SparkApplication

object Aggregation extends SparkApplication {
  import spark.implicits._

  // Input
  //+---+-----+
  //| id|group|
  //+---+-----+
  //|  0|    0|
  //|  1|    1|
  //|  2|    0|
  //|  3|    1|
  //|  4|    0|
  //+---+-----+
  // Result
  //+-----+------+------+
  //|group|max_id|min_id|
  //+-----+------+------+
  //|    0|     4|     0|
  //|    1|     3|     1|
  //+-----+------+------+
  val multipleAggregationInputDf = spark.range(5).withColumn("group", 'id % 2)

  def doMultipleAggregations: DataFrame = ???

  val findBiggestCityInputDf = Seq(
    ("Warsaw", 1764615),
    ("Villeneuve-Loubet", 15020),
    ("Vranje", 83524),
    ("Pittsburgh", 1775634)
  ).toDF("City", "Population")

  def findBiggestCity(df: DataFrame): DataFrame = ???

  val findFirstAndSecondBestSellerBygenreInput = Seq(
    (1, "Hunter Fields", "romance", 15),
    (2, "Leonard Lewis", "thriller", 81),
    (3, "Jason Dawson", "thriller", 90),
    (4, "Andre Grant", "thriller", 25),
    (5, "Earl Walton", "romance", 40),
    (6, "Alan Hanson", "romance", 24),
    (7, "Clyde Matthews", "thriller", 31),
    (8, "Josephine Leonard", "thriller", 1),
    (9, "Owen Boone", "sci-fi", 27),
    (10, "Max McBride", "romance", 75),
  ).toDF("id", "title", "genre", "quantity")

  val findFirstAndSecondBestSellerBygenre: DataFrame = ???
}
