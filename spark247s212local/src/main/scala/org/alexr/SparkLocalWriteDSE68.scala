package org.alexr

import org.alexr.data.Data.people
import org.alexr.util.ScalaVersion
import org.apache.spark.sql.{SaveMode, SparkSession}

object SparkLocalWriteDSE68 {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("Example #2")
      .master("local")
      .getOrCreate()

    val df = spark
            .createDataFrame(people)

    df.printSchema()

    df.write
      .format("org.apache.spark.sql.cassandra")
      .options(Map(
        "spark.cassandra.connection.host" -> "127.0.0.1",
        "spark.cassandra.connection.port" -> "9842",
        "table" -> "person",
        "keyspace" -> "space68")
      )
      .mode(SaveMode.Append)
      .save()

    spark.close()

  }

}
