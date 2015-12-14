import org.apache.kafka.clients.producer.KafkaProducer
import java.util.Properties

object Producer extends App {

    val props = new Properties()

    props.put("bootstrap.servers", "192.168.1.90:9092")
    props.put("key.serializer",
      "org.apache.kafka.common.serialization.StringSerializer");
    props.put("value.serializer",
      "org.apache.kafka.common.serialization.StringSerializer");

    val producer = new KafkaProducer(props)
    producer.close()
}
