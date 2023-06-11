package cn.studybigdata.scala
package oop.obj.apply

class Dog(val name: String, val price: Int) {

  private val id: Int = Dog.increasePrimarykey()

  override def toString: String = s"id: $id; name: $name; price: $price"
}

object Dog {

  private var primarykey = 0

  def increasePrimarykey(): Int = {
    primarykey += 1
    primarykey
  }

  def apply(name: String, price: Int): Dog = {
    new Dog(name, price)
  }
}

object Test {
  def main(args: Array[String]): Unit = {
    val chineseRuralDog = new Dog("中华田园犬", 1000);
    println(chineseRuralDog.toString)
    val goldenHairDog = Dog("金毛", 500) // 伴生对象中的Apply方法
    println(goldenHairDog.toString)
  }
}