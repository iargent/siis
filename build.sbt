name := "siis"

version := "1.0"

scalaVersion := "2.10.2"

libraryDependencies ++= Seq(
"com.typesafe.slick" %% "slick" % "2.0.0",
"mysql" % "mysql-connector-java" % "latest.release",
"org.slf4j" % "slf4j-nop" % "1.6.4",
"org.seleniumhq.webdriver" % "webdriver-selenium" % "0.9.7376",
"org.seleniumhq.webdriver" % "webdriver-htmlunit" % "0.9.7376",
"org.seleniumhq.selenium" % "selenium-java" % "2.41.0" % "test",
"org.scalatest" % "scalatest_2.10" % "2.1.0" % "test"
)

val mysql = "mysql" % "mysql-connector-java" % "5.1.12"