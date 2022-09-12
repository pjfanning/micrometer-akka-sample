name := "micrometer-akka-sample"

scalaVersion := "2.13.8"

val akkaVersion = "2.6.20"
val akkaHttpVersion = "10.2.10"
val aspectJVersion = "1.9.9.1"
val micrometerVersion = "1.9.4"
val prometheusVersion = "0.16.0"

ThisBuild / resolvers ++= Resolver.sonatypeOssRepos("snapshots")

enablePlugins(JavaAgent)
javaAgents += "org.aspectj" % "aspectjweaver" % aspectJVersion  % "runtime"

libraryDependencies ++= Seq(
  "com.github.pjfanning" %% "micrometer-akka" % "0.13.3",
  "org.aspectj" % "aspectjweaver" % aspectJVersion  % "runtime",
  "io.micrometer" % "micrometer-registry-prometheus" % micrometerVersion,
  "io.prometheus" % "simpleclient" % prometheusVersion,
  "io.prometheus" % "simpleclient_common" % prometheusVersion,
  "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
  "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion,
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe.akka" %% "akka-stream" % akkaVersion,
  "com.typesafe.akka" %% "akka-slf4j" % akkaVersion,
  "ch.qos.logback" % "logback-classic" % "1.4.0"
)

//uncomment this add-opens -- needed for Java 16 and above runtimes -- will cause issues if used with Java 8 runtime
//run / javaOptions ++= Seq("--add-opens", "java.base/java.lang=ALL-UNNAMED")
