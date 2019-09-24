object SortList extends App{


    // Supposing the following list we can sort a variety of ways.

val names = List("Kathryn", "Allie", "Beth", "Serin", "Alana")

// The default behavior of sorted() is to use math.Ordering, which for strings results in a lexographic sort:

names.sorted
// results in: List(Alana, Allie, Beth, Kathryn, Serin)

// sortWith allows you to provide your own ordering utilizing a comparison function:

names.sortWith(_.length < _.length)
// results in: List(Beth, Allie, Serin, Alana, Kathryn)

sortBy allows you to provide a transformation function:

//A set of vowels to use
val vowels = Set('a', 'e', 'i', 'o', 'u')

//A function that counts the vowels in a name
def countVowels(name: String) = name.count(l => vowels.contains(l.toLower))

//Sorts by the number of vowels
names.sortBy(countVowels)
//result is: List(Kathryn, Beth, Serin, Allie, Alana)

// You can always reverse a list, or a sorted list, using `reverse:

names.sorted.reverse
//results in: List(Serin, Kathryn, Beth, Allie, Alana)

// Lists can also be sorted using Java method java.util.Arrays.sort and its Scala wrapper scala.util.Sorting.quickSort

java.util.Arrays.sort(data)
scala.util.Sorting.quickSort(data)

}