scalaVersion := "2.11.12"

inThisBuild(List(
  organization := "io.github.datYori",
  homepage := Some(url("https://github.com/datYori/cassper")),
  // Alternatively License.Apache2 see https://github.com/sbt/librarymanagement/blob/develop/core/src/main/scala/sbt/librarymanagement/License.scala
  licenses := List("Apache-2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0")),
  developers := List(
    Developer(
      "datYori",
      "Yann Bouzonie",
      "yann.bouzonie@gmail.com",
      url("https://github.com/datYori")
    )
  )
))
// cassper
name := "cassper"
description := "Schema migrations tool for `Apache Cassandra` that can be used with `JVM` applications."

// disable publish with scala version, otherwise artifact name will include scala version 
// e.g cassper_2.11
crossPaths := false

// other library dependencies
libraryDependencies ++= {
  val cassandraVersion = "3.1.1"
  val akkaVersion = "2.5.19"
  
  Seq(
      "com.datastax.cassandra"  % "cassandra-driver-core"   % cassandraVersion,
      "com.typesafe.akka"       %% "akka-actor"             % akkaVersion,
      "com.typesafe.akka"       %% "akka-stream"            % akkaVersion,
      "com.typesafe.akka"       %% "akka-slf4j"             % akkaVersion,
      "org.scalatest"           %% "scalatest"              % "3.0.4"                 % Test
    )
}

ThisBuild / sonatypeCredentialHost := "s01.oss.sonatype.org"
sonatypeRepository := "https://s01.oss.sonatype.org/service/local"