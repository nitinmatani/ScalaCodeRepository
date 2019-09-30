object PartialFunctionsWithCollectFunc extends App {

//     While partial function are often used as convenient syntax for total functions, by including a final wildcard match (case _), in some methods, their partiality is key. One very common example in idiomatic Scala is the collect method, defined in the Scala collections library. Here, partial functions allow the common functions of examining the elements of a collection to map and/or filter them to occur in one compact syntax.

// Example 1

// Assuming that we have a square root function defined as partial function:

  val sqRoot: PartialFunction[Double, Double] = {
    case n if n > 0 => math.sqrt(n)
  }

// We can invoke it with the collect combinator:

  List(-1.1, 2.2, 3.3, 0).collect(sqRoot)

// effectively performing the same operation as:

  List(-1.1, 2.2, 3.3, 0).filter(sqRoot.isDefinedAt).map(sqRoot)

// Example 2

  sealed trait SuperType // `sealed` modifier allows inheritance within current build-unit only
  case class A(value: Int) extends SuperType
  case class B(text: String) extends SuperType
  case object C extends SuperType

  val input: Seq[SuperType] = Seq(A(5), B("hello"), C, A(25), B(""))

  input.collect {
    case A(value) if value < 10   => value.toString
    case B(text) if text.nonEmpty => text
  } // Seq("5", "hello")

// There are several things to note in the example above:

//     The left-hand side of each pattern match effectively selects elements to process and include in the output. Any value that doesn't have a matching case is simply omitted.
//     The right-hand side defines the case-specific processing to apply.
//     Pattern matching binds variable for use in guard statements (the if clauses) and the right-hand side.

}
