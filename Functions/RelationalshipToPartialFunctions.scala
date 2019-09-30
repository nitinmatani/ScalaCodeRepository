object RelationalshipToPartialFunctions extends App {

  trait PartialFunction[-A, +B] extends (A => B)

// Every single-argument PartialFunction is also a Function1. This is counter-intuitive in a formal mathematical sense, but better fits object oriented design. For this reason Function1 does not have to provide a constant true isDefinedAt method.

// To define a partial function (which is also a function), use the following syntax:

  { case i: Int => i + 1 } // or equivalently { case i: Int ⇒ i + 1 }

}
