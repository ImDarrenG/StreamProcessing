import java.util.Properties
import java.util.Arrays
import org.apache.kafka.clients.consumer.KafkaConsumer

object Consumer extends App {

  val props = new Properties()
  props.put("bootstrap.servers", "192.168.1.90:9092")
  props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
  props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
  props.put("group.id", "test")

  val consumer = new KafkaConsumer[java.lang.String, java.lang.String](props)
  consumer.subscribe(Arrays.asList("test-topic"))
  while (true) {
    val records = consumer.poll(100)
    val iterator = records.iterator()
    while (iterator.hasNext)
    {
      val record = iterator.next
      println(record.offset() +", "+
        record.key() +", "+
        record.value())
    }
  }
}
