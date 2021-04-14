package com.kafka.poc

import com.kafka.poc.avro.UserDetails
import org.apache.kafka.clients.producer.{ProducerRecord, RecordMetadata}
import org.apache.log4j.BasicConfigurator
import org.slf4j.LoggerFactory

class AvroMessageProducer extends KafkaConfigTrait {

  val logger = LoggerFactory.getLogger(getClass.getName)

  def sendAvroMessage(): Unit = {

    try {
      val avroProducer = getAvroProducerConfig //Traits
      val userList = List(new UserDetails("User1", 101, "Pune"), new UserDetails("USer2", 102, "Bijapur"))

      for (user <- userList) {
        val key = user.id
        val record = new ProducerRecord[String, UserDetails]("UserAvroTopic", key.toString, user)

        //Asynchronous
        avroProducer.send(record, (recordMetadata: RecordMetadata, e: Exception) => {
          if (e == null) {
            logger.info(s"Message Sent ======> offset: [${recordMetadata.offset()}] , partition: [${recordMetadata.partition()}]")
          } else {
            logger.error("Message Sent Failed Exception [{}]", e.getCause)
          }
        })
        avroProducer.flush()
      }
    } catch {
      case  ex => logger.error("Exception while sending data: {}", ex.getMessage)
    }
  }
}

object RunAvroProducer {

  def main(args: Array[String]): Unit = {
    BasicConfigurator.configure()
    val logger = LoggerFactory.getLogger(getClass)
    logger.info("========== Starting the application ============ ")
    val prod = new AvroMessageProducer
    prod.sendAvroMessage()
  }

}