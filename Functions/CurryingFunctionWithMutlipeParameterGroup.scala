object CurryingFunctionWithMutlipeParameterGroup extends App {
  def numberOrCharacterSwitch(
      toggleNumber: Boolean
  )(number: Int)(character: Char): String =
    if (toggleNumber) number.toString else character.toString

// need to explicitly specify the type of the parameter to be curried
// resulting function signature Boolean => String
  val switchBetween3AndE = numberOrCharacterSwitch(_: Boolean)(3)('E')

  switchBetween3AndE(true) // "3"
  switchBetween3AndE(false) // "E"
}
