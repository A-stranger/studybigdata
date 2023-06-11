package cn.studybigdata.scala
package oop.obj.companion

class Dog {

  private var id: Int = 0
  private var name: String = ""
  private var price: Int = 0

  def this(name: String, price: Int) {
    this()
    this.id = Dog.increasePk()
    this.name = name
    this.price = price
  }

  override def toString = s"Dog($id, $name, $price)"
}

object Dog {
  private var primaryKey: Int = 0

  def increasePk(): Int = {
    primaryKey += 1
    primaryKey
  }
}

object Test {
  def main(args: Array[String]): Unit = {
    val chineseRuralDog = new Dog("中华田园犬", 1000)
    val goldenHairDog = new Dog("金毛", 500)

    val dogs: Set[Dog] = Set(chineseRuralDog, goldenHairDog)

    for (dog <- dogs) {
      println(dog)
    }
  }
}