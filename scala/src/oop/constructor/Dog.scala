package cn.studybigdata.scala
package oop.constructor

class Dog(var age: Int)

object Test {
  def main(args: Array[String]): Unit = {

    val chineseRuralDog = new Dog(18)
    chineseRuralDog.age = 10 //如果不希望构造器参数成为类的字段，只需要省略val或var关键字
    println(chineseRuralDog.age)
  }
}