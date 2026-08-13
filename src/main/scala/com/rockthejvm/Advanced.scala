package com.rockthejvm

import scala.concurrent.Future
import scala.util.{Failure, Success, Try}
import scala.concurrent.ExecutionContext.Implicits.global

object Advanced extends App {
    // Lazy Evaluation
    lazy val aLazyValue = 2
    val lazyValueWithSideEffect = {
        println("I am so very lazy!")
        43
    }

    val eagerValue = lazyValueWithSideEffect + 1
    // useful in infinite collections

    // pseudo-collections: Option, Try
    def methodWhichCanReturnNull(): String = "Hello, Scala"
    val anOption = Option(methodWhichCanReturnNull())// Some ("Hello, Scala")
    // option == "collection which contains at most one element": Some(value) or None

    val stringProcessing = anOption match {
        case Some(string) => s"I have obtained a valid string: $string"
        case None => "I obtained nothing"
    }
    // map, flatMap, filter

    def methodWhichCanThrowException(): String = throw new RuntimeException
    val aTry = Try(methodWhichCanThrowException())
    // a try = "collection" with either a value if the code went well, or an exception if the code threw one

    val anotherStringProcessing = aTry match {
        case Success(validValue) => s"I have obtained a valid string: $validValue"
        case Failure(_) => "I obtained an exception" 
    }
    /**
      * Evaluate something on another thread
      * *(asynchronous programming)
      */
    val aFuture = Future{
       println("Loading...")
       Thread.sleep(1000)
       println("I have computed a value.")
       67
    }

    // future is a "collection" that contains a value when it is evaluated
    // future is composable with map, flatmap and filter
    // future, try and option types are monads

    /* 
     * Implicits basics
     * #1 - implicit arguments
     */
    def aMethodWithImplicitArgs(implicit arg: Int) = arg + 1
    implicit val myImplicitInt = 46
    println(aMethodWithImplicitArgs) // aMethodWithImplicitArgs(myImplicitInt)

    // #2 - implicit conversions
    implicit class MyRichInteger(n: Int) {
        def isEven() = n % 2 == 0
    }
    println(23.isEven()) // new MyRichInteger(23).isEven()
    // use implicit with care
  
}
