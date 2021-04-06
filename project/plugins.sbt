/**
 * fat JAR plugin
 *
 * [[https://github.com/sbt/sbt-assembly]]
 *
 * tasks:
 *  - assembly - fat JAR (with options)
 *  - assemblyPackageDependency - all dependencies without
 *
 * put % Provided for these, we don't want to add
 * without SCALA standard library:
 * assembly / assemblyOption := (assembly / assemblyOption).value.copy(includeScala = false)
 * without ANY dependencies:
 * assembly / assemblyOption := (assembly / assemblyOption).value.copy(includeScala = false, includeDependency = false)
 * specify jar name:
 * assembly / assemblyJarName := "something.jar"
 */
addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.15.0")

/**
 * dependency graph investigation
 *
 * [[https://github.com/sbt/sbt-dependency-graph]]
 *
 * tasks:
 * - dependencyTree
 * - dependencyBrowseGraph
 * - dependencyBrowseTree
 * - dependencyList
 * - dependencyStats
 * - dependencyGraph
 *
 */
addDependencyTreePlugin
//addSbtPlugin("net.virtual-void" % "sbt-dependency-graph" % "0.9.2")
