object InstantiateClassWithNoParamenters extends App {
  // Let's say we have a class MyClass with no constructor argument:

  class MyClass

//In Scala we can instantiate it using below syntax:

  val obj = new MyClass()

//Or we can simply write:

  val obj = new MyClass

//But, if not paid attention, in some cases optional parenthesis may produce some unexpected behavior. Suppose we want to create a task that should run in a separate thread. Below is the sample code:

  val newThread = new Thread {
    new Runnable {
      override def run(): Unit = {
        // perform task
        println("Performing task.")
      }
    }
  }

  newThread.start // prints no output

//We may think that this sample code if executed will print Performing task., but to our surprise, it won't print anything. Let's see what's happening here. If you pay a closer look, we have used curly braces {}, right after new Thread. It created an annonymous class which extends Thread:

  val newThread = new Thread {
    //creating anonymous class extending Thread
  }

//And then in the body of this annonymous class, we defined our task (again creating an annonymous class implementing Runnable interface). So we might have thought that we used public Thread(Runnable target) constructor but in fact (by ignoring optional ()) we used public Thread() constructor with nothing defined in the body of run() method. To rectify the problem, we need to use parenthesis instead of curly braces.

  val newThread = new Thread(new Runnable {
    override def run(): Unit = {
      // perform task
      println("Performing task.")
    }
  })

//In other words, here {} and () are not interchangeable.
}
