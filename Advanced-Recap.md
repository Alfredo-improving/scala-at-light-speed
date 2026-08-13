# Advanced.scala - Study Recap

## Main Topics Covered

### 1) Lazy Evaluation
- `lazy val` delays computation until first use.
- Useful for expensive computations or values that may never be needed.
- In the file:
  - `aLazyValue` demonstrates lazy initialization.
  - `lazyValueWithSideEffect` demonstrates eager initialization with a side effect (`println`).

### 2) Option (Null-Safe Values)
- `Option` wraps possibly null results into:
  - `Some(value)` when a value exists
  - `None` when value is absent (or null)
- Pattern matching is used to safely process the result:
  - `Some(string)` -> success message
  - `None` -> fallback message
- Key idea: treat `Option` like a tiny collection (0 or 1 element) that supports `map`, `flatMap`, and `filter`.

### 3) Try (Exception-Safe Computation)
- `Try` captures exceptions without crashing the program flow:
  - `Success(value)` if computation succeeds
  - `Failure(exception)` if it throws
- In the file, a throwing method is wrapped in `Try(...)` and then pattern-matched.
- Key idea: represent success/failure as values, then compose safely.

### 4) Future (Asynchronous Programming)
- `Future` runs computations asynchronously on another thread.
- The file imports:
  - `scala.concurrent.Future`
  - `scala.concurrent.ExecutionContext.Implicits.global`
- Example flow:
  - prints "Loading..."
  - waits (`Thread.sleep`)
  - prints completion
  - returns a computed value
- Key idea: a `Future` represents a value available later and is composable with `map`, `flatMap`, and `filter`.

### 5) Implicits Basics

#### a) Implicit Arguments
- A method can receive parameters implicitly from scope.
- `aMethodWithImplicitArgs` takes an implicit `Int`.
- `myImplicitInt` is provided automatically when calling the method without explicit args.

#### b) Implicit Class (Extension Methods)
- `implicit class MyRichInteger(n: Int)` adds behavior to existing types.
- Enables syntax like `23.isEven()`.
- Conceptually expands to wrapping `23` into `MyRichInteger(23)`.

## Big Picture Takeaway
- This file introduces key advanced Scala ideas:
  - delayed evaluation (`lazy val`)
  - safer data/error handling (`Option`, `Try`)
  - async computation (`Future`)
  - contextual and extension capabilities (`implicit` patterns)
- Together, these are foundational for idiomatic functional and concurrent Scala code.
