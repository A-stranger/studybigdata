package cn.studybigdata.scala
package oop.classdefine.simplified

//1. 类定义
class Dog {

  //2. 字段定义，默认公有
  var age = 0

  //3. 方法定义
  def setAge(num: Int) {age = num }
  def getAge(): Int = age
  def increaseAge(num: Int) = age = age + num

}

object Test {
  def main(args: Array[String]): Unit = {

    val dog = new Dog

    dog.setAge(3)
    println(dog.age)

    dog.age = 4
    println(dog.age)

    dog.increaseAge(1)
    println(dog.getAge())

    dog increaseAge 1
    println(dog.getAge())
  }
}