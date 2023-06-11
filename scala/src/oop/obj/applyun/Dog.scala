package cn.studybigdata.scala
package oop.obj.applyun

class Dog(val name: String, val price: Int) {

  private val id: Int = Dog.increasePk()

  override def toString: String = s"id: $id, name: $name"
}

object Dog {

  private var primaryKey = 0

  def increasePk(): Int = {
    primaryKey += 1
    primaryKey
  }

  def apply(name: String, price: Int): Dog = {
    new Dog(name, price)
  }

  def unapply(dog: Dog): Option[(String, Int, Int)] = {
    Some(dog.name, dog.price, 100)
  }
}

object Test {
  def main(args: Array[String]): Unit = {
    val Dog(brand, price, x): Dog = Dog("中华田园犬", 1000)
    println(brand)
    println(price)
    println(x)
  }
}