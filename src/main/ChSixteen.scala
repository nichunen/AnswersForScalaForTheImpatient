/**
 * Created by mac on 16/4/18.
 */
import scala.xml._
import scala.xml.transform._

object ChSixteen {
  //Ex2
  val aa =
    <ul><li>Opening bracket: [</li> <li>Closing bracket: ]</li> <li>Opening brace: {{</li> <li>Closing brace: }}</li> </ul>


  //Ex3
  def Ex3 = {
    val a = <li>Fred</li> match { case <li>{ Text(t) }</li> => t }
    //val b = <li>{ "Fred" }</li> match { case <li>{ Text(t) }</li> => t }
    val c = <li>{ Text("Fred") }</li> match { case <li>{ Text(t) }</li> => t }
    println("a=" + a)
    println("c=" + c)
    /*output:
      a=Fred
      b: Exception in thread "main" scala.MatchError: <li>Fred</li> (of class scala.xml.Elem)
      c=Fred
    */
  }

  //Ex4
  def Ex4 = {
    val root = XML.loadFile("./src/main/scala/test.xhtml")
    val imgs: NodeSeq = root \\ "img"
    // img \ "@alt " 's type is scala.xml.NodeSeq
    for (img <- imgs if (img \ "@alt").text == "") println(img)
  }

  //Ex5
  def Ex5 = {
    val root = XML.loadFile("./src/main/scala/test.xhtml")
    val imgs: NodeSeq = root \\ "img"
    imgs.foreach { x => println((x \ "@src").text) }
  }

  //Ex6
  def Ex6 = {
    val root = XML.loadFile("./src/main/scala/oschina.xhtml")
    val imgs: NodeSeq = root \\ "a"
    imgs.foreach { x =>
      val child = x.child
      println("%s: %s".format(child(0).text, x.attribute("href").getOrElse("")))
    }
  }

  //Ex7
  def genDl(input: Map[String,String])={
    <dl>{for((k,v) <- input) yield <dt>{k}</dt><dd>{v}</dd>}</dl>
  }

  //Ex8
  def dl2map(input: scala.xml.Elem): Map[String, String] = {
    var map = Map[String, String]()
    val keys = input \ "dt"
    val values = input \ "dd"
    for (i <- 0 until keys.size) map += keys(i).text -> values(i).text
    map
  }

  //Ex9
  def transform(filename: String) {
    val root = XML.loadFile(filename)
    val rule1 = new RewriteRule {
      override def transform(n: Node) = n match {
        case x @ <img/> => if (x.attributes("alt") == null) x.asInstanceOf[Elem] % Attribute(null, "alt", "TODO", scala.xml.Null) else x
        case _ => n
      }
    }
    val transformed = new RuleTransformer(rule1).transform(root)
    println(transformed)
    scala.xml.XML.save("./src/main/scala/test_new.xhtml", transformed(0))
  }
  

  def main(args: Array[String]): Unit = {
    transform("./src/main/scala/test.xhtml")
  }
}
