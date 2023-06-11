package cn.studybigdata.spark.ml

import org.apache.spark.SparkConf
import org.apache.spark.ml.clustering.KMeans
import org.apache.spark.ml.evaluation.ClusteringEvaluator
import org.apache.spark.ml.feature.{Binarizer, PCA, StandardScaler}
import org.apache.spark.ml.linalg.Vectors
import org.apache.spark.sql.{DataFrame, SparkSession}

object MachineLearning {
  def main(args: Array[String]): Unit = {
    val sparkConf: SparkConf = new SparkConf().setAppName("Car_Cluster").setMaster("local[*]")

    val spark = SparkSession.builder.config(sparkConf).getOrCreate()

    import spark.implicits._

    val dataset = spark.read.format("libsvm").load("data/mllib/sample_kmeans_data.txt")

    // Trains a k-means model.
    val kmeans = new KMeans().setK(2).setSeed(1L)
    val model = kmeans.fit(dataset)

    // Make predictions
    val predictions = model.transform(dataset)

    predictions.show()

    // Shows the result.
    println("Cluster Centers: ")
    model.clusterCenters.foreach(println)
  }

}
