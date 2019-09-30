object ImplicitConversion extends App {

  // An implicit conversion allows the compiler to automatically convert an object of one type to another type. This allows the code to treat an object as an object of another type.

  case class Foo(i: Int)

// without the implicit
  Foo(40) + 2 // compilation-error (type mismatch)

// defines how to turn a Foo into an Int
  implicit def fooToInt(foo: Foo): Int = foo.i

// now the Foo is converted to Int automatically when needed
  Foo(40) + 2 // 42

// The conversion is one-way: in this case you cannot convert 42 back to Foo(42). To do so, a second implicit conversion must be defined:

  implicit def intToFoo(i: Int): Foo = Foo(i)

// Note that this is the mechanism by which a float value can be added to an integer value, for instance.

//     Implicit conversions should be used sparingly because they obfuscate what is happening. It is a best practice to use an explicit conversion via a method call unless there's a tangible readability gain from using an implicit conversion.

// There is no significant performance impact of implicit conversions.

// Scala automatically imports a variety of implicit conversions in scala.Predef, including all conversions from Java to Scala and back. These are included by default in any file compilation.
}
