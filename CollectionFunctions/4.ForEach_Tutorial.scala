object ForEach_Tutorial extends App {

//foreach is unusual among the collections iterators in that it does not return a result. Instead it applies a function to each element that has only side effects. For example:

  val x = List(1, 2, 3)
  x.foreach { println }
// O/P
// 1
// 2
// 3

//The function supplied to foreach can have any return type, but the result will be discarded. Typically foreach is used when side effects are desirable. If you want to transform data consider using map, filter, a for comprehension, or another option.

//Example of discarding results

  val y = List(1, 2, 3, 4)
  def myFunc(a: Int): Int = a * 2
  y.foreach(myFunc) // Returns nothing

  var list = List(1, 8, 5, 6, 9, 58, 23, 15, 4)
//var list2=list.foreach((element:Int) => print(s"$element "))
  var list2 = list.foreach((element: Int) => myFunc(element))
// Iterating using foreach loop

}
