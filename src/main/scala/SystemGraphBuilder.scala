import java.time.Instant

import akka.Done
import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.stream.alpakka.influxdb.InfluxDbWriteMessage
import akka.stream.alpakka.influxdb.scaladsl.{InfluxDbFlow, InfluxDbSink}
import akka.stream.scaladsl.{RunnableGraph, Sink, Source}
import org.influxdb.InfluxDBFactory

import scala.concurrent.Future

trait GraphBuilder {
  def buildGraph: RunnableGraph[(Any, Future[Done])]
}

class SystemGraphBuilder (implicit val system: ActorSystem, val materializer: ActorMaterializer)
  extends GraphBuilder {
  override def buildGraph: RunnableGraph[(Any, Future[Done])] = {
    implicit  val  influxDB = InfluxDBFactory.connect("localhost:8086", "root", "12345678")
    influxDB.setDatabase("Iot")
    influxDB.query(new Nothing("CREATE DATABASE " + "Iot", "Iot"))



   val ss: Any = Source(
     List(

        Message(Instant.now(),"1","123")
      )
    )
    .runWith(InfluxDbSink.typed(classOf[Message]))
//     .via(InfluxDbFlow.create())
//      .runWith(Sink.seq)
//      .futureValue

  }
}


