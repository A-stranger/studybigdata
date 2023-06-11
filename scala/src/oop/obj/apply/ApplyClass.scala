package cn.studybigdata.scala
package oop.obj.apply

class ApplyClass {
  def apply(param:String): Unit ={
    println("class apply method called " + param)
  }
}

object Main{
  def main(args: Array[String]): Unit = {
    val obj = new ApplyClass
    obj.apply("xxx")
    obj("xxx")
  }
}
