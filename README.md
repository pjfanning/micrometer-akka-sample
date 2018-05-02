# micrometer-akka-sample

This sample demonstrates how to add [Micrometer-Akka](https://github.com/kontainers/micrometer-akka) metrics to your application.
Micrometer-Akka is in experimental mode and is based on [Prometheus-Akka](https://github.com/Workday/prometheus-akka) - and has a similar application.conf setting (replacing `prometheus.akka` with `micrometer.akka`.

This sample is based on https://github.com/pjfanning/prometheus-akka-sample

[Micrometer Metrics](http://micrometer.io/) compares itself to `SLF4J, but for metrics`.

All you need to do is add a dependency on the micrometer-akka jar, add some configuration to your [application.conf](https://github.com/pjfanning/micrometer-akka-sample/blob/master/src/main/resources/application.conf) and to enable aspectjweaver.

This sample uses `micrometer-registry-prometheus` to have the metrics registered as Prometheus client metrics.
This is setup in [Main.scala](https://github.com/pjfanning/micrometer-akka-sample/blob/master/src/main/scala/com/example/akka/Main.scala).

```sbt clean run```

```./gradlew clean run```

This sample uses [sbt-javaagent](https://github.com/sbt/sbt-javaagent) to enable aspectjweaver.
This plugin basically adds this to the java runtime command.

```-javaagent:/path/to/aspectjweaver-1.9.1.jar```

If you want to use micrometer-akka with your own application, ensure that you startup script adds something like this:

```bash
JAVA_AGENT="-javaagent:$BASE/lib/aspectjweaver-1.9.1.jar"
$JAVA_HOME/bin/java $JAVA_AGENT -cp $CP $JVM_OPTS $CLASS_NAME
```

To query the metrics endpoint, use:

```curl http://localhost:12345/metrics```

## Grafana

If you want to visualise the metrics, you could try [Grafana](http://docs.grafana.org/).
The Prometheus website has a [page](https://prometheus.io/docs/visualization/grafana/) about setting up Prometheus Server to scrape your metrics and how to integrate this with Grafana.
