object PartialFunctionsWithMapFunc extends App {
  // These three map functions are equivalent, so use the variation that your team finds most readable.

  val numberNames = Map(1 -> "One", 2 -> "Two", 3 -> "Three")

  // 1. No extraction
  numberNames.map(it => s"${it._1} is written ${it._2}")

  // 2. Extraction within a normal function
  numberNames.map(it => {
    val (number, name) = it
    s"$number is written $name"
  })

  // 3. Extraction via a partial function (note the brackets in the parentheses)
  numberNames.map({ case (number, name) => s"$number is written $name" })

  // The partial function must match all input: any case which doesn't match will throw an exception at runtime.

}
