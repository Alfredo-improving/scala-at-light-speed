# FunctionalProgramming.scala — Study Session Summary

## 1) `apply` Method and Function-like Objects
- The `Person` class defines `apply(age: Int)`.
- This allows an instance to be invoked like a function:
  - `bob.apply(43)`
  - `bob(43)`
- Main idea: objects with `apply` can be called using function syntax.

## 2) Functions Are Objects in Scala
- Scala models functions as instances of function traits:
  - `Function1[A, B]`
  - `Function2[A, B, C]`
  - ... up to `Function22`
- Examples in the file:
  - `simpleIncrementer` as `Function1[Int, Int]`
  - `stringConcatenator` as `Function2[String, String, String]`

## 3) Lambda Syntax (Syntactic Sugar)
- A concise function literal is used:
  - `val doubler: Function1[Int, Int] = (x: Int) => 2 * x`
- Main idea: lambdas are the idiomatic shorthand for function values.

## 4) Higher-Order Functions on Collections
- `map` transforms elements.
- `flatMap` transforms and flattens nested results.
- `filter` keeps elements matching a predicate.
- Examples shown with `List(1,2,3,4,5)` operations.

## 5) Building Combinations with `flatMap` + `map`
- You generated all number-letter pairs (`1-a`, `1-b`, ...).
- Main idea: nested `flatMap/map` is a common functional pattern for combinations.

## 6) For-Comprehensions
- The same pairing logic is rewritten using:
  - `for { number <- ...; letter <- ... } yield ...`
- Main idea: for-comprehensions are more readable syntax over `map/flatMap` chains.

## 7) Core Immutable Collections Overview
- **List**: `head`, `tail`, prepend (`::`), append (`:+`), and combined prepend/append (`+: ... :+`).
- **Seq**: sequence abstraction with index access.
- **Vector**: indexed immutable collection.
- **Set**: uniqueness, membership (`contains`), add (`+`), remove (`-`).
- **Range**: numeric interval (`1 to 1000`) and mapping.
- **Tuple**: grouped heterogeneous values.
- **Map**: key-value pairs (`aPhonebook`).

## Big-Picture Takeaway
This file connects Scala OOP and FP fundamentals:
- objects with `apply`
- first-class functions
- higher-order collection APIs
- for-comprehensions
- immutable collection basics

These are foundational concepts for advanced Scala and functional programming patterns.
