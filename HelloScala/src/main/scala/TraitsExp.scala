trait Equal {
    def isEqual(x:Any) : Boolean
    def isNotEqual(x:Any): Boolean = {
      !isEqual(x)  // not equal
    }
}

class Poi(xc:Int, yc:Int) extends Equal {

  var x = xc
  var y = yc
  override def isEqual(obj: Any): Boolean = {
      obj.isInstanceOf[Poi] && obj.asInstanceOf[Poi].x == x
  }
}

object TraitsExp {
  def main(args: Array[String]): Unit = {
     var p1 = new Poi(2,3)
     var p2 = new Poi(2,4)
     var p3 = new Poi(3,3)

    println("1 - "+p1.isNotEqual(p2))
    println("2 - "+p1.isNotEqual(p1))
    println("3 - "+p1.isNotEqual(2))

  }
}
