package org.alexr

import org.alexr.data.Data.people
import org.apache.spark.sql.{SaveMode, SparkSession}

object SparkStandalone {

  def code = {
    val spark = SparkSession.builder()
      .appName("Example #1")
      .master("local")
      .getOrCreate()

    val df = spark
      .createDataFrame(people)

    df.printSchema()


    spark.close()
  }

  def main(args: Array[String]): Unit = code

}
