object Fill_Tutorial extends App {

  // To create a collection of n copies of some object x, use the fill method. This example creates a List, but this can work with other collections for which fill makes sense:

// List.fill(n)(x)
  val a = List.fill(3)("Hello World")

//res0: List[String] = List(Hello World, Hello World, Hello World)
  println(a)
}
