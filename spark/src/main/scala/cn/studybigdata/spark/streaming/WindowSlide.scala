package cn.studybigdata.spark.streaming

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.{FileSystem, Path}
import org.apache.spark.streaming.dstream.{DStream, ReceiverInputDStream}
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.{SparkConf, SparkContext}

import java.net.URI

object WindowSlide {

  def main(args: Array[String]): Unit = {
    val sparkConf: SparkConf = new SparkConf().setAppName("Window Slide").setMaster("local[2]")
    val sc: SparkContext = new SparkContext(sparkConf)

    // Batch Interval : 2s
    val ssc: StreamingContext = new StreamingContext(sc, Seconds(2))
    ssc.checkpoint("./")
    val stream: DStream[String] = ssc.socketTextStream("localhost", 9998).window(Seconds(4))
    stream.print()


    ssc.start()
    ssc.awaitTermination()


  }
}