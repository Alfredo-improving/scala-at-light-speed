# Basics.scala — Quick Study Recap

This file introduces Scala fundamentals: values, expressions, control flow, functions, recursion, and side effects.

## 1) Entry point with `object ... extends App`
- `object Basics extends App` is a runnable program.
- Code inside the object body executes when the program starts.

## 2) Immutable values (`val`) and type inference
- `val` declares immutable values.
- Types can be explicit (`val meaningOfLife: Int = 42`) or inferred (`val aBoolean = false`).

## 3) Basic built-in types
- Examples shown: `Int`, `Boolean`, `String`.
- Comment mentions other common primitives: `Char`, `Double`, `Float`.

## 4) String operations
- Concatenation with `+`.
- String interpolation with `s"... $value"`.

## 5) Expressions vs instructions
- Scala is expression-oriented: many constructs return values.
- Example: `val anExpression = 2 + 3`.

## 6) `if` as an expression
- `if` returns a value, so it can be assigned directly to a `val`.
- Includes chained `if / else if / else` expression.

## 7) Code blocks
- A block `{ ... }` is also an expression.
- The block value is the value of its last expression.

## 8) Defining functions
- Function syntax shown with parameter and return types:
  - `def myFunction(x: Int, y: String): String = ...`

## 9) Recursion
- `factorial` demonstrates recursive definition.
- Base case + recursive step pattern:
  - base: `if (n <= 1) 1`
  - recursive: `n * factorial(n - 1)`

## 10) No traditional loops emphasis
- Notes the Scala learning style preference toward recursion/functional style in many cases.

## 11) `Unit` type and side effects
- `Unit` is Scala's "no meaningful value" type (similar to `void`).
- `println(...)` is a side effect.
- `def myUnitReturningFunction(): Unit` explicitly returns `Unit`.
- `val theUnit = ()` shows the single `Unit` value.

---

## Practical takeaway
`Basics.scala` is about building intuition for Scala as an expression-oriented language with immutable values, typed functions, and recursion-first thinking.
