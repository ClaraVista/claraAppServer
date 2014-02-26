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

  def displayExtraction = Action {
    request => request.session.get("username").map {
      extractionActive = true
      FluxController.fluxActive = false
      user => Ok(views.html.header().+=(views.html.extraction(models.ExtractionModel.fieldsNameTableFormatIdDB().sortBy(r => r.order)).+=(views.html.footer())))
    }.getOrElse {
      Redirect(routes.IndexController.index)
    }
  }



  def checkedValues(fieldsNames: String) = Action {
      println("Ok je suis ici " + "          " + fieldsNames)
      ExtractionModel.createFileToSend(fieldsNames)
      Ok.sendFile(new File("/home/spark/nohup.out"))
      Redirect(routes.ExtractionController.displayExtraction)
  }



}
