import sbtassembly.MergeStrategy

val sparkVersion = "2.4.7"

version := "0.0.3"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion % Provided,
  "org.apache.spark" %% "spark-sql"  % sparkVersion % Provided,
  "com.datastax.spark" %% "spark-cassandra-connector" % "2.5.0",
)

artifactName := { (sv: ScalaVersion, module: ModuleID, artifact: Artifact) =>
  artifact.name + "_" + sv.binary + "-" + sparkVersion + "_" + module.revision + "." + artifact.extension
}

// do not put scala standard library into fat JAR
//assembly / assemblyOption := (assembly / assemblyOption).value.copy(includeScala = false)

assembly / assemblyMergeStrategy := {
  case PathList("module-info.class", _ @ _*) => MergeStrategy.discard
  case x: String =>
    val old: String => MergeStrategy = (assembly / assemblyMergeStrategy).value
    old(x)
}
