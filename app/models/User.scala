package models

import play.api.db._
import play.api.Play.current
import anorm._
import anorm.SqlParser._


/**
 * Created with IntelliJ IDEA.
 * User: spark
 * Date: 1/22/14
 * Time: 11:55 AM
 */
case class User(login: String, password: String, email: String, isAdmin: Boolean = false)

object User {

  val userParser = {
    get[String]("login") ~ get[String]("password") ~ get[String]("email") map {
      case lg ~ pwd ~ email => User(lg, pwd, email)
    }
  }

  def all() = DB.withConnection {
    implicit connect =>
      SQL("select * from t_user").as(userParser *)
  }

  def create(login: String, password: String, email: String) = {
    DB.withConnection {
      implicit connect =>
        SQL("insert into t_user (login, password, email, isAdmin) values ({login}, {password}, {email}, false)")
          .on('login -> login, 'password -> password, 'email -> email)
          .executeUpdate()
    }
  }

  def delete(login: String) {
    DB.withConnection {
      implicit c =>
        SQL("delete from t_user where login = {login}").on(
          'login -> login
        ).executeUpdate()
    }
  }
}
