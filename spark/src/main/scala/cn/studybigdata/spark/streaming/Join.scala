package cn.studybigdata.spark.streaming

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.streaming.dstream.ReceiverInputDStream

object Join {
  def main(args: Array[String]): Unit = {

    val conf: SparkConf = new SparkConf().setAppName("Streaming").setMaster("local[*]")
    val sc = new SparkContext(conf)
    val ssc = new StreamingContext(sc, Seconds(1))

    val stream: ReceiverInputDStream[String] = ssc.socketTextStream("node0", 9998)
//    stream.print()
//    stream.saveAsTextFiles("hdfs://node0:9000/spark/")
//    stream.foreachRDD(x=>x.saveAsObjectFile("hdfs://node0:9000/spark/"))
    stream.saveAsObjectFiles("pre","end")
    ssc.start()
    ssc.awaitTermination()
  }
}
