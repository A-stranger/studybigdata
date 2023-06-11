package cn.studybigdata.spark.rdd

import org.apache.spark.{SparkConf, SparkContext}

object RddTest {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("Rdd Test").setMaster("local[*]")
    val sc = new SparkContext(conf)

    val data = List(1, 2, 3, 5, 5, 6, 6, 67)
    val rdd = sc.parallelize(data)
    rdd.foreach(println)
    rdd.max()
  }
}

object TopN {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("TopN").setMaster("local")
    val sc = new SparkContext(conf)
    sc.setLogLevel("ERROR")
    val lines = sc.textFile("file:///D:\\IdeaProjects\\studybigdata\\data\\spark\\rdd\\top", 2)
    var num = 0;
    val result = lines.filter(line => (line.trim().length > 0) && (line.split(",").length == 4))
      .map(_.split(",")(2))
      .map(x => (x.trim.toInt, ""))
      .sortByKey(false)
      .map(x => x._1).take(5)
      .foreach(x => {
        num = num + 1
        println(num + "\t" + x)
      })
  }
}

object movie {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("TopN").setMaster("local")
    val sc = new SparkContext(conf)
    sc.setLogLevel("ERROR")
    val movie = sc.textFile("D:\\IdeaProjects\\studybigdata\\data\\spark\\rdd\\movies\\movies.csv")
    val rating = sc.textFile("D:\\IdeaProjects\\studybigdata\\data\\spark\\rdd\\movies\\ratings.csv")

    val movie_new = movie.map(line => {
      val fields = line.split(",")
      (fields(0).toInt, fields(1))
    })   // (movieID, name)

    val rating_new = rating.map(line => {
      val fields = line.split(",")
      (fields(1).toInt, fields(2).toDouble)
    }).groupByKey().map(data => {
      val avg = data._2.sum / data._2.size
      (data._1, avg)
    })// (movieID, avg)

    val result = rating_new.join(movie_new)
//    result.foreach(println)

    // (movieId,(avg,"name"))
    result.filter(x => x._2._1 > 4.8).foreach(println)
  }
}


object KeyBySuite {
  def main(args: Array[String]) {
    keybyTest()
  }

  def keybyTest() =  {
    val conf = new SparkConf().setAppName(this.getClass().getSimpleName().filter(!_.equals('$'))).setMaster("local[4]")
    val sc = new SparkContext(conf)
        val rdd1 = sc.parallelize(Array(("a", 2, 3), ("b", 2, 5), ("a", 4, 100), ("b", 1, 200), ("a", 1, 1)))
//    val rdd1 = sc.parallelize(Array(("ab", 2, 3), ("bb", 2, 5), ("ac", 4, 100), ("bb", 1, 200), ("ac", 1, 1)))
    val rdd2 = rdd1.keyBy(each => (each._1, each._2)).sortByKey()
//    println("init:")
//    rdd1.foreach(println)
//    println("keyby not zipWithIndex:")
    rdd2.foreach(println)
//    println("keyby value:")
//    rdd2.map(_._2).foreach(println)
//    println("zipWithIndex:")
//    val rdd3 = rdd1.keyBy(each => (each._1, each._2)).sortByKey().map(_._2).collect().zipWithIndex
//    rdd3.foreach(println)
//    println("sort:")
//    rdd3.map(_._1).foreach(println)
//    sc.stop
  }
}

