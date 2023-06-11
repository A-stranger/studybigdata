package cn.studybigdata.spark.wordcount

import org.apache.spark.{SparkConf, SparkContext}

object WordCount {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("WordCount")
    val sc = new SparkContext(conf)

    //WordCount
    val result = sc.textFile(args(0)).flatMap(_.split(" ")).map((_, 1)).reduceByKey(_ + _)

    //结果输出到container的日志中
    result.foreach(println)

    //结果输出到HDFS
    result.saveAsTextFile(args(1))

    //结果收集:
    //collect() 会将结果收集到Driver的内存中
    //在Client模式下，Driver运行在客户端进程中，因此println会将收集的结果输出到控制台；
    //在Cluster模式下，Driver在AM内，collect会将结果输出到AM所在Container的日志中。
    result.collect().foreach(println)

    sc.stop()
  }
}