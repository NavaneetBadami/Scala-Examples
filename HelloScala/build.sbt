import sbt.util

name := "HelloScala"

version := "0.1"
logLevel := util.Level.Info
scalaVersion := "2.13.4"
libraryDependencies ++= Seq("ch.qos.logback" % "logback-classic"% "1.1.7",
  "org.apache.kafka" %% "kafka-streams-scala" % "2.7.0",
  "org.apache.avro"  %  "avro"  %  "1.7.7",
  "org.apache.kafka" % "kafka_2.11" % "0.10.0.0",
  "org.apache.avro" % "avro" % "1.8.2",
  "io.confluent" % "kafka-avro-serializer" % "3.2.1"
)

resolvers ++= Seq(Classpaths.typesafeReleases,
  "confluent" at "https://packages.confluent.io/maven/"
)

sourceGenerators in Compile += (avroScalaGenerateSpecific in Compile).taskValue

//enablePlugins(SrcGenPlugin)
//import higherkindness.mu.rpc.srcgen.Model._
//
//// Look for Avro IDL files
//muSrcGenIdlType := IdlType.Avro
//addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.1" cross CrossVersion.patch)

//sourceGenerators in Compile += (avroScalaGenerate in Compile).taskValue
//
//(avroSpecificSourceDirectory in Compile) := new java.io.File("src/main/resources/avro")
//
//(avroScalaSpecificCustomNamespace in Compile) := Map("" -> "avro")
//
//(avroSpecificScalaSource in Compile) := new java.io.File("target/generated-sources/avro")


//libraryDependencies ++= Seq(
//  "org.scala-lang.modules" %% "scala-parser-combinators" % "1.1.2",
//  "org.apache.spark" %% "spark-core" % "3.0.1",
//  "org.apache.spark" %% "spark-sql" % "3.0.1",
//  "org.reactivemongo" %% "reactivemongo-bson-api" % "0.20.11",
//  "org.mongodb.spark" %% "mongo-spark-connector" % "3.0.0",
//  "com.ibm.db2.jcc" % "db2jcc" % "db2jcc4"
//)
//resolvers += Resolver.typesafeRepo("releases")
//resolvers ++= Seq(
//  "snapshots" at "http://oss.sonatype.org/content/repositories/snapshots",
//  "releases" at "http://oss.sonatype.org/content/repositories/releases"
//)
//resolvers += Resolver.typesafeRepo("releases")
//resolvers += "Typesafe" at "http://repo.typesafe.com/typesafe/releases/"
//
//resolvers += "Java.net Maven2 Repository" at "http://download.java.net/maven/2/"

//resolvers ++= Seq(
//  "Typesafe" at "http://repo.typesafe.com/typesafe/releases/",
//  "Java.net Maven2 Repository" at "http://download.java.net/maven/2/"
//)

//resolvers  += "Online Play Repository" at
//  "http://repo.typesafe.com/typesafe/simple/maven-releases/"