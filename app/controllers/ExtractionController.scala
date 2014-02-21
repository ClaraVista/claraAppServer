package controllers

import play.api.mvc.{Action, Controller}

/**
 * Created with IntelliJ IDEA.
 * User: spark
 * Date: 2/19/14
 * Time: 10:34 AM
 */
object ExtractionController extends Controller {

  var extractionActive : Boolean  = false

  def displayExtraction = Action {
    extractionActive = true
    FluxController.fluxActive = false
    //models.ExtractionModel.selectLastFileDB()
    println("Okkk " + models.ExtractionModel.fieldsNameTableFormatIdDB())
    Ok(views.html.header().+=(views.html.extraction()).+=(views.html.footer()))
  }

}
