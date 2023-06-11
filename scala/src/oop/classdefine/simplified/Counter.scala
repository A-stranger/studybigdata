package cn.studybigdata.scala
package oop.classdefine.simplified

//1. 类定义
class Counter {

  //2. 字段定义，默认公有
  private var count = 0

  def value: Int = count

  def value_=(v: Int): Unit = if (v > 0) count = v

  //3. 方法定义
  def increment(num: Int): Unit = count = count + num

  //不需要返回值时，可以省略等号
  def current() {
    println(count)
  }
}

object Main {
  def main(args: Array[String]): Unit = {

    val counter = new Counter()
    counter.value = 3
    println(counter.value)

    counter increment 2
    println(counter.value)

    counter.current()
  }
}