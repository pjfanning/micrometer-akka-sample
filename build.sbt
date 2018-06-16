name := "micrometer-akka-sample"

scalaVersion := "2.12.6"

resolvers += Resolver.sonatypeRepo("releases")
resolvers += Resolver.sonatypeRepo("snapshots")

val akkaVersion = "2.5.13"
val akkaHttpVersion = "10.1.3"
val micrometerVersion = "1.0.5"
val prometheusVersion = "0.4.0"

enablePlugins(JavaAgent)
javaAgents += "org.aspectj" % "aspectjweaver" % "1.9.1" % "runtime"

libraryDependencies ++= Seq(
  "io.kontainers" %% "micrometer-akka" % "0.9.0",
  "io.micrometer" % "micrometer-registry-prometheus" % micrometerVersion,
  "io.prometheus" % "simpleclient_common" % prometheusVersion,
  "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
  "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion,
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe.akka" %% "akka-stream" % akkaVersion,
  "com.typesafe.akka" %% "akka-slf4j" % akkaVersion,
  "ch.qos.logback" % "logback-classic" % "1.2.3"
)
