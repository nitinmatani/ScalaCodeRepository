object Enumeration_tutorial1 extends App {

  object WeekDays extends Enumeration {
    val Mon, Tue, Wed, Thu, Fri, Sat, Sun = Value
  }

  def isWeekend(day: WeekDays.Value): Boolean = day match {
    case WeekDays.Sat | WeekDays.Sun => true
    case _                           => false
  }

  isWeekend(WeekDays.Sun)
  //res0: Boolean = true

  //It is also possible to add a human-readable name for values in an enumeration:

  object WeekDays extends Enumeration {
    val Mon = Value("Monday")
    val Tue = Value("Tuesday")
    val Wed = Value("Wednesday")
    val Thu = Value("Thursday")
    val Fri = Value("Friday")
    val Sat = Value("Saturday")
    val Sun = Value("Sunday")
  }

  println(WeekDays.Mon)
  // >> Monday

  WeekDays.withName("Monday") == WeekDays.Mon
  //>> res0: Boolean = true

  //Beware of the not-so-typesafe behavior, wherein different enumerations can evaluate as the same instance type:

  object Parity extends Enumeration {
    val Even, Odd = Value
  }

  WeekDays.Mon.isInstanceOf[Parity.Value]
  //>> res1: Boolean = true

}
