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

### yet another links
 - https://jasset75.github.io/Spark-Cassandra-Notes/Examples/dataset-join-02.html
 - https://community.datastax.com/questions/1161/spark-cassandra-connector-issue.html
 - https://itnext.io/spark-cassandra-all-you-need-to-know-tips-and-optimizations-d3810cc0bd4e
 - https://www.datastax.com/blog/install-all-things-especially-apache-cassandra-apache-spark-and-jupyter
