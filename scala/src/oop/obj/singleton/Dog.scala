package cn.studybigdata.scala
package oop.obj.singleton

object Dog {

  private var primaryKey = 0

  def increasePk(): Int = {
    primaryKey = primaryKey + 1
    primaryKey
  }
}

object Test {
  def main(args: Array[String]): Unit = {
    val pk: Int = Dog.increasePk()
    print(pk)
  }
}
