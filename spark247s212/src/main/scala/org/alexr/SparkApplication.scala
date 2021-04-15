package org.alexr

import org.alexr.data.Data.people
import org.alexr.util.ScalaVersion
import org.apache.spark.sql.SparkSession

object SparkApplication {

  def main1(args: Array[String]): Unit = {
    println(s"module common: ${Constants.commonVersion}")
    println(s"module spark247s212: ${ScalaVersion.line}")

    val address =
      "local"
//      "spark://localhost:7077"

    val data = (1 to 10).map(Tuple1(_)).toVector

    val spark = SparkSession.builder()
      .appName("Example #2")
      .master(address)
      .getOrCreate()

    val df = spark
            .createDataFrame(people)
//      .createDataFrame(data)

    df.printSchema()

  }

}
