object SealedTraitAndCaseObject extends App {

  // An alternative to extending Enumeration is using sealed case objects:

  sealed trait WeekDay

  object WeekDay {
    case object Mon extends WeekDay
    case object Tue extends WeekDay
    case object Wed extends WeekDay
    case object Thu extends WeekDay
    case object Fri extends WeekDay
    case object Sun extends WeekDay
    case object Sat extends WeekDay
  }

//The sealed keyword guarantees that the trait WeekDay cannot be extended in another file. This allows the compiler to make certain assumptions, including that all possible values of WeekDay are already enumerated.

//One drawback is that this method does not allow you to obtain a list of all possible values. To get such a list it must be provided explicitly:

  val allWeekDays = Seq(Mon, Tue, Wed, Thu, Fri, Sun, Sat)

//Case classes can also extend a sealed trait. Thus, objects and case classes can be mixed to create complex hierarchies:

  sealed trait CelestialBody

  object CelestialBody {
    case object Earth extends CelestialBody
    case object Sun extends CelestialBody
    case object Moon extends CelestialBody
    case class Asteroid(name: String) extends CelestialBody
  }

//Another drawback is that there is no way to access a the variable name of a sealed object's enumeration, or search by it. If you need some kind of name associated to each value, it must be manually defined:

  sealed trait WeekDay { val name: String }

  object WeekDay {
    case object Mon extends WeekDay { val name = "Monday" }
    case object Tue extends WeekDay { val name = "Tuesday" }
    //(...)
  }

//Or just:

  sealed case class WeekDay(name: String)

  object WeekDay {
    object Mon extends WeekDay("Monday")
    object Tue extends WeekDay("Tuesday")
    //(...)
  }

//   This is just an extension on the sealed trait variant where a macro generates a set with all instances at compile time. This nicely omits the drawback that a developer can add a value to the enumeration but forget to add it to the allElements set.

// This variant especially becomes handy for large enums.

  import EnumerationMacros._

  sealed trait WeekDay
  object WeekDay {
    case object Mon extends WeekDay
    case object Tue extends WeekDay
    case object Wed extends WeekDay
    case object Thu extends WeekDay
    case object Fri extends WeekDay
    case object Sun extends WeekDay
    case object Sat extends WeekDay
    val allWeekDays: Set[WeekDay] = sealedInstancesOf[WeekDay]
  }

// For this to work you need this macro:

  import scala.collection.immutable.TreeSet
  import scala.language.experimental.macros
  import scala.reflect.macros.blackbox

  /**
A macro to produce a TreeSet of all instances of a sealed trait.
Based on Travis Brown's work:
http://stackoverflow.com/questions/13671734/iteration-over-a-sealed-trait-in-scala
CAREFUL: !!! MUST be used at END OF code block containing the instances !!!
    */
  object EnumerationMacros {
    def sealedInstancesOf[A]: TreeSet[A] = macro sealedInstancesOf_impl[A]

    def sealedInstancesOf_impl[A: c.WeakTypeTag](c: blackbox.Context) = {
      import c.universe._

      val symbol = weakTypeOf[A].typeSymbol.asClass

      if (!symbol.isClass || !symbol.isSealed)
        c.abort(
          c.enclosingPosition,
          "Can only enumerate values of a sealed trait or class."
        )
      else {

        val children = symbol.knownDirectSubclasses.toList

        if (!children.forall(_.isModuleClass))
          c.abort(c.enclosingPosition, "All children must be objects.")
        else
          c.Expr[TreeSet[A]] {

            def sourceModuleRef(sym: Symbol) =
              Ident(
                sym
                  .asInstanceOf[scala.reflect.internal.Symbols#Symbol]
                  .sourceModule
                  .asInstanceOf[Symbol]
              )

            Apply(
              Select(
                reify(TreeSet).tree,
                TermName("apply")
              ),
              children.map(sourceModuleRef(_))
            )
          }
      }
    }
  }

}
