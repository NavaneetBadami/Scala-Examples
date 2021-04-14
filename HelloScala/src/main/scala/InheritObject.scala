

class Point (var xc:Int, var yc: Int) {   //Primary constructor
  var x: Int = xc
  var y: Int = yc

  def displayPoint(): Unit ={
    println("X: "+x +" Y: "+y)
  }

  def move (dx: Int, dy:Int): Unit = {
    x+= dx
    y+= dy
    println("Updating X,Y with DX: "+dx +" and DY: "+ dy)
  }
}

//Subclass
class Location (var xcc:Int,  var ycc: Int, var zc: Int) extends Point(xcc , ycc) {
  var z: Int = zc

  def move (dx: Int, dy:Int, dz:Int): Unit = {
    move(dx,dy)   // base class fun
    z+= dz
  }

  def displayLoc(): Unit = {
    displayPoint()  // base class fun
    println("Z: "+z)
  }

}

object InheritObject {
  def main(args: Array[String]): Unit = {

    val loc = new Location(10,20,30)   // inherited class
    loc.displayLoc()
    loc.move(40,50,60)
    loc.displayLoc()
  }

}
