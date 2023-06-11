package cn.studybigdata.scala
package oop.option


object Test {

  def main(args: Array[String]): Unit = {

    val books: Map[String, Int] = Map("西游记" -> 100, "红楼梦" -> 120)
    val xyjPrice: Option[Int] = books.get("西游记")
    val sgyyPrice: Option[Int] = books.get("三国演义")
    println(xyjPrice)
    println(sgyyPrice)

    val price: Int = books.getOrElse("三国演义", 100)
    println(price)

  }
  // 接下来请学习unapply
}