import java.time.Instant

import org.influxdb.annotation.{Column, Measurement}

@Measurement(name = "record", database = "Iot")
object Message {

  def apply(time: Instant, id: String, value:  String): Message = {
    new Message(
      time,
      id,
      value
    )
  }
}
case class Message(@Column(name = "time") time: Instant,@Column(name = "id", tag = true) id: String,@Column(name = "value") value:  String)
