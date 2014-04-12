package siis

import org.openqa.selenium.htmlunit.HtmlUnitDriver
import org.openqa.selenium.By

object hello {
  def main(args: Array[String]) {
    println("Main starting")

    val url = "http://www.education.gov.uk/edubase/public/quickSearchResult.xhtml?myListCount=0"

    val driver = new HtmlUnitDriver
    driver.get(url)
    val raw = driver.findElementsByXPath("//*[@class=\"search_results\"]/tbody/tr/td/a")
    val es = raw.iterator
    while (es.hasNext) {
      val e = es.next()
      println("Establishment name: " + e.getText())

      val href = e.getAttribute("href")
      println("               URL: http://www.education.gov.uk/edubase/establishment/summary.xhtml?urn=" + findUrn(href))

      def findUrn(s: String): String = {
        val regex = ".*urn=(.*)".r
        s match {
          case regex(urn) => urn
          case _ => ""
        }
      }
    }
    println("Done!")
  }
}
