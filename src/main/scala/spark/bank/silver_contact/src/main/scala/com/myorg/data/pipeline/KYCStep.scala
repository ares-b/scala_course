package com.myorg.data.pipeline

import com.myorg.data.domain.{ Contact, Data }
import com.myorg.data.error.IOError
import com.myorg.data.service.ETLService
import org.apache.spark.sql.{ DataFrame, Dataset }

case class KYCStep(
    service: ETLService,
    contact: Data
) {
  import service.spark.implicits._

  lazy val contactDS: Either[IOError, Dataset[Contact]] = service.sparkReader.readAsDataset[Contact](
    contact,
    service.runDate,
    service.dateFormat
  )

  def computeKycMetrics(contactDs: Dataset[Contact]): DataFrame =
    ???
}
