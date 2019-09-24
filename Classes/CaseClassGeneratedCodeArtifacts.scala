object CaseClassGeneratedCodeArtifacts extends App {

//   The case modifier causes the Scala compiler to automatically
//   generate common boilerplate code for the class. Implementing this code manually is tedious and a source of errors. The following case class definition:

  case class Person(name: String, age: Int)

// ... will have the following code automatically generated:

  class Person(val name: String, val age: Int)
      extends Product
      with Serializable {
    def copy(name: String = this.name, age: Int = this.age): Person =
      new Person(name, age)

    def productArity: Int = 2

    def productElement(i: Int): Any = i match {
      case 0 => name
      case 1 => age
      case _ => throw new IndexOutOfBoundsException(i.toString)
    }

    def productIterator: Iterator[Any] =
      scala.runtime.ScalaRunTime.typedProductIterator(this)

    def productPrefix: String = "Person"

    def canEqual(obj: Any): Boolean = obj.isInstanceOf[Person]

    override def hashCode(): Int = scala.runtime.ScalaRunTime._hashCode(this)

    override def equals(obj: Any): Boolean = this.eq(obj) || obj match {
      case that: Person => this.name == that.name && this.age == that.age
      case _            => false
    }

    override def toString: String =
      scala.runtime.ScalaRunTime._toString(this)
  }

// The case modifier also generates a companion object:

  object Person
      extends AbstractFunction2[String, Int, Person]
      with Serializable {
    def apply(name: String, age: Int): Person = new Person(name, age)

    def unapply(p: Person): Option[(String, Int)] =
      if (p == null) None else Some((p.name, p.age))
  }

// When applied to an object, the case modifier has similar (albeit less dramatic) effects. Here the primary gains are a toString implementation and a hashCode value that is consistent across processes. Note that case objects (correctly) use reference equality:

  object Foo extends Product with Serializable {
    def productArity: Int = 0

    def productIterator: Iterator[Any] =
      scala.runtime.ScalaRunTime.typedProductIterator(this)

    def productElement(i: Int): Any =
      throw new IndexOutOfBoundsException(i.toString)

    def productPrefix: String = "Foo"

    def canEqual(obj: Any): Boolean = obj.isInstanceOf[this.type]

    override def hashCode(): Int = 70822 // "Foo".hashCode()

    override def toString: String = "Foo"
  }

// It is still possible to manually implement methods that would otherwise be provided by the case modifier in both the class itself and its companion object.

}
