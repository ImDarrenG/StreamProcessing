import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerRecord
import java.util.Properties

object Producer extends App {

    val props = new Properties()

    props.put("bootstrap.servers", "192.168.1.90:9092")
    props.put("key.serializer",
      "org.apache.kafka.common.serialization.StringSerializer");
    props.put("value.serializer",
      "org.apache.kafka.common.serialization.StringSerializer");

    val producer = new KafkaProducer[java.lang.String, java.lang.String](props)

    try {
      for (i <- 1 to 100) {
        producer.send(new ProducerRecord[java.lang.String, java.lang.String](
          "test-topic", Integer.toString(i), Integer.toString(i)))
      }
    } finally {
      producer.close()
    }

}
