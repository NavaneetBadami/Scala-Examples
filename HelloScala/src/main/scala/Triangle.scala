
class Triangle (var width:Double, var height: Double) extends Polygon with Shape {
  override def area:Double = width * height / 2
  override def area2: Double = width * height / 2  //abstract method  //same impl to both abstract and trait class.

  override def color: String = "Green"  // Trait class Shape property
}
