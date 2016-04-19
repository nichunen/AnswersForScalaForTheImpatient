/**
 * Created by mac on 16/4/2.
 */

import collection.mutable.ArrayBuffer

object ChEleven {
  //Ex1
  //From the left to the right

  //Ex2
  //Use **, the priority will be the same with *. Use ^, the priority will be lower then *

  //Ex3
  class Fraction(n:Int, d:Int) {
    private val num: Int = if(d == 0) 1 else n * sign(d) / gcd(n, d)
    private val den: Int = if(d == 0) 0 else d * sign(d) / gcd(n, d)
    override def toString = num + "/" + den
    def sign(a: Int) = if(a > 0) 1 else if(a < 0) -1 else 0
    def gcd(a: Int, b: Int): Int = if(b == 0) abs(a) else gcd(b, a % b)
    def abs(a: Int):Int = if(a < 0) -a else a
    def +(other:Fraction):Fraction = new Fraction(this.num * other.den + other.num * this.den, this.den * other.den)
    def -(other:Fraction):Fraction = new Fraction(this.num * other.den - other.num * this.den, this.den * other.den)
    def *(other:Fraction):Fraction = new Fraction(this.num * other.num, this.den * other.den)
    def /(other:Fraction):Fraction = new Fraction(this.num * other.den, this.den * other.num)
  }

  //Ex4
  class Money(d:Int, c:Int) {
    private val cents:Int = d * 100 + c
    private def abs(a: Int):Int = if(a < 0) -a else a
    private def addZero(a:Int):String = if(a/10 == 0) "0" + a else a.toString()
    override def toString = "$" + cents / 100 + "." + addZero(abs(cents % 100))
    def +(other:Money) = new Money((this.cents + other.cents) / 100, (this.cents + other.cents) % 100)
    def -(other:Money) = new Money((this.cents - other.cents) / 100, (this.cents - other.cents) % 100)
    def ==(other:Money) = this.cents == other.cents
    def <(other:Money) = this.cents < other.cents
  }

  //Ex5
  class Table {
    private var html = ""
    override def toString = "<table><tr>" + html + "</tr></table>"
    def |(str:String):Table = {
      val t = Table()
      t.html = this.html + "<td>" + str + "</td>"
      t
    }

    def ||(str:String):Table = {
      val t = Table()
      t.html =  this.html +  "</tr><tr><td>" + str + "</td>"
      t
    }
  }

  object Table {
    def apply() = new Table()
  }

  //Ex6
  class ASCIIArt(str:String){
    val arr:ArrayBuffer[ArrayBuffer[String]] = new ArrayBuffer[ArrayBuffer[String]]()

    if (str != null && !str.trim.eq("")){
      str.split("[\r\n]+").foreach{
        line =>
          val s = new ArrayBuffer[String]()
          s += line
          arr += s
      }
    }

    def this(){
      this("")
    }

    def +(other:ASCIIArt):ASCIIArt={
      val art = new ASCIIArt()
      val length = if (this.arr.length >= other.arr.length) this.arr.length else other.arr.length
      for(i <- 0 until length){
        val s = new ArrayBuffer[String]()
        val thisArr:ArrayBuffer[String] = if (i < this.arr.length) this.arr(i) else new ArrayBuffer[String]()
        val otherArr:ArrayBuffer[String] = if (i < other.arr.length) other.arr(i) else new ArrayBuffer[String]()
        thisArr.foreach(s += _)
        otherArr.foreach(s += _)
        art.arr += s
      }
      art
    }

    def *(other:ASCIIArt):ASCIIArt={
      val art = new ASCIIArt()
      this.arr.foreach(art.arr += _)
      other.arr.foreach(art.arr += _)
      art
    }

    override def toString()={
      var ss:String = ""
      arr.foreach{
        ss += _.mkString(" ") + "\n"
      }
      ss
    }
  }

  //Ex7
  class BigSequence{
    private val myValue = new Array[Int](64)

    for(i <-0 until myValue.length) myValue(i) = -1
    def pack():Long = {
      myValue.filter(_ >= 0).mkString.toLong
    }

    def update(arg1:Int, bit:Int) = if(arg1 >= 0 && arg1 < 64) myValue(arg1) = bit
  }

  object BigSequence{
    def apply(num:Long) = {
      val myObj = new BigSequence()
      var i = 0
      num.toString().foreach { n =>
        myObj.myValue(i) = n.getNumericValue
        i += 1
      }
      myObj
    }
  }

  //Ex8
  class Matrix {
    var mt: Array[Array[Int]] = _

    def this(m: Int, arr: Array[Int]) {
      this()
      mt = new Array[Array[Int]](m)
      var idx = 0
      for (i <- 0 until m; j <- 0 until m) {
        if (j == 0)
          mt(i) = new Array[Int](m)
        mt(i)(j) = if (arr != None && arr.length > idx) arr(idx) else 0
        idx += 1
      }
    }


    def this(m: Int, n: Int, arr: Array[Int]) = {
      this()
      mt = new Array[Array[Int]](m)
      var idx = 0
      for (i <- 0 until m; j <- 0 until n) {
        if (j == 0)
          mt(i) = new Array[Int](n)
        mt(i)(j) = if (arr != None && arr.length > idx) arr(idx) else 0
        idx += 1
      }
    }

    def +(other: Matrix) = {
      if (this.mt.length != other.mt.length || this.mt(0).length != other.mt(0).length) new Matrix()
      else if (this.mt.length == this.mt(0).length) {
        val mySeq = this.mt.flatMap(x => x)
        val otherSeq = other.mt.flatMap(x => x)
        val addedSeq = for (i <- 0 until mySeq.length) yield (mySeq(i) + otherSeq(i))
        new Matrix(this.mt.length, addedSeq.toArray)
      } else {
        val mySeq = this.mt.flatMap(x => x)
        val otherSeq = other.mt.flatMap(x => x)
        val addedSeq = for (i <- 0 until mySeq.length) yield (mySeq(i) + otherSeq(i))
        new Matrix(this.mt.length, this.mt(0).length, addedSeq.toArray)
      }
    }

    def *(other: Matrix) = {
      if (this.mt.length != other.mt(0).length || this.mt(0).length != other.mt.length) new Matrix()
      else {
        val arrBuff = ArrayBuffer[Int]()
        for (i <- 0 until this.mt.length; j <- 0 until other.mt(0).length) {
          var sum = 0
          for (ii <- 0 until other.mt.length) {
            sum += this.mt(i)(ii) * other.mt(ii)(j)
          }
          arrBuff += sum
        }
        new Matrix(this.mt.length, other.mt(0).length, arrBuff.toArray)
      }
    }

    def *(other:Int) = {
      val arrBuff = ArrayBuffer[Int]()
      for(i<- 0 until this.mt.length; j <- 0 until this.mt(0).length) {
        arrBuff += this.mt(i)(j) * other
      }
      new Matrix(this.mt.length, this.mt(0).length, arrBuff.toArray)
    }
  }

  //Ex9
  class RichFile(val path:String){

  }

  object RichFile {
    def apply(path: String): RichFile = {
      new RichFile(path)
    }

    def unapply(richF: RichFile) = {
      if (richF.path == null) None
      else {
        val reg = "([/\\w+]+)/(\\w+)\\.(\\w+)".r
        val reg(r1, r2, r3) = richF.path
        Some(r1, r2, r3)
      }
    }

    //Ex10
    def unapplySeq(richFile: RichFile): Option[Seq[String]] = {
      if (richFile.path == null) {
        None
      } else {
        Some(richFile.path.split("/"))
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val richFile = RichFile("/home/cay/readme.txt")
    val RichFile(r @ _) = richFile
    println(r)
  }
}
