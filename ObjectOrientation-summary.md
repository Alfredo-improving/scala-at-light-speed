# ObjectOrientation.scala — Quick Study Recap

This file is a compact tour of core Scala OOP concepts using small examples.

## 1) Classes, fields, methods, instances
- A class defines a type and behavior.
- `Animal` defines:
  - a field: `age`
  - a method: `eat()`
- `new Animal` creates an instance.

## 2) Inheritance
- `Dog` extends `Animal`:
  - `class Dog(val name: String) extends Animal`
- `val` in constructor parameters promotes the parameter to a field (`aDog.name`).

## 3) Subtype polymorphism
- A subtype can be referenced by a parent type:
  - `val aDeclaredAnimal: Animal = new Dog("Hachi")`
- Method dispatch is dynamic (runtime): calling methods on the parent reference can execute subclass overrides.

## 4) Abstract classes
- `abstract class walkingAnimal` cannot be instantiated directly.
- It can contain both implemented members (`hasLegs`) and abstract members (`walk()`).

## 5) Traits (interfaces) + mixins
- `Carnivore` and `Philosopher` are traits.
- `Crocodile` mixes in multiple traits:
  - `extends Animal with Carnivore with Philosopher`
- Demonstrates Scala's single class inheritance + multiple trait composition.

## 6) Method overriding
- `Crocodile` overrides `eat(animal: Animal)` and `?!(thought: String)`.
- `override` is explicit and required for safer code.

## 7) Infix notation and symbolic methods
- Standard call: `aCroc.eat(aDog)`
- Infix call (single-arg methods): `aCroc eat aDog`
- Symbolic method call: `aCroc.?!(...)`

## 8) Operators are methods
- `1 + 2` is syntax sugar for `1.+(2)`.

## 9) Anonymous classes
- `new Carnivore { ... }` creates an on-the-fly implementation without naming a class.

## 10) Singleton objects
- `object MySingleton` defines a single global instance.
- No `new` is needed.
- Supports fields/methods and `apply`.

## 11) `apply` convention
- Defining `apply` lets you call an object like a function:
  - `MySingleton(65)` == `MySingleton.apply(65)`

## 12) Companion object idea
- `class Animal` + `object Animal` share the same name in the same scope.
- The object typically stores "static-like" members for the class.

## 13) Case classes
- `case class Person(name: String, age: Int)` gives useful defaults:
  - structural `equals`/`hashCode`
  - readable `toString`
  - companion `apply`
  - pattern-matching friendliness

## 14) Exceptions
- `try/catch/finally` shown with a possible `NullPointerException` scenario.
- `finally` executes regardless of success/failure.

## 15) Generics
- `MyList[T]` introduces type parameters.
- Concrete usage examples: `List[Int]`, `List[String]`.

## 16) Immutability mindset
- Emphasis on immutable collections and values.
- Example: `aList.reverse` returns a new list instead of mutating the original.

---

## Practical takeaway
This lesson combines OOP fundamentals (classes, inheritance, polymorphism, traits, overrides) with Scala idioms (singleton objects, `apply`, case classes, infix/symbolic methods, immutability, and generics).
