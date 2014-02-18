package controllers


import play.api.mvc._


/**
 * Created with IntelliJ IDEA.
 * User: spark
 * Date: 2/18/14
 * Time: 5:02 PM
 */
object FluxController extends Controller {

  def displayFlux = Action {
    Ok(views.html.flux())
  }

}
