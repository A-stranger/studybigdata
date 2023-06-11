package cn.studybigdata.scala
package oop

class Car(val brand:String,val price:Int) {
  def info() {
    println("Car brand is "+ brand+" and price is "+price)
  }
}
//-----------------------------------------------------
object Car{
  def apply(brand:String,price:Int)= {
    println("Debug:calling apply ... ")
    new Car(brand,price)
  }
  def unapply(c:Car):Option[(String,Int)]={
    println("Debug:calling unapply ... ")
    Some((c.brand,c.price))
  }
}
//-----------------------------------------------------

object TestUnapply{
  def main (args: Array[String]) {
    var Car(carbrand,carprice) = Car("BMW",800000)
    println("brand: "+carbrand+" and carprice: "+carprice)
  }
}
