trait Printabale extends Any {
  def print(): Unit ={
    println(this)
  }
}

class Wrapper (val underlying: Int) extends AnyVal with Printabale

object ValClassExp {
  def main(args: Array[String]): Unit = {

    var w = new Wrapper(3)
    w.print()
  }
}
