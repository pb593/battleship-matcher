package actors

/**
  * Created by pb593 on 07/05/2017.
  */
import akka.actor._
import models._

object MyWebSocketActor {
  def props(out: ActorRef) = Props(new MyWebSocketActor(out))
}

class MyWebSocketActor(out: ActorRef) extends Actor {
  def receive = {
    case msg: String => out ! ("I received your message: " + msg)
    case in: InEvent => out ! OutEvent("I got this msg of your input json: " + in.msg)
  }
}
