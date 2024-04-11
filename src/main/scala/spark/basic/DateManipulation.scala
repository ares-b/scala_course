package spark.basic

import org.apache.spark.sql.DataFrame
import spark.SparkApplication

object DateManipulation extends SparkApplication {

  import spark.implicits._

  //  INPUT
  //+-----------+
  //|date_string|
  //+-----------+
  //| 08/11/2015|
  //| 09/11/2015|
  //| 09/12/2015|
  //+-----------+
  //  Result
  //+-----------+----------+----+
  //|date_string|   to_date|diff|
  //+-----------+----------+----+
  //| 08/11/2015|2015-11-08|1256|
  //| 09/11/2015|2015-11-09|1255|
  //| 09/12/2015|2015-12-09|1225|
  //+-----------+----------+----+

  val differenceBetweenCurrentDateInput = Seq("08/11/2015", "09/11/2015", "09/12/2015").toDF("date_string")

  val differenceBetweenCurrentDate = ???

}
