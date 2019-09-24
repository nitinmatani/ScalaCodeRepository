// https://riptutorial.com/scala/example/9078/instance-type-checking

object InstanceTypeChecking extends App {

//    Type check: variable.isInstanceOf[Type]

//With pattern matching (not so useful in this form):

  variable match {
    case _: Type => true
    case _       => false
  }

//Both isInstanceOf and pattern matching are checking only the object's type, not its generic parameter (no type reification), except for arrays:

  val list: List[Any] = List(1, 2, 3) //> list  : List[Any] = List(1, 2, 3)

  val upcasting = list.isInstanceOf[Seq[Int]] //> upcasting  : Boolean = true

  val shouldBeFalse = list.isInstanceOf[List[String]]
  //> shouldBeFalse  : Boolean = true

  But

  val chSeqArray
      : Array[CharSequence] = Array("a") //> chSeqArray  : Array[CharSequence] = Array(a)
  val correctlyReified = chSeqArray.isInstanceOf[Array[String]]
  //> correctlyReified  : Boolean = false

  val stringIsACharSequence
      : CharSequence = "" //> stringIsACharSequence  : CharSequence = ""

  val sArray = Array("a") //> sArray  : Array[String] = Array(a)
  val correctlyReified = sArray.isInstanceOf[Array[String]]
  //> correctlyReified  : Boolean = true

//val arraysAreInvariantInScala: Array[CharSequence] = sArray
//Error: type mismatch;  found   : Array[String]  required: Array[CharSequence]
//Note: String <: CharSequence, but class Array is invariant in type T.
//You may wish to investigate a wildcard type such as `_ <: CharSequence`. (SLS 3.2.10)
//Workaround:
  val arraysAreInvariantInScala: Array[_ <: CharSequence] = sArray
  //> arraysAreInvariantInScala  : Array[_ <: CharSequence] = Array(a)

  val arraysAreCovariantOnJVM = sArray.isInstanceOf[Array[CharSequence]]
  //> arraysAreCovariantOnJVM  : Boolean = true

//Type casting: variable.asInstanceOf[Type]

//With pattern matching:

  variable match {
    case _: Type => true
  }

//Examples:

  val x = 3 //> x  : Int = 3
  x match {
    case _: Int => true //better: do something
    case _      => false
  } //> res0: Boolean = true

  x match {
    case _: java.lang.Integer => true //better: do something
    case _                    => false
  } //> res1: Boolean = true

  x.isInstanceOf[Int] //> res2: Boolean = true

  //x.isInstanceOf[java.lang.Integer]//fruitless type test: a value of type Int cannot also be a Integer

  trait Valuable { def value: Int }
  case class V(val value: Int) extends Valuable

  val y: Valuable = V(3) //> y  : Valuable = V(3)
  y.isInstanceOf[V] //> res3: Boolean = true
  y.asInstanceOf[V] //> res4: V = V(3)

//Remark: This is only about the behaviour on the JVM, on other platforms (JS, native) type casting/checking might behave differently.

}
