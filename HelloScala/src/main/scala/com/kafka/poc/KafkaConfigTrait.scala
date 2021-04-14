package com.kafka.poc

import java.util.Properties

import com.kafka.poc.avro.UserDetails
import io.confluent.kafka.serializers.{KafkaAvroDeserializer, KafkaAvroSerializer}
import org.apache.avro.generic.GenericData
import org.apache.kafka.clients.consumer.{ConsumerConfig, KafkaConsumer}
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerConfig}
import org.apache.kafka.common.serialization.{ByteArrayDeserializer, StringDeserializer, StringSerializer}

trait KafkaConfigTrait {

  def getProducerConfig: KafkaProducer[String, GenericData.Record] = {
    val props = new Properties()
    props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "http://localhost:9092")
    props.put("schema.registry.url", "http://localhost:8081")
    props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, classOf[StringSerializer].getCanonicalName)
    props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, classOf[KafkaAvroSerializer].getCanonicalName)
    props.put(ProducerConfig.ACKS_CONFIG, "all")
    props.put(ProducerConfig.RETRIES_CONFIG, "3")
    props.put(ProducerConfig.LINGER_MS_CONFIG, "2")
    props.put(ProducerConfig.BATCH_SIZE_CONFIG, "1000")

    val producer = new KafkaProducer[String, GenericData.Record](props)
    producer
  }

  def getConsumerConfig: KafkaConsumer[String, GenericData.Record] = {
    val props = new Properties()
    props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "http://localhost:9092")
    props.put("schema.registry.url", "http://localhost:8081")
    props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, classOf[StringDeserializer].getCanonicalName)
    props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, classOf[KafkaAvroDeserializer].getCanonicalName)
    props.put(ConsumerConfig.GROUP_ID_CONFIG, "poc-consumer4")
    props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest")
    props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true)
    props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "30000")

    val consumer = new KafkaConsumer[String, GenericData.Record](props)
    consumer
  }


  def getAvroProducerConfig: KafkaProducer[String,UserDetails] = {
    val props = new Properties()
    props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "http://localhost:9092")
    props.put("schema.registry.url", "http://localhost:8081")
    props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, classOf[StringSerializer].getCanonicalName)
    props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, classOf[KafkaAvroSerializer].getCanonicalName)
    props.put(ProducerConfig.ACKS_CONFIG, "all")
    props.put(ProducerConfig.RETRIES_CONFIG, "3")
    props.put(ProducerConfig.LINGER_MS_CONFIG, "2")
    props.put(ProducerConfig.BATCH_SIZE_CONFIG, "1000")

    val producer = new KafkaProducer[String, UserDetails](props)
    producer
  }

  def getAvroConsumerConfig: KafkaConsumer[String, UserDetails] = {
    val props = new Properties()
    props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "http://localhost:9092")
    props.put("schema.registry.url", "http://localhost:8081")
    props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, classOf[StringDeserializer].getCanonicalName)
    props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, classOf[KafkaAvroDeserializer].getCanonicalName)
    props.put(ConsumerConfig.GROUP_ID_CONFIG, "poc-avro-consumer1")
    props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest")
    props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true)
    props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "30000")

    val consumer = new KafkaConsumer[String, UserDetails](props)
    consumer
  }


}
