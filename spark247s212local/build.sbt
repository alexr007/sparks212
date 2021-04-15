val sparkVersion = "2.4.7"

version := "0.0.3"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core"       % sparkVersion,
  "org.apache.spark" %% "spark-sql"        % sparkVersion,
  "org.apache.spark" %% "spark-streaming"  % sparkVersion,

//    "com.datastax.spark" %% "spark-cassandra-connector" % "2.4.2", // 2.11 + 2.12, works with DSE 6.8
//    "com.datastax.spark" %% "spark-cassandra-connector" % "2.4.3", // 2.11 + 2.12, works with DSE 6.8
  "com.datastax.spark" %% "spark-cassandra-connector" % "2.5.0", // 2.11 + 2.12, works with DSE 6.8, works w.o exceptions, (com.datastax.oss:java-driver-core-shaded) version 4.5.0
//    "com.datastax.spark" %% "spark-cassandra-connector" % "2.5.1", // 2.11 + 2.12, works with DSE 6.8, but some exceptions ((com.datastax.oss:java-driver-core-shaded) version 4.7.2)

//    "com.datastax.spark" %% "spark-cassandra-connector" % "3.0.0", // 2.12 ONLY. ISSUES java.lang.NoClassDefFoundError: org/apache/spark/sql/connector/catalog/TableProvider
)

artifactName := { (sv: ScalaVersion, module: ModuleID, artifact: Artifact) =>
  artifact.name + "_" + sv.binary + "-" + sparkVersion + "_" + module.revision + "." + artifact.extension
}

// do not put scala standard library into fat JAR
assembly / assemblyOption := (assembly / assemblyOption).value.copy(includeScala = false)
