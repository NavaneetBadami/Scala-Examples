abstract class Polygon {
  def area:Double = 0.0 // concert anonymous function
  def area2:Double      // non-concert abstract anonymous function
}

trait Shape {
  def color:String    //abstract
  def decs: String =" This is description"  //non-abstract
  def area2:Double
}

trait Shape2{
  def color:String    //abstract
  def volume: Double

}
