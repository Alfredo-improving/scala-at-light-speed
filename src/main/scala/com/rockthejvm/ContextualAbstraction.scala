package com.rockthejvm

object ContextualAbstraction {

    /* 
        1 - Context Parameters and Arguments
     */

    val aList = List(1, 2, 3, 4)
    val anOrderedList = aList.sorted // (ordering)

    // Ordering
    given descendingOrdering: Ordering[Int] = Ordering.fromLessThan(_ > _) // (a,b) => a > b



    def main(args: Array[String]): Unit = {
        println(anOrderedList)
    }   
  
}
