object MatchingMultiplePatterns extends App {

  // The | can be used to have a single case statement match against multiple inputs to yield the same result:

  def f(str: String): String = str match {
    case "foo" | "bar" => "Matched!"
    case _             => "No match."
  }

  f("foo") // res0: String = Matched!
  f("bar") // res1: String = Matched!
  f("fubar") // res2: String = No match.

// Note that while matching values this way works well, the following matching of types will cause problems:

  sealed class FooBar
  case class Foo(s: String) extends FooBar
  case class Bar(s: String) extends FooBar

  val d = Foo("Diana")
  val h = Bar("Hadas")

// This matcher WILL NOT work.
  def matcher(g: FooBar): String = {
    g match {
      case Foo(s) | Bar(s) => print(s) // Won't work: s cannot be resolved
      case Foo(_) | Bar(_) => _ // Won't work: _ is an unbound placeholder
      case _               => "Could not match"
    }
  }

// If in the latter case (with _) you don't need the value of the unbound variable and just want to do something else, you're fine:

  def matcher(g: FooBar): String = {
    g match {
      case Foo(_) | Bar(_) => "Is either Foo or Bar." // Works fine
      case _               => "Could not match"
    }
  }

// Otherwise, you are left with splitting your cases:

  def matcher(g: FooBar): String = {
    g match {
      case Foo(s) => s
      case Bar(s) => s
      case _      => "Could not match"
    }
  }

}
