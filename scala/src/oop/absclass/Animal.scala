package cn.studybigdata.scala
package oop.absclass


/**
 * 抽象类：Animal(id,name,age)
 * 抽象字段
 * 具体字段
 * 具体方法 speak
 * 抽象方法 action
 *
 * 特质：Flyable
 * 抽象字段 maxFlyHeight:Int
 * 抽象方法 fly
 *
 * HasLegs
 * 具体字段 legs = 4
 * 具体方法 run
 *
 * 继承类： Dog
 * 增加字段 weight
 * 构造器一 Dog(name,age)
 * 构造器二 Dog(name,age,weight)
 * 继承类：Bird(height)，
 *
 *
 *
 */
trait Flyable {
  var maxFlyHeight: Int

  def fly(): Unit
}

trait HasLegs {
  var legs: Int = 4

  def run(): String = {
    if (legs == 2) {
      s"I have $legs legs, I run slower"
    } else if (legs == 4) {
      s"I have $legs legs, I run faster"
    } else {
      s"I have $legs legs"
    }
  }
}

abstract class Animal {

  var id: Int = Animal.increaseId
  val name: String
  var age: Int = _

  def action()

  def speak(): Unit = {
    println(s" name: $name ; age: $age ！")
  }
}

object Animal{
  var id = 0

  def increaseId: Int = {
    id += 1
    id
  }
}

class Dog(override val name: String, age: Int) extends Animal with HasLegs with Flyable {

  private var weight: Int = _

  def this(name: String, age: Int, weight: Int) {
    this(name, age)
    println(age)
    this.weight = weight
  }

  override def action(): Unit = {
    println("看家护院")
  }

  override def speak(): Unit = {
    println(s"id: $id;  name: $name ; age: $age ; weight:$weight！")
  }

  override def run(): String = {
    s"I am  $name, I have $legs legs, I run very fast"
  }

  override var maxFlyHeight: Int = 0

  override def fly(): Unit = {
    println("I can not Fly")
  }
}

object Dog {

  def apply(name: String, age: Int): Dog = new Dog(name, age)

  def apply(name: String, age: Int, weight: Int): Dog = new Dog(name, age, weight)

  def unapply(dog: Dog): Option[(Int, String, Int, Int)] = Some(dog.id, dog.name, dog.age, dog.weight)
}

class Bird(override val name: String, age: Int) extends Animal with Flyable {
  override def action(): Unit = {
    println("消灭害虫")
  }

  override def speak(): Unit = {
    println(s"id: $id;  name: $name ; age: $age ; maxFlyHeight:$maxFlyHeight！")
  }

  override var maxFlyHeight: Int = 1000

  override def fly(): Unit = {
    println(s" I am %s , I can fly %d m", name, maxFlyHeight)
  }
}

object Test {
  def main(args: Array[String]): Unit = {
    val bird1 = new Bird("bird1",5)
    bird1.speak()

    val dog1 = Dog("dog1", 10)
    dog1.age = 11
    dog1.speak()
    println(dog1.run())

    val Dog(id, name, age, weight): Dog = dog1
    println(id)
    println(name)
    println(age)
    println(weight)
  }
}
