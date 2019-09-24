object CaseClassImmutability extends App{

    The Scala compiler prefixes every argument in the parameter list by default with val. This means that, by default, case classes are immutable. Each parameter is given an accessor method, but there are no mutator methods. For example:

case class Foo(i: Int)

val fooInstance = Foo(1)
val j = fooInstance.i       // get
fooInstance.i = 2           // compile-time exception (mutation: reassignment to val)

//Declaring a parameter in a case class as var overrides the default behavior and makes the case class mutable:

case class Bar(var i: Int)

val barInstance = Bar(1)
val j = barInstance.i       // get
barInstance.i = 2           // set

//Another instance when a case class is 'mutable' is when the value in the case class is mutable:

import scala.collection._

case class Bar(m: mutable.Map[Int, Int])

val barInstance = Bar(mutable.Map(1 -> 2))
barInstance.m.update(1, 3)                  // mutate m
barInstance                                 // Bar(Map(1 -> 3)

//Note that the 'mutation' that is occurring here is in the map that m points to, not to m itself. Thus, if some other object had m as a member, it would see the change as well. Note how in the following example changing instanceA also changes instanceB:

import scala.collection.mutable

case class Bar(m: mutable.Map[Int, Int])

val m = mutable.Map(1 ->2)
val barInstanceA = Bar(m)
val barInstanceB = Bar(m)
barInstanceA.m.update(1,3)
barInstanceA  // Bar = Bar(Map(1 -> 3))
barInstanceB  // Bar = Bar(Map(1 -> 3))
m  // scala.collection.mutable.Map[Int,Int] = Map(1 -> 3)



}