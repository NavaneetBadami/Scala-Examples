package com.kafka.poc


import org.apache.avro.Schema.Parser
import org.apache.avro.generic.{GenericData, GenericRecord}
import org.apache.kafka.clients.producer.{Callback, KafkaProducer, ProducerRecord, RecordMetadata}
import org.apache.log4j.BasicConfigurator
import org.slf4j.LoggerFactory

case class User(name: String, id: Integer, loc: String)

class MessageProducer extends KafkaConfigTrait {

  val logger = LoggerFactory.getLogger(getClass.getName)

  def SendData(): Unit = {
    try {
      val navi = User("Test1", 7, "Bjp")
      val navi2 = User("Test2", 8, "Pune")
      val dataList = List(this.getAvroGenRecord(navi), this.getAvroGenRecord(navi2))

      val producer = this.getProducerConfig   // From Trait
      dataList.foreach { value =>
        val key = value.get("id").toString
        val record = new ProducerRecord("UserTopic", key, value)

        //Asynchronous
        producer.send(record, (recordMetadata: RecordMetadata, e: Exception) => {
          if (e == null) {
            logger.info(s"Message Sent ======> offset: [${recordMetadata.offset()}] , partition: [${recordMetadata.partition()}]")
          } else {
            logger.error("Message Sent Failed Exception [{}]", e.getCause)
          }
        })
      }
      producer.flush()
    } catch {
      case e: Exception => logger.error("ExceptionL  ", e.getMessage, e)
      case e: Throwable => logger.error("ExceptionL  ", e.getMessage, e)
    }
  }

  /**
   *
   * @param user
   * @return
   */
  def getAvroGenRecord(user: User): GenericData.Record = {
    val schemaJson = s"""
    { "namespace": "com.avro.data", "type": "record", "name": "User2",
      "fields": [ {"name": "name", "type": "string"}, {"name": "id",  "type": "int"}, {"name": "loc", "type": "string"}]
    }
     """
    val parser = new Parser
    val valueSchemaAvro = parser.parse(schemaJson)
    val genAvroRec = new GenericData.Record(valueSchemaAvro)
    genAvroRec.put("name", user.name)
    genAvroRec.put("id", user.id)
    genAvroRec.put("loc", user.loc)
    genAvroRec
  }
}

object RunProducer {

  def main(args: Array[String]): Unit = {
    BasicConfigurator.configure()
    val logger = LoggerFactory.getLogger(getClass)
    logger.info("========== Starting the application ============ ")
    new MessageProducer().SendData()
  }
}