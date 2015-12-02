/**
 * Created by Ni Chunen on 15/12/1.
 */
class ChOne {
  /*
   Ex1.
  %   *   -   >    >>    ^              isInstanceOf   toChar     toFloat   toLong    toString   unary_-   |
  &   +   /   >=   >>>   asInstanceOf   toByte         toDouble   toInt     toShort   unary_+    unary_~

  Ex2.
  scala> math.sqrt(3)
  res7: Double = 1.7320508075688772

  scala> math.pow
     def pow(x: Double, y: Double): Double

  scala> math.pow(res7,2)
  res8: Double = 2.9999999999999996

  Ex3.
  scala> 3
  res9: Int = 3

  scala> res9 = 4
  <console>:11: error: reassignment to val
         res9 = 4
              ^
  So res is val.

  Ex4.
  Repeat the string with given times.
  Query class StringOps, find the api
  def
    *(n: Int): String
  Return the current string concatenated n times.

  Ex5.
  Get the max one between 10 and 2, defined in class RichInt

  Ex6.
  scala> BigInt(2)
  res16: scala.math.BigInt = 2
  scala> res16.pow(1024)
  res19: scala.math.BigInt = 179769313486231590772930519078902473361797697894230657273430081157732675805500963132708477322407536021120113879871393357658789768814416622492847430639474124377767893424865485276302219601246094119453082952085005768838150682342462881473913110540827237163350510684586298239947245938479716304835356329624224137216

  Ex7.
  import scala.math._
  import scala.util._

  Ex.8
  scala> val sed = new scala.util.Random(7)
  sed: scala.util.Random = scala.util.Random@6f237a4f

  scala> val rand = sed.nextInt(1000000)
  rand: Int = 164236
  scala> BigInt(rand).toString(36)
  res32: String = 3iq4

  Ex.9
  scala> "Hello World"
  res33: String = Hello World
  scala> res33.slice(0,1)
  res34: String = H
  scala> res33.slice(res33.length()-1,res33.length())
  res40: String = d

  Ex.10
  take:Selects first n elements.
  drop:Selects all elements except first n ones.
  takeRight:Selects last n elements.
  dropRight:Selects all elements except last n ones.
   */

}
