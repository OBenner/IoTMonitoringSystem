import sbt._

object Dependencies {
  val scalaCompat = "2.12.11"

  private object Version {
    val akka = "2.5.31"
    val alpakkaKafka = "2.0.5"
    val akkaHttp = "10.2.1"
    val slf4jApi = "1.7.30"
    val log4jSlf4jImpl = "2.13.0"
    val kamon = "2.1.0"
    val alpakkaInfluxDb = "2.0.2"
  }

  object Akka {
    val AlpakkaKafka = "com.typesafe.akka" %% "akka-stream-kafka" % Version.alpakkaKafka
    val AkkaSlf4j = "com.typesafe.akka" %% "akka-slf4j" % Version.akka
    val Stream = "com.typesafe.akka" %% "akka-stream" % Version.akka
    val Http = "com.typesafe.akka" %% "akka-http" % Version.akkaHttp
   val AlpakkaInfluxDb = "com.lightbend.akka" %% "akka-stream-alpakka-influxdb" % Version.alpakkaInfluxDb
  }

  object Logging {
    val Slf4jApi = "org.slf4j" % "slf4j-api" % Version.slf4jApi
    val Log4jSlf4jImpl = "org.apache.logging.log4j" % "log4j-slf4j-impl" % Version.log4jSlf4jImpl
  }


  object Kamon {
    val KamonPrometeus = "io.kamon" %% "kamon-prometheus" % Version.kamon
    val Kamon = "io.kamon" %% "kamon-bundle" % Version.kamon

  }



}
