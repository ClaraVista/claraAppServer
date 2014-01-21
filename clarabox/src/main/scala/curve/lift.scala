package curve

import org.apache.spark.SparkContext

/**
 * Created with IntelliJ IDEA.
 * User: coderh
 * Date: 1/15/14
 * Time: 2:31 PM
 */


object lift {
  def result = {
    val awsAccessKeyId = System.getenv("AWS_ACCESS_KEY_ID")
    val awsSecretAccessKey = System.getenv("AWS_SECRET_ACCESS_KEY")
    val sc = new SparkContext("local[2]", "SparkLR", System.getenv("SPARK_HOME"),
      Seq("clarabox/target/scala-2.10/clarabox_2.10-0.1.jar"))

    sc.hadoopConfiguration.set("fs.s3.awsAccessKeyId", awsAccessKeyId)
    sc.hadoopConfiguration.set("fs.s3.awsSecretAccessKey", awsSecretAccessKey)
    sc.hadoopConfiguration.set("fs.s3n.awsAccessKeyId", awsAccessKeyId)
    sc.hadoopConfiguration.set("fs.s3n.awsSecretAccessKey", awsSecretAccessKey)

    val s3BucketName = "claravista.output/"
    val s3outputLocation = "liftTest/"
    val learningCurveData = sc.textFile("s3n://" + s3BucketName + s3outputLocation)
      .map(_.split(";"))
      .map {
      case Array(x, y) => (x.toDouble, y.toDouble)
    }.collect

    learningCurveData
  }
}
