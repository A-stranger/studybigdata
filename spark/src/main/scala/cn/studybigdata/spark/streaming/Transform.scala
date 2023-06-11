package cn.studybigdata.spark.streaming

import org.apache.spark.rdd.RDD
import org.apache.spark.streaming.dstream.{DStream, ReceiverInputDStream}
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.streaming.{Seconds, StreamingContext}

object Transform {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("Streaming Transform").setMaster("local[*]")
    val sc = new SparkContext(conf)
    val ssc = new StreamingContext(sc, Seconds(1))

    val stream: ReceiverInputDStream[String] = ssc.socketTextStream("node0", 9998)

    val black_rdd: RDD[(String, Boolean)] = sc.parallelize(List(("zhangsan", true), ("lisi", true), ("wangwu", false), ("zhaoliu", false)))

    val value: DStream[(String, Int)] = stream.map((_, 1))
    value.transform(
      rdd => {
        val result: RDD[(String, (Int, Option[Boolean]))] = rdd.leftOuterJoin(black_rdd)
        val white_list: RDD[(String, (Int, Option[Boolean]))] = result.filter(record=>(record._2._2.getOrElse(false)==false))
        white_list
      }
    ).print()

    ssc.start()
    ssc.awaitTermination()
  }
}