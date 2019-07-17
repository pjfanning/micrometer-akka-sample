name := "micrometer-akka-sample"

scalaVersion := "2.13.0"

resolvers += Resolver.sonatypeRepo("releases")
resolvers += Resolver.sonatypeRepo("snapshots")

val akkaVersion = "2.5.23"
val akkaHttpVersion = "10.1.9"
val micrometerVersion = "1.2.0"
val prometheusVersion = "0.6.0"

enablePlugins(JavaAgent)
javaAgents += "org.aspectj" % "aspectjweaver" % "1.9.4" % "runtime"

libraryDependencies ++= Seq(
  "io.kontainers" %% "micrometer-akka" % "0.10.2",
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
