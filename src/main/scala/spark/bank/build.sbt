ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.13"

val sparkVersion = "3.5.0"

// Spark
val commonDependencies = Seq(
  "org.apache.spark"      %% "spark-core"         % sparkVersion,
  "org.apache.spark"      %% "spark-sql"          % sparkVersion,
  "com.github.pureconfig" %% "pureconfig"         % "0.16.0",
  "org.scalatest"         %% "scalatest-flatspec" % "3.2.17" % Test,
  "org.scalatest"         %% "scalatest-flatspec" % "3.2.17" % Test,
  "org.scalatest"         %% "scalatest-flatspec" % "3.2.17" % Test
)

lazy val root = (project in file("."))
  .settings(
    name := "bank"
  )
  .dependsOn(silverContact)

lazy val externallyBuildedCoreLibrary = (project in file("externally_builded_core_library"))
  .settings(name := "externally_builded_core_library")
  .settings(libraryDependencies ++= commonDependencies)

lazy val silverContact = (project in file("silver_contact"))
  .settings(name := "silver_contact")
  .settings(libraryDependencies ++= commonDependencies)
  .dependsOn(externallyBuildedCoreLibrary)
