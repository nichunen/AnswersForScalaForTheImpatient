/**
 * Created by Ni Chunen on 15/12/11.
 */

//Ex1 & Ex2
abstract class Conversions {
  def inchesToCentimeters(inch:Double):Double = {inch * 2}
  def gallonsToLiters(gallon:Double):Double = {gallon * 2}
  def milesToKilometers(mile:Double):Double = {mile * 2}
}

//Ex3 only one point?
object Origin extends java.awt.Point{

}

//Ex4
class Point private (val x:Double, val y:Double) {

}

object Point{
  def apply(x:Double, y:Double):Point = {
    new Point(x,y)
  }
}

//Ex5
/*
object Reverse extends App{
  if(args.length >= 2){
    for(i <- 0 until args.length){
      print(args(args.length - 1 - i) + " ")
    }
    println()
  }
  else if(args.length == 1){
    println(args(0))
  }
}
*/

//Ex6
object Puke extends Enumeration {
  type Puke = Value
  val Spade, Heart, Diamond, Club = Value
  def toString(myType:Puke):String = {
    if(myType == Spade) "Spade"
    else if(myType == Heart) "Heart"
    else if(myType == Diamond) "Diamond"
    else "Club"
  }
}



object ChSix{

  //Ex7
  def isCardRed(puke: Puke.Puke):Boolean = {
    if(puke == Puke.Heart || puke == Puke.Diamond) true
    else false
  }

  def main(args:Array[String]):Unit = {
    val aa:Puke.Puke = Puke.Spade
    val cc = aa.toString()
    val bb = 0
  }
}
