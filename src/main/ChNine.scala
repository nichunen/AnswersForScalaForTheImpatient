/**
 * Created by mac on 15/12/15.
 */

import scala.io.Source
import collection.mutable.ArrayBuffer
import java.io.{PrintWriter, File, ObjectInputStream, FileOutputStream, FileInputStream, ObjectOutputStream}

object ChNine {
  //Ex1
  def reverseFile(file:String):Unit = {
    val source = Source.fromFile(file,"UTF-8")
    val lines = source.getLines().toArray
    val out = new PrintWriter(file)
    for(i <- 0 until lines.length) out.println(lines(lines.length -1 - i))
    out.close()
  }

  //Ex2
  def replaceTab(file:String):Unit = {
    val source = Source.fromFile(file,"UTF-8")
    val lines = source.getLines().toArray
    val out = new PrintWriter(file)
    for(line <- lines){
      val newLine = line.replaceAll("\\t","    ")
      out.println(newLine)
    }
    out.close()
  }

  //Ex3
  def printLongWords(file:String):Unit = {
    for(c <- (Source.fromFile(file,"UTF-8").mkString.split("\\s+")) if c.length > 12) println(c)
  }

  //Ex4
  def printDoubles(file:String):Unit = {
    val words = Source.fromFile(file, "UTF-8").mkString.split("\\s+")
    val numbers = for(word <- words) yield word.toDouble
    var min:Double = Double.MaxValue
    var max:Double = Double.MinValue
    var sum:Double = 0.0
    var num:Int = 0
    for(e <- numbers){
      if(e < min) min = e
      if(e > max) max = e
      sum += e
      num += 1
    }
    val mean:Double = sum/num
    if(num > 0)
      println("min = " + min + " max = " + max + " sum = " + sum + " avg = " + mean)
  }

  //Ex5
  def writePow2(file:String):Unit = {
    val out = new PrintWriter(file)
    for(i<-0 to 20){
      val thePower = math.pow(2,i)
      val reciprocal:Double = 1.0/thePower
      out.print(i)
      out.print("\t\t")
      out.print(reciprocal)
      out.print("\n")
    }
    out.close()
  }

  //Ex6
  def getAllInQuotation(file:String): Unit ={
    val source = Source.fromFile(file).mkString

    val pattern = "\"\\w+\"".r

    val myArr = pattern.findAllIn(source).toArray
    for(e <- myArr) println(e)
  }

  //Ex7
  def printAllNotDouble(file:String): Unit = {
    val source = Source.fromFile(file).mkString

    val pattern = """[^((\d+\.){0,1}\d+)^\s+]+""".r

    pattern.findAllIn(source).foreach(println)
  }

  //Ex8
  def printImgAndSrc(file:String):Unit = {
    val source = Source.fromFile(file).mkString
    val pattern = """<img[^>]+(src\s*=\s*"[^>^"]+")[^>]*>""".r
    for (pattern(str) <- pattern.findAllIn(source)) println(str)
  }

  //Ex9
  def getNumOfClass(dir:String):Int = {

    val myDir = new File(dir)

    def subdirs(dir:File):Iterator[File]={
      val children = dir.listFiles().filter(_.getName.endsWith("class"))
      children.toIterator ++ dir.listFiles().filter(_.isDirectory).toIterator.flatMap(subdirs _)
    }

    val n = subdirs(myDir).length
    n
  }

  //Ex10
  class Person(var name:String) extends Serializable {
    private val friends: ArrayBuffer[Person] = new  ArrayBuffer[Person]()

    def addFriend(friend: Person) = {
      friends += friend
    }

    override def toString() = {
      var str = "My name is " + name + " and my friends name is "
      friends.foreach(str += _.name + ",")
      str
    }
  }

  def printFriends():Unit = {
    val p1 = new Person("Jack")
    val p2 = new Person("Tom")
    val p3 = new Person("Jane")
    val p4 = new Person("George")
    p1.addFriend(p2)
    p1.addFriend(p4)
    val out = new ObjectOutputStream(new FileOutputStream("stream.obj"))
    out.writeObject(p1)
    out.close()
    val in = new ObjectInputStream(new FileInputStream("stream.obj"))
    val savedJack = in.readObject().asInstanceOf[Person]
  }




  def main(args:Array[String]):Unit = {
    printFriends()
  }
}
