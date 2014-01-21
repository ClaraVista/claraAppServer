package controllers

import play.api._
import play.api.mvc._
import scala.io.Source

object Application extends Controller {


  def prepareData = {
    val c = curve.lift.result
//    val c = Array((0d, 0d))
    val dist1 = models.DataPoint.loadData.filter(_.label == 1.0)
    val dist2 = models.DataPoint.loadData.filter(_.label != 1.0)
    (c, dist1, dist2)
  }

  def index = Action {
    Ok("Your application is ready!")
  }

  def googleChart = Action {
    val (c, dist1, dist2) = prepareData
    Ok(views.html.googleChart("Google Chart")(c)(dist1)(dist2))
  }

  def highChart = Action {
    val (c, dist1, dist2) = prepareData
    Ok(views.html.highChart("High Chart")(c)(dist1)(dist2))
  }

  def startEC2 = Action {
    Runtime.getRuntime.exec("/home/coderh/development/scripts/ec2cmd.sh test start")
    Ok(views.html.index("EC2 cluster is starting..."))
  }

  def stopEC2 = Action {
    Runtime.getRuntime.exec("/home/coderh/development/scripts/ec2cmd.sh test stop")
    Ok(views.html.index("EC2 cluster is stopping..."))
  }

}