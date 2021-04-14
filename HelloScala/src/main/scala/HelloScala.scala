import java.io.{File, PrintWriter}
import java.util.Date

import scala.collection.mutable.ArrayBuffer
import scala.io.Source
import scala.util.control.Breaks
import scala.util.matching.Regex.Match
import scala.util.matching
import scala.util.matching.Regex
object HelloScala {

  def main(args: Array[String]): Unit = {}

  Console.println("Jai sri Ram !!")
  println("============= String ==================")

  var num1 = 9
  var num2: Int = 9
  val num3 = 9
  var str1 = "Navaneet"
  var str2: String = "Navaneet"
  var num12: Int = num1 + num2
  num1 = 10; // Mutable
  // num3 = 10;   // error immutable
  println(num1, num2, num3, str1, str2, num12)

  //string interpolation
  var name = "Navaneet"
  var age = 30
  var salary: Float = 200.31f
  var ctc: Double = 210000.301
  val height = 1.9d

  //  10 * 4
  //  println("====> "+ res0)

  println(s"$name " + "is " + s"$age " + "year old" + "salary is " + f"$salary " + "pkg " + s"$ctc")
  println(s"$name is $age year old salary is $salary pkg $ctc")

  println(raw"Hello \nword")
  println("Hello \nword")
  println(f"$name%s is $height%2.2f meters tall") // James is 1.90 meters tall


  var res: String = if (age == 30) "age is 30" else "age is less then 30"
  println("Age status: " + res)

  println("=============Constructor==================")

  case class Student() {
    println(" ==> Default constructor:")
  }

  case class Student1(var num: Int, var name: String) {
    println(" ==> Param constructor:", num, name)
  }

  case class Student2(var num: Int = 10, var name: String = "DefualtName", var marks: Int = 11) {
    println(" ==> constructor with default value:", num, name, marks)
  }

  var s1: Student = Student()
  var s2: Student1 = Student1(10, "Navaneet")
  println("Before: " + s2.name)
  s2.name = "NavaneetUpdated"
  println("After: " + s2.name)
  var s3: Student2 = Student2(11, marks = 12)


  println("==============Auxiliray constructor =================")

  case class User(name: String, age: Int) {
    def this() {
      this("Navi", 55) // must call previous constructor like chaining
    }

    def this(name: String) {
      this(name, 32) // must call previous constructor
    }

    def this(add: String, location: String) {
      this()
      println("Address: " + add + "Location: " + location)
    }
  }

  var u1 = new User("COns1", 33)
  var u2 = new User()
  var u3 = new User("Consname")
  var u4 = new User("Karadi ", "pune")

  println(u1)
  println(u2)
  println(u3)
  println(u4)

  println("==============METHOD =================")

  case class Person(name: String, age: Int)

  case class Employee() {

    def main(args: Array[String]): Unit = {

    }

    def Show(): Unit = {
      println(" == Method")
    }

    def Show2(id: Int, name: String): Unit = {
      println(" == Method param ", id, name)
    }

    def Showdefaul(id: Int = 100, name: String = "default"): Unit = {
      println(" == Method default:  " + id, name)
    }


    def multiplyBy2(a: Int): Int = {
      a * 2
    }

    def squareNum(i: Int) = i * i

    def sumNo(data: Int*): Int = {
      var sum = 0
      for (a <- data) {
        sum += a
      }
      sum // return
    }

    println("=============Anonymous function==================")

    var result1 = (a: Int, b: Int) => a + b // Anonymous function by using => (rocket)
    var result2 = (_: Int) + (_: Int) // Anonymous function by using _ (underscore) wild card
    var result3 = (a: Int, b: Int) => println("A: " + a + " B:" + b)
    println("Result1: " + result1(10, 10))
    println("Result2: " + result2(10, 10))
    result3(30, 40)
    var result4 = (a: String) => println(a.map(a => a.toLower))
    result4("XYZ")
    var result5 = () => println("without param")
    result5()

    println("============= Pattern Matching ==================")

    def matchVal(id: Int): Unit = {
      id match {
        case 1 => println("Case 1")
        case 2 => println("Case 2")
        case _ => println("Not Found")
      }
    }

    def matchAnyVal(data: Any): Unit = {
      data match {
        case 1 => println("Integer")
        case "Navaneet" => println("String ")
        case true => println("Boolean")
        case y: Int => println("scala.Int")
        case _ => println("Not found!!")
      }
    }

    def matchSeries(v: Int): Unit = {
      v match {
        case 1 | 3 | 5 | 7 | 9 => println("found its Odd number")
        case 2 | 4 | 6 | 8 | 10 => println("found its even number")
        case _ => println("not found")
      }
    }

    def matPat(): Unit = {
      var p1 = new Person("Navaneet", 30)
      var p2 = new Person("Navi", 31)
      var p3 = new Person("Naviiii", 31)
      for (person <- List(p1, p2, p3)) {
        person match {
          case Person("Navaneet", 30) => println("Navaneet found")
          case Person("Navi", 31) => println("Navi Found")
          case Person(name, age) => println("Name: "+ name +" Age: "+age +" ??")
          case _ => println("NON Person found") // doesn't execute
        }
      }
    }
  }

  var e1: Employee = Employee()
  e1.Show()
  e1.Show2(44, "Navaneet")
  e1.Showdefaul()
  e1.matchVal(3)
  e1.matchAnyVal(1)
  e1.matchAnyVal("Navaneet")
  e1.matchAnyVal(true)
  e1.matchAnyVal(3)
  e1.matchSeries(7)
  e1.matPat()
  println(e1.squareNum(3))
  var res2: Int = e1.multiplyBy2(3)
  println("Multiple: " + res2)

  var sum: Int = e1.sumNo(1, 2, 3, 4, 5, 6, 7, 8, 9)
  println("SumOfNo: " + sum)


  println("=============FOR and FOREach==================")

  var numlist = List(3, 4, 1, 2, 5, 6)
  println("Num List :", numlist)

  for (n <- numlist) {
    println(n)
  }

  for (a <- 1 until 10) {
    println("Until: " + a) //1,2,3,4,5,6,7,8,9
  }

  for (a <- 1 to 10) {
    println("To: " + a) //1,2,3,4,5,6,7,8,9,10
  }

  for (a <- 1 to 10 if a % 2 == 0) {
    println("Even Number: " + a)
  }

  for (a <- 1 to 10 if a % 2 != 0) {
    println("Odd Number: " + a)
  }

  for (i <- 1 to 10 by 2) { //The by keyword is used to skip the iteration by 2
    println("By: " + i)
  }

  for (i <- 10 to 0 by -2) { //The by keyword is used to skip the iteration by 2
    println("By -2 : " + i)
  }

  for (i <- Array.range(1, 10)) {
    println("Range : " + i)
  }

  for (j <- Array.range(1, 10, 2)) {
    println("Range skip 2 : " + j)
  }

  for (i <- 1 to 9; j <- 1 to 3) // nested loop
    println("i: " + i + " j: " + j)

  var result = for (a <- 1 to 10) yield a //  yield keyword which returns a result after completing of loop iterations,The for use buffer internally to store iterated result
  for (i <- result) {
    println(i)
  }

  val retVal = for {a <- numlist if (a != 3) if (a < 7)} yield a // must yield, after whole operation results will be returned.
  println("Expression: " + retVal)

  println("== Lambda")

  numlist.foreach {
    println
  }

  numlist.foreach { i: Int => println(i) } // Explicitly mentioning type of elements

  println("============ Break ===================")

  var numlistB = List(1, 2, 3, 4, 5, 6, 7)
  var loop = new Breaks // Scala doesn't support break and continue instead we need use Breaks object.
  loop.breakable {
    for (a <- numlistB) {
      println("break : " + a)
      if (a == 4)
        loop.break()
    }
  }

  println("===> Nested loop break")
  var numlistC = List(11, 12, 13)
  var inner = new Breaks
  var outer = new Breaks
  outer.breakable {
    for (a <- numlistB) {
      println("The value A: " + a)
      inner.breakable {
        for (b <- numlistC) {
          println("The value b: " + b)
          if (b == 12)
            inner.break()
        }
      }
    }
  }

  println("============ LIST ===================")

  var rev = numlist.reverse
  println(" == Reverse: ", rev)
  rev.foreach { i: Int => println(i) }

  println(" == remove: ", numlist.drop(2)) // removes first two 3,4
  println(" == take:", numlist.take(2)) // takes only first two 3,4
  println(" == removetake: ", numlist.drop(2).take(2)) //removes first two 3,4 then take next two 1,2
  println(" == Slice: ", numlist.slice(2, 4)) //removes first two 3,4 then take next two 1,2

  var numMix = List(3, 2, true)
  numMix.foreach { i: AnyVal => println(" == anyVal: ", i) }

  case class Grad(rollNo: Int, name: String, marks: Int) {
    //println("RollNo :", rollNo, "Nama: ", name, "Marks: ", marks)
  }

  var gList = List(Grad(1, "User1", 35), Grad(2, "User2", 40), Grad(3, "User3", 50), Grad(4, "User4", 60))
  var gHead = gList.head
  println("First record: ", gHead)
  var gTail = gList.tail
  println("reverse -1 record: ", gTail)
  println(gList)
  println("Take: ", gTail.take(1)) // take/drop: , just perform the operation on retrieval.
  println(gTail)

  gList.head; // head/tail - It actually does the operation/modify  on list.
  println(gList)

  var topper = gList.filter(s => s.marks >= 60)
  println(" == Filter: ", topper)

  //Tuples:
  var parts = gList.partition(s => s.marks >= 60)
  println(" == parts: ", parts)
  println("Part1: ", parts._1)
  println("Part2: ", parts._2)
  //or
  val (part1, part2) = gList.partition(s => s.marks >= 60)
  println("Part1: ", part1)
  println("Part2: ", part2)

  var uniList = List.fill(5)("Navaneet") //List(Navaneet, Navaneet, Navaneet, Navaneet, Navaneet)
  println("Uniform List1: " + uniList)

  var uniList2 = List.fill(5)(3)
  println("Uniform List2: " + uniList2) //List(3, 3, 3, 3, 3)

  var tabulate1 = List.tabulate(6)(n => n * n) //0, 1, 4, 9, 16, 25)
  println("Tabulate Square: " + tabulate1)

  var tabulate2 = List.tabulate(4, 5)(_ * _) // List(List(0, 0, 0, 0, 0), List(0, 1, 2, 3, 4), List(0, 2, 4, 6, 8), List(0, 3, 6, 9, 12))
  println("Tabulate dim: " + tabulate2)
  /*(0, 0, 0, 0, 0)
    (0, 1, 2, 3, 4)
    (0, 2, 4, 6, 8)
    (0, 3, 6, 9, 12)*/


  println("==========MAP================")

  var mapData = Map(1 -> "value1", 2 -> "value2", 1 -> "value3", 3 -> true, 4 -> 55)
  println("Map: ", mapData)
  mapData.foreach { x => println("Key: ", x._1, " Value: ", x._2) }
  println("=====")
  mapData += (5 -> "Value4")
  mapData.foreach { x => println("Key: ", x._1, " Value: ", x._2) }
  println(" ====")
  mapData ++= Map(6 -> "value5", 7 -> "value6")
  mapData.foreach { x => println("Key: ", x._1, " Value: ", x._2) }

  println("Keys: " + mapData.keys)
  println("KeySet: " + mapData.keySet)
  println("Value: " + mapData.values)

  println(mapData(1))
  println(mapData(4))
  // println(mapData(8))  // Exception NoSuchElementException
  println(mapData.contains(8)) // false


  println("==========SET================")

  var setData = Set(1, 2, 3, 5, 5)
  println("SET: ", setData)
  setData.foreach { i: Int => println(i * i) }
  println(" ====")
  setData += 6 // add single element
  println(setData)
  setData ++= Set(7, 8, 9) //add list of elements
  println(setData)

  setData -= 3 // remove single element
  println(setData)
  setData --= List(5, 9) // remove single elements
  println(setData)

  println("==========================")

  var mySet = Set(100, 200, 300, 400)
  var mySetRes = mySet + 900
  println(mySetRes)

  var mySetRes2 = mySet + (900, 1000)
  println(mySetRes2)

  var mySetRes3 = mySet ++ List(1001, 1002)
  println(mySetRes3)

  var mySetRes4 = mySet -- List(1001, 1002)
  println(mySetRes4)

  var mySet2 = Set(2001, 2002, 2003, 2004)
  var mix = mySet ++ mySet2
  println("Merge: ", mix)

  println("==========SET OPERATION ================")

  var mySet3 = Set(100, 200, 300, 400)
  var mySet4 = Set(100, 600, 300, 500)

  var interset = mySet3.intersect(mySet4)
  println("Interset: ", interset)

  var union = mySet3.union(mySet4)
  println("Union: ", union)

  var diff = mySet3.diff(mySet4)
  println("diff: ", diff)

  var diff2 = mySet4.diff(mySet3)
  println("diff: ", diff2)

  println("==========Map, flatmap, flatten methods ================")

  var datalist = List(300, 500, 600, 200)
  datalist.map(x => x * x).foreach { I: Int => println(I) }

  datalist.filter(x => x >= 500).map(y => {
    println("==> " + y)
    y * y
  }).foreach { i: Int => println(i) }

  var nameLIst = Seq("Navi", "Navaneet")
  println("LowerCase: " + nameLIst.map(_.toLowerCase()))

  var flattenData = nameLIst.map(_.toLowerCase).flatten
  println("Flattendata => " + flattenData)
  println("Lists => " + List(List(1, 2, 3), List(4, 5, 6)))
  println("flatten Lists => " + List(List(1, 2, 3), List(4, 5, 6)).flatten) //combines all lists.

  var flatData = nameLIst.flatMap(_.toLowerCase)
  println("FlatData: " + flatData) //combination of map and flatten
  println("MapData ==> " + datalist.map(x => List(x, x + 1)))
  println("Flatdata ==> " + datalist.flatMap(x => List(x, x + 1)))

  var datalist2 = List(1, 2, 3, 4)
  println(" => ", datalist2.map(x => "Hi" * x))

  val myMapp = Map(1 -> "val1", 2 -> "val2", 3 -> "val3")
  println("myMapp KV => " + myMapp.map(x => x._1 + " " + x._2))
  println("myMapp values => ", myMapp.values.map(x => "val-" + x))

  println("========== objects class ================")

  object cal {
    def calval(a: Int, b: Int) = a + b

    def calSqa(a: Int) = a * a

    def +(a: Int, b: Int) = a + b

    def -(a: Int, b: Int) = a - b

    def *(a: Int, b: Int) = a * b

    def /(a: Int, b: Int) = a / b

  }

  var calval: Int = cal.calval(4, 6)
  println("Calvalue: " + calval)
  println("Square : " + cal.calSqa(3))
  println(cal.+(3, 4))
  println(cal.-(3, 4))
  println(cal.*(3, 4))
  println(cal./(10, 2))

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

  println("========== Named reusable function ================")

  val getRec = (l: Double, b: Double) => {
    println("calculating .. ");
    l * b
  }
  println("Named res fun: " + getRec(10, 20))

  println("========== Nested function ================")

  def out(): Unit = {
    println("------Outer --")

    def in(): Unit = {
      println("----inner")
    }

    in() // call outside
  }

  out()
  println("========== Higher Order function ================")

  object HigherOrder {
    def math(x: Double, y: Double, f: (Double, Double) => Double): Double = { //Pass function as parameter
      f(x, y)
    }

    def math2(x: Double, y: Double, z: Double, f: (Double, Double, Double) => Double): Double = {
      f(x, y, z)
    }

    //    def math3(x: Double, y: Double, z: Double, f:(Double,Double) => Double): Double = {
    //      f(f(x,y),z)
    //    }
  }

  var resAdd = HigherOrder.math(50, 20, (x, y) => (x + y)) // same function can be used for multiple operation.
  println("HigherOrder_ADD: " + resAdd)
  var resAdd1 = HigherOrder.math(50, 20, _ + _) // _ Using wildcard
  println("HigherOrder_ADD_WC: " + resAdd1)

  var resSub = HigherOrder.math(50, 20, (x, y) => (x - y))
  println("HigherOrder_SUB: " + resSub)
  var resSub1 = HigherOrder.math(50, 20, _ - _)
  println("HigherOrder_SUB_WC: " + resSub1)

  var resMin = HigherOrder.math(50, 20, (x, y) => x min (y))
  println("HigherOrder_MIN: " + resMin)
  var resMin1 = HigherOrder.math(50, 20, _ min _)
  println("HigherOrder_MIN_WC: " + resMin1)

  var res4 = HigherOrder.math2(10, 20, 30, (x, y, z) => x + y + z)
  println("HigherOrder_ADD3: " + res4)

  var res41 = HigherOrder.math2(10, 20, 30, _ + _ + _)
  println("HigherOrder_ADD3_WC: " + res41)

  var res5 = HigherOrder.math2(30, 20, 10, (x, y, z) => x min (y) min (z))
  println("HigherOrder_MIN3: " + res5)

  var res51 = HigherOrder.math2(30, 20, 10, _ min _ min _)
  println("HigherOrder_MIN3_WC: " + res51)


  println("========== Partially Function ================")

  def sumVal(a: Int, b: Int): Int = a + b

  def getVal(): Int = 30

  var sumPar = sumVal(10, _: Int) // Partially
  var totalVal = sumPar(getVal())
  println("Final value: " + totalVal)


  def log(date: Date, msg: String): Unit = {
    println("Log- Date: " + date + " Message: " + msg)
  }

  var newLog = log(new Date(), _: String) // Partially
  newLog("Message 1")
  newLog("Message 2")
  newLog("Message 3")


  def log(appName: String, mesg: String): Unit = {
    println("Log - Static AppName: " + appName + "  Dynamic Message: " + mesg)
  }

  var printLog = log("Static-Appname", _: String)
  printLog("Message1")
  printLog("Message2")
  printLog("Message3")
  printLog("Message4")


  println("========== Closures variables ================")

  var num = 10 //Declared outside the function.
  var add = (x: Int) => x + num

  def callMet() {
    num = 100 // takes latest value:
    println("Closer add: " + add(100))
  }

  callMet()
  val z = 5
  var total = (x: Int, y: Int) => (x + y) * z
  println(total(30, 20))

  //Imp
  val my_age = 30
  val pincode = 586102

  val hello_msg1 = (name: String) => println(s"My name is $name and age is $my_age")
  hello_msg1("navi")

  val hello_msg2 = (city: String) => println(s"My City is $city and pincode is $pincode")
  hello_msg2("Bijapur")

  //function takes function as parameter
  def function1(func: String => Unit, name: String): Unit = {
    func(name) // hello_msg("Navaneet") or  hello_msg1("Vijapur")
  }

  // same function1 can be used to call multiple functions as parameter
  function1(hello_msg1, "Navaneet")
  function1(hello_msg2, "VIjapur")

  val namesBuffer = ArrayBuffer("City 1", "City 2", "City 3")
  for (city <- namesBuffer) {
    function1(hello_msg2, city)
  }

  for (v <- 0 to 2) {
    function1(hello_msg2, namesBuffer(v))
  }

  println("========== Currying function ================")

  def addCurry(x: Int) = (y: Int) => x + y

  def addCurry2(x: Int)(y: Int) = x + y

  def CallCur() {
    println(addCurry(10)(20)) //30
    val sum40 = addCurry(40) // call only first param
    println(sum40(100)) //140

    val sum50 = addCurry2(50) _ // *
    println(sum50(100)) //150
  }

  CallCur()

  println("========== String format ================")
  var fn: Float = 100.10f
  var dn: Double = 100.10
  var str: String = "Hello max"

  println("%f -- %s".format(fn, str))
  printf("%f -- %f -- %s", fn, dn, str)


  println("========== Arrays  ================")

  var myArray1: Array[Int] = new Array[Int](5) // Type 1
  var myArray2 = new Array[Int](5) // Type 2
  var myArray3 = Array(1, 2, 3, 5, 6) // Type 3

  myArray1(0) = 1;
  myArray1(1) = 2;
  myArray1(2) = 3;
  myArray1(3) = 4;
  myArray1(4) = 5;
  //  myArray1(5) = 6;   // IOB exception
  for (x <- myArray1) {
    println("Array1: " + x)
  }

  myArray2(0) = 1;
  myArray2(1) = 2;
  myArray2(2) = 3;
  myArray2(3) = 4;
  myArray2(4) = 5;
  for (x <- myArray2) {
    println("Array2: " + x)
  }

  for (x <- myArray3) {
    println("Array3: " + x)
  }

  val conRes = Array.concat(myArray1, myArray2)
  println("==== concat array ==")
  conRes.foreach { x: Int => println(x) }

  var arrRang = Range(2, 15)
  println("Array Range 2-15: " + arrRang.toList) //List(2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14)

  var arrRang2 = Range(15, 2, -2)
  println("Array Range rev 15-2 -2: " + arrRang2.toList) //List(15, 13, 11, 9, 7, 5, 3)


  println("========== Tuples  ================")
  // Immutable

  val myTuple1 = (1, 2, "Navi", true) //approach 1
  val myTuple2 = new Tuple3(1, 2, "Navi")
  val myTuple3 = new Tuple4(1, 2, "Navi", true) // up to 22 elements we are store in tuples
  val myTuple4 = new Tuple4(1, 2, "Navi", (2, 3)) // tuple inside

  println("Tuple1: " + myTuple1 + " single values: " + myTuple1._1, myTuple1._2, myTuple1._3, myTuple1._4)
  println("Tuple2: " + myTuple2 + " single values: " + myTuple2._1, myTuple2._2, myTuple2._3)
  println("Tuple4: " + myTuple4 + " single values: " + myTuple4._1, myTuple4._2, myTuple4._3, myTuple4._4._1, myTuple4._4._2)

  myTuple1.productIterator.foreach { x => println(x) }
  println("Using toString: " + myTuple2.toString())

  println("========== options Some or None  ================")

  val oList = List(1, 2, 3, 4)
  println("Find: " + oList.find(_ > 3)) //some(4)
  println("Find: " + oList.find(_ > 4)) //none
  println("Find: " + oList.find(_ > 3).get) //4
  println("Find: " + oList.find(_ > 4).getOrElse(0)) //0
  println("Find: " + oList.find(_ > 4).getOrElse("Not found")) //Not found

  println("========== Reduce, fold, Scan  ================")

  val rList = List(1, 2, 3, 4, 5)
  val rList2 = List("A", "B", "C")

  /*  Reduce  */
  println("ReducedLeft => " + rList.reduceLeft(_ + _)) //15 sum of all from left --> right
  println(rList.reduceLeft((x, y) => {
    println(x + " + " + y)
    x + y
  }))

  println("ReducedLeft => " + rList.reduceLeft(_ - _)) // -13
  println(rList.reduceLeft((x, y) => {
    println(x + " - " + y)
    x - y
  }))

  println("ReducedRight => " + rList.reduceRight(_ - _)) //3
  println(rList.reduceRight((x, y) => {
    println(x + " - " + y)
    x - y
  }))

  println("ReducedLeft => " + rList2.reduceLeft(_ + _)) //ABC
  println(rList2.reduceLeft((x, y) => {
    println(x + " + " + y)
    x + y
  }))

  println("ReducedRight => " + rList2.reduceRight(_ + _)) //ABC
  println(rList2.reduceRight((x, y) => {
    println(x + " + " + y)
    x + y
  }))

  /*  Fold  we can specify the position */
  println("FoldLeft => " + rList.foldLeft(1)(_ + _)) //16 sum of all from left --> right start from 1
  println(rList.foldLeft(1)((x, y) => {
    println(x + " + " + y)
    x + y
  }))

  println("FoldLeft => " + rList.foldLeft(100)(_ + _)) //115 sum of all from left --> right start from 100
  println(rList.foldLeft(100)((x, y) => {
    println(x + " + " + y)
    x + y
  }))

  println("FoldLeft => " + rList2.foldLeft("N")(_ + _)) //NABC sum of all from left --> right start from N
  println(rList2.foldLeft("N")((x, y) => {
    println(x + " + " + y)
    x + y
  }))

  /*  SCAN  - returns list */

  println("ScanLeft => " + rList.scanLeft(100)(_ + _)) //115 sum of all from left --> right start from 100
  println(rList.scanLeft(100)((x, y) => {
    println(x + " + " + y)
    x + y
  }))

  println("ScanLeft => " + rList2.scanLeft("N")(_ + _)) //NABC sum of all from left --> right start from N
  println(rList2.scanLeft("N")((x, y) => {
    println(x + " + " + y)
    x + y
  }))

  println("========== Inheritance example =======")

  // var poly = new Polygon   //cannot create the object of abstract class
  var rectangle = new Rectangle(55.5, 22.2)
  var triangle = new Triangle(55.5, 22.2)
  // this.printArea(poly)
  this.printArea(rectangle)
  this.printArea(triangle)

  def printArea(p: Polygon): Unit = {
    println("Object: " + p.getClass.getName + " Area: " + p.area)
    println("Object: " + p.getClass.getName + " Area: " + p.area2)
  }

  println("========== Lazy Evaluation example =======")

  /* value will not be evaluated until its called  */

  case class StrictExp() {
    val e = {
      println("Strict");
      9
    }
  }

  case class LazyEval() {
    lazy val e = {
      println("Lazy");
      9
    } // wont be called until it called
  }

  val st = new StrictExp
  val le = new LazyEval
  le.e // call here

  /* Example 2  */
  def evalMethod1(n: Int): Unit = {
    println("evalMethod1")
    println(n)
  }

  def evalMethod2(n: => Int): Unit = { // named parameter
    println("evalMethod2") //1
    println(n) //3
  }

  val addeval = (a: Int, b: Int) => {
    println("ADD") //2
    a + b
  }

  this.evalMethod1(addeval(5, 6))
  this.evalMethod2(addeval(5, 6)) // check the o/p sequence

  println("========== Traits example =======")

  var rectangleTrait = new Rectangle(55.5, 22.2)
  var triangleTrait = new Triangle(55.5, 22.2)
  this.printArea(rectangleTrait)
  println(rectangleTrait.color) //Traits function, but its not PRCO
  println(rectangleTrait.volume)

  this.printArea(triangleTrait)
  println(triangleTrait.color) //Traits function, but its not PRCO

  def printAreaTrait(p: Polygon): Unit = {
    println("Object: " + p.getClass.getName + " Area: " + p.area)
    println("Object: " + p.getClass.getName + " Area: " + p.area2)
  }

  println("========== Expression and Nested expression block =======")

  val myArea1 = {
    val pi = 3.14
    pi * 10
  }
  println("Expression val: " + myArea1)

  val myArea2 = {
    val pi = 2
    println("Outer expression block " + pi)
    pi * 10; // semicolon must for inner block
    {
      val pi = 3
      println("inner expression block " + pi)
      pi * 10 // always return inner value
    }
  }
  println("Nested Expression val: " + myArea2)

  println("========== simple class flow =======")

  case class classOne(var name: String, var age: Int) {

    println("Call 1: This will be called FIRST when class will be loaded")

    def this(name: String) { //auxiliary constructor
      this(name, 40)
      println("This is auxiliary cons")
    }

    def displayValue(): Unit = {
      println("Call 3: Name:" + name + " Age: " + age)
    }

    println("Call 2: This will be called SECOND when class will be loaded")
  }

  val obj1 = classOne("Navaneet", 30)
  obj1.displayValue()

  val obj2 = new classOne("Navi") //new KW is must for auxiliary constructor
  obj2.displayValue()


  println("========== String example =======")
  var (xx: Int, yy: Int, zz: Int) = (33, 22, 21)
  printf("X: %d, Y: %d, Z: %d \n", xx, yy, zz)
  printf(s"X: $xx, Y: $yy, Z: $zz \n")
  printf(f"X =$xx%4d, Y =$yy%6d, Z= $zz%5d \n") //%4d means 4 whitespace


  println("========== collections example =======")
  scala.collection.immutable.List // only immutable
  scala.collection.immutable.Set
  scala.collection.mutable.Set
  scala.collection.immutable.Map
  scala.collection.mutable.Map
  scala.collection.immutable.Seq
  scala.collection.mutable.Seq
  scala.collection.immutable.SortedMap
  scala.collection.mutable.SortedMap

  println("========== Regex example =======")
  
  var pattern = "Scala".r   //r means regex
  var strMsg = "Scala is scalable and cool"
  println("Reg: "+ pattern.findFirstIn(strMsg))

  var pattern2= new Regex("(S|s)cala")
  println("Reg: "+ pattern2.findAllIn(strMsg).mkString(","))

  println("Reg: "+ pattern2.replaceFirstIn(strMsg,"java"))
  println("Reg: "+ pattern2.replaceAllIn(strMsg,"java"))


  println("========== Command console example =======")
  println("Enter the number: ")
  val x = Console
  println("Please verify: "+x)

  println("========== File read write =======")
  Source.fromFile("input.txt").getLines().next().foreach(v => print(v))

  val writer = new PrintWriter(new File("input.txt"))
  writer.write("Its done")
  writer.close()


}




