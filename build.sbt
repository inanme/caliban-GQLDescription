Global / fork := true

lazy val `caliban-GQLDescription` = (project in file("."))
  .enablePlugins(CalibanPlugin)
  .settings(
    organization := "org.inanme",
    scalaVersion := Version.scala3,
    scalacOptions ++= Seq(
      "-Wconf:msg=\\$implicit\\$:s"
    ),
    semanticdbEnabled := true,                        // enable SemanticDB
    semanticdbVersion := scalafixSemanticdb.revision, // use Scalafix compatible version
    libraryDependencies ++= Dependencies.zio ++ Dependencies
      .circe(scalaVersion.value) ++ Dependencies.caliban(
      (Compile / calibanVersion).value
    ) ++ Dependencies.logging
  )
