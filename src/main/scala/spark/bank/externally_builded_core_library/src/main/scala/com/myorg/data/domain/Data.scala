package com.myorg.data.domain

import com.myorg.data.domain.Data.DataPath

case class Data(
    dataSource: DataSource,
    dataName: String,
    timePartition: TimePartition
) {
  // or this
  self =>

  def getDataPath(givenDate: String, dateFormat: String): DataPath =
    timePartition.getDataPath(self, givenDate, dateFormat)
}
object Data {
  type DataPath = String
}
