object PartialFunctionsUsageAsTotalFunc extends App {

  // Partial functions are very common in idiomatic Scala. They are often used for their convenient case-based syntax to define total functions over traits:

  sealed trait SuperType // `sealed` modifier allows inheritance within current build-unit only
  case object A extends SuperType
  case object B extends SuperType
  case object C extends SuperType

  val input: Seq[SuperType] = Seq(A, B, C)

  input.map {
    case A => 5
    case _ => 10
  } // Seq(5, 10, 10)

// This saves the additional syntax of a match statement in a regular anonymous function. Compare:

  input.map { item =>
    item match {
      case A => 5
      case _ => 10
    }
  } // Seq(5, 10, 10)

// It is also frequently used to perform a parameter decomposition using pattern matching, when a tuple or a case class is passed to a function:

  val input = Seq("A" -> 1, "B" -> 2, "C" -> 3)

  input.map {
    case (a, i) =>
      a + i.toString
  } // Seq("A1", "B2", "C3")

}
