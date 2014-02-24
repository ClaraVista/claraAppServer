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
case class User(login: String, password: String, email :String, isAdmin : Boolean)

object User {
   /*
  def creatDB()= {
    DB.withConnection {
      implicit connect =>
        SQL(
          """
            |COPY FROM
            |
            |CREATE TABLE t_hello (
            |    login varchar(255) NOT NULL,
            |    password varchar(255) NOT NULL,
            |    email varchar(255) NOT NULL,
            |    isAdmin boolean NOT NULL,
            |    PRIMARY KEY (login)
            |);
          """.stripMargin)
          .on('login -> login, 'password -> password, 'email -> email)
          .executeUpdate()
    }
  }
  */

  /* val userParser = {
     get[String]("login") ~ get[String]("password") ~ get[String]("email") map {
       case lg ~ pwd ~ email => User(lg, pwd)
     }
   } */

  /*

  def all() = DB.withConnection {
    implicit connect =>
      SQL("select * from t_userBis").as(userParser *)
  } */

  /*

  def create(login: String, password: String, email: String) = {
    DB.withConnection {
      implicit connect =>
        SQL("insert into t_userBis (login, password, email, isAdmin) values ({login}, {password}, {email}, false)")
          .on('login -> login, 'password -> password, 'email -> email)
          .executeUpdate()
    }
  } */



  def delete(login: String) {
    DB.withConnection {
      implicit c =>
        SQL("delete from t_userBis where login = {login}").on(
          'login -> login
        ).executeUpdate()
    }
  }

}
