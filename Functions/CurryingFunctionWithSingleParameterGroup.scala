object CurryingFunctionWithSingleParameterGroup extends App {

  def minus(left: Int, right: Int) = left - right

  val numberMinus5 = minus(_: Int, 5)
  val fiveMinusNumber = minus(5, _: Int)

  numberMinus5(7) //  2
  fiveMinusNumber(7) // -2
}
