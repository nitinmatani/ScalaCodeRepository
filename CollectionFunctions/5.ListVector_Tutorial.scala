object ListVector extends App {

  //It is now a best-practice to use Vector instead of List because the implementations have better performance Performance characteristics can be found here. Vector can be used wherever List is used.

// List creation

  List[Int]() // Declares an empty list of type Int
  List.empty[Int] // Uses `empty` method to declare empty list of type Int
  Nil // A list of type Nothing that explicitly has nothing in it

  List(1, 2, 3) // Declare a list with some elements
  1 :: 2 :: 3 :: Nil // Chaining element prepending to an empty list, in a LISP-style

// Take element

  List(1, 2, 3).headOption // Some(1)
  List(1, 2, 3).head // 1

  List(1, 2, 3).lastOption // Some(3)
  List(1, 2, 3).last // 3, complexity is O(n)

  List(1, 2, 3)(1) // 2, complexity is O(n)
  List(1, 2, 3)(3) // java.lang.IndexOutOfBoundsException: 4

// Prepend Elements

  0 :: List(1, 2, 3) // List(0, 1, 2, 3)

// Append Elements

  List(1, 2, 3) :+ 4 // List(1, 2, 3, 4), complexity is O(n)

// Join (Concatenate) Lists

  List(1, 2) ::: List(3, 4) // List(1, 2, 3, 4)
  List.concat(List(1, 2), List(3, 4)) // List(1, 2, 3, 4)
  List(1, 2) ++ List(3, 4) // List(1, 2, 3, 4)

// Common operations

  List(1, 2, 3).find(_ == 3) // Some(3)
  List(1, 2, 3).map(_ * 2) // List(2, 4, 6)
  List(1, 2, 3).filter(_ % 2 == 1) // List(1, 3)
  List(1, 2, 3).fold(0)((acc, i) => acc + i * i) // 1 * 1 + 2 * 2 + 3 * 3 = 14
  List(1, 2, 3).foldLeft("Foo")(_ + _.toString) // "Foo123"
  List(1, 2, 3).foldRight("Foo")(_ + _.toString) // "123Foo"

}
