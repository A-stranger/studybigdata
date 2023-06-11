package cn.studybigdata.scala
package oop.obj.caseclass

case class Dog(name: String, price: Int)

object Test {

  def main(args: Array[String]): Unit = {

    val chineseRuralDog = Dog("中华田园犬", 1000)
    val goldenHairDog = Dog("金毛", 500)

    println(chineseRuralDog.name)
    println(goldenHairDog.price)
  }
}
