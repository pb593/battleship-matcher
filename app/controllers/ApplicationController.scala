package controllers

import play.api.Play.current
import actors.{HelloActor, MyWebSocketActor}
import actors.HelloActor.SayHello
import akka.pattern.ask
import akka.util.Timeout
import models._
import play.api.libs.concurrent.Akka
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import play.api.mvc.{Action, Controller, WebSocket}

import scala.concurrent.duration._

class ApplicationController extends Controller {

  val helloActor = Akka.system.actorOf(HelloActor.props, "hello-actor")
  implicit val timeout: Timeout = 5.seconds


  def index = Action {
    Ok("OK!")
  }


  def sayHello(name: String) = Action.async {
    (helloActor ? SayHello(name)).mapTo[String].map {
      message => Ok(message)
    }
  }

  def socket = WebSocket.acceptWithActor[InEvent, OutEvent] { request => out =>
    MyWebSocketActor.props(out)
  }

}
