import scala.collection.BitSet

/**
 * Created by mac on 15/12/26.
 */
object ChTen {
  //Ex1
  trait RectangleLike {
    def translate(x:Int, y:Int) = {
      println(x +" " + y)
    }

    def grow(x:Int, y:Int) = {
      println(x + " grow " + y)
    }
  }

  //Ex2
  class OrderedPoint extends java.awt.Point with Ordered[java.awt.Point] {
    def compare(other:java.awt.Point): Int ={
      if(this.x > other.x || (this.x == other.x && this.y > other.y))  1
      else if(this.x == other.x && this.y == other.y)  0
      else -1
    }
  }

  //Ex3
  /*
  trait BitSet extends scala.AnyRef with scala.collection.SortedSet[scala.Int] with scala.collection.BitSetLike[scala.collection.BitSet]
  object BitSet extends scala.AnyRef with scala.collection.generic.BitSetFactory[scala.collection.BitSet]
   */

  //Ex4
  trait Logger{
    def log(str:String,key:Int = 3):String
  }

  class CryptoLogger extends Logger{
    def log(str:String, key:Int):String = {
      for(i<-str) yield if(key >= 0) (97 + ((i - 97 + key) % 26)).toChar else (97 + ((i - 97 + 26 + key) % 26)).toChar
    }
  }

  //Ex7
  trait Fly{
    def fly() = {
      println("I'm flying.")
    }
    def flyWithoutWings()
  }

  trait Walk{
    def walk() = {
      println("I'm walking.")
    }
  }

  class Bird(var name:String = ""){

  }

  class blueBird extends Bird with Fly with Walk{
    def flyWithoutWings() = {
      println("I'm flying without wings.")
    }
  }

  //Ex10
  import java.io.InputStream

  class IterableInputStream extends InputStream with Iterable[Byte]{
    def read(): Int = 0

    def iterator: Iterator[Byte] = null
  }


  def main(args: Array[String]): Unit = {

  }
}
