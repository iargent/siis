package siis

import org.scalatest.FlatSpec
import org.openqa.selenium._
import org.openqa.selenium.htmlunit._

class EduBaseSearch extends FlatSpec {
  val driver = new HtmlUnitDriver
  driver.get("http://www.education.gov.uk/edubase/public/quickSearchResult.xhtml?myListCount=0")

  // verify we retrieved the page and have the title
  "EduBase" should "have the proper title" in {
    assert(driver.getTitle() === "Establishment list")
  }

  it should "have term in result set" in {
    val firstResult = driver.findElement(By.xpath("//*[@class=\"vcard\"]/div"))
    println(firstResult.getText())
    assert(firstResult.getText contains "d")
  }

}