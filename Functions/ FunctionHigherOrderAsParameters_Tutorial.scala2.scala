object FunctionHigherOrderAsParameters_Tutorial2 extends App {

  // A higher-order function, as opposed to a first-order function, can have one of three forms:

  // One or more of its parameters is a function, and it returns some value.

  // It returns a function, but none of its parameters is a function.

  // Both of the above: One or more of its parameters is a function, and it returns a function.

  object HOF {
    def main(args: Array[String]) {
      val list = List(
        ("Srini", "E"),
        ("Subash", "R"),
        ("Ranjith", "RK"),
        ("Vicky", "s"),
        ("Sudhar", "s")
      )
      //HOF
      val fullNameList = list.map(n => getFullName(n._1, n._2))

    }

    def getFullName(firstName: String, lastName: String): String =
      firstName + "." + lastName
  }

// Here the map function takes a getFullName(n._1,n._2) function as a parameter. This is called HOF (Higher order function).

}
