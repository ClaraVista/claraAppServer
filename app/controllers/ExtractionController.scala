package controllers

import play.api.mvc.{Action, Controller}
import views.html.helperForm
import play.api.data.Form
import play.api.data.Forms._
import models.IndexModel
import play.api.Routes


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
    extractionActive = true
    FluxController.fluxActive = false
    //models.ExtractionModel.selectLastFileDB()
    //  println("Okkk " + models.ExtractionModel.fieldsNameTableFormatIdDB())
    Ok(views.html.header().+=(views.html.extraction(models.ExtractionModel.fieldsNameTableFormatIdDB().sortBy(r => r.order)).+=(views.html.footer())))
  }


  def checkedValues(fieldsNames: String) = Action {
    println("Ok je suis ici " + "          " + fieldsNames)
    Redirect(routes.ExtractionController.displayExtraction)

  }


}
