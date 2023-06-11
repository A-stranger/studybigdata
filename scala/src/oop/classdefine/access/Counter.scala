package cn.studybigdata.scala
package oop.classdefine.access

//1. 类定义
class Counter {

  //2. 字段定义，默认公有
  private var count = 0

  //2.1 getter
  def value: Int = {
    count
  }

  //2.2 setter
  def value_=(v: Int): Unit = {
    if (v > 0) count = v
  }

  //3. 方法定义
  def increment(num: Int): Unit = {
    count = count + num
  }

  //不需要返回值时，可以省略等号
  def current(): Unit = {
    println(count)
  }

}

object Main {
  def main(args: Array[String]): Unit = {
    //4. 对象创建
    val counter = new Counter()

    //5. 当使用第二步所示的方式时， setter方法 counter.value_=(1) 可简写成如下格式：
    counter.value = 3
    println(counter.value)

    //6. 方法调用
    counter.increment(2)
    println(counter.value)

    counter.current()
  }
}