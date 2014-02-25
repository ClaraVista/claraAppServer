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

  def javascriptRoutes = Action { implicit request =>

    Ok(
      Routes.javascriptRouter("jsRoutes")(
        routes.javascript.ExtractionController.approve
      )
    ).as("text/javascript")
  }
  //def approve(user: List[String])  = Action  {
  def approve(user: String)  = Action  {
    println("Valeur du array chk" + user)
    Ok("qsdf")
  }
  var extractionActive : Boolean  = false

  case class extractionBoxesForm(value : List[Boolean])
  case class extractionBoxForm(value : Boolean)

  val extractionListForm : Form[extractionBoxesForm] = Form(
    mapping(
      "valueFields" ->  list(boolean)
    )(extractionBoxesForm.apply)(extractionBoxesForm.unapply)
  )

  val extractionForm : Form[extractionBoxForm] = Form(
    mapping(
      "value" ->  boolean
    )(extractionBoxForm.apply)(extractionBoxForm.unapply)
  )

  def displayExtraction = Action {
    extractionActive = true
    FluxController.fluxActive = false
    //models.ExtractionModel.selectLastFileDB()
  //  println("Okkk " + models.ExtractionModel.fieldsNameTableFormatIdDB())
    Ok(views.html.header().+=(views.html.extraction(models.ExtractionModel.fieldsNameTableFormatIdDB(),ExtractionController.extractionForm, ExtractionController.extractionListForm)).+=(views.html.footer()))
  }


  def checkedValues = Action {
    implicit request =>
      extractionListForm.bindFromRequest.fold(
        errors => BadRequest(views.html.extraction(List[List[String]](),extractionForm, extractionListForm)),
        fields => {
      //    println("Ok je suis ici " + fields.value )
         Redirect(routes.ExtractionController.displayExtraction)
        }
      )
  }


}
