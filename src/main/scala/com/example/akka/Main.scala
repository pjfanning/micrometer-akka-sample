package com.example.akka

import com.example.akka.http.WebServer
import io.kontainers.micrometer.akka.AkkaMetricRegistry
import io.micrometer.core.instrument.Clock
import io.micrometer.prometheus.{PrometheusConfig, PrometheusMeterRegistry}
import io.prometheus.client.CollectorRegistry

object Main extends App {
  val prometheusMeterRegistry = new PrometheusMeterRegistry(PrometheusConfig.DEFAULT, CollectorRegistry.defaultRegistry, Clock.SYSTEM)
  AkkaMetricRegistry.setRegistry(prometheusMeterRegistry)
  WebServer.start()
}
