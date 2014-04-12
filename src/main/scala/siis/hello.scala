package siis

import org.openqa.selenium.htmlunit.HtmlUnitDriver

object hello {
  def main(args: Array[String]) {
    println("Main starting")

    val k = new EduBase
    val results = k.getPage(1)
    for (r <- results) {
      println(r._1)
      println(r._2)
    }
  }

}
