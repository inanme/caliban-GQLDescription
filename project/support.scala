import sbt.*

object Version {
  val betterMonadicFor = "0.3.1"
  val cats             = "2.10.0"
  val circe            = "0.14.6"
  val effect           = "3.5.4"
  val fs2              = "3.9.4"
  val http4s           = "0.23.26"
  val kindProjector    = "0.13.3"
  val natchezVersion   = "0.3.5"
  val sangria          = "4.1.0"
  val scala            = "2.13.13"
  val scala3           = "3.4.0"
  val sttp             = "3.9.3"
  val zio              = "2.0.21"
  val zioConfig        = "4.0.1"
}
object Dependencies {
  val kindProjector =
    "org.typelevel" % "kind-projector" % Version.kindProjector cross CrossVersion.full
  val betterMonadicFor =
    "com.olegpy" %% "better-monadic-for" % Version.betterMonadicFor

  val fs2: Seq[ModuleID] = Seq(
    "co.fs2" %% "fs2-core"   % Version.fs2,
    "co.fs2" %% "fs2-io"     % Version.fs2,
    "co.fs2" %% "fs2-scodec" % Version.fs2
  )
  def cats(scalaVersion: String): Seq[ModuleID] = Seq(
    "org.typelevel" %% "cats-core"   % Version.cats,
    "org.typelevel" %% "cats-free"   % Version.cats,
    "org.typelevel" %% "cats-kernel" % Version.cats,
    "org.typelevel" %% "cats-mtl"    % "1.4.0"
  ) ++ (
    CrossVersion.partialVersion(scalaVersion) match {
      case Some((2, 13)) => Option("org.typelevel" %% "cats-tagless-macros" % "0.15.0")
      case _             => None
    }
  )
  val effect: Seq[ModuleID] = Seq(
    "org.typelevel"       %% "cats-effect"        % Version.effect,
    "org.typelevel"       %% "cats-effect-kernel" % Version.effect,
    "org.typelevel"       %% "cats-effect-std"    % Version.effect,
    "com.disneystreaming" %% "weaver-cats"        % "0.8.4",
    "com.disneystreaming" %% "weaver-scalacheck"  % "0.8.4"
  )
  def circe(scalaVersion: String): Seq[ModuleID] = Seq(
    "io.circe" %% "circe-core"    % Version.circe,
    "io.circe" %% "circe-generic" % Version.circe,
    "io.circe" %% "circe-literal" % Version.circe,
    "io.circe" %% "circe-parser"  % Version.circe
  ) ++ (
    CrossVersion.partialVersion(scalaVersion) match {
      case Some((2, 13)) => Option("io.circe" %% "circe-shapes" % Version.circe)
      case _             => None
    }
  )
  val http4s: Seq[ModuleID] = Seq(
    "org.typelevel" %% "case-insensitive"       % "1.4.0",
    "org.http4s"    %% "http4s-blaze-client"    % "0.23.16",
    "org.http4s"    %% "http4s-blaze-server"    % "0.23.16",
    "org.http4s"    %% "http4s-jdk-http-client" % "0.9.1",
    "org.http4s"    %% "http4s-ember-client"    % Version.http4s,
    "org.http4s"    %% "http4s-ember-server"    % Version.http4s,
    "org.http4s"    %% "http4s-circe"           % Version.http4s,
    "org.http4s"    %% "http4s-dsl"             % Version.http4s
  )

  val logging: Seq[ModuleID] = Seq(
    "org.typelevel" %% "log4cats-core"  % "2.6.0",
    "org.typelevel" %% "log4cats-slf4j" % "2.6.0",
    "org.slf4j"      % "slf4j-api"      % "2.0.12",
    "org.slf4j"      % "slf4j-simple"   % "2.0.12"
  )

  val zio: Seq[ModuleID] = Seq(
    "dev.zio" %% "zio"               % Version.zio,
    "dev.zio" %% "zio-http"          % "3.0.0-RC4",
    "dev.zio" %% "zio-opentracing"   % "3.0.0-RC21",
    "dev.zio" %% "zio-prelude"       % "1.0.0-RC23",
    "dev.zio" %% "zio-streams"       % Version.zio,
    "dev.zio" %% "zio-test"          % Version.zio % Test,
    "dev.zio" %% "zio-test-magnolia" % Version.zio % Test,
    "dev.zio" %% "zio-test-sbt"      % Version.zio % Test
  ) ++ Seq(
    "dev.zio" %% "zio-config"          % Version.zioConfig,
    "dev.zio" %% "zio-config-magnolia" % Version.zioConfig,
    "dev.zio" %% "zio-config-typesafe" % Version.zioConfig
  )

  def caliban(calibanVersion: String): Seq[ModuleID] = Seq(
    "com.github.ghostdogpr" %% "caliban"            % calibanVersion,
    "com.github.ghostdogpr" %% "caliban-cats"       % calibanVersion,
    "com.github.ghostdogpr" %% "caliban-client"     % calibanVersion,
    "com.github.ghostdogpr" %% "caliban-federation" % calibanVersion,
    "com.github.ghostdogpr" %% "caliban-http4s"     % calibanVersion,
    "com.github.ghostdogpr" %% "caliban-quick"      % calibanVersion,
    "com.github.ghostdogpr" %% "caliban-tracing"    % calibanVersion,
    "com.github.ghostdogpr" %% "caliban-zio-http"   % calibanVersion
  ) ++ sttp

  def sangria: Seq[ModuleID] = Seq(
    "org.sangria-graphql" %% "sangria-ast"    % Version.sangria,
    "org.sangria-graphql" %% "sangria-core"   % Version.sangria,
    "org.sangria-graphql" %% "sangria-parser" % Version.sangria
  )

  val sttp = Seq[ModuleID](
    "com.softwaremill.sttp.client3" %% "async-http-client-backend-cats" % Version.sttp,
    "com.softwaremill.sttp.client3" %% "async-http-client-backend-zio"  % Version.sttp,
    "com.softwaremill.sttp.client3" %% "core"                           % Version.sttp,
    "com.softwaremill.sttp.client3" %% "jsoniter"                       % Version.sttp
  )

  val testing: Seq[ModuleID] = Seq(
    "org.scalacheck"       %% "scalacheck"                    % "1.17.0"       % Test,
    "org.scalameta"        %% "munit"                         % "0.7.29"       % Test,
    "org.typelevel"        %% "cats-effect-testing-scalatest" % "1.5.0"        % Test,
    "org.typelevel"        %% "cats-effect-testkit"           % Version.effect % Test,
    "org.typelevel"        %% "cats-testkit-scalatest"        % "2.1.5"        % Test,
    "org.typelevel"        %% "munit-cats-effect-3"           % "1.0.7"        % Test,
    "org.typelevel"        %% "scalacheck-effect"             % "1.0.4"        % Test,
    "com.eed3si9n.expecty" %% "expecty"                       % "0.16.0"
  )

  val natchez: Seq[ModuleID] = Seq(
    "org.tpolecat" %% "natchez-core"    % Version.natchezVersion,
    "org.tpolecat" %% "natchez-datadog" % Version.natchezVersion,
    "org.tpolecat" %% "natchez-log"     % Version.natchezVersion,
    "org.tpolecat" %% "natchez-jaeger" % Version.natchezVersion exclude (" io.jaegertracing", "jaeger-thrift"),
    "org.tpolecat"  %% "natchez-noop"    % Version.natchezVersion,
    "org.tpolecat"  %% "natchez-http4s"  % "0.5.0",
    "com.datadoghq"  % "dd-trace-ot"     % "1.30.0",
    "io.opentracing" % "opentracing-api" % "0.33.0"
  )

  val otel4s: Seq[ModuleID] = Seq(
    "org.typelevel"   %% "otel4s-java"                               % "0.4.0",
    "org.http4s"      %% "http4s-otel4s-middleware"                  % "0.3.0",
    "io.opentelemetry" % "opentelemetry-exporter-otlp"               % "1.35.0" % Runtime,
    "io.opentelemetry" % "opentelemetry-sdk-extension-autoconfigure" % "1.35.0" % Runtime
  )

  def typelevel(scalaVersion: String): Seq[ModuleID] =
    fs2 ++ cats(scalaVersion) ++ effect ++ circe(scalaVersion) ++ http4s ++ logging
}
