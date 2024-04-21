package com.myorg.data.config

import com.myorg.data.domain.Data
import com.typesafe.config.ConfigFactory
import pureconfig.{ CamelCase, ConfigFieldMapping, ConfigSource }
import pureconfig.generic.ProductHint
import pureconfig.generic.auto._

case class AppConfig(
    rawContactData: Data,
    rawAddressData: Data,
    silverContactData: Data
)
object AppConfig {
  def apply(filePath: String): AppConfig = {
    val reader                                  = ConfigFactory.load(filePath)
    implicit def productHint[A]: ProductHint[A] = ProductHint(ConfigFieldMapping(CamelCase, CamelCase))
    ConfigSource.fromConfig(reader).loadOrThrow[AppConfig]
  }
}
