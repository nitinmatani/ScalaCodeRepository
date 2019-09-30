object ImplicitClasses extends App {

//     Implicit classes make it possible to add new methods to previously defined classes.

// The String class has no method withoutVowels. This can be added like so:

  object StringUtil {
    implicit class StringEnhancer(str: String) {
      def withoutVowels: String = str.replaceAll("[aeiou]", "")
    }
  }

// The implicit class has a single constructor parameter (str) with the type that you would like to extend (String) and contains the method you would like to "add" to the type (withoutVowels). The newly defined methods can now be used directly on the enhanced type (when the enhanced type is in implicit scope):

  import StringUtil.StringEnhancer // Brings StringEnhancer into implicit scope

  println("Hello world".withoutVowels) // Hll wrld

// Under the hood, implicit classes define an implicit conversion from the enhanced type to the implicit class, like this:

  implicit def toStringEnhancer(str: String): StringEnhancer =
    new StringEnhancer(str)

// Implicit classes are often defined as Value classes to avoid creating runtime objects and thus removing the runtime overhead:

  implicit class StringEnhancer(val str: String) extends AnyVal {
    /* conversions code here */
  }

// With the above improved definition, a new instance of StringEnhancer doesn't need to be created every time the withoutVowels method gets invoked.
}
