package com.example.akka.http

import akka.actor.ActorSystem
import akka.http.scaladsl.Http

import scala.concurrent.{ExecutionContextExecutor, Future}

object WebServer {

  def start(): Future[Nothing] = {
    implicit val system: ActorSystem = ActorSystem("akka-http-sample")
    sys.addShutdownHook(system.terminate())

    implicit val executionContext: ExecutionContextExecutor = system.dispatcher

    for {
      bindingFuture <- Http().newServerAt("0.0.0.0", 12345).bind(PrometheusService.route)
      waitOnFuture  <- Future.never
    } yield waitOnFuture
  }
}
