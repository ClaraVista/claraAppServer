package controllers

import play.api.mvc._
import play.api.data.Form
import play.api.data.Forms._


/**
 * Created with IntelliJ IDEA.
 * User: spark
 * Date: 2/18/14
 * Time: 4:57 PM
 */
case class signUpForm(login: String, password: String, pwdConfirmation: String, email: String)


object IndexController extends Controller {

  var indexActive : Boolean = false

  val userForm : Form[signUpForm] = Form(
    mapping(
      "username" -> nonEmptyText,
      "password" -> nonEmptyText,
      "pwdConfirmation" -> nonEmptyText,
      "email" -> text
    )(signUpForm.apply)(signUpForm.unapply)
  )

  def checkPassword = Action {
     indexActive = true
     FluxController.fluxActive = false
     Redirect(routes.FluxController.displayFlux)
  }


}
