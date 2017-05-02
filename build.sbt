lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .settings(
    organization := "com.ideonika",
    name := "battleship-matcher",
    version := "0.0.1",
    scalaVersion := "2.11.8"
  )
