/**
 * Created by NiChunen on 15/12/5.
 */
import scala.util._

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
  def newSwapArr(arr:Array[Int]):Array[Int] = {
    val newArr = for(i <- 0 to arr.length) yield {
      if(i % 2 == 0 && (i + 1) <= (arr.length -1))
        arr(i + 1)
      else if(i % 2 == 1)
        arr(i -1)
    }
    var retArr = new Array[Int](arr.length)
    newArr.copyToArray(retArr,0)
    arr
  }

  def main(args: Array[String]): Unit = {
    var aa = Array(1, 2, 3, 4)
    val bb = newSwapArr(aa)
    val cc = 0
  }

}
