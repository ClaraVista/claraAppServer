package models

import java.sql.{Date}
import anorm.SqlParser._
import anorm._
import play.api.db.DB
import anorm.~
import org.joda.time.DateTime
import AnormExtension._
import play.api.Play.current

/**
 * Created with IntelliJ IDEA.
 * User: spark
 * Date: 2/19/14
 * Time: 12:04 PM
 */


case class Flow (idFlow: Int, name: String, dateFirst: DateTime, nbLinesTotal: Int, dateLastReceived: DateTime, nbLinesReceived: Int)
case class GlobalId(idIndicators: Int, name: String, description: String, order: Int, value: Int)

object FluxModel {

  val userParser = {
    get[Int]("idflow") ~ get[String]("name") ~ get[DateTime]("firstdate") ~ get[Int]("nb_lines_total") ~ get[DateTime]("lastreceptiondate") ~get[Int]("nb_lines_received") map {
      case id ~ n ~ fd ~ nlt ~ lrd ~ nlr => Flow(id, n, fd, nlt,lrd, nlr)
    }
  }

  def all() = DB.withConnection {
    implicit connect =>
      SQL("select * from t_flow").as(userParser *)
  }

}
