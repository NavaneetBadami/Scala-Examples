/** MACHINE-GENERATED FROM AVRO SCHEMA. DO NOT EDIT DIRECTLY */
package com.kafka.poc.avro

import scala.annotation.switch

final case class UserDetails(var name: String, var id: Int, var loc: String) extends org.apache.avro.specific.SpecificRecordBase {
  def this() = this("", 0, "")
  def get(field$: Int): AnyRef = {
    (field$: @switch) match {
      case 0 => {
        name
      }.asInstanceOf[AnyRef]
      case 1 => {
        id
      }.asInstanceOf[AnyRef]
      case 2 => {
        loc
      }.asInstanceOf[AnyRef]
      case _ => new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }
  def put(field$: Int, value: Any): Unit = {
    (field$: @switch) match {
      case 0 => this.name = {
        value.toString
      }.asInstanceOf[String]
      case 1 => this.id = {
        value
      }.asInstanceOf[Int]
      case 2 => this.loc = {
        value.toString
      }.asInstanceOf[String]
      case _ => new org.apache.avro.AvroRuntimeException("Bad index")
    }
    ()
  }
  def getSchema: org.apache.avro.Schema = UserDetails.SCHEMA$
}

object UserDetails {
  val SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"UserDetails\",\"namespace\":\"com.kafka.poc.avro\",\"fields\":[{\"name\":\"name\",\"type\":\"string\"},{\"name\":\"id\",\"type\":\"int\"},{\"name\":\"loc\",\"type\":\"string\"}]}")
}