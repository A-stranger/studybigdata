package cn.studybigdata.scala
package oop.constructor

class Cat(var name: String) {

  private var age: Int = 0

  println("主构造器")

  def this(name: String, age: Int) {
    this(name)
    this.age = age
    println("辅助构造器")
  }

  override def toString: String = s"name: $name, age: $age"
}

object ConstructorAuxiliary {
  def main(args: Array[String]): Unit = {

    val jumao = new Cat("橘猫")
    println(jumao)
    val blackCat = new Cat("白猫", 10)
    println(blackCat)
  }
}