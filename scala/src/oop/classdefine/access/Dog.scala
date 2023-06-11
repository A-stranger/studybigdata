package cn.studybigdata.scala
package oop.classdefine.access

//1. 类定义
class Dog {

  //2. 字段定义，默认公有
  private var age = 0

  //3. 方法定义
  def ageValue_=(num: Int): Unit = age = num

  def ageValue: Int = age

  def increaseAge(num: Int): Unit = age += num

}

object Test {
  def main(args: Array[String]): Unit = {

    val dog = new Dog

    dog.ageValue_=(3)
    println(dog.ageValue)

    dog.ageValue = 4
    println(dog.ageValue)

    dog.increaseAge(1)
    println(dog.ageValue)

    dog increaseAge 1
    println(dog.ageValue)
  }
}