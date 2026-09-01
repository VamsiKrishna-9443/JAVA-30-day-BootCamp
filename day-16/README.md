<div align="center">

<img src="https://capsule-render.vercel.app/api?type=waving&color=0:F7A41D,100:2ECC71&height=220&section=header&text=Day%2016%20%7C%20Lambda%20Expressions&fontSize=44&fontColor=ffffff&animation=fadeIn&fontAlignY=38&desc=Predicate%20%E2%86%92%20Function%20%E2%86%92%20Consumer%20%E2%86%92%20Supplier%20%E2%86%92%20Method%20References&descAlignY=58&descAlign=50" width="100%"/>

![Java](https://img.shields.io/badge/Java-17+-orange?style=for-the-badge&logo=openjdk&logoColor=white)
![Day](https://img.shields.io/badge/Day-16%2F30-blue?style=for-the-badge)
![Topic](https://img.shields.io/badge/Topic-Lambda%20Expressions-brightgreen?style=for-the-badge)
![Backend](https://img.shields.io/badge/Backend%20Interview-Critical-red?style=for-the-badge)

### 🎯 Today's Mission
**Master functional interfaces — `Predicate`, `Function`, `Consumer`, `Supplier` — and method references, then build 5 real functional examples.**

![Progress](https://img.shields.io/badge/Progress-16%2F30%20Days%20(53%25)-success?style=for-the-badge)

</div>

---

## 📖 Table of Contents
- [Why This Day Matters](#-why-this-day-matters)
- [What Is a Lambda Expression?](#-what-is-a-lambda-expression)
- [Concept 1: Predicate\<T\>](#-concept-1-predicatet)
- [Concept 2: Function\<T,R\>](#-concept-2-functiontr)
- [Concept 3: Consumer\<T\>](#-concept-3-consumert)
- [Concept 4: Supplier\<T\>](#-concept-4-suppliert)
- [Concept 5: Method References](#-concept-5-method-references)
- [Project Structure](#-project-structure)
- [How Each Concept Is Used](#-how-each-concept-is-used-in-this-project)
- [5 Functional Examples Built](#-5-functional-examples-built)
- [How to Run](#-how-to-run)
- [Key Takeaways](#-key-takeaways)
- [What's Next](#-whats-next--day-17)

---

## 🤔 Why This Day Matters

Before Java 8, passing "behavior" as a parameter meant writing a full anonymous class:

```java
// ❌ Old way — verbose anonymous class just to pass a condition
Comparator<Employee> byName = new Comparator<Employee>() {
    @Override
    public int compare(Employee e1, Employee e2) {
        return e1.getName().compareTo(e2.getName());
    }
};
```

Lambdas collapse this into one line:

```java
// ✅ Lambda — same behavior, no boilerplate
Comparator<Employee> byName = (e1, e2) -> e1.getName().compareTo(e2.getName());
```

This matters because **Streams (Day 17), Spring Boot event handlers, and functional-style backend code are built entirely on lambdas and functional interfaces**. You can't write idiomatic modern Java without this day's concepts.

---

## 🧩 What Is a Lambda Expression?

> A lambda expression is an **anonymous function** — a block of code with no name that can be passed around like a value. It only works where a **functional interface** (an interface with exactly one abstract method) is expected.

**Syntax:**

```java
(parameters) -> expression
(parameters) -> { statements; }
```

```java
Runnable r = () -> System.out.println("Running!");
Comparator<Integer> cmp = (a, b) -> a - b;
```

---

## 🧩 Concept 1: `Predicate<T>`

> Represents a **condition** — takes one argument, returns `boolean`. Method: `test(T t)`.

```java
Predicate<Employee> isHighEarner = e -> e.getSalary() > 60000;
System.out.println(isHighEarner.test(employee));   // true / false

// Combinators
Predicate<Employee> isManager = e -> e.getRole().equals("Manager");
Predicate<Employee> combined = isHighEarner.and(isManager);
Predicate<Employee> negated  = isHighEarner.negate();
```

**Common use:** conditions passed to `filter()` in Streams.

---

## 🧩 Concept 2: `Function<T, R>`

> Represents a **transformation** — takes one argument of type `T`, returns a result of type `R`. Method: `apply(T t)`.

```java
Function<Employee, String> getName = Employee::getName;
String name = getName.apply(employee);

Function<Integer, Integer> square = x -> x * x;

// Chaining
Function<Integer, Integer> plusOne = x -> x + 1;
Function<Integer, Integer> combined = square.andThen(plusOne);  // (x*x) + 1
```

**Common use:** transformations passed to `map()` in Streams.

---

## 🧩 Concept 3: `Consumer<T>`

> Represents an **action** — takes one argument, returns nothing (`void`). Method: `accept(T t)`.

```java
Consumer<Employee> printEmployee = e -> System.out.println(e.getName());
printEmployee.accept(employee);

// Chaining
Consumer<Employee> printSalary = e -> System.out.println(e.getSalary());
Consumer<Employee> both = printEmployee.andThen(printSalary);
```

**Common use:** `forEach()` on collections and Streams.

---

## 🧩 Concept 4: `Supplier<T>`

> Represents a **factory** — takes no arguments, returns a value. Method: `get()`.

```java
Supplier<Employee> newEmployee = () -> new Employee("Unnamed", 0);
Employee e = newEmployee.get();

Supplier<Double> randomSalary = () -> Math.random() * 100000;
```

**Common use:** lazy default values, `orElseGet()` in `Optional` (Day 18).

---

## 🧩 Concept 5: Method References

> Shorthand for a lambda that just calls **one existing method**. Four flavors:

| Type | Syntax | Equivalent Lambda |
|---|---|---|
| Static method | `ClassName::staticMethod` | `x -> ClassName.staticMethod(x)` |
| Instance method (particular object) | `object::instanceMethod` | `x -> object.instanceMethod(x)` |
| Instance method (arbitrary object of a type) | `ClassName::instanceMethod` | `(x, y) -> x.instanceMethod(y)` |
| Constructor | `ClassName::new` | `() -> new ClassName()` |

```java
// Static
Function<String, Integer> parse = Integer::parseInt;

// Instance — particular object
Employee emp = new Employee("Vamsi", 50000);
Supplier<String> getName = emp::getName;

// Instance — arbitrary object of a type
Function<Employee, String> getName2 = Employee::getName;

// Constructor
Supplier<Employee> factory = Employee::new;
```

---

## 📁 Project Structure

```
day-16/
└── src/
    ├── Lambda/
    │   ├── LambdaExample.java              # Core lambda syntax playground
    │   ├── PredicateExample.java           # Predicate<T> — conditions, and()/or()/negate()
    │   ├── FunctionExample.java            # Function<T,R> — transformations, andThen()
    │   ├── ConsumerExample.java            # Consumer<T> — actions, andThen()
    │   └── SupplierExample.java            # Supplier<T> — lazy value factories
    │
    ├── MethodReferences/
    │   ├── StaticMethodReferenceExample.java     # ClassName::staticMethod
    │   ├── InstanceMethodReferenceExample.java   # object::instanceMethod
    │   └── ArbitraryMethodReferenceExample.java  # ClassName::instanceMethod
    │
    └── Practice/
        ├── Employees.java                  # Shared model: name, salary, role
        ├── EmployeePredicateExample.java    # Predicate applied to Employees
        ├── EmployeeFunctionExample.java     # Function applied to Employees
        └── EmployeeConsumerExample.java     # Consumer applied to Employees
```

---

## 🔗 How Each Concept Is Used in This Project

| File | Concepts Applied |
|---|---|
| `LambdaExample.java` | Core `(params) -> expression` syntax across simple use cases |
| `PredicateExample.java` | `Predicate<T>` — `test()`, `.and()`, `.or()`, `.negate()` |
| `FunctionExample.java` | `Function<T,R>` — `apply()`, `.andThen()`, `.compose()` |
| `ConsumerExample.java` | `Consumer<T>` — `accept()`, `.andThen()` chaining |
| `SupplierExample.java` | `Supplier<T>` — `get()`, lazy object creation |
| `StaticMethodReferenceExample.java` | `ClassName::staticMethod` (e.g. `Integer::parseInt`) |
| `InstanceMethodReferenceExample.java` | `object::instanceMethod` on a specific instance |
| `ArbitraryMethodReferenceExample.java` | `ClassName::instanceMethod` used across a stream of objects |
| `Employees.java` | Shared model reused by every `Practice/` example |
| `EmployeePredicateExample.java` | Real-world `Predicate<Employee>` — filter by salary/role |
| `EmployeeFunctionExample.java` | Real-world `Function<Employee,R>` — extract/transform fields |
| `EmployeeConsumerExample.java` | Real-world `Consumer<Employee>` — print/report actions |

**The throughline:** the `Lambda/` and `MethodReferences/` folders teach each functional interface in isolation, then `Practice/` applies all of them to one shared `Employees` model — the same pattern **Streams (Day 17)** builds directly on top of, since `filter()`, `map()`, and `forEach()` are just `Predicate`, `Function`, and `Consumer` under the hood.

---

## ✅ 5 Functional Examples Built

| # | Example | Interface / Feature Used |
|---|---|---|
| 1 | Filter employees earning above a threshold | `Predicate<Employee>` |
| 2 | Extract employee names as uppercase strings | `Function<Employee,String>` |
| 3 | Print each employee's details | `Consumer<Employee>` |
| 4 | Generate a default/placeholder employee lazily | `Supplier<Employee>` |
| 5 | Parse and transform values using existing methods, no new lambdas | Method References (`Integer::parseInt`, `Employee::getName`, `Employee::new`) |

---

## ▶️ How to Run

```bash
# From day-16/src/
javac Lambda/*.java MethodReferences/*.java Practice/*.java

java Lambda.LambdaExample
java Lambda.PredicateExample
java Lambda.FunctionExample
java Lambda.ConsumerExample
java Lambda.SupplierExample
java MethodReferences.StaticMethodReferenceExample
java MethodReferences.InstanceMethodReferenceExample
java MethodReferences.ArbitraryMethodReferenceExample
java Practice.EmployeePredicateExample
java Practice.EmployeeFunctionExample
java Practice.EmployeeConsumerExample
```

---

## 💡 Key Takeaways

- ✅ A lambda only works where a **functional interface** (one abstract method) is expected
- ✅ `Predicate` → boolean condition, `Function` → transformation, `Consumer` → action, `Supplier` → factory — memorize these four by their method signature, not just the name
- ✅ Method references (`Class::method`) are just shorthand for a lambda that calls one existing method — use them whenever the lambda body is a single method call
- ✅ These four interfaces are the **foundation of Streams** (Day 17) — `filter()` takes a `Predicate`, `map()` takes a `Function`, `forEach()` takes a `Consumer`
- ✅ Real feature built today: 5 functional examples applied to a shared `Employees` model, mirroring how Spring Boot services use functional interfaces for validation, transformation, and side effects

<div align="center">

![Complete](https://img.shields.io/badge/Day%2016-Complete%20✅-success?style=for-the-badge)

</div>

---

## 🔮 What's Next — Day 17

<div align="center">

**Day 16 ✅ → Day 17 🔜**

From individual functional interfaces into the **Streams API** — where `Predicate`, `Function`, `Consumer`, and method references all come together in one declarative pipeline: `filter → map → flatMap → sorted → distinct → collect → reduce → group`.

![Progress](https://img.shields.io/badge/Progress-16%2F30%20Days-success?style=for-the-badge)
![Next](https://img.shields.io/badge/Next-Day%2017-yellow?style=for-the-badge)

</div>

<img src="https://capsule-render.vercel.app/api?type=waving&color=0:2ECC71,100:F7A41D&height=150&section=footer&animation=fadeIn"/>

<div align="center">

⭐ **Part of the [JAVA-30-day-BootCamp](../../) series** ⭐

</div>
