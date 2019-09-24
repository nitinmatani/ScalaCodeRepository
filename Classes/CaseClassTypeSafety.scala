object CaseClassTypeSafety extends App {
  // In order to achieve type safety sometimes we want to avoid the use of primitive types on our domain. For instance, imagine a Person with a name. Typically, we would encode the name as a String. However, it would not be hard to mix a String representing a Person's name with a String representing an error message:

  def logError(message: ErrorMessage): Unit = ???
  case class Person(name: String)
  val maybeName: Either[String, String] = ??? // Left is error, Right is name
  maybeName.foreach(logError) // But that won't stop me from logging the name as an error!

// To avoid such pitfalls you can encode the data like this:

  case class PersonName(value: String)
  case class ErrorMessage(value: String)
  case class Person(name: PersonName)

// and now our code will not compile if we mix PersonName with ErrorMessage, or even an ordinary String.

  val maybeName: Either[ErrorMessage, PersonName] = ???
  maybeName.foreach(reportError) // ERROR: tried to pass PersonName; ErrorMessage expected
  maybeName.swap.foreach(reportError) // OK

// But this incurs a small runtime overhead as we now have to box/unbox Strings to/from their PersonName containers. In order to avoid this, one can make PersonName and ErrorMessage value classes:

  case class PersonName(val value: String) extends AnyVal
  case class ErrorMessage(val value: String) extends AnyVal

}
