/**
 * Created by mac on 15/12/13.
 */
object ChEight {
  class BankAccount(initialBalance: Double) {
    private var balance = initialBalance
    def deposit(amount: Double) = {balance += amount; balance}
    def withdraw(amount: Double) = {balance -= amount; balance}
    def interest(rate: Double) = {balance += balance * rate}
  }

  //Ex1
  class CheckingAccount(initialBalance: Double) extends BankAccount(initialBalance: Double){
    override def deposit(amount: Double) = {super.deposit(amount - 1)}
    override def withdraw(amount: Double) = {super.withdraw(amount + 1)}
  }

  //Ex2
  class SavingAccount(val rate:Double,initialBalance:Double) extends CheckingAccount(initialBalance: Double){
    private var numFree = 3;
    def earnMonthlyInterest() = {
      super.interest(rate)
      numFree = 3
    }
    override def deposit(amount: Double) = {if(numFree > 0) {numFree -= 1; super.deposit(amount)} else super.deposit(amount - 1)}
    override def withdraw(amount: Double) = {if(numFree >0) {numFree -= 1; super.withdraw(amount)} else super.withdraw(amount + 1)}
  }

  //EX3
  class ShapeOld(){
    protected var name:String = "shape"
    def this(name:String)  {
      this()
      this.name = name
    }
  }

  class CircleOld extends ShapeOld {

    private var radius:Double = 0.0;

    def this(radius:Double) {
      this()
      this.radius = radius;
    }

    def this(radius:Double, name:String) {
      this(radius)
      this.name = name
    }
  }

  //Ex4
  abstract class Item {
    def price:Double
    def description:String
  }

  class SimpleItem(myprice:Double, name:String) extends Item {
    override val price = myprice
    override val description = "I am " + name
  }

  class Bundle(private val itemArr:Array[SimpleItem]) extends Item{
    override val price = {
      var priceSum = 0.0
      for(e<-itemArr) priceSum += e.price
      priceSum
    }
    override val description = {
      var desAll = ""
      for(e<-itemArr) desAll += (e.description + ".")
      desAll
    }
  }

  //Ex5
  class Point(val x:Double,val y:Double){

  }

  class LabeledPoint(val token:String,  x:Double,  y:Double) extends Point(x, y){

  }

  //Ex6
  abstract class Shape{
    def centerPoint:Point
  }

  class Rectangle(val x:Double, val y:Double, val length:Double, val height:Double) extends Shape{
    override def centerPoint:Point = {
      new Point(x + length/2, y + height/2)
    }
  }

  class Circle(val x:Double, val y:Double, val radius:Double) extends Shape{
    override def centerPoint:Point = {
      new Point(x, y)
    }
  }

  //Ex7
  class Square(x:Int, y:Int, width: Int) extends java.awt.Rectangle(x,y,width,width){
    def this(width:Int){
      this(0,0,width)
    }
    def this() {
      this(0,0,0)
    }
  }

  //Ex9
  //Override needed

  //Ex10
  //The constructor only be called by other constructors or its subclasses, not used to create instances

  def main(args:Array[String]):Unit = {
    val aa = new SimpleItem(10, "aa")
    val bb = new SimpleItem(20, "bb")
    val arr:Array[SimpleItem] = Array[SimpleItem](aa,bb)
    val dd = new Bundle(arr)
    val mm = dd.price
    val nn = dd.description
    val cc = 0
  }
}
