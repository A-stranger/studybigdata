package cn.studybigdata.spark.sql

import org.apache.spark.sql.expressions.{MutableAggregationBuffer, UserDefinedAggregateFunction}
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.types.{DataType, IntegerType, LongType, StringType, StructField, StructType}
import org.apache.spark.sql.{DataFrame, Dataset, Row, SparkSession}

object DataFrameTest {


  def main(args: Array[String]): Unit = {

    System.setProperty("HADOOP_USER_NAME", "zhangsan")

    val conf = new SparkConf().setAppName("Spark SQL").setMaster("local[*]")
    val spark = SparkSession.builder().config(conf).getOrCreate()
    val sc: SparkContext = spark.sparkContext
    import spark.implicits._

    val personRDD = spark.sparkContext.parallelize(List(("zhangsan",10),("lisi",20),("wangwu",30)))

    val personDS: Dataset[Person] = personRDD.map(x => Person(x._1, x._2)).toDS()
    val personDF: DataFrame = personRDD.map(x => Person(x._1, x._2)).toDF()

//    personDF.foreach(x=>x.name) // 无法按列名取值
    personDS.foreach(x=>x.name)


    val df: DataFrame = personDS.toDF()
    val ds: Dataset[Person] = personDF.as[Person]


    personDF.createOrReplaceTempView("person")
    spark.udf.register("prefixName",(name:String)=>("name:"+name))
    spark.sql("select prefixName(name),age from person").show

    // 目的是使用UDAF计算年龄的平均值，
    spark.udf.register("ageAvg",new MyUDAF())
    spark.sql("select ageAvg(age) from person").show


    spark.close()

  }

  class MyUDAF extends UserDefinedAggregateFunction{
    override def inputSchema: StructType = StructType(List(StructField("age",LongType)))

    //age 10
    //age 20
    //age 30

    // val total = 0
    // var count = 0
    //
    //
    // total = 10+20+30
    // count = 1+1+1
    override def bufferSchema: StructType = StructType(List(StructField("total",LongType),StructField("count",LongType)))

    override def dataType: DataType = LongType

    override def deterministic: Boolean = true

    override def initialize(buffer: MutableAggregationBuffer): Unit = {
      buffer(0)=0L
      buffer(1)=0L
    }

    override def update(buffer: MutableAggregationBuffer, input: Row): Unit = {
      val age = input.getLong(0)
      buffer(0) = buffer.getLong(0)+age  //total
      buffer(1) =  buffer.getLong(1) + 1 //count
    }

    override def merge(buffer1: MutableAggregationBuffer, buffer2: Row): Unit = {
      buffer1(0) = buffer1.getLong(0)+buffer2.getLong(0)  //total
      buffer1(1) = buffer1.getLong(1) + buffer2.getLong(1) //count
    }

    override def evaluate(buffer: Row): Any = {
      buffer.getLong(0)/buffer.getLong(1)
    }
  }
  case class Person(name:String,age:Integer)

}
