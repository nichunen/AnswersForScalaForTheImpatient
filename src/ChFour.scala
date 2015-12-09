/**
 * Created by Ni Chun'en on 15/12/9.
 */
import scala.collection.mutable._
import java.util.Scanner
import scala.collection.JavaConversions.mapAsScalaMap
import scala.collection.JavaConversions.propertiesAsScalaMap

object ChFour {
  //Ex1
  def lowPrice():Map[String,Double] = {
    val theMap = Map[String,Double](("Apple", 5.6),("Orange", 3.6), ("Banana",8.4))
    val newMap = for((k,v) <- theMap) yield  (k,0.9*v)
    newMap
  }

  //Ex2
  def getWordsNum(fileName:String):Unit = {
    val in = new Scanner(new java.io.File(fileName))
    var myMap = Map[String,Int]()
    while(in.hasNext()){
      val theWord = in.next()
      if(myMap.contains(theWord)){
        myMap(theWord) += 1
      }
      else {
        myMap = myMap + (theWord -> 1)
      }
    }

    for((k,v) <- myMap){
      println(k,v)
    }
  }

  //Ex3
  def getWordsNumV2(fileName:String):Unit = {
    val in = new Scanner(new java.io.File(fileName))
    var myMap = scala.collection.immutable.Map[String,Int]()
    while(in.hasNext()){
      val theWord = in.next()
      if(myMap.contains(theWord)){
        val newV = (myMap(theWord) + 1)
        myMap -= theWord
        myMap += (theWord -> newV)
      }
      else {
        myMap = myMap + (theWord -> 1)
      }
    }

    for((k,v) <- myMap){
      println(k,v)
    }
  }


  //Ex4
  def getWordsNumV3(fileName:String):Unit = {
    val in = new Scanner(new java.io.File(fileName))
    var myMap = scala.collection.immutable.SortedMap[String, Int]()
    while (in.hasNext()) {
      val theWord = in.next()
      if (myMap.contains(theWord)) {
        val newV = (myMap(theWord) + 1)
        myMap -= theWord
        myMap += (theWord -> newV)
      }
      else {
        myMap = myMap + (theWord -> 1)
      }
    }

    for ((k, v) <- myMap) {
      println(k, v)
    }
  }

  //Ex5
  def getWordsNumV4(fileName:String):Unit = {
    val in = new Scanner(new java.io.File(fileName))
    val myMap = new java.util.TreeMap[String, Int]
    while(in.hasNext()){
      val theWord = in.next()
      if(myMap.containsKey(theWord)){
        val oldV = myMap.get(theWord)
        val newV = oldV + 1
        myMap.put(theWord,newV)
      }
      else {
        myMap.put(theWord,1)
      }
    }

    for((k,v) <- myMap){
      println(k,v)
    }
  }

  //Ex6
  def testLinkedHashMap():Unit = {
    var weekDays = scala.collection.mutable.LinkedHashMap("Monday"->java.util.Calendar.MONDAY)
    weekDays += ("TUESDAY"->java.util.Calendar.TUESDAY)
    weekDays += ("WEDNESDAY"->java.util.Calendar.WEDNESDAY)
    weekDays += ("THURSDAY"->java.util.Calendar.THURSDAY)
    weekDays += ("FRIDAY"->java.util.Calendar.FRIDAY)
    weekDays += ("SATURDAY"->java.util.Calendar.SATURDAY)
    weekDays += ("SUNDAY"->java.util.Calendar.SUNDAY)
    for((k,v) <- weekDays){
      println(k,v)
    }
  }

  //Ex7
  def printSystemProperties():Unit = {
    val props:Map[String,String] = System.getProperties()
    var maxLen:Int = 0
    for((k,v) <- props){
      if(k.length() > maxLen)
        maxLen = k.length()
    }
    for((k,v) <- props){
      println(k + " "*(maxLen + 1 - k.length()) + "| " + v)
    }
  }

  //Ex8
  def minmax(values:Array[Int]):(Int,Int) = {
    var min = Int.MaxValue
    var max = Int.MinValue
    for(e<-values) {
      if(e < min) min = e
      if(e > max) max = e
    }
    (min,max)
  }

  //Ex9
  def lteeqgt(values:Array[Int], v:Int):(Int,Int,Int) = {
    var lt = 0
    var eq = 0
    var gt = 0
    for(e<-values) {
      if(e < v) lt += 1
      else if(e == v) eq += 1
      else gt += 1
    }
    (lt,eq,gt)
  }

  def main(args:Array[String]):Unit = {
    //Ex10
    val aa = "Hello".zip("World")
    val bb = 0
  }
}
