package com.rockthejvm

object PatternMatching extends App {

    // switch "expression"
    val anInteger = 55
    val order = anInteger match {
        case 1 => "first"
        case 2 => "second"
        case 3 => "third"
        case _ => anInteger + "th"
    }  

    // Patter matching is an EXPRESSION

    println(order)

    case class Person(name: String, age: Int)
    val bob = Person("Bob", 43) // Person.apply("Bob", 43)

    val personGreeting = bob match {
        case Person(name, age) => s"Hi, my name is $name and I am $age years old."
    }
    
    println(personGreeting)

    // deconstructing tuples
    val aTuple = ("Bon Jovi", "Rock")
    val bandsDescription = aTuple match {
        case (band, genre) => s"$band belongs to the genre $genre"
        case _ => "I don't know what you're talking about"
    }
    
    println(bandsDescription)

    // decomposing lists
    val aList = List(1, 2, 3)
    val listDescription = aList match {
        case List(_, 2, _) => "List containing 2 on its second position"
        case _ => "unknown list"
    }
    
    println(listDescription)

    // If PM doesn't match anything, it will throw a MatchError
    // PM will try all cases in sequence if it is used backwards
    // PM is much more powerful than described here, we need to expand it


}

