package cn.studybigdata.scala
package oop.classdefine.generic

class Dog {

  var age = 0

  def setAge(num: Int): Unit = {
    age = num
  }

  def getAge(): Int = {
    return age
  }

  def increaseAge(num: Int): Unit = {
    age = age + num
  }

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