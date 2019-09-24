object ReduceTutorial extends App {

//     Example
// #

// The reduce(), reduceLeft() and reduceRight methods are similar to folds. The function passed to reduce takes two values and yields a third. When operating on a list, the first two values are the first two values in the list. The result of the function and the next value in the list are then re-applied to the function, yielding a new result. This new result is applied with the next value of the list and so on until there are no more elements. The final result is returned.

  val nums = List(1, 2, 3, 4, 5)
  sum = nums.reduce({ (a, b) =>
    a + b
  })
  println(sum) //prints 15

  val names = List("John", "Koby", "Josh", "Matilda", "Zac", "Mary Poppins")

  def findLongest(nameA: String, nameB: String): String = {
    if (nameA.length > nameB.length) nameA else nameB
  }

  def findLastAlphabetically(nameA: String, nameB: String): String = {
    if (nameA > nameB) nameA else nameB
  }

  val longestName: String = names.reduce(findLongest(_, _))
  println(longestName) //prints Mary Poppins

//You can also omit the arguments if you want
  val lastAlphabetically: String = names.reduce(findLastAlphabetically)
  println(lastAlphabetically) //prints Zac

// There are some differences in how the reduce functions work as compared to the fold functions. They are:

//     The reduce functions have no initial accumulator value.
//     Reduce functions cannot be called on empty lists.
//     Reduce functions can only return the type or supertype of the list.

}
