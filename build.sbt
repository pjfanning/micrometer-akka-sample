name := "micrometer-akka-sample"

scalaVersion := "2.13.1"

val akkaVersion = "2.6.4"
val akkaHttpVersion = "10.1.11"
val micrometerVersion = "1.3.6"
val prometheusVersion = "0.7.0"

enablePlugins(JavaAgent)
javaAgents += "org.aspectj" % "aspectjweaver" % "1.9.5" % "runtime"

libraryDependencies ++= Seq(
  "io.kontainers" %% "micrometer-akka" % "0.11.0",
  "io.micrometer" % "micrometer-registry-prometheus" % micrometerVersion,
  "io.prometheus" % "simpleclient" % prometheusVersion,
  "io.prometheus" % "simpleclient_common" % prometheusVersion,
  "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
  "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion,
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe.akka" %% "akka-stream" % akkaVersion,
  "com.typesafe.akka" %% "akka-slf4j" % akkaVersion,
  "ch.qos.logback" % "logback-classic" % "1.2.3"
)
