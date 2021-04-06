Global / onChangedBuildSource := ReloadOnSourceChanges

ThisBuild / organization := "org.alexr"
ThisBuild / scalaVersion := "2.12.13"
name := "sparks212"

scalacOptions ++= Seq(
  "-encoding", "UTF-8",
  "-feature",
  "-deprecation",
  "-unchecked",
  "-language:postfixOps",
  "-language:higherKinds",
//  "-Ymacro-annotations",
  "-Ywarn-value-discard",
  "-Ywarn-dead-code",
  "-Ywarn-unused",
  "-Xfatal-warnings",
)

libraryDependencies ++= Seq(
  "com.lihaoyi"       %% "pprint"                   % "0.6.4",
  "com.lihaoyi"       %% "fansi"                    % "0.2.12",
  "com.lihaoyi"       %% "upickle"                  % "1.3.11",
  "org.scalatest"     %% "scalatest-shouldmatchers" % "3.2.7",
  "org.scalatest"     %% "scalatest-funspec"        % "3.2.7",
  "org.scalacheck"    %% "scalacheck"               % "1.15.2", // due to 2.11
)

lazy val common = (project in file("common"))

/** spark 3.1.1 + scala 2.12 */
lazy val spark311s212 = (project in file("spark311s212"))
  .dependsOn(common)

/** spark 2.4.7 + scala 2.12 % Provided */
lazy val spark247s212 = (project in file("spark247s212"))
  .dependsOn(common)

/** spark 2.4.7 + scala 2.12 */
lazy val spark247s212local = (project in file("spark247s212local"))
  .dependsOn(common)

lazy val whole = (project in file("."))
  .aggregate(
    common,
    spark247s212,
    spark311s212,
  )
