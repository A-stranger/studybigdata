package cn.studybigdata.spark.hbase

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.hbase.HBaseConfiguration
import org.apache.hadoop.hbase.client.{Mutation, Put, Result}
import org.apache.hadoop.hbase.io.ImmutableBytesWritable
import org.apache.hadoop.hbase.mapreduce.{TableInputFormat, TableOutputFormat}
import org.apache.hadoop.hbase.util.Bytes
import org.apache.hadoop.mapreduce.{Job, OutputFormat}
import org.apache.spark.{SparkConf, SparkContext}

object SparkOperateHBase {
  def main(args: Array[String]): Unit = {

    val conf = HBaseConfiguration.create()
    conf.set("hbase.zookeeper.quorum", "node1")
    conf.set("hbase.zookeeper.property.clientPort", "2181")
    //设置查询的表名
    conf.set(TableInputFormat.INPUT_TABLE, "student")

    val sc = new SparkContext(new SparkConf().setAppName("SparkOperateHBase").setMaster("local"))

    readHBase(sc, conf)
  }

  def readHBase(sc: SparkContext, conf: Configuration): Unit = {
    val stuRDD = sc.newAPIHadoopRDD(conf, classOf[TableInputFormat], classOf[org.apache.hadoop.hbase.io.ImmutableBytesWritable], classOf[org.apache.hadoop.hbase.client.Result])
    val count = stuRDD.count()
    println("Students RDD Count:" + count)
    stuRDD.cache()
    //遍历输出
    stuRDD.foreach({ case (_, result) =>
      val key = Bytes.toString(result.getRow)
      val name = Bytes.toString(result.getValue("info".getBytes, "name".getBytes))
      val gender = Bytes.toString(result.getValue("info".getBytes, "gender".getBytes))
      val age = Bytes.toString(result.getValue("info".getBytes, "age".getBytes))
      println("Row key:" + key + " Name:" + name + " Gender:" + gender + " Age:" + age)
    })
  }
}

object SparkWriteHBase {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setAppName("SparkWriteHBase").setMaster("local")
    val sc = new SparkContext(sparkConf)

    sc.hadoopConfiguration.set(TableOutputFormat.OUTPUT_TABLE, "student")
    sc.hadoopConfiguration.set("hbase.zookeeper.quorum", "node1")
    sc.hadoopConfiguration.set("hbase.zookeeper.property.clientPort", "2181")
    sc.hadoopConfiguration.set("spark.hadoop.validateOutputSpecs", "false")

    val job = new Job(sc.hadoopConfiguration)
    job.setOutputKeyClass(classOf[ImmutableBytesWritable])
    job.setOutputValueClass(classOf[Result])
    job.setOutputFormatClass(classOf[TableOutputFormat[ImmutableBytesWritable]])

    val indataRDD = sc.makeRDD(Array("3,Rongcheng,M,26","4,Guanhua,M,27")) //构建两行记录
    val rdd = indataRDD.map(_.split(',')).map{arr=>{
      val put = new Put(Bytes.toBytes(arr(0))) //行健的值
      put.add(Bytes.toBytes("info"),Bytes.toBytes("name"), Bytes.toBytes(arr(1)))  //info:name列的值
      put.add(Bytes.toBytes("info"),Bytes.toBytes("gender"), Bytes.toBytes(arr(2)))  //info:gender列的值
      put.add(Bytes.toBytes("info"),Bytes.toBytes("age"), Bytes.toBytes(arr(3).toInt))  //info:age列的值
      (new ImmutableBytesWritable, put)
    }}
    rdd.saveAsNewAPIHadoopDataset(job.getConfiguration())
  }
}



