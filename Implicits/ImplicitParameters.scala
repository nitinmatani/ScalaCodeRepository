object ImplicitParameters extends App {

  // Implicit parameters can be useful if a parameter of a type should be defined once in the scope and then applied to all functions that use a value of that type.

// A normal function call looks something like this:

// import the duration methods
  import scala.concurrent.duration._

// a normal method:
  def doLongRunningTask(timeout: FiniteDuration): Long = timeout.toMillis

  val timeout = 1.second
// timeout: scala.concurrent.duration.FiniteDuration = 1 second

// to call it
  doLongRunningTask(timeout) // 1000

// Now lets say we have some methods that all have a timeout duration, and we want to call all those methods using the same timeout. We can define timeout as an implicit variable.

// import the duration methods
  import scala.concurrent.duration._

// dummy methods that use the implicit parameter
  def doLongRunningTaskA()(implicit timeout: FiniteDuration): Long =
    timeout.toMillis
  def doLongRunningTaskB()(implicit timeout: FiniteDuration): Long =
    timeout.toMillis

// we define the value timeout as implicit
  implicit val timeout: FiniteDuration = 1.second

// we can now call the functions without passing the timeout parameter
  doLongRunningTaskA() // 1000
  doLongRunningTaskB() // 1000

// The way this works is that the scalac compiler looks for a value in the scope which is marked as implicit and whose type matches the one of the implicit parameter. If it finds one, it will apply it as the implicit parameter.

//     Note that this won't work if you define two or even more implicits of the same type in the scope.

// To customize the error message, use the implicitNotFound annotation on the type:

  @annotation.implicitNotFound(
    msg = "Select the proper implicit value for type M[${A}]!"
  )
  case class M[A](v: A) {}

  def usage[O](implicit x: M[O]): O = x.v

//Does not work because no implicit value is present for type `M[Int]`
//usage[Int]   //Select the proper implicit value for type M[Int]!
  implicit val first: M[Int] = M(1)
  usage[Int] //Works when `second` is not in scope
  implicit val second: M[Int] = M(2)
//Does not work because more than one implicit values are present for the type `M[Int]`
//usage[Int]   //Select the proper implicit value for type M[Int]!

// A timeout is a usual use case for this, or for example in Akka the ActorSystem is (most of the times) always the same, so it's usually passed implicitly. Another use case would be library design, most commonly with FP libraries that rely on typeclasses (like scalaz, cats or rapture).

//     It's generally considered bad practice to use implicit parameters with basic types like Int, Long, String etc. since it will create confusion and make the code less readable.

}
