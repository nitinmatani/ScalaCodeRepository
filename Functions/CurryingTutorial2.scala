object CurryingTutorial2 extends App {

  def add: (Int, Int) => Int = (x, y) => x + y
  val three = add(1, 2)

//Currying add transforms it into a function that takes one Int and returns a function (from one Int to an Int)

  val addCurried: (Int) => (Int => Int) = add2.curried
//               ^~~ take *one* Int
//                        ^~~~ return a *function* from Int to Int

  val add1: Int => Int = addCurried(1)
  val three: Int = add1(2)
  val allInOneGo: Int = addCurried(1)(2)

//You can apply this concept to any function that takes multiple arguments. Currying a function that takes multiple arguments, transforms it into a series of applications of functions that take one argument:

  def add3: (Int, Int, Int) => Int = (a, b, c) => a + b + c
  def add3Curr: Int => (Int => (Int => Int)) = add3.curried

  val x = add3Curr(1)(2)(42)

}
