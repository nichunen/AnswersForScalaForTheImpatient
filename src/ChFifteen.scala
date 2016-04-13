/**
 * Created by mac on 16/4/13.
 */

import org.junit.Test

class ScalaTest {

  @Test
  def test1(){
    print("test1")
  }

  @Test(timeout = 1L)
  def test2(){
    print("test2")
  }
}

object ChFifteen {
  def main(args: Array[String]): Unit = {
    print("aa")
  }
}
