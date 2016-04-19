/**
 * Created by mac on 16/4/7.
 */
import scala.collection.mutable.{Map,SortedSet,LinkedList}
import scala.collection.immutable.{List,HashMap}

object ChThirteen {
  //Ex1
  def indexes(str:String):Map[Char, SortedSet[Int]] = {
    var ret = Map[Char, SortedSet[Int]]()
    for(i <- 0 until str.length())
      if(ret.contains(str(i))) ret(str(i)).+=(i)
      else
        ret += (str(i)->(SortedSet(i)))
    ret
  }

  //Ex2
  def indexesV2(str:String):Map[Char, List[Int]] = {
    var ret = Map[Char, List[Int]]()
    for(i <- 0 until str.length())
      if(ret.contains(str(i))) ret += (str(i) -> ((ret(str(i)):::List(i))))
      else
        ret += (str(i)->(List(i)))
    ret
  }

  //Ex3
  def removeZerosInList(myList: List[Int]):List[Int] = {
    myList.filter(_ != 0)
  }

  //Ex4
  def flatMapTest(arr:Array[String], mymap:Map[String,Int]):Array[Int] = {
    val myseq = arr.flatMap(mymap.get(_))
    myseq.toArray
  }

  //Ex5
  def myMkString(arr:Array[Any]) = {
    val ret = arr.reduceLeft(_.toString() + _.toString())
    ret
  }

  //Ex7
  def Ex7() = {
    val prices = List(5.0, 20.0, 9.95)
    val quantities = List(10, 2, 1)
    print(prices.zip(quantities).map(Function.tupled(_ * _)))
  }

  //Ex8
  def get2D(arr:Array[Double], n: Int) = {
    val ret = arr.grouped(n).toArray
    ret
  }

  //Ex10
  def frequence(str: String): HashMap[Char, Int] = {
    val result = str.par.aggregate(HashMap[Char, Int]())(
    {
      (m, c) =>
        m + ( c -> (m.getOrElse(c,0) + 1) )
    },
    {
      (m1, m2) =>
        (m1.keySet ++ m2.keySet).foldLeft( HashMap[Char, Int]() ) {
          (result, k) =>
            result + (k -> (m1.getOrElse(k, 0) + m2.getOrElse(k, 0)))
        }
    })
    result
  }

  def main(args: Array[String]): Unit = {
    print("hello".aggregate(Set[Char]())(_ + _, _ ++ _))
  }
}
