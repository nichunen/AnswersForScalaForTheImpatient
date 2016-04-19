/**
 * Created by mac on 16/4/6.
 */

object ChTwelve {
  //Ex1
  def values(fun:(Int)=>Int,low:Int,high:Int) = {
    for(i <- low to high)
      yield (i,fun(i))
  }

  //Ex2
  def getMaxNum(arr:Array[Int]):Int = {
    arr.reduceLeft((left,right) => if(left < right) right else left)
  }

  //Ex3
  def factorial(num:Int):Int = {
    if(num < 0) 0
    else if(num == 0) 1
    else
      (1 to num).reduceLeft((left,right)=>left*right)
  }

  //Ex4
  def newFactorial(num:Int):Int = {
    (1 to num).foldLeft(1)(_ * _)
  }

  //Ex5
  def largest(fun:(Int)=>Int,inputs:Seq[Int]) = {
    val a = inputs.reduceRight((left,right) => if(fun(left) < fun(right)) right else left)
    fun(a)
  }

  //Ex6
  def largestAt(fun:(Int)=>Int,inputs:Seq[Int]) = {
    inputs.reduceRight((left,right) => if(fun(left) < fun(right)) right else left)
  }

  //Ex7
  def adjustToPair(fun:(Int,Int)=>Int)(pair:(Int,Int)) = {
    fun(pair._1, pair._2)
  }

  //Ex10
  def unless(condition: =>Boolean)(block: =>Unit){
    if (!condition){
      block
    }
  }

  def main(args: Array[String]): Unit = {
    //Ex7
    val pairs = (1 to 10) zip (11 to 20)
    pairs.foreach { onePair =>
      println(ChTwelve.adjustToPair(_ + _)(onePair))
    }

    //Ex8
    val a = Array("asd","df","aadc")
    val b = Array(3,2,4)
    val c = Array(3,2,1)

    println(a.corresponds(b)(_.length == _))
    println(a.corresponds(c)(_.length == _))

    var x = 10
    unless(x == 0){
      x -= 1
      println(x)
    }

  }
}
