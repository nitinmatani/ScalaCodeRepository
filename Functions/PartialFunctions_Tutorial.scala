object PartialFunctions_Tutorial extends App {

// Scala has a special type of function called a partial function, which extends normal functions -- meaning that a PartialFunction instance can be used wherever Function1 is expected. Partial functions can be defined anonymously using case syntax also used in pattern matching:

  val pf: PartialFunction[Boolean, Int] = {
    case true => 7
  }

  pf.isDefinedAt(true) // returns true
  pf(true) // returns 7

  pf.isDefinedAt(false) // returns false
  pf(false) // throws scala.MatchError: false (of class java.lang.Boolean)

// As seen in the example, a partial function need not be defined over the whole domain of its first parameter. A standard Function1 instance is assumed to be total, meaning that it is defined for every possible argument

// Partial functions are often used to define a total function in parts:

  sealed trait SuperType
  case object A extends SuperType
  case object B extends SuperType
  case object C extends SuperType

  val pfA: PartialFunction[SuperType, Int] = {
    case A => 5
  }

  val pfB: PartialFunction[SuperType, Int] = {
    case B => 10
  }

  val input: Seq[SuperType] = Seq(A, B, C)

  input.map(pfA orElse pfB orElse {
    case _ => 15
  }) // Seq(5, 10, 15)

// In this usage, the partial functions are attempted in order of concatenation with the orElse method. Typically, a final partial function is provided that matches all remaining cases. Collectively, the combination of these functions acts as a total function.

// This pattern is typically used to separate concerns where a function may effectively act a dispatcher for disparate code paths. This is common, for example, in the receive method of an Akka Actor.
}
