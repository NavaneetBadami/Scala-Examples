
class Rectangle(var width:Double, var height: Double) extends Polygon with Shape with Shape2 {
  override def area:Double = width * height
  override def area2: Double = width * height //abstract method  //same impl to both abstract and trait class.

  /* override kw is optional for traits */
  override def color: String = "red"  // Trait class Shape and Shape2 property
  def volume: Double = 33.3  // Trait class only Shape2 property
}