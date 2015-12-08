/**
 * Created by NiChunen on 15/12/5.
 */

import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.Buffer
import java.util.TimeZone._
import scala.util._
import java.awt.datatransfer._
import scala.collection.JavaConversions.asScalaBuffer


object ChThree {
  //Ex1
  def getRandomArr(n:Int) = {
    if(n <= 0) new Array[Int](0)
    else {
      val theArr = new Array[Int](n)
      val sed = new Random(7)
      for(i <- 0 until n){
        theArr(i) = sed.nextInt(n)
      }
      theArr
    }
  }

  //Ex2
  def swapArr(arr:Array[Int]):Unit = {
    for(i <- 0 to arr.length; if i % 2 == 0 && (i + 1) <= (arr.length - 1)){
      val tmp = arr(i)
      arr(i) = arr(i + 1)
      arr(i + 1) = tmp
    }
  }

  //Ex3
  def newSwapArr(arr:Array[Int]) = {
    val newArr = for(i <- 0 until arr.length) yield {
      if(i % 2 == 0 && (i + 1) <= (arr.length -1))
        arr(i + 1)
      else if(i % 2 == 1)
        arr(i -1)
    }
    newArr
  }

  //Ex4
  def reOrder(arr:Array[Int]):Array[Int] = {
    var curIdx = 0
    val positiveIdx = new ArrayBuffer[Int]()
    val zeroIdx = new ArrayBuffer[Int]()
    val negativeIdx = new ArrayBuffer[Int]()
    val newArr = new Array[Int](arr.length)
    for(i <- 0 until arr.length) {
      if(arr(i) > 0) positiveIdx += i
      else if(arr(i) == 0) zeroIdx += i
      else negativeIdx += i
    }
    while(curIdx < positiveIdx.length){
      newArr(curIdx) = arr(positiveIdx(curIdx))
      curIdx += 1
    }
    while((curIdx - positiveIdx.length) < zeroIdx.length){
      newArr(curIdx) = arr(zeroIdx(curIdx - positiveIdx.length))
      curIdx += 1
    }
    while((curIdx - positiveIdx.length - zeroIdx.length) < negativeIdx.length){
      newArr(curIdx) = arr(negativeIdx(curIdx - positiveIdx.length - zeroIdx.length))
      curIdx += 1
    }
    newArr
  }

  //Ex5
  def getMean(arr:Array[Double]):Double = {
    arr.sum / arr.length
  }

  //Ex6
  def reverseArr(arr:Array[Int]):Unit = {
    for(i <- 0 until (arr.length/2 - 1)){
      val tmp = arr(i)
      arr(i) = arr(arr.length - 1 - i)
      arr(arr.length - 1 - i) = tmp
    }
  }

  //Ex7
  def getAllValues(arr:Array[Int]):Array[Int] = {
    arr.distinct
  }

  //Ex8
  def removeNegs(arr:ArrayBuffer[Int]):Unit = {
    val allNegs = ArrayBuffer[Int]()
    for(i <- 0 until arr.length if arr(i) < 0){
      allNegs += i
    }
    for(i <-1  until allNegs.size){
      arr.remove(allNegs(i))
    }
  }

  //Ex9
  def getAmericas():Array[String] = {
    val allIds = getAvailableIDs();
    val ret = for(e <- allIds if e.startsWith("America/")) yield e.stripPrefix("America/")
    ret.sortWith(_ > _)
    ret
  }

  //Ex10
  def javaToBuffer():Buffer[String] = {
    val flavors = SystemFlavorMap.getDefaultFlavorMap.asInstanceOf[SystemFlavorMap]
    val command = flavors.getNativesForFlavor(DataFlavor.imageFlavor)
    val pb = new ProcessBuilder(command)
    val cmd:Buffer[String] = pb.command()
    cmd
  }


  def main(args: Array[String]): Unit = {

  }

}
