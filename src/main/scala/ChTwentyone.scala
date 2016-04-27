/**
 * Created by mac on 16/4/25.
 */

import java.awt.Point

object ChTwentyone {
  //Ex1
  /*
    implicit final class ArrowAssoc[A](private val self: A) extends AnyVal {
    @inline def -> [B](y: B): Tuple2[A, B] = Tuple2(self, y)
    def ¡ú[B](y: B): Tuple2[A, B] = ->(y)
  }
   */

  //Ex2
  class PercentPlus[T](val x: T) {
    def +%(percent: Int): T =
      math.round(this.x.asInstanceOf[Double] * (1 + percent / 100.0)).asInstanceOf[T]
  }

  implicit def int2PercentPlus(from: Double) = new PercentPlus(from)

  //Ex3
  class Factorial(val x:Int) {
    def helper(n:Int):Long = if(n == 0 || n == 1) 1 else if(n < 0) 0 else n * helper(n-1)
    def ! = {
      helper(x)
    }
  }

  implicit def int2Factorial(from:Int) = new Factorial(from)

  //Ex5
  class Fraction(val numerator: Int, val denominator: Int) {
    override val toString = numerator + "/" + denominator
  }

  object Fraction {
    def apply(numerator: Int, denominator: Int) = new Fraction(numerator, denominator)
  }

  class RichFraction(n: Int, d: Int) extends Fraction(n, d) with Ordered[Fraction] {
    def compare(that: Fraction) =
      (numerator.asInstanceOf[Double] / denominator * 1000).asInstanceOf[Int] -
        (that.numerator.asInstanceOf[Double] / that.denominator * 1000).asInstanceOf[Int]
  }

  //Ex6
  class RichPoint(x: Double, y: Double) extends Point(x, y) with Ordered[Point] {
    override def toString = "" + (x, y)
    def compare(that: Point) =
      toString.compare((new RichPoint(that.x, that.y)).toString)
  }

  def main(args: Array[String]): Unit = {
    println(5!)
  }



}
