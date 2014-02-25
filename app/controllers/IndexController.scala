package controllers

import play.api.mvc._
import play.api.data.Form
import play.api.data.Forms._
import views.html.helperForm
import models.IndexModel


/**
 * Created with IntelliJ IDEA.
 * User: spark
 * Date: 2/18/14
 * Time: 4:57 PM
 */

object IndexController extends Controller {

  case class signUpForm(login: String, password: String)

  object HelperForm {
    import views.html.helper.FieldConstructor
    implicit val fieldForm = FieldConstructor(helperForm.f)
  }


  var indexActive : Boolean = false

  val indexForm : Form[signUpForm] = Form(
    mapping(
      "login" -> text,
      "password" -> text
    )(signUpForm.apply)(signUpForm.unapply)
  )

  def index = Action {
    Ok(views.html.index(indexForm))
    //Ok(views.html.indexbis(User.all(), userForm))
  }

  def checkPassword = Action {
    implicit request =>
         indexForm.bindFromRequest.fold(
            errors => BadRequest(views.html.index(indexForm)),
            fields => {
             if(!IndexModel.checkPassword(fields.login, fields.password))
               Redirect(routes.FluxController.displayFlux)
              else  Redirect(routes.IndexController.index)
            }
         )
  }

}
