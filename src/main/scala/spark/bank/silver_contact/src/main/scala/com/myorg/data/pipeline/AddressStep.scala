package com.myorg.data.pipeline

import com.myorg.data.domain.{ Address, Data }
import com.myorg.data.error.IOError
import com.myorg.data.service.ETLService
import org.apache.spark.sql.{ DataFrame, Dataset }

case class AddressStep(
    service: ETLService,
    address: Data
) {

  import service.spark.implicits._

  lazy val addressDS: Either[IOError, Dataset[Address]] = service.sparkReader.readAsDataset[Address](
    address,
    service.runDate,
    service.dateFormat
  )

  def computeAddressMetrics(addressDs: Dataset[Address])(df: DataFrame): DataFrame =
    ???
}
