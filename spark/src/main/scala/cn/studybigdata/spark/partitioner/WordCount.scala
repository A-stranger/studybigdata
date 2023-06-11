package cn.studybigdata.spark.partitioner

import org.apache.spark.{Partitioner, SparkConf, SparkContext}

class MyPartitioner(numParts: Int) extends Partitioner {
  override def numPartitions: Int = numParts

  override def getPartition(key: Any): Int = {
    key.toString.toInt % numPartitions
  }
}

object TestPatitioner{
  def main(args:Array[String]): Unit ={
    var conf = new SparkConf()
    conf.setMaster("local[*]")
    conf.setAppName("Spark-Partitioner")
    val sc = new SparkContext(conf)
    val rdd = sc.parallelize( 1 to 10, 5)
    rdd.map((_,1)).partitionBy(new MyPartitioner(10)).map(_._1).saveAsTextFile("file:///D:\\IdeaProjects\\studybigdata\\out\\part")
  }
}