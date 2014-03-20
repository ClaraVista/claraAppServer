package controllers

import play.api._
import play.api.mvc._
import scala.io.Source
import play.api.data._
import play.api.data.Forms._
import models.User

object Application extends Controller {

//  type Fields = (String, String, String, String)
  case class signUpForm(login: String, password: String, pwdConfirmation: String, email: String)

  val userForm : Form[signUpForm] = Form(
    mapping(
      "login" -> nonEmptyText,
      "password" -> nonEmptyText,
      "pwdConfirmation" -> nonEmptyText,
      "email" -> text
    )(signUpForm.apply)(signUpForm.unapply)
  )

  /*
  def index = Action {
    Ok(views.html.index())
    //Ok(views.html.indexbis(User.all(), userForm))
  }
  */

  /*
  def create = Action {
     User.creatDB()
    Ok("DONE")
  } */
//  def newUser = Action {
//    implicit request =>
//      userForm.bindFromRequest.fold(
//        errors => BadRequest(views.html.index(User.all(), errors)),
//        fields => {
//          User.create(fields.login, fields.password, fields.email)
//          Redirect(routes.Application.index)
//        }
//      )
//  }

  /*
  def deleteUser(login: String) = Action {
    User.delete(login)
    Redirect(routes.Application.index)
  }
  */

  // create chart

//  def prepareData = {
//    val c = curve.lift.result
//    val dist1 = models.DataPoint.loadData.filter(_.label == 1.0)
//    val dist2 = models.DataPoint.loadData.filter(_.label != 1.0)
//    (c, dist1, dist2)
//  }
//
//  def googleChart = Action {
//    val (c, dist1, dist2) = prepareData
//    Ok(views.html.googleChart("Google Chart")(c)(dist1)(dist2))
//  }
//
//  def highChart = Action {
//    val (c, dist1, dist2) = prepareData
//    Ok(views.html.highChart("High Chart")(c)(dist1)(dist2))
//  }

  // start and stop EC2 instances cluster

  /*
  def startEC2 = Action {
    Runtime.getRuntime.exec("/home/spark/development/scripts/ec2cmd.sh test start")
    Ok("EC2 cluster is starting...")
  }

  def stopEC2 = Action {
    Runtime.getRuntime.exec("/home/spark/development/scripts/ec2cmd.sh test stop")
    Ok("EC2 cluster is stopping...")
  }
  */

}
