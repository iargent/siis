package siis

import org.openqa.selenium.htmlunit.HtmlUnitDriver
import java.sql.{ Connection, DriverManager, ResultSet };

import scala.slick.driver.MySQLDriver.simple._
//import slickTest.DB.SuppliersEntity

object hello {
  def main(args: Array[String]) {
    println("Main starting")
    val schemaName = "slickTest"
    val conn_str = System.getenv("SIISDB")

    // Load the driver
    Class.forName("com.mysql.jdbc.Driver")

    //val k = new EduBase
    //val res = k.getPage(1)
    val res=Map[Int,Char]()

    // Setup the connection
    val conn = DriverManager.getConnection(conn_str)
    try {
      // Configure to be Read Only
      val statement = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)

      for (urn<-res) {
      // Execute Query
      val rs = statement.executeQuery("""
          SELECT *
          FROM fact
          LIMIT 5
""")

      // Iterate Over ResultSet
      while (rs.next) {
        println(rs.getString("quote"))
      }
      }
    } finally {
      conn.close
    }

    /*
    val k = new EduBase

    val results = k.getAllPages
    println(results.size)
    for (r <- results) {
      println(r._1)
      println(r._2)
    }
    * 
    */
  }
  println("Done!")

}
