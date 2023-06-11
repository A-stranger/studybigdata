package cn.studybigdata.scala
package oop.obj.update


object Main {

  def main(args: Array[String]): Unit = {
    val subjects:Array[String] = new Array[String](3)
    subjects(0) = "Hadoop"
    subjects.update(1,"Spark")

    for (i <- subjects) println(i)
  }
}
