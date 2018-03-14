name := "micrometer-akka-sample"

scalaVersion := "2.12.4"

resolvers += Resolver.sonatypeRepo("releases")
resolvers += Resolver.sonatypeRepo("snapshots")

val akkaVersion = "2.5.11"
val akkaHttpVersion = "10.1.0"
val micrometerVersion = "1.0.2"

enablePlugins(JavaAgent)
javaAgents += "org.aspectj" % "aspectjweaver" % "1.8.13" % "runtime"

libraryDependencies ++= Seq(
  "com.workday" %% "micrometer-akka" % "0.8.5-SNAPSHOT" changing(),
  "io.micrometer" % "micrometer-registry-prometheus" % micrometerVersion,
  "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
  "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion,
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe.akka" %% "akka-stream" % akkaVersion,
  "com.typesafe.akka" %% "akka-slf4j" % akkaVersion,
  "ch.qos.logback" % "logback-classic" % "1.2.3"
)
