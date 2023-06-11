package cn.studybigdata.spark.streaming

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.{FileSystem, Path}
import org.apache.spark.rdd.RDD
import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming.dstream.{DStream, ReceiverInputDStream}
import org.apache.spark.streaming.receiver.Receiver
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.{SparkConf, SparkContext}

import java.net.URI

object StreamingWordcount {

  def main(args: Array[String]): Unit = {
    val sparkConf: SparkConf = new SparkConf().setAppName("Spark_Streaming").setMaster("local[*]")
    val sc: SparkContext = new SparkContext(sparkConf)

    val ssc = new StreamingContext(sc, Seconds(2))
    val stream: DStream[String] = ssc.socketTextStream("node0", 9998, StorageLevel.MEMORY_AND_DISK)

    val words: DStream[String] = stream.flatMap(_.split(" "))
    val wordOne: DStream[(String, Int)] = words.map((_, 1))
    val result: DStream[(String, Int)] = wordOne.reduceByKey(_ + _)
    result.print()
    ssc.start()

    new Thread() {
      val uri = new URI("hdfs://node0:9000/")
      val conf = new Configuration
      val user = "zhangsan"
      val fs: FileSystem = FileSystem.get(uri, conf, user)

      while (true) {
        val exist: Boolean = fs.exists(new Path("/user/zhangsan/bigdata.txt"))
        if (exist) {
          println("exist.. ...")
          ssc.stop(true, true)
          System.exit(0)
        }
        println("wait.. ...")
        Thread.sleep(2000)
      }
    }.start()

  ssc.awaitTermination()
}
}
