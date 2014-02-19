package controllers


import play.api.mvc._


/**
 * Created with IntelliJ IDEA.
 * User: spark
 * Date: 2/18/14
 * Time: 5:02 PM
 */
object FluxController extends Controller {

  var fluxActive : Boolean  = false

  def displayFlux = Action {
    fluxActive = true
    ExtractionController.extractionActive = false

    println(models.FluxModel.all().toString())
    Ok(views.html.header().+=(views.html.flux(models.FluxModel.all())).+=(views.html.footer()))
  }

}
