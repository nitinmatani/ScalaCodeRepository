object CurryingTutorial3 extends App {

//     Currying, according to Wikipedia,

//     is the technique of translating the evaluation of a function that takes multiple arguments into evaluating a sequence of functions.

// Concretely, in terms of scala types, in the context of a function that take two arguments, (has arity 2) it is the conversion of

  val f: (A, B) => C // a function that takes two arguments of type `A` and `B` respectively
  // and returns a value of type `C`

  //to

  val curriedF: A => B => C // a function that take an argument of type `A`
  // and returns *a function*
  // that takes an argument of type `B` and returns a `C`

// So for arity-2 functions we can write the curry function as:

  def curry[A, B, C](f: (A, B) => C): A => B => C = { (a: A) => (b: B) =>
    f(a, b)
  }

// Usage:

  val f: (String, Int) => Double = { (_, _) =>
    1.0
  }
  val curriedF: String => Int => Double = curry(f)
  f("a", 1) // => 1.0
  curriedF("a")(1) // => 1.0

// Scala gives us a few language features that help with this:

//     You can write curried functions as methods. so curriedF can be written as:

  def curriedFAsAMethod(str: String)(int: Int): Double = 1.0
  val curriedF = curriedFAsAMethod _

  // You can un-curry (i.e. go from A => B => C to (A, B) => C) using a standard library method: Function.uncurried

  val f: (String, Int) => Double = Function.uncurried(curriedF)
  f("a", 1) // => 1.0

}
