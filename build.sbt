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