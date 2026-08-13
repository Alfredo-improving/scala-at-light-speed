package com.rockthejvm

object ContextualAbstraction {

    /* 
        1 - Context Parameters and Arguments
     */

    val aList = List(1, 2, 3, 4)
    val anOrderedList = aList.sorted // (ordering)

    // Ordering
    given descendingOrdering: Ordering[Int] = Ordering.fromLessThan(_ > _) // (a,b) => a > b

    // analogous to an implicit val
    
    // monoid

    trait Combinator[A] { 
        def combine(x: A, y: A): A 
    } 

    def combineAll[A](list: List[A])(combinator: Combinator[A]): A = 
        list.reduce((a,b) => combinator.combine(a,b))

    
    given intCombinator: Combinator[Int] = new Combinator[Int] {
        override def combine(x: Int, y: Int) = x + y
    }
    val theSum = combineAll(aList) // (intCombinator)

    /* 
    Given places
    - local scope
    - imported scope
    - The Companions of all the types involved in the method call:
        - The companion of List
        - The companion of Int
    */

    // context bounds
    def combineAll_v2[A](ist: List[A])(using Combinator[A]): A = ???
    def combineAll_v3[A : Combinator](list: List[A]): A = ???

    /* 
    where context args are useful
    - type classes
    - dependency injection
    - context-dependent functionality
    - type-level programming
    
     */

    /* 
    2 - Extension methods
    */

    case class Person(name: String) {
        def greet(): String = s"Hi, my name is $name, I love Scala"
    }

    extension (string: String)
        def greet(): String = new Person(string).greet()

    // POWER

    extension [A] (list: List[A]) {
        def combineAllValues(using combinator: Combinator[A]): A =
            list.reduce(combinator.combine)
    }

    val theSum_v2 = aList.combineAllValues



    val danielsGreeting = "Daniel".greet() // Type enrichment = pimping


    def main(args: Array[String]): Unit = {
        println(anOrderedList)
        println(theSum)
        println("Alice".greet())
    }   
  
}
