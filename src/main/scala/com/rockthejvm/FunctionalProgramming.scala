package com.rockthejvm

object FunctionalProgramming extends App {
    // Scala is Object an Object Oriented Language
    class Person(name: String) {
        def apply(age: Int) = println(s"I have age $age years")
    }

    val bob = new Person("Bob")
    bob.apply(43)
    bob(43) // INVOKING bob as a function === bob.apply(43)

    /* 
    Scala run on the JVM
    In function Programming:
        - Compose Functions
        - Pass functions as arguments
        - Return functions as results 
    
    Conclusion: FunctionX = Function1, Function2, ... Function22
    
    */

    val simpleIncrementer = new Function1[Int, Int] {
        override def apply(arg: Int): Int = arg + 1
    }

    simpleIncrementer.apply(23) // 24
    simpleIncrementer(23) // simpleIncrementer.apply(23)
    // Defined as a function!

    // ALL SCALA FUNCTIONS ARE INSTANCES OF THESE FUNCTION_X TYPES

    val stringConcatenator = new Function2[String, String, String] {
        override def apply(arg1: String, arg2: String): String = arg1 + arg2
    }

    stringConcatenator("I love ", "Scala")// "I love Scala"

    // syntax sugars
    val doubler: Function1[Int, Int] = (x: Int) => 2 * x
    doubler(4) // 8

    /* 
        new Function1[Int, Int] {
            override def apply(x: Int) = 2 * x
        }
     */

    // higher-order functions: Take functions as arguments or return functions as results
    val aMappedList = List(1,2,3).map(x => x + 1) // Higher order function
    println(aMappedList)
    val aFlatMappedList = List(1,2,3).flatMap(x => List(x, 2 * x)) // Seems to be a Lambda function will need clarification
    println(aFlatMappedList)
    val aFilteredList = List(1,2,3,4,5).filter(x => x <= 3) // Equivalent to (_ <= 3)
    println(aFilteredList)

    // all pairs between the numbers 1,2,3 and the letters 'a','b','c'
    val allPairs = List(1,2,3).flatMap(number => List('a','b','c').map(letter => s"$number-$letter"))
    println(allPairs)

    // for comprehensions
    val alternativePairs = for {
        number <- List(1,2,3)
        letter <- List('a','b','c')
    } yield s"$number-$letter"
    println(alternativePairs)
    //equivalent to the map/flatMap chain above

    /* 
    Collections:
    - Lists
  
    */
    // lists
    val aList = List(1,2,3,4,5)
    val firstElement = aList.head
    val rest = aList.tail
    val aPrependedList = 0 :: aList // List(0,1,2,3,4,5)
    val anExtendedList = 0 +: aList :+ 6 // List(0,1,2,3,4,5,6)

    //sequences
    val aSequence = Seq[Int](1,2,3) // Seq.apply(1,2,3)
    val accessedElement = aSequence(1) // the element at index 1 -> 2

    // vectors
    val aVector = Vector(1,2,3,4,5)

    // sets = no duplicates
    val aSet = Set(1,2,3,4,1,2,3) //set(1,2,3,4,)
    val setHas5 = aSet.contains(5)
    println(setHas5)
    val anAddedSet = aSet + 5 // set(1,2,3,4,5)
    val aRemovedSet = aSet - 3 // set(1,2,4)
    
    // ranges
    val aRange = 1 to 1000
    val twoByTwo = aRange.map(x => 2 * x).toList // List(2,4,6,8,...,2000)

    // Tuples = groups of values under the same value
    val aTuple = ("Bon Jovi", "Rock", 1983)

    // Maps
    val aPhonebook = Map[String, Int](
        ("Daniel", 49997067),
        ("Jane" -> 51184720)
    )

  
}
