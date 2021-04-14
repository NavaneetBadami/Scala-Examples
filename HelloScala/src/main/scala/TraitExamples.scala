trait MyTrait1 {
  def pet
  def pet_color
  def pet_origin = () => println("Pet_origin: India")   //Non-Abstract methods.
}

trait MyTrait2 {
  def pet_age
}

trait MyTrait3 extends MyTrait1 with MyTrait2 {
  def pet_desc;
}

trait MyTrait4 {
  var pet_shop = "Navi_shop"    // can be overridden
  val pet_shop_addr = "Bijapur" // can be overridden
}

trait MyTrait5{
  def petBread(): String = "Imported"
}
trait MyTrait6{
  def petBread(): String  = "Local"
}

class TraitExample1 extends MyTrait1{

  override def pet(): Unit = println("Pet: Dog")
  override def pet_color(): Unit = println("Pet_color: White")
  //Class method
  def pet_name = () => println("Pet_name: Tonee")
}

class TraitExample2 extends MyTrait1 with MyTrait2 {

  override def pet(): Unit =  println("Pet: cat")               //MyTrait1
  override def pet_color(): Unit =  println("Pet_color: black") //MyTrait1
  override def pet_age(): Unit =  println("Pet_age: 1m")        //MyTrait2
}

class TraitExample3 extends MyTrait3 {

  override def pet(): Unit =  println("Pet: Bird")              //MyTrait1
  override def pet_color(): Unit =  println("Pet_color: green") //MyTrait1
  override def pet_age(): Unit =  println("Pet_age: 2m")        //MyTrait2
  override def pet_desc(): Unit = println("Pet_Desc: Sweet")    //MyTrait3
}

class TraitExample4 extends MyTrait4 {
    pet_shop = "New_new_Shop"
    override val pet_shop_addr = "Vijapur"  // for val value its mandatory to use override kw.
}

abstract class TraitExample5 extends MyTrait3 {
  override def pet(): Unit =  println("Pet: Fish")              //MyTrait1
  override def pet_color(): Unit =  println("Pet_color: Red")   //MyTrait1
  override def pet_age(): Unit =  println("Pet_age: 3m")        //MyTrait2
  override def pet_desc(): Unit = println("Pet_Desc: cute")     //MyTrait3
}

class TraitExample6(buy:String) extends MyTrait3 with MyTrait4 {

  override def pet(): Unit =  println("Pet: Cow")              //MyTrait1
  override def pet_color(): Unit =  println("Pet_color: Cream")   //MyTrait1
  override def pet_age(): Unit =  println("Pet_age: 1Y")        //MyTrait2
  override def pet_desc(): Unit = println("Pet_Desc: VeryCute")     //MyTrait3
  pet_shop = "New_new_Cow_Shop"
  override val pet_shop_addr = "Vijapura"
  def buyStatus = () => println(s"Buy_status: $buy "+"\nPet_shop: "+ pet_shop +"\nPet_shop_addr: "+ pet_shop_addr)

}

// Multiple Inheritance
class TraitExample7 extends MyTrait5 with MyTrait6 {
  //super.petBread()    // conflict
  //super[MyTrait5].petBread() // conflict
  //super[MyTrait6].petBread() // conflict

  //To solve conflict, get the implementation from both super traits.
  //override def petBread: Unit = println("pet_Bread: Confused...")   // own implementation
  //override def petBread(): String = super[MyTrait6].petBread()  // use super to call any specific trait
  override def petBread(): String = "From MyTrait5: "+ super[MyTrait5].petBread() +", From MyTrait5: "+ super[MyTrait6].petBread()

}


object RunTraits {
  def main(args: Array[String]): Unit = {

    println("============== TraitExample1 ==============")
    val obj = new TraitExample1
    obj.pet()
    obj.pet_color()
    obj.pet_name()
    obj.pet_origin()

    println("============== TraitExample2 ==============")
    val obj2 = new TraitExample2
    obj2.pet()
    obj2.pet_color()
    obj2.pet_origin()

    println("============== TraitExample3 ==============")
    val obj3 = new TraitExample3
    obj3.pet()
    obj3.pet_color()
    obj3.pet_origin()
    obj3.pet_desc()

    println("============== TraitExample4 ==============")
    val obj4 = new TraitExample4
    println("Pet_shop: "+ obj4.pet_shop)
    println("Pet_shop_addr: "+ obj4.pet_shop_addr)

    println("============== TraitExample5 ==============")
    val obj5 = new TraitExample5 {}
    obj5.pet()
    obj5.pet_color()
    obj5.pet_origin()
    obj5.pet_desc()

    println("============== TraitExample6 ==============")
    val obj6 = new TraitExample6("Yes")
    obj6.pet()
    obj6.pet_color()
    obj6.pet_origin()
    obj6.pet_desc()
    obj6.buyStatus()

    println("============== TraitExample7 ==============")
    val obj7 = new TraitExample1
    this.prco(obj7)

    println("============== TraitExample8 ==============")
    val obj8 = new TraitExample7
    println(obj8.petBread)

  }

  def prco(prcoObj: TraitExample1): Unit = {
    prcoObj.pet()
    prcoObj.pet_color()
    prcoObj.pet_name()
    prcoObj.pet_origin()
  }

}