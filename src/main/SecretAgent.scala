/**
 * Created by Ni Chunen on 15/12/13.
 */
class Person(val name: String) {
  override def toString = getClass.getName + "[name=" + name + "]"
}

class SecretAgent(codename: String) extends Person(codename){
  override val name = "secret"
  override val toString = "secret"
}
