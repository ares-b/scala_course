ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.13"

val sparkVersion = "3.5.0"

// Spark
libraryDependencies += "org.apache.spark" %% "spark-core" % sparkVersion
libraryDependencies += "org.apache.spark" %% "spark-sql"  % sparkVersion

libraryDependencies += "org.scalatest" %% "scalatest-flatspec" % "3.2.17" % Test

libraryDependencies += "org.scalatest" %% "scalatest-flatspec" % "3.2.17" % Test
libraryDependencies += "org.scalatest" %% "scalatest-flatspec" % "3.2.17" % Test

lazy val root = (project in file("."))
  .settings(
    name := "formation_scala"
  )
