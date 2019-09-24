object CaseClassCopy extends App {

  // Case classes provide a copy method that creates a new object that shares the same fields as the old one, with certain changes.

  // We can use this feature to create a new object from a previous one that has some of the same characteristics. This simple case class to demonstrates this feature:

  case class Person(
      firstName: String,
      lastName: String,
      grade: String,
      subject: String
  )
  val putu = Person("Putu", "Kevin", "A1", "Math")
  val mark = putu.copy(firstName = "Ketut", lastName = "Mark")
  // mark: People = People(Ketut,Mark,A1,Math)

  //In this example we can see that the two objects share similar characteristics (grade = A1, subject = Math), except where they have been specified in the copy (firstName and lastName).

}
