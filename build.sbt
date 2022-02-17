name := "micrometer-akka-sample"

scalaVersion := "2.13.8"

val akkaVersion = "2.6.18"
val akkaHttpVersion = "10.2.7"
val micrometerVersion = "1.8.3"
val prometheusVersion = "0.12.0"

ThisBuild / resolvers += Resolver.sonatypeRepo("snapshots")

enablePlugins(JavaAgent)
javaAgents += "org.aspectj" % "aspectjweaver" % "1.9.8" % "runtime"

libraryDependencies ++= Seq(
  "com.github.pjfanning" %% "micrometer-akka" % "0.13.2",
  "io.micrometer" % "micrometer-registry-prometheus" % micrometerVersion,
  "io.prometheus" % "simpleclient" % prometheusVersion,
  "io.prometheus" % "simpleclient_common" % prometheusVersion,
  "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
  "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion,
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe.akka" %% "akka-stream" % akkaVersion,
  "com.typesafe.akka" %% "akka-slf4j" % akkaVersion,
  "ch.qos.logback" % "logback-classic" % "1.2.10"
)

//uncomment this add-opens -- needed for Java 16 and above runtimes -- will cause issues if used with Java 8 runtime
//run / javaOptions ++= Seq("--add-opens", "java.base/java.lang=ALL-UNNAMED")
