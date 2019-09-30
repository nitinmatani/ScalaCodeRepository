object LazyEvaluationORFunctionByName extends App {

//     Scala supports lazy evaluation for function arguments using notation: def func(arg: => String). Such function argument might take regular String object or a higher order function with String return type. In second case, function argument would be evaluated on value access.

// Please see the example:

  def calculateData: String = {
    print("Calculating expensive data! ")
    "some expensive data"
  }

  def dumbMediator(preconditions: Boolean, data: String): Option[String] = {
    print("Applying mediator")
    preconditions match {
      case true  => Some(data)
      case false => None
    }
  }

  def smartMediator(preconditions: Boolean, data: => String): Option[String] = {
    print("Applying mediator")
    preconditions match {
      case true  => Some(data)
      case false => None
    }
  }

  smartMediator(preconditions = false, calculateData)

  dumbMediator(preconditions = false, calculateData)

// smartMediator call would return None value and print message "Applying mediator".

// dumbMediator call would return None value and print message "Calculating expensive data! Applying mediator".

// Lazy evaluation might be extremely useful when you want to optimize an overhead of expensive arguments calculation.
}
