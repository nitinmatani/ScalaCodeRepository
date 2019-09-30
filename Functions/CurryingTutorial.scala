object CurryTutorial extends App {

  def multiply(factor: Int)(numberToBeMultiplied: Int): Int =
    factor * numberToBeMultiplied

  val multiplyBy3 = multiply(3) _ // resulting function signature Int => Int
  val multiplyBy10 = multiply(10) _ // resulting function signature Int => Int

  val sixFromCurriedCall = multiplyBy3(2) //6
  val sixFromFullCall = multiply(3)(2) //6

  val fortyFromCurriedCall = multiplyBy10(4) //40
  val fortyFromFullCall = multiply(10)(4) //40
}
