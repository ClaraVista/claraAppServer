package controllers

import play.api.mvc.{Action, Controller}
import views.html.helperForm
import play.api.data.Form
import play.api.data.Forms._
import models.{ExtractionModel, IndexModel}
import play.api.Routes
import java.io.File


/**
 * Created with IntelliJ IDEA.
 * User: spark
 * Date: 2/19/14
 * Time: 10:34 AM
 */
object ExtractionController extends Controller {

  def javascriptRoutes = Action {
    implicit request =>

      Ok(
        Routes.javascriptRouter("jsRoutes")(
          routes.javascript.ExtractionController.checkedValues
        )
      ).as("text/javascript")
  }

  var extractionActive: Boolean = false


  val myForm = Form(
    single(
      "fields" -> list(text)
    )
  )


  def displayExtraction = Action {
    request => request.session.get("username").map {
      extractionActive = true
      FluxController.fluxActive = false
      user => Ok(views.html.header().+=(views.html.extraction(models.ExtractionModel.fieldsNameTableFormatIdDB().sortBy(r => r.order), myForm).+=(views.html.footer())))
    }.getOrElse {
      Redirect(routes.IndexController.index)
    }
  }



  def checkedValues = Action {
    implicit request =>
      myForm.bindFromRequest.fold(
        errors => {
          // binding failure, you retrieve the form containing errors:
          println("ERROR")
          BadRequest("Bad request")
        },
        fs => {
          ExtractionModel.createFileToSend(fs)
          Ok.sendFile(new File("/tmp/test.csv"))
        }
      )
  }



}
