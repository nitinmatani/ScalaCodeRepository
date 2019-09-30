object Composition_tutorial extends App{

    // Function composition allows for two functions to operate and be viewed as a single function. Expressed in mathematical terms, given a function f(x) and a function g(x), the function h(x) = f(g(x)).

    // When a function is compiled, it is compiled to a type related to Function1. Scala provides two methods in the Function1 implementation related to composition: andThen and compose. The compose method fits with the above mathematical definition like so:
    
    val f: B => C = ...
    val g: A => B = ...
    
    val h: A => C = f compose g
    
    // The andThen (think h(x) = g(f(x))) has a more 'DSL-like' feeling:
    
    val f: A => B = ...
    val g: B => C = ...
    
    val h: A => C = f andThen g
    
    // A new anonymous function is allocated with that is closed over f and g. This function is bound to the new function h in both cases.
    
    def andThen(g: B => C): A => C = new (A => C){
      def apply(x: A) = g(self(x))
    }
    
    // If either f or g works via a side-effect, then calling h will cause all side-effects of f and g to happen in the order. The same is true of any mutable state changes.


}