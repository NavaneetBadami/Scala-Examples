import java.util.Date

import HelloScala.Person

import scala.util.Random
import scala.util.control.Breaks
import scala.util.matching.Regex.Match
//A Scala class can contain one and only one Primary constructor,
//var = for var scala generates both getter setter method
//val = for val scala generates only getter method
// if we dont specify val or var then scala doesn't create getter/setter

class Employee() {
  println("default constructo")
}

class Employee1(var name:String, val age:Float, city:String) {
  println("parametrized constructor: "+ name +" "+age)
  //age = 20;  // CTE
  def detail () = name +" "+ (age+10) //possible   // function within constructor
}

class Employee2(var name:String = "defautname") {
  println("Default Name: "+ name)
}

class Stud(var name:String, var branch:String) {

  var id = 0
  var surname = ""
  var na  = name;
  var br = branch

  def this(surname:String) {
    this(ScalaRevise.DEFAULT_NAME, "")      // cannot refer any value here, manually have to pass value only local or static Value from Object
    this.surname = surname
    println("==========> "+ this.na)
  }

  def this(id:Int) {
    this(ScalaRevise.DEFAULT_SURNAME)
    this.id = id
  }

  def getName (): String = {
      return  "TestName"
  }

  def disp(): Unit = {
    println(" Auxiliray : - "+ name +" "+branch +" "+ id +" "+ surname)
  }
}



object ScalaRevise {

  val DEFAULT_SURNAME = "BADAMI"
  val DEFAULT_NAME = "NAVANEET"

  def main(args: Array[String]): Unit = {
    println("Just get started and lets become master in scala")

    var a  = 10;
    var aa:Int = 10;
    var name = "Naveneet"
    var name1:String = "Test"
    var age = 31.5f;
    var agee:Double = 31.22;
    var ageee = 31.22d;
    aa = 10
    println(a +" "+aa+" "+name+" "+name1+" "+age+" "+agee + " "+aa+ " "+ageee)
    println(s"a: $a  name: $name name1: $name1 age: $age")

    val res = if(aa ==11) "yep good" else "noooooo not good"
    println(res)
  }

  println("============= primary Constructor==================")
  new Employee()
  new Employee1("Navneet", 31, "pune")
  var empDetail = new Employee1("TestName",31, "Bjp").detail()
  println("Emp details: "+empDetail)
  new Employee2() // default name


  println("==============Auxiliary constructor =================")
//  var s1:Stud = new Stud("Navaneet","ISE")
//  s1.disp()
//
//  var s2 = new Stud("Badami")
//  s2.disp()
//
  var s3 = new Stud(22)
  s3.disp()

  println("============= method and function===========")

  def getIntValue(value:Int): Int ={
        value+2
  }

  def getSumall(data:Int*) ={
      var sum = 0
       for(data <- data) {
          sum +=data
       }
    sum
  }

  def getConString(datList:String*): String =  {
      var con=""
      for(d <- datList)
          con+=d
    con
  }

  def getArray(args:Array[String]): Unit = {
      args.foreach{e => println(e)}
  }

  def getListData(arg:List[String]): Unit = {
    arg.foreach{e => println(e)}
  }

  def getSetData(arg:Set[String]): Unit ={
    arg.foreach{e => println(e)}
  }

  def getMapData(arg:Map[String,String]): Unit = {
    arg.foreach{e => println(e._1 +" "+e._2)}
  }

  def getRefObjList(arg:List[Employee2]): Unit = {
    arg.foreach{e => println(e.name)}
  }

  println(getSumall(1,4,2,5,6,7))
  println(getConString("dsdsd","dsdsdsd","dsdsdd"))
  this.getArray(Array("nana1","nana2"))
  this.getListData(List("lala1","lala2"))
  this.getSetData(Set("kaka","kaka","kkaa"))
  this.getMapData(Map("1" -> "mala", "2" -> "tala"))
  this.getRefObjList(List(new Employee2("dala"), new Employee2()))

  println("=============Anonymous function==================")

  var result0 = (a:Int, b:Int) => a + b
  var result1 = (a:Int, b:Int) => (a + b)
  var result2 = (a:Int, b:Int) => { a + b}
  var result3 = (_:Int) + (_:Int)
  var result4 = (a:String) => a.toLowerCase
  var result5 = (a:List[String]) => a.foreach(a => println(a.toLowerCase()))
  var result6 = (a:Set[String]) => a.foreach(a => println(a.toLowerCase()))

  println(result0(3,4))
  println(result1(3,4))
  println(result2(3,4))
  println(result3(3,4))
  println(result4("Navi"))
  this.result5(List("ruru","eueu"))
  this.result6(Set("gugu","huhu"))

  println("========== Recursive function ================")

  def factorial(n: Int): Int = {
    var res: Int = 0
    if (n == 1 || n == 0) {
      println(n + " * " + n + " = " + 1)
      return 1
    }

    println(n + " * " + (n - 1) + " = " + n * (n - 1))
    res += n * factorial(n - 1)
    return res
  }
  println("Recursive factorial result: " + factorial(4))

  def res(n:Int): Unit = {
    var res = 0;
    var nn = n

      while (nn > 0) {
           if(res == 0 )  {
             val l = n - 1
             res = nn * l
             nn = l - 1
           }
           else {
             res = res * nn
             nn = nn - 1
           }
    }
    println("Factorial normal: "+ res)
  }
  this.res(4)

  println("========== Named reusable function ================")

    val getRes = (a:Double, b:Double) => {
      println("calculating the values: ")
      a*b
    }
    println(this.getRes(30,10))

  println("========== Nested function ================")

  def out(): Int = {
      def in(): Int = {
        10
      }
    println("inner function result : "+ in())
    in() + 10
  }
  println("Final result : "+this.out())

  println("========== Higher Order function ================")

  def higherfun1(a: Double, b:String, c:(Double, String) => String ): String = {  //Pass function as parameter
    c(a,b)
  }

  val hres = this.higherfun1(10,"test", (a,b) => a + b)
  println("Higher 1: "+ hres)

  val hres2 = this.higherfun1(10,"test", (a,b) => a + b.toUpperCase())  // same function can be used for multiple operation.
  println("Higher 2: "+ hres2)

  val hres3 = this.higherfun1(10,"test", (a,b) => (a+10)+ b.toUpperCase())
  println("Higher 3: "+ hres3)

  val hres4 = this.higherfun1(10,"test", _ + _.toUpperCase )  //wildcard
  println("Higher 4: "+ hres4)

  val hres5 = this.higherfun1(10,"test", _.toString + _.toString )  //wildcard
  println("Higher 5: "+ hres5)

  //Example of high order function inbuilt map
  val ls = List(1,2,3)
  def doubleValue (a:Int) = a * a
  ls.map(x => x * x).foreach(a => println("Doubled value : "+ a))
  ls.map(x => doubleValue(x)).foreach(a => println("Doubled2 value : "+ a))   // takes fun as param

  val commFun  = (f: (Int, Int) => Int, a:Int, b:Int) => f(a,b)   //anonymous higher fun
  val doubleValue2 = (a:Int, b:Int) => a+a + b+b
  val squareSum = (a:Int, b:Int) => a*a + b*b
  println("Higher 6: "+ commFun(doubleValue2, 10,20))
  println("Higher 7: "+ commFun((a:Int, b:Int) => a*a + b*b, 2,3))

  val commFun2= (f:(Int,Int) => Unit, a:Int, b:Int) => f(a,b)  //fun returns void/unit
  val printAdd = (a:Int, b:Int) => println("Higher 8: "+ (a+b))
  commFun2(printAdd, 5,6)
//  commFun2((a,b) => println("Higher 8: "+ (a+b)), 5,6)

  val commFun3 = (f:(Set[Int], Int) => Set[Int], a:Set[Int], b:Int ) => f(a,b)
  def modiListFun (a: Set[Int], b:Int ): Set[Int] = {
    var addData = Set(0)
    a.foreach {aa:Int =>
      addData += aa+b
    }
    addData
  }
  println("Higher 9: "+ commFun3(modiListFun, Set(3,4,5), 1))
  println("Higher 10: "+ commFun3(modiListFun, Set(3,4,5), 2))


  println("========== Partially Function ================")

  def sumValue( a:Int, b:Int) : Int = a+b
  def getVal(): Int = 10

  val sumPart1 =  sumValue(10, _:Int) // pass wildcard, certain cases you may need to get the value from another function.
  val totalSum = sumPart1(getVal())
  println("Total value: "+ totalSum)

  def log (date:Date, message:String ): Unit = {
        println("Application Log: "+ date  +" Message : "+ message )
  }
  val appLog = log(new Date(), _:String)      // anything static data pass once the use it as a partially
  appLog("Message 1")
  appLog("Message 2")

  val mul = (a:Int, b:Int) => a*b //   partially doesn't work with anonymous fun

  def mulVal(a:Int, b:Int): Int = {
      a*b
  }
  val res = mulVal _
  println("Pass all : "+ res(10,20))

  val number = 25 + Random.nextInt(50)

  def validateGuess(lower:Int, guess:Int, higher:Int, message:String): Unit = {
    if(lower <= guess  && guess <= higher) println(message)
    else println(s"you lost it, number was: $number")
  }

  val stage1 = validateGuess(number-25,_:Int, number+25, "You won procced for stage2")
  val stage2 = validateGuess(number-15,_:Int, number+15, "You won procced for stage3")
  val stage3 = validateGuess(number-5,_:Int, number+5, s"You won procced for stage $number")

  stage1(30)
  stage2(40)
  stage3(50)

  println("========== Currying function ================")

  def addCurry1(a:Int)(b:Int) = a + b     //approach 1
  var curRes = addCurry1(10)(_)  //wildcard
  println("curr: "+ curRes(30))

  var curRes1 = addCurry1(10) _  //wildcard
  println("curr1: "+ curRes1(10))

  def addCurry2(a:Int) = (b:Int) => a*b   //approach 2
  val curRes2 = addCurry2(10)     //partially
  println("curr2:"+ curRes2(10))

  def addCurry3(s1:String)(s2:String)(s3:String) = s1+s2+s3
  val curRes3 = addCurry3("How ") _   //_ must follow method call only
  val curRes4 = curRes3("are ") ("You")
  println("Curry 3: "+ curRes4)

  val curRes5 = addCurry3("Lets ") (_:String) ("a call")
  val curRes6 = curRes5("have ")
  println("Curry 3.1 "+ curRes6)

  def add(x: Int, y: Int) = x + y
  val ck = (add _).isInstanceOf[Function2[_,_,_]]   //[p1,P2,r] checking whether function is instanceOf
  if(ck) println("compatible : "+ ck)
  else println("Not compatible")

  val addCurried = (add _).curried   //convert normal def to currying function
  val curRes7 =  addCurried(10)
  println("Curry 7 "+ curRes7(10))

  println("========== Tuples  ================")

  val tup1 = (1,"Navi",'A',true)
  println("Tuple1: "+ tup1 +" partition "+ tup1._1 +" "+tup1._2+" "+tup1._3+" "+tup1._4)

  val tup2 = new Tuple2(4,"twoParam")
  val tup3 = new Tuple3("threeParam", true, 6)
  val tup4 = new Tuple4("fourParam", 4, false, (4,"Comp"))
  println("Tuple2: "+ tup2 +" partition "+ tup2._1 +" "+tup2._2)
  println("Tuple3: "+ tup3 +" partition "+ tup3._1 +" "+tup3._2+" "+tup3._3)
  println("Tuple4: "+ tup4 +" partition "+ tup4._1 +" "+tup4._2+" "+tup4._3+" ( "+tup4._4._1 +" - "+tup4._4._2+")")

  println("Converting: "+ tup1.toString())

  tup1.productIterator.foreach{x => println(x)}

  var (a,b,c) = (34,"Navi",false)
  println(a + " " + b + " " + c)

  println("============= Patter Matching ==================")

  def ckVal(a:Int): Unit = {
    a match {
      case 10 => println("Value Found : "+ a)
      case 12 => println("Value Found : "+ a)
      case _ => println("Not Found: "+ a)
    }
  }
  ckVal(13)

  def matchSeries(v: Int): Unit = {
    v match {
      case 1 | 3 | 5 | 7 | 9 => println("found its Odd number")
      case 2 | 4 | 6 | 8 | 10 => println("found its even number")
      case _ => println("not found")
    }
  }
  matchSeries(9)

  case class Person(name: String, age: Int)

  def matPat(): Unit = {
    var p1 = new Person("Navaneet", 30)
    var p2 = new Person("Navi", 31)
    var p3 = new Person("Naviiii", 31)
    for (person <- List(p1, p2, p3)) {
      person match {
        case Person("Navaneet", 30) => println(s"Navaneet found")
        case Person("Navi", 31) => println("Navi Found")
        case Person(name, age) => println("Name: "+ name +" Age: "+age +" ??")
        case _ => println("NON Person found") // doesn't execute
      }
    }
  }
  matPat()

  def matchAny(v:Any): Unit = {
    v match {
      case true  => println("True")
      case 1  => println("1")
      case "test"  => println("Test")
      case 1.1  => println("1.1")
      case y:Int => println("Scala Int")
      case 1|3|5|7|9 => println("Odd numbers")
      case _ => println("Sorry not found")
    }
  }
  matchAny(5)

  def sequencesPatterMatching(sequence:Any): String = {

    sequence match {
      case 10 => s"I'm single value $sequence"
      case List(singleElement) => s"I'm single element $sequence"
      case List(_*) => s"I'm a list with one or multiple elements: $sequence"
      case Vector(1,2,_*) => s"I'm a vector: $sequence"
      case _ => s"I'm an unrecognized sequence. My value: $sequence"
    }
  }
  println("=====> " +sequencesPatterMatching(List(10)))
  println("=====> " +sequencesPatterMatching(List(10,20,30)))
  println("=====> " +sequencesPatterMatching(Vector(1,2,3,4,5)))
  println("=====> " +sequencesPatterMatching(10))
  println("=====> " +sequencesPatterMatching(false))


  def tuplesPatternMatching(tuple: Any): String = {
    tuple match {
      case (first, second) => s"I'm a tuple with two elements: $first & $second"
      case (first, second, third) => s"I'm a tuple with three elements: $first & $second & $third"
      case _ => s"Unrecognized pattern. My value: $tuple"
    }
  }
  println("=====>TuplesPat:  " +tuplesPatternMatching((1,2,3)))
  println("=====>TuplesPat:  " +tuplesPatternMatching((Tuple2("navi",33))))
  println("=====>TuplesPat:  " +tuplesPatternMatching((Tuple4("navi",33,44,66))))


  def regexPatterns(toMatch: String): String = {
    val numeric = """([0-9]+)""".r
    val alphabetic = """([a-zA-Z]+)""".r
    val alphanumeric = """([a-zA-Z0-9]+)""".r
    toMatch match {
      case numeric(value) => s"I'm a numeric with value $value"
      case alphabetic(value) => s"I'm an alphabetic with value $value"
      case alphanumeric(value) => s"I'm an alphanumeric with value $value"
      case _ => s"I contain other characters than alphanumerics. My value $toMatch"
    }
  }


  println("=====>regexPatterns:  " +regexPatterns("4454"))
  println("=====>regexPatterns:  " +regexPatterns("Navaneet"))
  println("=====>regexPatterns:  " +regexPatterns("4454testD565"))
  println("=====>regexPatterns:  " +regexPatterns("33,33,33"))

}




