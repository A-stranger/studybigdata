package cn.studybigdata.spark.streaming

import org.apache.spark.streaming.dstream.{DStream, ReceiverInputDStream}
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.streaming.{Seconds, StreamingContext}

object UpdateStateByKey {

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("CustomerReceiver").setMaster("local[*]")
    val sc = new SparkContext(conf)
    val ssc = new StreamingContext(sc, Seconds(1))




    ssc.start()
    ssc.awaitTermination()
  }
}
