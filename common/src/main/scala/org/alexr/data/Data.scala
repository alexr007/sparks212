package org.alexr.data

object Data {

  case class Person(id: Int, name: String)
  val ints = (1 to 10).map(Tuple1(_)).toVector
  val tuples = (1 to 10).map { n =>
    (n, s"<$n>", n.toDouble * 10.1)
  }
  val people = (1 to 3).map { n =>
    Person(n, s"Person $n")
  }.toVector

}
