package com.kafka.poc

import java.util.Properties

import org.apache.kafka.clients.producer.{Callback, KafkaProducer, ProducerRecord, RecordMetadata}
import org.slf4j.LoggerFactory

class KafkaPoc {

  def sendData(): Unit = {

    val props = new Properties();
    props.put("bootstrap.servers", "localhost:9092")
    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")

    val producer = new KafkaProducer[String, String](props)
    val record = new ProducerRecord[String, String]("topic", "Kay", "Data")

    //Fire and forgot
    //producer.send(record)
    // Asynchronous
     producer.send(record, new compareProducerCallback)
    // Synchronous
    // val metadata = producer.send(record).get()
    // logger.info(s" ======> ${metadata.offset()} written to partition ${metadata.partition.toString}")

    producer.flush()
    producer.close()
  }
}

class compareProducerCallback extends Callback {

  val logger = LoggerFactory.getLogger(getClass.getName)

  override def onCompletion(recordMetadata: RecordMetadata, e: Exception): Unit = {
    if (e == null) {
      logger.info(s"Message Sent ======> offset: [${recordMetadata.offset()}] , partition: [${recordMetadata.partition()}]")
    } else {
      logger.error("Message Sent Failed Exception [{}]", e.getCause)
    }
  }
}

object runProcess {

  def main(args: Array[String]): Unit = {
    val kafkaPoc = new KafkaPoc
    kafkaPoc.sendData()
  }

}

