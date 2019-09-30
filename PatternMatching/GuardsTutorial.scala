object GuardsTutorial extends App {
  // Case statements can be combined with if expressions to provide extra logic when pattern matching.

  def checkSign(x: Int): String = {
    x match {
      case a if a < 0 => s"$a is a negative number"
      case b if b > 0 => s"$b is a positive number"
      case c          => s"$c neither positive nor negative"
    }
  }

// It is important to ensure your guards do not create a non-exhaustive match (the compiler often will not catch this):

  def f(x: Option[Int]) = x match {
    case Some(i) if i % 2 == 0 => doSomething(i)
    case None                  => doSomethingIfNone
  }

// This throws a MatchError on odd numbers. You must either account for all cases, or use a wildcard match case:

  def f(x: Option[Int]) = x match {
    case Some(i) if i % 2 == 0 => doSomething(i)
    case _                     => doSomethingIfNoneOrOdd
  }

}
