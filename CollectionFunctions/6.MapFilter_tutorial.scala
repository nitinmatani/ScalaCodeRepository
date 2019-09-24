object MapFilter extends App{

    // Map

// 'Mapping' across a collection uses the map function to transform each element of that collection in a similar way. The general syntax is:

// val someFunction: (A) => (B) = ???
// collection.map(someFunction)

// You can provide an anonymous function:

collection.map((x: T) => /*Do something with x*/)

// Multiplying integer numbers by two
// #

// Initialize 
val list = List(1,2,3)
// list: List[Int] = List(1, 2, 3)

// Apply map
list.map((item: Int) => item*2)
// res0: List[Int] = List(2, 4, 6)

// Or in a more concise way
list.map(_*2)
// res1: List[Int] = List(2, 4, 6)

// Filter

// filter is used when you want to exclude or 'filter out' certain elements of a collection. As with map, the general syntax takes a function, but that function must return a Boolean:

val someFunction: (a) => Boolean = ???
collection.filter(someFunction)

// You can provide an anonymous function directly:

collection.filter((x: T) => /*Do something that returns a Boolean*/)

// Checking pair numbers
// #

val list = 1 to 10 toList
// list: List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

// Filter out all elements that aren't evenly divisible by 2
list.filter((item: Int) => item % 2==0)
// res0: List[Int] = List(2, 4, 6, 8, 10)

// More Map and Filter examples

case class Person(firstName: String,
                  lastName: String,
                  title: String)

// Make a sequence of people
val people = Seq(
  Person("Millie", "Fletcher", "Mrs"),
  Person("Jim", "White", "Mr"),
  Person("Jenny", "Ball", "Miss") )


// Make labels using map
val labels = people.map( person =>
  s"${person.title}. ${person.lastName}"
)

// Filter the elements beginning with J
val beginningWithJ = people.filter(_.firstName.startsWith("J"))

// Extract first names and concatenate to a string
val firstNames = people.map(_.firstName).reduce( (a, b) => a + "," + b )



// Note that this deals with the creation of a collection of type Map, which is distinct from the map method.

// Map Creation

Map[String, Int]() 
val m1: Map[String, Int] = Map()
val m2: String Map Int = Map()

// A map can be considered a collection of tuples for most operations, where the first element is the key and the second is the value.

val l = List(("a", 1), ("b", 2), ("c", 3))
val m = l.toMap                               // Map(a -> 1, b -> 2, c -> 3)

// Get element

val m = Map("a" -> 1, "b" -> 2, "c" -> 3)

m.get("a")  // Some(1)
m.get("d")  // None
m("a")      // 1
m("d")      // java.util.NoSuchElementException: key not found: d

m.keys      // Set(a, b, c)
m.values    // MapLike(1, 2, 3)

// Add element(s)

Map("a" -> 1, "b" -> 2) + ("c" -> 3)               // Map(a -> 1, b -> 2, c -> 3)
Map("a" -> 1, "b" -> 2) + ("a" -> 3)               // Map(a -> 3, b -> 2)
Map("a" -> 1, "b" -> 2) ++ Map("b" -> 3, "c" -> 4) // Map(a -> 1, b -> 3, c -> 4)

// Common operations

// In operations where an iteration over a map occurs (map, find, forEach, etc), the elements of the collection are tuples. The function parameter can either use the tuple accessors (_1, _2), or a partial function with a case block:

m.find(_._1 == "a")  // Some((a,1))
m.map {
  case (key, value) => (value, key)
}                    // Map(1 -> a, 2 -> b, 3 -> c)
m.filter(_._2 == 2)  // Map(b -> 2)
m.foldLeft(0){
  case (acc, (key, value: Int)) => acc + value
}                    // 6



}