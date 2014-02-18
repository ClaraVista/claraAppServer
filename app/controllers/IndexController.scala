package controllers

import play.api.mvc._


/**
 * Created with IntelliJ IDEA.
 * User: spark
 * Date: 2/18/14
 * Time: 4:57 PM
 */
object IndexController extends Controller {


  def checkPassword = Action {
     Redirect(routes.FluxController.displayFlux)
  }


}
