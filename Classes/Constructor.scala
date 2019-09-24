object Constructor extends App{

//    Primary Constructor
//#

//In Scala the primary constructor is the body of the class. The class name is followed by a parameter list, which are the constructor arguments. (As with any function, an empty parameter list may be omitted.)

class Foo(x: Int, y: String) {
    val xy: String = y * x
    /* now xy is a public member of the class */
}

class Bar {
    //...
}

//The construction parameters of an instance are not accessible outside its constructor body unless marked as an instance member by the val keyword:

class Baz(val z: String) 
// Baz has no other members or methods, so the body may be omitted

val foo = new Foo(4, "ab")
val baz = new Baz("I am a baz")
foo.x // will not compile: x is not a member of Foo
foo.xy // returns "abababab": xy is a member of Foo
baz.z // returns "I am a baz": z is a member of Baz
val bar0 = new Bar
val bar1 = new Bar() // Constructor parentheses are optional here

//Any operations that should be performed when an instance of an object is instantiated are written directly in the body of the class:

class DatabaseConnection
    (host: String, port: Int, username: String, password: String) {
    /* first connect to the DB, or throw an exception */
    private val driver = new AwesomeDB.Driver()
    driver.connect(host, port, username, password)
    def isConnected: Boolean = driver.isConnected
    ...
}

// Note that it is considered good practice to put as few side effects into the constructor as possible; instead of the above code, one should consider having connect and disconnect methods so that consumer code is responsible for scheduling IO.
// Auxiliary Constructors
// #

// A class may have additional constructors called 'auxiliary constructers'. These are defined by constructor definitions in the form def this(...) = e, where e must invoke another constructor:

class Person(val fullName: String) {    
  def this(firstName: String, lastName: String) = this(s"$firstName $lastName")
}

// usage:
new Person("Grace Hopper").fullName // returns Grace Hopper
new Person("Grace", "Hopper").fullName // returns Grace Hopper

//This implies each constructor can have a different modifier: only some may be available publicly:

class Person private(val fullName: String) {    
  def this(firstName: String, lastName: String) = this(s"$firstName $lastName")
}

new Person("Ada Lovelace") // won't compile
new Person("Ada", "Lovelace") // compiles

//In this way you can control how consumer code may instantiate the class.
}