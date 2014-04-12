package siis

import org.openqa.selenium.htmlunit.HtmlUnitDriver
import scala.collection._

class EduBase {
  val baseUrl = "http://www.education.gov.uk/edubase/public/quickSearchResult.xhtml?page="

  val driver = new HtmlUnitDriver

  val x = Map
  def getPage(page: Int) = {
    driver.get(baseUrl + page.toString)
    val es = driver.findElementsByXPath("//*[@class=\"search_results\"]/tbody/tr/td/a").iterator()
    var retMap = mutable.Map[Int, String]()
    while (es.hasNext) {
      val e = es.next()
      val urn = findUrn(e.getAttribute("href"))
      val link =
        "URL: http://www.education.gov.uk/edubase/establishment/summary.xhtml?urn=" + urn
      retMap(urn.toInt) = link
    }
    retMap
  }

  def findUrn(s: String): String = {
    val regex = ".*urn=(.*)".r
    s match {
      case regex(urn) => urn
      case _ => ""
    }
  }

}