name := "hello"
version := "1.0"
scalaVersion := "2.12.12"

lazy val common = project.in(file("common"))
    .settings(
        libraryDependencies ++= Seq(
            "org.json4s" %% "json4s-native" % "4.1.0", 
            "com.eltimn" %% "sbt-slf4j" % "1.0.4",
            "com.typesafe" %% "config" % "1.4.2",
            "org.scalatest" %% "scalatest" % "3.2.11" % "test",
            "org.mockito" %% "mockito-scala_2.11" % "1.13.6" % "test"
        )
)

lazy val persistence = project.in(file("persistence"))
    .settings(
        libraryDependencies ++= Seq(
            "com.typesafe.slick" %% "slick" % "3.0.0",
            "org.postgresql" %% "postgresql" % "42.3.4",
            "com.h2database" %% "h2" % "1.4.192" % "test"
        )
    )
    .dependsOn(common)

addSbtPlugin("org.scalastyle" % "scalastyle-sbt-plugin" % "1.0.0")
addSbtPlugin("io.github.knoldus" % "codesquad-sbt-plugin" % "0.2.1")

lazy val root = project.in(file(".")).aggregate(common, persistence)