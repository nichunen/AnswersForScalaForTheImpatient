/**
 * Created by mac on 16/4/21.
 */
import scala.collection.mutable.ArrayBuffer

object ChEighteen {
  //Ex1
  class Bug{
    var loc = 0
    var direction = true
    def move(x : Int) = {
      if(direction) loc += x else loc -= x
      this
    }

    def turn() = {
      direction = !direction
      this
    }

    def show() = {
      println("Current loc is " + loc)
      this
    }
  }

  //Ex2
  object show
  object then
  object around

  class NewBug{
    private var loc = 0
    private var direction = true

    def move(x : Int):this.type = {
      if(direction) loc += x else loc -= x
      this
    }

    def showme():this.type = {
      println("Current loc is " + loc)
      this
    }

    def turn():this.type = {
      direction = !direction
      this
    }

    def and(obj: show.type): this.type = this.showme()
    def and(obj: then.type): this.type = this
    def turn(obj: around.type): this.type = turn()

  }

  //Ex3
  object Title
  object Author
  class Document {
    private var title = ""
    private var author = ""
    private var useNextArgAs: Any = null
    def set(obj: Title.type): this.type = { useNextArgAs = obj; this }
    def set(obj: Author.type): this.type = { useNextArgAs = obj; this }

    def to(arg: String): this.type = {
      if (useNextArgAs == Title) title = arg
      if (useNextArgAs == Author) author = arg
      this
    }

    override def toString = getClass.getName + "[title=" + title + ", author=" + author + "]"
  }

  //Ex4&Ex5
  class Network {

    class Member(val name: String) {
      val contacts = new ArrayBuffer[Network#Member]

      override def equals(that: Any) = that match {
        case t: Member => true
        case _ => false
      }

      override val toString = name
    }

    protected val members = new ArrayBuffer[Member]

    def join(name: String) = {
      val m = new Member(name)
      members += m
      m
    }
  }

  type NetworkMember = n.Member forSome { val n: Network }

  def process[M <: n.Member forSome { val n: Network }](m1: M, m2: M) = (m1, m2)
  def process2[M <: Network#Member](m1: M, m2: M) = (m1, m2)
  def process3(m1: NetworkMember, m2: NetworkMember) = (m1, m2)

  def main(args: Array[String]): Unit = {
    val bugsy = new NewBug
    val rr = bugsy move 4 and show and then move 6 and show turn around move 5 and show
    val aa = 0
  }
}
