/**
 * Created by mac on 16/4/13.
 */

import org.junit.Test
import annotation.varargs
import io.Source
import annotation.tailrec


//Ex1
class ScalaTest {

  @Test
  def test1(){
    print("test1")
  }

  @Test(timeout = 10L)
  def test2(){
    print("test2")
  }
}

//Ex2
@deprecated
object deprecatedTest {
  @deprecated
  class deprecatedClass(@deprecated private val hh:Int){
    @deprecated
    def deprecatedMethod = print("deprecated")
    @deprecated
    val mm = 0
  }
}

//Ex4
class MyTest{

  @varargs
  def sum(n : Int*)={
    n.sum
  }
}

//Ex5
class PrintFile{
  def print(fileName:String) = {
    println(Source.fromFile(fileName).mkString)
  }
}


object ChFifteen {
  //Ex7
  class Ex7{
    @tailrec
    final def mySum(xs : Seq[Int],partial : BigInt) : BigInt = {
      if (xs.isEmpty) partial else mySum(xs.tail,xs.head + partial)
    }
  }


  def main(args: Array[String]): Unit = {
    val mm = new Ex7()
    println(mm.mySum(1 to 1000000,0))
  }
}