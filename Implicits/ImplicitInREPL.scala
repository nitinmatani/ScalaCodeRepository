// To view all the implicits in-scope during a REPL session:

// scala> :implicits

// To also include implicit conversions defined in Predef.scala:

// scala> :implicits -v

// If one has an expression and wishes to view the effect of all rewrite rules that apply to it (including implicits):

// scala> reflect.runtime.universe.reify(expr) // No quotes. reify is a macro operating directly on code.

// (Example:

// scala> import reflect.runtime.universe._
// scala> reify(Array("Alice", "Bob", "Eve").mkString(", "))
// resX: Expr[String] = Expr[String](Predef.refArrayOps(Array.apply("Alice", "Bob", "Eve")(Predef.implicitly)).mkString(", "))

//Resolving Implicit Parameters Using 'implicitly'

// Assuming an implicit parameter list with more than one implicit parameter:

case class Example(p1: String, p2: String)(
    implicit ctx1: SomeCtx1,
    ctx2: SomeCtx2
)

// Now, assuming that one of the implicit instances is not available (SomeCtx1) while all other implicit instances needed are in-scope, to create an instance of the class an instance of SomeCtx1 must be provided.

// This can be done while preserving each other in-scope implicit instance using the implicitly keyword:

//Example("something","somethingElse")(new SomeCtx1(), implicitly[SomeCtx2])
