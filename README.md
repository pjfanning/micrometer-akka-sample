# micrometer-akka-sample

This sample demonstrates how to add [Micrometer-Akka](https://github.com/pjfanning/micrometer-akka) metrics to your application.

This sample is based on https://github.com/pjfanning/prometheus-akka-sample

[Micrometer Metrics](http://micrometer.io/) compares itself to `SLF4J, but for metrics`.

All you need to do is add a dependency on the micrometer-akka jar, add some configuration to your [application.conf](https://github.com/pjfanning/micrometer-akka-sample/blob/main/src/main/resources/application.conf) and to enable aspectjweaver.

This sample uses `micrometer-registry-prometheus` to have the metrics registered as Prometheus client metrics.
This is setup in [Main.scala](https://github.com/pjfanning/micrometer-akka-sample/blob/main/src/main/scala/com/example/akka/Main.scala).

```sbt clean run```

This sample uses [sbt-javaagent](https://github.com/sbt/sbt-javaagent) to enable aspectjweaver.
This plugin basically adds this to the java runtime command.

```-javaagent:/path/to/aspectjweaver-1.9.19.jar```

If you want to use micrometer-akka with your own application, ensure that you startup script adds something like this:

```bash
JAVA_AGENT="-javaagent:$BASE/lib/aspectjweaver-1.9.19.jar"
$JAVA_HOME/bin/java $JAVA_AGENT -cp $CP $JVM_OPTS $CLASS_NAME
```

To query the metrics endpoint, use:

```curl http://localhost:12345/metrics```

## Running with Java 16 and above

Note that the `build.sbt` has this:
```
//uncomment this add-opens -- needed for Java 16 and above runtimes -- will cause issues if used with Java 8 runtime
run / javaOptions ++= Seq("--add-opens", "java.base/java.lang=ALL-UNNAMED")
```

If you use micrometer-akka in your own application, you will need to add an equivalent `--add-opens` configuration.

## Grafana

If you want to visualise the metrics, you could try [Grafana](http://docs.grafana.org/).
The Prometheus website has a [page](https://prometheus.io/docs/visualization/grafana/) about setting up Prometheus Server to scrape your metrics and how to integrate this with Grafana.
