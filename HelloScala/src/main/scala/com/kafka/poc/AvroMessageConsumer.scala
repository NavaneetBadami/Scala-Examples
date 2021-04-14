package com.kafka.poc

import java.util

import com.kafka.poc.RunProducer.getClass
import com.kafka.poc.avro.UserDetails
import org.apache.kafka.clients.consumer.{ConsumerRecord, ConsumerRecords}
import org.apache.log4j.BasicConfigurator
import org.slf4j.LoggerFactory

class AvroMessageConsumer extends KafkaConfigTrait {

  val logger = LoggerFactory.getLogger(getClass.getName)

  def receiveMessage(): Unit = {
    try {
      val consumer = this.getAvroConsumerConfig // Traits
      consumer.subscribe(util.Arrays.asList("UserAvroTopic"))

      while (true) {
        val record: ConsumerRecords[String, UserDetails] = consumer.poll(1000)
        record.forEach(record => {
          logger.info(s"Message Received =====> Key: ${record.key()} Value: ${record.value()}")
        })
      }
    } catch {
      case exception: Exception => logger.error("Exception while consuming {}", exception.getMessage)
    }
  }
}

object RunAvroConsumer {
  def main(args: Array[String]): Unit = {
    BasicConfigurator.configure()
    val logger = LoggerFactory.getLogger(getClass)
    logger.info("========== Starting the application ============ ")
    val consu = new AvroMessageConsumer
    consu.receiveMessage()
  }
}