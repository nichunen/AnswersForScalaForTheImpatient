/**
 * Created by mac on 15/12/11.
 */

import javax.print.attribute.standard.PrinterMoreInfoManufacturer

import scala.beans.BeanProperty

object ChFive {

  //Ex1
  class Counter {
    private var value = 0
    def increment() { value = if(value == Int.MaxValue) value else (value + 1)}
    def current() = value
  }

  //Ex2
  class BankAccount {
    private  var money:Double = 0.0
    private  val balance = 0
    def deposit(inmoney:Double):Double = { money += inmoney; money}
    def withdraw(outmoney:Double):Double = {
      if(money < outmoney){
        money = 0.0
      }
      else{
        money -= outmoney
      }
      money
    }
    def showMyoney() = {money}
  }

  //Ex3
  class Time(val hours:Int, val minutes:Int) {
    def description = hours + " : " + minutes
    def before(other:Time):Boolean = {
      if(other.hours > hours){
        true
      } else if(other.hours < hours){
        false
      } else {
        if(other.minutes > minutes) true else false
      }
    }
  }

  //Ex4
  class TimeV2(val hours:Int, val minutes:Int) {
    private  val allMins = hours * 60 + minutes
    def description = hours + " : " + minutes
    def before(other:TimeV2):Boolean = {
      if(allMins < other.allMins) true else false
    }
  }

  //Ex5
  class Student {
    @BeanProperty var name:String = _
    @BeanProperty var id:Long = _
    /*
    Compiled from "Student.scala"
    public class Student {
      private java.lang.String name;
      private long id;
      public java.lang.String name();
      public void name_$eq(java.lang.String);
      public void setName(java.lang.String);
      public long id();
      public void id_$eq(long);
      public void setId(long);
      public java.lang.String getName();
      public long getId();
      public Student();
    }
    */
  }

  //Ex6
  class Person(var age:Int) {
    if(age < 0)
      age = 0
  }

  //Ex7
  class PersonV2(val name:String){
    val firstName:String = {
      val arr:Array[String] = name.split(" ")
      if(arr.length > 0)
        arr(0)
      else
        ""
    }
    val lastName:String = {
      val arr:Array[String] = name.split(" ")
      if(arr.length > 1)
        arr(arr.length - 1)
      else
        ""
    }

    def description() = firstName + " " + lastName
  }

  //Ex8
  class Car(val manufacturer:String, val model:String, val year:Int = -1, var number:String){

  }

  //Ex9
  /*
public class Car {
    private String manufacturer, model;
    private String number = "";
    private int year = -1;

    public Car(String manu, String model) {
        this.manufacturer = manu;
        this.model = model;
    }

    public Car(String manu, String model, String number) {
        this.manufacturer = manu;
        this.model = model;
        this.number = number;
    }

    public Car(String manu, String model, int year) {
        this.manufacturer = manu;
        this.model = model;
        this.year = year;
    }

    public Car(String manu, String model, int year, String number) {
        this.manufacturer = manu;
        this.model = model;
        this.year = year;
        this.number = number;
    }


    public String getManufacturer() {
        return this.manufacturer;
    }

    public String getModel() {
        return this.model;
    }

    public int getYear(){
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public static void main(String [] args) {

    }
}
   */


  def main(args:Array[String]):Unit = {
    //Ex10
    val aa = new PersonV2("Ni Chunen")
    println(aa.description())
  }

}
