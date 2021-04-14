package com.kafka.poc

import java.util

import org.apache.avro.generic.GenericData
import org.apache.log4j.BasicConfigurator
import org.slf4j.LoggerFactory

import scala.util.{Failure, Success, Try}

class MessageConsumer extends KafkaConfigTrait {

  val logger = LoggerFactory.getLogger(getClass.getName)

  def receiveMessage(): Unit = {
    val consumer = this.getConsumerConfig // Traits
    consumer.subscribe(util.Arrays.asList("UserTopic"))
    while (true) {
      val record = consumer.poll(1000)
      record.forEach {
        record =>  {
          val msg = this.getAvroRecord(record.value())
          logger.info(s"Message Received =====> Key: ${record.key()} Value: $msg")
        }
      }
    }
  }

  /**
   *
   * @param message
   * @return
   */
  def getAvroRecord(message: GenericData.Record): Option[User] = {
    val user = Try[User](User(message.get("name").toString, message.get("id").toString.toInt, message.get("loc").toString))
    user match {
      case Success(user) => Some(user)
      case Failure(exception) => None
    }
  }
}

object RunConsumer {
  def main(args: Array[String]): Unit = {
    BasicConfigurator.configure()
    val logger = LoggerFactory.getLogger(getClass)
    logger.info("========== Starting the application ============ ")
    new MessageConsumer().receiveMessage()
  }
}
