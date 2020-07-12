name := "micrometer-akka-sample"

scalaVersion := "2.13.3"

val akkaVersion = "2.6.7"
val akkaHttpVersion = "10.1.12"
val micrometerVersion = "1.5.2"
val prometheusVersion = "0.9.0"

enablePlugins(JavaAgent)
javaAgents += "org.aspectj" % "aspectjweaver" % "1.9.5" % "runtime"

libraryDependencies ++= Seq(
  "io.kontainers" %% "micrometer-akka" % "0.12.0",
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
