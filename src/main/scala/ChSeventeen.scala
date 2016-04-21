/**
 * Created by mac on 16/4/19.
 */
object ChSeventeen {
  //Ex1
  class Pair[T, S](val first:T, val second:S){
    def swap = {
      (second,first)
    }
  }

  //Ex2
  class NewPair[T](var first:T, var second:T){
    def swap = {
      val tmp = first
      first = second
      second = tmp
    }

    def myprint = {
      print((first,second))
    }

    def replaceFirst(newFirst: T) = new NewPair[T](newFirst, second)
  }

  //Ex3
  class PairNew[T, S]{
    def swap[T, S](p:(T, S)) = {
      (p._2,p._1)
    }
  }

  //Ex4
  class Person
  class Student extends Person

  //Ex6
  def middle[T](it:Iterable[T]) = {
    val mylist = it.toList
    mylist((mylist.length)/2)
  }

  //Ex7
  //foldLeft, foldRight, groupBy

  //Ex8



  def main(args: Array[String]): Unit = {
    print(middle(List("a","b","c","d","e")))
  }
}
