### compile

`sbt spark247s212/assembly`

### copy to spark folder

`cp ./spark247s212/target/scala-2.12/spark247s212-assembly-0.0.3.jar ~/rw`

### submit to spark

`
/usr/bin/spark-2.4.7-bin-hadoop2.7/bin/spark-submit \ 
--class org.alexr.SparkApplication \
--master local[2] \
./spark247s212-assembly-0.0.3.jar
`
