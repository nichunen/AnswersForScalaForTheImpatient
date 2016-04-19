/**
 * Created by Ni Chunen on 15/12/2.
 */
object  ChTwo {
  //Ex1
  def getSigNum(n:Int) = {
    var signum = 0
    if(n > 0) signum = 1
    else if(n < 0) signum = -1
    else signum = 0
    signum
  }

  //Ex2
  /*
  The type is Unit, the value is ()
   */

  //Ex3
  /*
  scala> var y =1
  y: Int = 1

  scala> val x=y=1
  x: Unit = ()
   */

  //Ex4
  def printNums():Unit = {
    for(i <- 0 to 10) println(10 -i)
  }

  //Ex5
  def countdown(n:Int):Unit = {
    for(i <- 0 to n) println(n-i)
  }

  //Ex6
  def getProduct(str:String) = {
    var ret:Long = 1
    for(c <- str){
      ret *= c
    }
    ret
  }

  //Ex7&8
  def product(s:String) = {
    var ret:Long = 1
    s.foreach(ret *= _.toLong)
    ret
  }

  //Ex9
  def productRecursive(s:String):Long = {
    var ret:Long = 1;
    ret = if(s.length == 1)
      s.charAt(0)
    else
      (s.charAt(0).toLong) * productRecursive(s.drop(1))
    ret
  }

  //Ex10
  def getXn(x:Double,n:BigInt):Double = {
    if(n > 0 && (n % 2 == 0))
    {
      val y = getXn(x,n/2)
      y*y
    }
    else if(n > 0 && (n % 2 == 1))
      x * getXn(x,n-1)
    else if(n == 0)
      1
    else
      1/(getXn(x,-n))
  }


  def main(args: Array[String]) {
    println(getXn(2.1,-16))
  }
}