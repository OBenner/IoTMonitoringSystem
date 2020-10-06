import java.time.Instant

import akka.NotUsed
import akka.actor.ActorSystem
import akka.kafka.scaladsl.Consumer.DrainingControl
import akka.stream.ActorMaterializer
import akka.stream.alpakka.influxdb.scaladsl.{InfluxDbFlow, InfluxDbSink}
import akka.stream.scaladsl.{Sink, Source}
import org.influxdb.{InfluxDB, InfluxDBFactory}
import akka.stream.alpakka.influxdb.{InfluxDbReadSettings, InfluxDbWriteMessage}

object Main {
  implicit val system: ActorSystem             = ActorSystem("iot")
  implicit val materializer: ActorMaterializer = ActorMaterializer()


  def main(args: Array[String]): Unit = {
    implicit  val  influxDB: InfluxDB = InfluxDBFactory.connect("localhost:8086", "root", "12345678")
    .setDatabase("Iot")

val sds: InfluxDbWriteMessage[Message, NotUsed] =  InfluxDbWriteMessage(
  Message(Instant.now(),"1","123")
)
    val ss: Nothing = Source(
      Seq(
        sds)
    )


    Source(  Iterable(Message(Instant.now(),"1","123")))
      .runWith(InfluxDbSink.typed(classOf[Message])
      )
  }




}

















