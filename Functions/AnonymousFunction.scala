object AnonymousFunction extends App {

  // Anonymous functions are functions that are defined but not assigned a name.

  // The following is an anonymous function that takes in two integers and returns the sum.

  (x: Int, y: Int) => x + y

  //The resultant expression can be assigned to a val:

  val sum = (x: Int, y: Int) => x + y

  // Anonymous functions are primarily used as arguments to other functions. For instance, the map function on a collection expects another function as its argument:

  // Returns Seq("FOO", "BAR", "QUX")
  Seq("Foo", "Bar", "Qux").map((x: String) => x.toUpperCase)

  // The types of the arguments of the anonymous function can be omitted: the types are inferred automatically:

  Seq("Foo", "Bar", "Qux").map((x) => x.toUpperCase)

  //If there is just one argument, the parentheses around that argument can be omitted:

  Seq("Foo", "Bar", "Qux").map(x => x.toUpperCase)

  //Underscores shorthand

  //There is an even shorter syntax that doesn't require names for the arguments. The above snippet can be written:

  Seq("Foo", "Bar", "Qux").map(_.toUpperCase)

  //_ represents the anonymous function arguments positionally. With an anonymous function that has multiple parameters, each occurrence of _ will refer to a different argument. For instance, the two following expressions are equivalent:

  // Returns "FooBarQux" in both cases
  Seq("Foo", "Bar", "Qux").reduce((s1, s2) => s1 + s2)
  Seq("Foo", "Bar", "Qux").reduce(_ + _)

  //When using this shorthand, any argument represented by the positional _ can only be referenced a single time and in the same order.

  //Anonymous Functions with No Parameters

  //To create a value for an anonymous function that does not take parameters, leave the parameter list blank:

  val sayHello = () => println("hello")

}
