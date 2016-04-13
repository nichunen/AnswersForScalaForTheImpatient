/**
 * Created by mac on 16/4/11.
 */
import scala.math.sqrt

object ChFourteen {
  //Ex2
  def swap(pair:(Int, Int)):(Int, Int) = {
    pair match{
      case (a,b) => (b, a)
    }
  }

  //Ex3
  def swapNew(arr: Array[Int]) = {
    arr match {
      case Array(a,b, ar @ _*) => Array(b,a) ++ ar
      case _ => arr
    }
  }

  //Ex4
  abstract class Item
  case class Article(name:String, price:Double) extends Item
  case class Multiple(num:Int, item:Item) extends Item
  case class Bundle(name : String , discount : Double , item : Item*) extends Item
  def price(it : Item) : Double = it match {
    case Article(_,p) => p
    case Bundle(_,disc,its @ _*) => its.map(price _).sum - disc
    case Multiple(n,it) => n * price(it)
  }

  //Ex5
  def leafSum(tree : List[Any]):Int = {
    var sum = 0
    tree.foreach{ sub =>
      sub match {
        case subTree : List[Any] => sum += leafSum(subTree)
        case i:Int => sum += i
      }
    }
    sum
  }

  //Ex6
  /*
  sealed abstract class BinaryTree
  case class Leaf(value : Int) extends BinaryTree
  case class Node(left : BinaryTree,right : BinaryTree) extends BinaryTree
  def leafSumNew(tree: BinaryTree): Int = {
    var sum = 0
    tree match {
      case leaf:Leaf => sum += leaf.value
      case subTree:Node => {
        sum += leafSumNew(subTree.left)
        sum += leafSumNew(subTree.right)
      }
    }
    sum
  }
  */

  //Ex7
  sealed abstract class BinaryTree
  case class Leaf(value : Int) extends BinaryTree
  case class Node(children : BinaryTree*) extends BinaryTree
  def leafSumNew(tree: BinaryTree):Int = {
    tree match {
      case Leaf(v) => v
      case Node(r @ _*) => {
        r.map(leafSumNew).sum
      }
    }
  }

  //Ex8
  case class NodeNew(ch : Char, children : BinaryTree*) extends BinaryTree
  def leafSumNewNew(tree: BinaryTree):Int = {
    tree match {
      case Leaf(v) => v
      case NodeNew(sign, children @ _*) => {
        if(sign == "+") children.map(leafSumNewNew).sum
        else if(sign == "*") children.map(leafSumNewNew).reduceLeft(_ * _)
        else if(sign == "-") children.map(leafSumNewNew).foldLeft(0)(_ - _)
        else 0
      }
    }
  }

  //Ex9
  def calSumOfNotNoe(ls : List[Option[Int]]) = {
    var sum = 0
    ls.foreach{ elem =>
      sum += elem.getOrElse(0)
    }
    sum
  }

  //Ex10

  def f(x : Double) = if ( x >= 0) Some(sqrt(x)) else None
  def g(x : Double) = if ( x != 1) Some( 1 / ( x - 1)) else None
  def compose(f : (Double => Option[Double]), g: (Double => Option[Double])):(Double => Option[Double]) = {
    (x : Double) =>
      if (f(x) == None && g(x) == None) None
      else if(f(x) == None) g(x)
      else f(x)
  }


  def main(args: Array[String]): Unit = {
    val l: List[Any] = List(List(3, 8), 2, List(5))
    println(leafSum(l))
  }


}
