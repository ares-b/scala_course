package com.myorg.data.pipeline
import com.myorg.data.service.ETLService
import org.apache.spark.sql.DataFrame

case class SilverContactPipeline(
    service: ETLService,
    addressStep: AddressStep,
    KYCStep: KYCStep
) {
  def computeSilverContact: DataFrame = ???
}
