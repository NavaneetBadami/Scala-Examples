import java.io.{FileNotFoundException, FileReader, IOException}

import scala.util.{Failure, Success, Try}

object ExceptionDemo {
  def main(args: Array[String]): Unit = {

    demo1()
  //  println(demo2(2,-1))
    println(trySuccessSum(2,2))

    val result =  trySuccessSum(-2,2)
    result match {
      case Failure(exception) => println("Exception: "+ exception.toString)
      case Success(value) => println("Successful: "+ value)
     }
  }

  def demo1(): Unit = {
    try {
      val fileDate = new FileReader("input.txt")
      println("File Found : " + fileDate.getEncoding.toString)
    } catch {
      case ex: FileNotFoundException => println("FILE NOT FOUND EXCEPTION")
      case ex: IOException => println("IO EXCEPTION")
    } finally {
      println("finally block executed !!!")
    }
  }

  def demo2(a: Int, b:Int): Int = {
      var result =0
      if(a < 0 || b < 0) {
        throw new ArithmeticException("Numbers cannot be negative")
      } else {
          result = a +b
      }
      result
  }

  def trySuccessSum(a: Int, b:Int): Try[Int] = Try {    // using success/failure
    demo2(a,b)
  }

}
