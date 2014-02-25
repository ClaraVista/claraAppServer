package controllers


import play.api.mvc._


/**
 * Created with IntelliJ IDEA.
 * User: spark
 * Date: 2/18/14
 * Time: 5:02 PM
 */
object FluxController extends Controller {

  var fluxActive: Boolean = false

  def displayFlux = Action {
    request => request.session.get("username").map {
      fluxActive = true
      ExtractionController.extractionActive = false
      user => Ok(views.html.header().+=(views.html.flux(models.FluxModel.flowAll(), models.FluxModel.globalIdAll().sortBy(r => r.order))).+=(views.html.footer()))
    }.getOrElse {
      Redirect(routes.IndexController.index)
    }
  }

}
