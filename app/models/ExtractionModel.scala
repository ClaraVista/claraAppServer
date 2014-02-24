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
object ExtractionModel {

  val fieldsNameParser = {
    str("fieldname") ~ str("indicatorname")  map {
      case fn ~ in => List(fn,in)
    }
  }

   def maxIdFormatTableFieldReceivedDB() = DB.withConnection {
    implicit connect =>SQL("select * from t_file_received").as(get[Int]("idformat") *).last
  }

   val idFormat = maxIdFormatTableFieldReceivedDB()

   def fieldsNameTableFormatIdDB() = DB.withConnection {
    implicit connect =>SQL(new String("select fieldname, indicatorname from t_format_indicators WHERE idformat=" + idFormat)).as(fieldsNameParser *)
  }

  val listFields = fieldsNameTableFormatIdDB()


  def selectLastFileDB() = DB.withConnection {
    implicit connect =>SQL("select * from recep2").apply()
  }
}
