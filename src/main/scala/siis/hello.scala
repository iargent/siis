package siis

import scala.io.Source

object hello {
  def main(args: Array[String]) {
    println("Main starting")
    val  x=scala.io.Source.fromURL("http://www.google.com")
    println(x.getLines().mkString("\n"))
  }
}