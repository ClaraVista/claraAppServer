package models

import anorm._
import anorm.SqlParser._
import play.api.db.DB
import play.api.Play.current
import java.io.{FileOutputStream, OutputStreamWriter, BufferedWriter}
import play.mvc.Results.Chunks

/**
 * Created with IntelliJ IDEA.
 * User: spark
 * Date: 2/19/14
 * Time: 11:19 AM
 */

case class IndexModel(login: String, password: String)

object IndexModel {

  val indexParser = {
    get[String]("login") ~ get[String]("password") map {
      case lg ~ pwd => IndexModel(lg, pwd)
    }
  }


  def checkPasswordDB(login: String, password: String) = DB.withConnection {
    implicit connect =>
    SQL("select login, password from t_user where login = {login} and password = {password}").on('login -> login, 'password -> password).as(indexParser *).isEmpty
  }

}
