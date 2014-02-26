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


case class Flow (idFlow: Int, name: String, dateFirst: String, nbLinesTotal: Int, dateLastReceived: String, nbLinesReceived: Int)
case class GlobalId(idIndicator: Int, name: String, description: String, order: Int, value: Int)

object FluxModel {

  val flowParser = {
    get[Int]("idflow") ~ get[String]("name") ~ get[DateTime]("firstdate") ~ get[Int]("nb_lines_total") ~ get[DateTime]("lastreceptiondate") ~get[Int]("nb_lines_received") map {
      case id ~ n ~ fd ~ nlt ~ lrd ~ nlr => Flow(id, n, fd.toString("dd-MM-yyyy"), nlt,lrd.toString("dd-MM-yyyy"), nlr)
    }
  }

  val globalIdParser = {
    get[Int]("idindicator") ~ get[String]("name") ~ get[String]("description") ~ get[Int]("orderofname") ~get[Int]("valueofname") map {
      case id ~ n ~ d ~ oon ~ von => GlobalId(id, n, d,oon, von)
    }
  }

  def flowAll() = DB.withConnection {
    implicit connect =>SQL("select * from t_flow").as(flowParser *)
  }

  def globalIdAll() = DB.withConnection {
    implicit connect =>SQL("select * from t_globalid ").as(globalIdParser *)
  }
  def test() = DB.withConnection {
    implicit connect =>SQL("Copy (Select * From t_flow) To '/tmp/test.csv' With CSV;").apply()
  }

}
