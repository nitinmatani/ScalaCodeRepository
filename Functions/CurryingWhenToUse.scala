object CurryingWhenToUse extends App {

//     Currying is the technique of translating the evaluation of a function that takes multiple arguments into evaluating a sequence of functions, each with a single argument.

// This is normally useful when for example:

//     different arguments of a function are calculated at different times. (Example 1)
//     different arguments of a function are calculated by different tiers of the application. (Example 2)

// Example 1

// Let's assume that the total yearly income is a function composed by the income and a bonus:

  val totalYearlyIncome: (Int, Int) => Int = (income, bonus) => income + bonus

// The curried version of the above 2-arity function is:

  val totalYearlyIncomeCurried: Int => Int => Int = totalYearlyIncome.curried

// Note in the above definition that the type can be also viewed/written as:

//Int => (Int => Int)

// Let's assume that the yearly income portion is known in advance:

  val partialTotalYearlyIncome: Int => Int = totalYearlyIncomeCurried(10000)

// And at some point down the line the bonus is known:

  partialTotalYearlyIncome(100)

// Example 2

// Let's assume that the car manufacturing involves the application of car wheels and car body:

  val carManufacturing: (String, String) => String = (wheels, body) =>
    wheels + body

// These parts are applied by different factories:

  class CarWheelsFactory {
    def applyCarWheels(
        carManufacturing: (String, String) => String
    ): String => String =
      carManufacturing.curried("applied wheels..")
  }

  class CarBodyFactory {
    def applyCarBody(partialCarWithWheels: String => String): String =
      partialCarWithWheels("applied car body..")
  }

// Notice that the CarWheelsFactory above curries the car manufacturing function and only applies the wheels.

// The car manufacturing process then will take the below form:

  val carWheelsFactory = new CarWheelsFactory()
  val carBodyFactory = new CarBodyFactory()

  val carManufacturing: (String, String) => String = (wheels, body) =>
    wheels + body

  val partialCarWheelsApplied: String => String =
    carWheelsFactory.applyCarWheels(carManufacturing)
  val carCompleted = carBodyFactory.applyCarBody(partialCarWheelsApplied)

}
