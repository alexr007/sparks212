package org.alexr

import org.alexr.data.Data.people
import org.apache.spark.sql.{SaveMode, SparkSession}

object SparkLocalWriteDSE68ocs {

  def cassandraHosts(env: String) = (1 to 3)
    .map(h => s"dse-$h.$env.sdw.ocs").mkString(",")

  val cassandraDriver = "org.apache.spark.sql.cassandra"

  val cassandraConnection = Map(
    "spark.cassandra.connection.host" -> cassandraHosts("staging"),
    "spark.cassandra.connection.port" -> "9042",
    "spark.cassandra.auth.username"-> "...",
    "spark.cassandra.auth.password" -> "...",
  )

  val cassandraTableDetails = Map(
    "keyspace" -> "space68",
    "table" -> "person",
  )

  def code = {
    val spark = SparkSession.builder
      .appName("Example #2")
      .master("local")
      .getOrCreate()

    val df = spark
      .createDataFrame(people)

    df.printSchema()

    df.write
      .format(cassandraDriver)
      .options(cassandraConnection)
      .options(cassandraTableDetails)
      .mode(SaveMode.Append)
      .save()

    spark.close()
  }

  def main(args: Array[String]): Unit = code

}
