object MethodsAsFunctionValues extends App {

// The Scala compiler will automatically convert methods into function values for the purpose of passing them into higher-order functions.

  object MyObject {
    def mapMethod(input: Int): String = {
      int.toString
    }
  }

  Seq(1, 2, 3).map(MyObject.mapMethod) // Seq("1", "2", "3")

// In the example above, MyObject.mapMethod is not a function call, but instead is passed to map as a value. Indeed, map requires a function value passed to it, as can be seen in it's signature. The signature for the map of a List[A] (a list of objects of type A) is:

  def map[B](f: (A) ⇒ B): List[B]

// The f: (A) => B part indicates that the parameter to this method call is some function that takes an object of type A and returns an object of type B. A and B are arbitrarily defined. Returning to the first example, we can see that mapMethod takes an Int (which corresponds to A) and returns a String (which corresponds to B). Thus mapMethod is a valid function value to pass to map. We could rewrite the same code like this:

// Seq(1, 2, 3).map(x:Int => int.toString)

// This inlines the function value, which may add clarity for simple functions.

}
