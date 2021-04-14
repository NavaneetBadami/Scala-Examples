//Classname and object name should same, both can access each other private members.

class Account(){
  val id = Account.newUiqueNum()
  private var bal:Double = 0.0
  def deposit (amount: Double): Unit ={
    bal += amount
  }
  def balEnq() = {
    id +" - "+ bal
  }
}

object Account {    //companion object

  private var lastNum = 0;
  private def newUiqueNum() = {
    lastNum += 1;
    lastNum
  }
}

 // not companion.
//class Account1(){
//  val id = Account.newUiqueNum()  //Compile time error
//  private var bal:Double = 0.0
//  def deposit (amount: Double): Unit ={
//    bal += amount
//  }
//  def balEnq() = {
//    id +" - "+ bal
//  }
//}

object CompanionObject {
  def main(args: Array[String]): Unit = {
    var accNum1 = new Account() // class
    println("Current Account no: "+ accNum1.id) //1
    accNum1.deposit(5000)
    println("Current Balance: "+ accNum1.balEnq())
    accNum1.deposit(5000)
    println("Current Balance: "+ accNum1.balEnq())

    var accNum2 = new Account() //class
    println("Current Account no: "+ accNum2.id)   // its new object should return 1 but it returns 2
    accNum2.deposit(3000)
    println("Current Balance: "+ accNum2.balEnq())
    accNum2.deposit(3000)
    println("Current Balance: "+ accNum2.balEnq())
  }
}
