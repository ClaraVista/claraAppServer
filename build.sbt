import play.Project._

name := "claraAppServer"

version := "1.0-SNAPSHOT"

play.Project.playScalaSettings

lazy val claraAppServer = project.in(file("."))
    .dependsOn(clarabox)

lazy val clarabox = project

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache
)

libraryDependencies += "com.typesafe.slick" %% "slick" % "2.0.0"

libraryDependencies += "org.postgresql" % "postgresql" % "9.2-1003-jdbc4"
