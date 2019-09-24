object Fold_Tutorial2 extends App {

  // The fold method iterates over a collection, using an initial accumulator value and applying a function that uses each element to update the accumulator successfully:

  val nums = List(1, 2, 3, 4, 5)
  var initialValue: Int = 0;
  var sum = nums.fold(initialValue) {
    (accumulator, currentElementBeingIterated) =>
      accumulator + currentElementBeingIterated
  }
  println(sum) //prints 15 because 0+1+2+3+4+5 = 15

// In the above example, an anonymous function was supplied to fold(). You can also use a named function that takes two arguments. Bearing this in my, the above example can be re-written thus:

  def sum(x: Int, y: Int): Int = x + y
  val nums = List(1, 2, 3, 4, 5)
  var initialValue: Int = 0
  val sum1 = nums.fold(initialValue)(sum)
  println(sum1) // prints 15 because 0 + 1 + 2 + 3 + 4 + 5 = 15

// Changing the initial value will affect the result:

  initialValue = 2;
  sum = nums.fold(initialValue) { (accumulator, currentElementBeingIterated) =>
    accumulator + currentElementBeingIterated
  }
  println(sum) //prints 17 because 2+1+2+3+4+5 = 17

// The fold method has two variants - foldLeft and foldRight.

// foldLeft() iterates from left to right (from the first element of the collection to the last in that order). foldRight() iterates from right to left (from the last element to the first element). fold() iterates from left to right like foldLeft(). In fact, fold() actually calls foldLeft() internally.

// def fold[A1 >: A](z: A1)(op: (A1, A1) => A1): A1 = foldLeft(z)(op)

// fold(), foldLeft() and foldRight() will return a value that has the same type with the initial value it takes. However, unlike foldLeft() and foldRight(), the initial value given to fold() can only be of the same type or a supertype of the type of the collection.

// In this example the order is not relevant, so you can change fold() to foldLeft() or foldRight() and the result will remain the same. Using a function that is sensitive to order will alter results.

// If in doubt, prefer foldLeft() over foldRight(). foldRight() is less performant.

}
