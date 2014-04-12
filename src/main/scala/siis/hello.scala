package siis

import org.openqa.selenium.htmlunit.HtmlUnitDriver

object hello {
  def main(args: Array[String]) {
    println("Main starting")

    val url = "http://www.education.gov.uk/edubase/public/quickSearchResult.xhtml?myListCount=0"

    val driver = new HtmlUnitDriver
    driver.get(url)
    val es = driver.findElementsByXPath("//*[@class=\"search_results\"]/tbody/tr/td/a").iterator()
    while (es.hasNext) {
      val e = es.next()
      println("Establishment name: " + e.getText())
      println("               URL: http://www.education.gov.uk/edubase/establishment/summary.xhtml?urn="
          + findUrn(e.getAttribute("href")))
    }
    println("Done!")
  }

  def findUrn(s: String): String = {
    val regex = ".*urn=(.*)".r
    s match {
      case regex(urn) => urn
      case _ => ""
    }
  }

}
