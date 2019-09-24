object CaseClassesEquality extends App {

//With ordinary classes:

  class Foo(val i: Int)
  val a = new Foo(3)
  val b = new Foo(3)
  println(a == b) // "false" because they are different objects

//With case classes:

  case class Foo(i: Int)
  val a = Foo(3)
  val b = Foo(3)
  println(a == b) // "true" because their members have the same value

}
