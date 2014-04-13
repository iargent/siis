package siis

import org.openqa.selenium.htmlunit.HtmlUnitDriver
import scala.collection._

class EduBase {
  val baseUrl = "http://www.education.gov.uk/edubase/public/quickSearchResult.xhtml?page="
  val baseLink = "URL: http://www.education.gov.uk/edubase/establishment/summary.xhtml?urn="
  val xpath = "//*[@class=\"search_results\"]/tbody/tr/td/a"
  val driver = new HtmlUnitDriver
  val urnRegex = ".*urn=(.*)".r

  def getPage(page: Int) = {
    println("getPage: "+page)
    driver.get(baseUrl + page.toString)
    val es = driver.findElementsByXPath(xpath).iterator()
    var retMap = mutable.Map[Int, String]()
    while (es.hasNext) {
      val urn = findUrn(es.next().getAttribute("href"))
      val link = baseLink + urn
      retMap(urn.toInt) = link
    }
    retMap
  }

  def getAllPages(): Map[Int, String] = {
    var i = 1077
    var mapSize = 0
    var retMap = mutable.Map[Int, String]()
    do {
      println(i)
      i += 1
      val newMap = getPage(i)
      var mapSize = newMap.size
      println(i + "->" + mapSize)
      retMap ++= newMap
    } while (mapSize > 0)
    retMap
  }

  def findUrn(s: String): String = {
    s match {
      case urnRegex(urn) => urn
      case _ => ""
    }
  }

}