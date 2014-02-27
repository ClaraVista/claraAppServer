package models

import anorm.SqlParser._
import anorm._
import play.api.db.DB
import play.api.Play.current
import scala.Predef._
import anorm.~


/**
 * Created with IntelliJ IDEA.
 * User: spark
 * Date: 2/20/14
 * Time: 11:21 AM
 */

case class formatId(fieldName: String, description: String, order: Int)

object ExtractionModel {

  val path : String = "/tmp/test2"

  val fieldsNameParser = {
    str("fieldname") ~ str("indicatorname") ~ get[Int]("orderofname") map {
      case fn ~ in ~ ofn => formatId(fn, in, ofn)
    }
  }

  def maxIdFormatOfTableFieldReceivedDB() = DB.withConnection {
    implicit connect => SQL("select * from t_file_received").as(get[Int]("idformat") *).last
  }

  val idFormat = maxIdFormatOfTableFieldReceivedDB()

  def fieldsNameOfTableFormatIdDB() = DB.withConnection {
    implicit connect => SQL(new String("select fieldname, indicatorname, orderofname from t_format_indicators WHERE idformat=" + idFormat)).as(fieldsNameParser *)
  }

  def createFileToSend(fieldsNames: List[String]) = DB.withConnection {
    implicit connect =>
      val fieldsNamesSQL = fieldsNames.mkString(" , ")
      SQL("COPY (SELECT " + fieldsNamesSQL + " FROM recep2) TO '"+ path +"' CSV HEADER").executeUpdate()
  }

}
