package models

import play.api.libs.json._
import play.api.mvc.WebSocket._

/**
  * Created by pb593 on 07/05/2017.
  */

case class InEvent(msg: String)
object InEvent {
  implicit val inFmt = Json.format[InEvent]
  implicit val inFrame = FrameFormatter.jsonFrame[InEvent]
}

case class OutEvent(msg: String)
object OutEvent {
  implicit val outFmt = Json.format[OutEvent]
  implicit val outFrame = FrameFormatter.jsonFrame[OutEvent]
}
