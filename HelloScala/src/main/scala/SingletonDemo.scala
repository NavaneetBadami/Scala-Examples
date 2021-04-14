//scala has no static method, fields, instead use object.

object BankaccNum {
  private var lastNum:Int = 0;    // stores updated value.
  def nextUniqueNum () = {
    lastNum+= 1;
    lastNum
  }
}

object SingletonDemo {
  def main(args: Array[String]): Unit = {
    println("The next val num: "+ BankaccNum.nextUniqueNum())
    println("The next val num: "+ BankaccNum.nextUniqueNum())
    println("The next val num: "+ BankaccNum.nextUniqueNum())
  }
}
