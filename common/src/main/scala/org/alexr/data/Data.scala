package org.alexr.data

object Data {

  val names = Array("Jim", "Jeremy", "Jorge", "Alex", "Sergio")
  private val size = names.length
  val randomName = () => names((math.random * size).toInt)

  case class Person(id: Int, name: String, salary: Double)

  val ints = (1 to 10).map(Tuple1(_)).toVector
  val tuples = (1 to 10).map { n =>
    (n, s"<$n>", n.toDouble * 10.1)
  }
  val people = (1 to size).map { n =>
    Person(n, randomName(), math.random * 1000)
  }.toVector

}
