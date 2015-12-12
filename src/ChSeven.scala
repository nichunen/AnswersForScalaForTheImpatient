/**
 * Created by mac on 15/12/11.
 */


import collection.mutable.Map
import scala.math

//Ex1

package com{
  package horstmann{
    class MyClass{
      private var immap = 0
    }
    package impatient{
      class YourClass{
        var my = new MyClass
      }
      //illegal var mymap = Map("one" -> 1)
    }
    package object random {
      val a:Int = 1664525
      val b:Int = 1013904223
      val n:Int = 32
      var seed:Int = 0
      var lastInt:Int = 0
      var lastDouble:Double = 0.0

      def nextInt():Int = {
        val ret:Int = (lastInt * a + b) % math.pow(2,n).toInt
        lastInt = ret
        ret
      }

      def nextDouble():Double = {
        val ret:Double = (lastDouble * a + b) % math.pow(2,n)
        lastDouble = ret
        ret
      }

      def setSeed(seed:Int):Unit = {
        random.seed = seed
        random.lastInt = seed
        random.lastDouble = seed.toDouble
      }
    }
    package random {

    }

  }
}

/*
package com.horstmann.impatient{
  class NewClass{
    var my = new MyClass //illegal
  }
}
*/


//Ex6&Ex7
object ChSeven {

  def hashCoppy():Unit = {
    import java.util.{HashMap => JavaHashMap}
    import scala.collection.mutable.{HashMap => ScalaHashMap}
    val myMap:JavaHashMap[String,Int] = new JavaHashMap[String,Int]()
    myMap.put("one",1)
    myMap.put("two",2)
    myMap.put("three",3)
    val newMap:ScalaHashMap[String, Int] = new ScalaHashMap[String, Int]
    val it:java.util.Iterator[String]  = myMap.keySet().iterator()
    while(it.hasNext()) {
      val key:String = it.next()
      val value:Int = myMap.get(key)
      newMap.+=(key->value)
    }
  }

  //Ex9
  def checkPassword():Unit = {
    import java.lang.System
    val name:String = System.getenv("USER")
    val console = java.lang.System.console()
    if(console == "secret"){
      println("Hello " + name)
    } else {
      println("Not logined.")
    }
  }


  def main(args:Array[String]):Unit = {
    //Ex2
    import com.horstmann._
    val my = new MyClass
    //Ex3
    random.setSeed(3)
    var aa = random.nextInt()
    var bb = random.nextDouble()

    //Ex4 For the limit of Java

    //Ex5 The function giveRaise can only be called in package com

    checkPassword()
    var cc = 0
  }
}
