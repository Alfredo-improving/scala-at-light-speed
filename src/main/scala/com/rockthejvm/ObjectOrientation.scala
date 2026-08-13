package com.rockthejvm

object ObjectOrientation extends App {

    // java equivalent: public static void main(String[] args) {
    // }

    // Class and instance creation

    class Animal {
        // defin fields
        val age: Int = 0
        // define methods
        def eat() = println("I'm eating")
    }

    val anAnimal = new Animal

    // inheritance
    class Dog(val name: String) extends Animal // constructgor definition
    val aDog = new Dog("Lassie")

    // constructor arguments are NOT fields: need to put a al before the constructor argument
    aDog.name

    // subtype polymorphism
    val aDeclaredAnimal: Animal = new Dog("Hachi")
    aDeclaredAnimal.eat() // the most derived method will be called at runtime

    // abstract class
    abstract class walkingAnimal {
        protected val hasLegs = true  // by default public, can restrict by using private or protected
        def walk(): Unit
    }

    // "Interface" = ultimate abstract type
    trait Carnivore {
        def eat(animal: Animal): Unit   
    }

    trait Philosopher {
        def ?! (thought: String): Unit
    }

    // single-class inheritance, multi-trait "mixing"
    class Crocodile extends Animal with Carnivore with Philosopher {
        override def eat(animal: Animal): Unit = println("I am eating you, animal!")

        override def ?!(thought: String): Unit = println(s"I was thinking $thought") 
    }
    
    val aCroc = new Crocodile
    aCroc.eat(aDog)
    aCroc eat aDog // infix notation = object method argument, only available for methods with ONE argument
    aCroc.?!("What if we could fly?")

    // operators in Scala are actually methods
    val basicMath = 1 + 2
    val anotherBasicMath = 1.+(2) // equivalent

    // anonymous classes
    val dinosaur = new Carnivore {
        override def eat(animal: Animal): Unit = println("I am a dinosaur so I can eat pretty much anything")
    }

    // Singleton object
    object MySingleton {
        // the only instance of the MySingleton type
        val mySpecialValue = 53278
        def mySpecialMethod(): Int = 5327
        def apply(x: Int): Int = x + 1
    }
    MySingleton.mySpecialMethod()
    MySingleton.apply(65)
    MySingleton(65) // equivalent to MySingleton.apply(123)

    object Animal {
        // companions - companion object
        val canLiveIndefinitely = true // Companions have the capacity to access each other's private fields and methods
        // singleton Animal and instances of Animal are different things
        val canLiveForever = false
    }

    val animalsCanLiveForever = Animal.canLiveForever // "static" fields/methods

    /* 
    case classes = lightweight data structures with some boilerplate code 
    - sensible equals and hash code
    - serialization
    - companion with apply
    */

    case class Person(name: String, age: Int)

    val bob = Person("Bob", 54) // Person.apply("Bob", 54)

    // exceptions

    try {
        // code that can throw
        val x: String = null
        x.length
    } catch {
        case e: Exception => "some faulty error message"
    } finally {
        // execute some code no matter what
    }

    // generics
    abstract class MyList[T] {
        def head: T
        def tail: MyList[T]
    }
    
    // using a generic with a concrete type
    val aList: List[Int] = List(1,2,3) // List.apply(1,2,3)
    val first = aList.head
    val last = aList.tail
    val aStringList = List("Hello","Scala")
    val firstString = aStringList.head
    val lastString = aStringList.tail

    // Point #1: In Scala we usually operate with IMMUTABLE values/objects
    // Any modification to an object must return ANOTHER object
    /* 
        Benefits:
        1) Works miracles in multithreaded/distributed env
        2) Helps making sense of the code ("reasoning about")
     */

    val reversedList = aList.reverse // returns a NEW list
    

    // Point #2: Scala is closest to the 00 ideal
}

