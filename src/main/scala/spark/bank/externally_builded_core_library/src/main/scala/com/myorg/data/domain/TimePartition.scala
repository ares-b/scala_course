package com.myorg.data.domain

import com.myorg.data.helpers.DateHelper

import java.nio.file.Paths

sealed trait TimePartition {
  def getDataPath(data: Data, givenDate: String, dateFormat: String): String
}
case class DailyTimePartition(
    yearFormat: String,
    monthFormat: String,
    dayFormat: String
) {
  def getDataPath(data: Data, givenDate: String, dateFormat: String): String =
    Paths
      .get(
        data.dataSource.sourceBasePath,
        data.dataSource.sourceType,
        data.dataSource.businessUnit,
        data.dataName,
        f"year=${DateHelper.switchDateFormat(givenDate, dateFormat, yearFormat)}",
        f"month=${DateHelper.switchDateFormat(givenDate, dateFormat, monthFormat)}",
        f"day=${DateHelper.switchDateFormat(givenDate, dateFormat, dateFormat)}"
      )
      .toString
}
