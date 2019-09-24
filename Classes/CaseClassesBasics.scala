object CaseClassesBasics extends App {
  case class Dog1(age: Int)
  val x = Dog1(18)
  println(x.age) // 18 (success!)

  class Dog2(age: Int)
  val x = new Dog2(18)
  println(x.age) // Error: "value age is not a member of Dog2"

  case class Dog(age: Int)
  val d1 = Dog(10)
  val d2 = d1.copy(age = 15)

  sealed trait Animal // `sealed` modifier allows inheritance within current build-unit only
  case class Dog(age: Int) extends Animal
  case class Cat(owner: String) extends Animal
  val x: Animal = Dog(18)
  x match {
    case Dog(x) => println(s"It's a $x years old dog.")
    case Cat(x) => println(s"This cat belongs to $x.")
  }
}
