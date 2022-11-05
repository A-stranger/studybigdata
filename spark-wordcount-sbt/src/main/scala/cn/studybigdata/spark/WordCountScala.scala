package cn.studybigdata.spark

import org.apache.spark.{SparkConf, SparkContext}

/**
 * file:///d:/bigdata.txt
 */
object WordCountScala {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("WordCountScala").setMaster("local");
    val sc = new SparkContext(conf)

    val result = sc.textFile("file:///d:/bigdata.txt").flatMap(_.split(" ")).map((_, 1)).reduceByKey(_ + _)
    result.foreach(println)
    sc.stop()
  }
}