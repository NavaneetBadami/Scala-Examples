package com.kafka.poc

import com.avro.data.UserDetails

class PocMis {


  //  def getAvroRecord(message: GenericData.Record): Option[User] = {
  //    val schemaJson =
  //      s"""
  //    { "namespace": "com.avro.data", "type": "record", "name": "User2",
  //      "fields": [ {"name": "name", "type": "string"}, {"name": "id",  "type": "int"}, {"name": "loc", "type": "string"}]
  //    }
  //     """
  //    val parser = new Parser
  //    val valueSchemaAvro = parser.parse(schemaJson)
  //    //deserialize
  //    val reader = new SpecificDatumReader[GenericRecord](valueSchemaAvro)
  //    val decoder = DecoderFactory.get().binaryDecoder(, null)
  //    val userData = reader.read(null, decoder)
  //
  //    val finalUser = Try[User](User(userData.get("name").toString, userData.get("id").toString.toInt, userData.get("loc").toString))
  //    finalUser match {
  //      case Success(u) => Some(u)
  //      case Failure(e) => None
  //    }
  //  }
}
