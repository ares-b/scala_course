ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.13"

libraryDependencies += "org.scalatest" %% "scalatest"          % "3.2.17" % Test
libraryDependencies += "org.scalatest" %% "scalatest-flatspec" % "3.2.17" % Test

lazy val root = (project in file("."))
  .settings(
    name := "formation_scala"
  )
