/**
  * Created by Nadim Bahadoor on 28/06/2016.
  *
  *  Tutorial: Learn How To Use Aggregate Function
  *
  * [[http://allaboutscala.com/tutorials/chapter-8-beginner-tutorial-using-scala-collection-functions/scala-aggregate-function/ Tutorial]]
  *
  * Copyright 2016 Nadim Bahadoor (http://allaboutscala.com)
  *
  * Licensed under the Apache License, Version 2.0 (the "License"); you may not
  * use this file except in compliance with the License. You may obtain a copy of
  * the License at
  *
  *  [http://www.apache.org/licenses/LICENSE-2.0]
  *
  * Unless required by applicable law or agreed to in writing, software
  * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
  * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
  * License for the specific language governing permissions and limitations under
  * the License.
  */
object Aggregate_Tutorial extends App {

  println(
    "Step 1: How to initialize a Set of type String to represent Donut elements"
  )
  val donutBasket1: Set[String] = Set("Plain Donut", "Strawberry Donut")
  println(s"Elements of donutBasket1 = $donutBasket1")

  println(
    "\nStep 2: How to define an accumulator function to calculate the total length of the String elements"
  )
  val donutLengthAccumulator: (Int, String) => Int = (accumulator, donutName) =>
    accumulator + donutName.length

  println(
    "\nStep 3: How to call aggregate function with the accumulator function from Step 2"
  )
  val totalLength = donutBasket1.aggregate(0)(donutLengthAccumulator, _ + _)
  println(s"Total length of elements in donutBasket1 = $totalLength")

  println(
    "\nStep 4: How to initialize a Set of Tuple3 elements to represent Donut name, price and quantity"
  )
  val donutBasket2: Set[(String, Double, Int)] =
    Set(("Plain Donut", 1.50, 10), ("Strawberry Donut", 2.0, 10))
  println(s"Elements of donutBasket2 = $donutBasket2")

  println(
    "\nStep 5: How to define an accumulator function to calculate the total cost of Donuts"
  )
  val totalCostAccumulator: (Double, Double, Int) => Double =
    (accumulator, price, quantity) => accumulator + (price * quantity)

  println(
    "\nStep 6: How to call aggregate function with accumulator function from Step 5"
  )
  val totalCost = donutBasket2.aggregate(0.0)(
    (accumulator: Double, tuple: (String, Double, Int)) =>
      totalCostAccumulator(accumulator, tuple._2, tuple._3),
    _ + _
  )
  println(s"Total cost of donuts in donutBasket2 = $totalCost")
}
