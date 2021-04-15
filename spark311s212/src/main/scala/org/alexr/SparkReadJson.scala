package org.alexr

import org.apache.spark.sql.{DataFrame, Row, SparkSession}

object SparkReadJson extends App {

  val spark = SparkSession.builder()
    .appName("Example #1")
    .master("local")
    .getOrCreate()

  val jsonFile = getClass.getResource("cars.json").toURI.toString
  val csvFile = getClass.getResource("titanic.csv").toURI.toString

  /** inferring schema  */
  val df1 = spark.read
    .option("inferSchema", true) // by default
    .json(jsonFile)

  val df2 = spark.read
    .option("header", true)
    .option("inferSchema", true)
    .csv(csvFile)

  df1.printSchema()
  df2.printSchema()

  val cols: Array[String] = df2.columns
  println(cols.mkString("Array(", ", ", ")"))

  for (row <- df2.head(10)) {
    println(row)
  }

  val r2: DataFrame = df2
    .select("PassengerId", "Name")

  val r3 = r2
    .select("PassengerId")
//    .as("pid")

  //    .withColumn("abc", df2("Pclass"))

  r3.show(5)

  /** Scala syntax */
  import spark.implicits._
  df2
    .filter('PassengerId % 2 > 0 && $"Fare" < 10 && 'Embarked === "S")
    .show(5)

  /** Spark SQL */
  val r4: Array[Row] = df2
    .filter("PassengerId % 2 > 0 AND Fare < 10")
//    .select('Fare)
    .collect()

  /** apache spark useful functions: https://spark.apache.org/docs/latest/api/java/org/apache/spark/sql/functions.html  */
  import org.apache.spark.sql.functions._


  df2.select(corr("a", "b"))

  pprint.pprintln(r4)

  spark.close()
}
