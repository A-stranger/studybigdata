package cn.studybigdata.spark.ml.als

import org.apache.spark.SparkConf
import org.apache.spark.ml.evaluation.RegressionEvaluator
import org.apache.spark.ml.param.ParamMap
import org.apache.spark.ml.recommendation.{ALS, ALSModel}
import org.apache.spark.ml.tuning.{CrossValidator, CrossValidatorModel, ParamGridBuilder}
import org.apache.spark.sql.types.{DoubleType, IntegerType, StringType, StructType}
import org.apache.spark.sql.{DataFrame, SparkSession}

object ALS {
  def main(args: Array[String]): Unit = {
    val sparkConf: SparkConf = new SparkConf().setAppName("MR").setMaster("local[*]")
    val spark: SparkSession = SparkSession.builder.config(sparkConf).getOrCreate()
    import spark.implicits._

    //1. 读取评分书籍
    //1.1 构造评分Schema
    val ratingsSchema: StructType = new StructType()
      .add("userId", IntegerType, nullable = true)
      .add("movieId", IntegerType, nullable = true)
      .add("rating", DoubleType, nullable = true)

    // 1.2 读取评分数据，指定Schema
    val ratingsDF1: DataFrame = spark.read.option("header", "false").
      option("inferSchema", "true")
      .schema(ratingsSchema)
      .csv("data/spark/rdd/movies/ratings.csv").
      drop("timestamp")

    // 1.3 计数
    ratingsDF1.count
    // 查看Schema
    ratingsDF1.printSchema
    // 显示前5行
    ratingsDF1.show(5)


    // 看看被评分的电影总共有多少部：
    ratingsDF1.select("movieId").distinct().count
    // 看看有多少用户参与评分：
    ratingsDF1.select("userId").distinct().count


    // 快速检查谁是活跃的电影评分者
    val ratingsByUserDF: DataFrame = ratingsDF1.groupBy("userId").count()
    ratingsByUserDF.orderBy($"count".desc).show(10)

    // 分析每部电影的最大评分数量
    val ratingsByMovieDF: DataFrame = ratingsDF1.groupBy("movieId").count()
    ratingsByMovieDF.orderBy($"count".desc).show(10)


    // 为训练和测试准备数据
    val Array(trainingData, testData) = ratingsDF1.randomSplit(Array(0.8, 0.2))


    // 建立ALS的实例
    val als: ALS = new ALS().setRank(12).
      setMaxIter(10).
      setRegParam(0.03).
      setUserCol("userId").
      setItemCol("movieId").
      setRatingCol("rating")

    // 训练模型
    val model: ALSModel = als.fit(trainingData)
    // 从Spark 2.2.0开始，可以将coldStartStrategy参数设置为drop，以便删除包含NaN值的预测的DataFrame中的任何行。
    // 然后将在非nan数据上计算评估度量，该度量将是有效的。
    model.setColdStartStrategy("drop")


    // 执行预测
    val predictions: DataFrame = model.transform(testData)
    // 查看预测结果
    println("查看预测结果")
    predictions.sort("userId").show(10)

    //有的预测值为NaN(非数字)，这会影响到rmse的计算，因些需要先删除结果集中的NaN值。
    val predictions_dropNaN: DataFrame = predictions.na.drop(Array("prediction"))
    predictions_dropNaN.count


    // 设置一个评估器（evaluator）来计算RMSE度量指标
    println("设置一个评估器（evaluator）来计算RMSE度量指标")
    val evaluator: RegressionEvaluator = new RegressionEvaluator().setMetricName("rmse").
      setLabelCol("rating").
      setPredictionCol("prediction")
    val rmse: Double = evaluator.evaluate(predictions_dropNaN)
    println(s"Root-mean-square error = ${rmse}")

    // 为所有用户推荐排名前五的电影
    println("为所有用户推荐排名前五的电影")
    model.recommendForAllUsers(5).show(false)

    // 为每部电影推荐top 3个用户
    println("为每部电影推荐top 3个用户")
    val recMovies: DataFrame = model.recommendForAllItems(3)
    recMovies.show(5, truncate = false)





    // 读取电影数据集，这样就能看到电影标题了
    val moviesSchema: StructType = new StructType()
      .add("movieId", IntegerType, nullable = true)
      .add("title", StringType, nullable = true)
      .add("type", StringType, nullable = true)


    val moviesDF: DataFrame = spark.read.option("header", "false").
      option("inferSchema", "true")
      .schema(moviesSchema)
      .csv("data/spark/rdd/movies/movies.csv").
      drop("timestamp")

    moviesDF.count
    moviesDF.printSchema
    moviesDF.show(5)

    val recMoviesWithInfoDF: DataFrame = recMovies.join(moviesDF, "movieId")
    recMoviesWithInfoDF.select("movieId", "title", "recommendations").show(5, false)


    //使用CrossValidator对ALS模型进行调优
    val paramGrid: Array[ParamMap] = new ParamGridBuilder()
                        .addGrid(als.regParam, Array(0.05, 0.15))
                        .addGrid(als.rank, Array(12,20))
                        .build

    val crossValidator: CrossValidator =new CrossValidator()
                            .setEstimator(als)
                            .setEvaluator(evaluator)
                            .setEstimatorParamMaps(paramGrid)
                            .setNumFolds(3)
    // 打印出4个超参数组合
    crossValidator.getEstimatorParamMaps.foreach(println)


    //这需要一段时间才能完成超过10个实验
    val cvModel: CrossValidatorModel = crossValidator.fit(trainingData)

    // 执行预测并删除空值
    val predictions2: DataFrame = cvModel.transform(testData).na.drop

    val evaluator2: RegressionEvaluator = new RegressionEvaluator()
                          .setMetricName("rmse")
                          .setLabelCol("rating")
                          .setPredictionCol("prediction")

    val rmse2: Double = evaluator2.evaluate(predictions2)
    //由以上输出内容可以看出，rmse2的值要低于rmse1，预测结果相比之前更加准确。
    println(rmse2)

  }

}
