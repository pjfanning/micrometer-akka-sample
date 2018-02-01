package com.example.akka.http

import scala.concurrent.ExecutionContext.Implicits.global
import akka.http.scaladsl.server.HttpApp

object WebServer extends HttpApp {
  override def routes = PrometheusService.route

  def start(): Unit = startServer("0.0.0.0", 12345)
}
