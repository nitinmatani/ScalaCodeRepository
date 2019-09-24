object SingeltonAndCompanionObject extends App {

  class Factorial(num: Int) {

    def fact(num: Int): Int = if (num <= 1) 1 else (num * fact(num - 1))

    def calculate(): Int = {
      if (!Factorial.cache.contains(num)) { // num does not exists in cache
        val output = fact(num) // calculate factorial
        Factorial.cache += (num -> output) // add new value in cache
      }

      Factorial.cache(num)
    }
  }

  object Factorial {
    private val cache = scala.collection.mutable.Map[Int, Int]()
  }

  val factfive = new Factorial(5)
  factfive.calculate // Calculates the factorial of 5 and stores it
  factfive.calculate // uses cache this time
  val factfiveagain = new Factorial(5)
  factfiveagain.calculate // Also uses cache

//       In this example we are using a private cache to store factorial of a number to save calculation time for repeated numbers.

// Here object Factorial is a companion object and class Factorial is its corresponding companion class. Companion objects and classes can access each other's private members. In the example above Factorial class is accessing the private cache member of it's companion object.

// Note that a new instantiation of the class will still utilize the same companion object, so any modification to member variables of that object will carry over.
}
