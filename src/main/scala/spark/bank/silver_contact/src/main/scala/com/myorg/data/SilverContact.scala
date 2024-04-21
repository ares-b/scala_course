package com.myorg.data

import com.myorg.data.config.AppConfig
import com.myorg.data.pipeline.{ AddressStep, KYCStep, SilverContactPipeline }
import com.myorg.data.service.ETLService

object SilverContact extends SparkApplication {

  val appConfig = AppConfig("application.conf")

  val service     = ETLService(spark, runDate.get, dateFormat.get)
  val kycStep     = KYCStep(service, appConfig.rawContactData)
  val addressStep = AddressStep(service, appConfig.rawAddressData)

  val silverContactPipeline = SilverContactPipeline(
    service,
    addressStep,
    kycStep
  )

  service.sparkWriter.write(
    appConfig.silverContactData,
    silverContactPipeline.computeSilverContact,
    runDate.get,
    dateFormat.get
  )

  spark.stop()

}
