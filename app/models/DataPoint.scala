package models

import scala.io.Source
import scala.Array

/**
 * Created with IntelliJ IDEA.
 * User: coderh
 * Date: 1/17/14
 * Time: 11:38 AM
 */
case class DataPoint(feature: List[Double], label: Double)


object DataPoint {

  def apply(param:Array[Double]) = {
    new DataPoint(param.tail.toList, param.head)
  }

  def loadData = {
    val data = for (line <- Source.fromFile("public/data/features.index.scala.html").getLines()) yield
      DataPoint.apply(line.replaceAll("^\\s+", "").split("\\s+").map(_.toDouble))
    data.toList
  }
}
