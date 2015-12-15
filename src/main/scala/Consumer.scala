import java.util.Properties
import org.apache.kafka.clients.consumer.KafkaConsumer

object Consumer extends App {

  val props = new Properties()
    props.put("bootstrap.servers", "192.168.1.90:9092")
    props.put("key.serializer",
      "org.apache.kafka.common.serialization.StringSerializer")
    props.put("value.serializer",
      "org.apache.kafka.common.serialization.StringSerializer")

  val consumer = new KafkaConsumer[java.lang.String, java.lang.String](props)
  while (true) {
    val records = consumer.poll(100)
    for (r <- records)
      println(r.offset() +", "+ r.key() +", "+ r.value())
  }
}
