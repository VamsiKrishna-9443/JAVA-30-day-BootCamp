

<div align="center">

<img src="https://capsule-render.vercel.app/api?type=waving&color=0:8b5cf6,100:22c55e&height=220&section=header&text=Day%2015%20%7C%20Generics%20%26%20Sorting&fontSize=44&fontColor=ffffff&animation=fadeIn&fontAlignY=38&desc=Generics%20%E2%86%92%20Wildcards%20%E2%86%92%20Comparable%20%E2%86%92%20Comparator%20%E2%86%92%20Multi-Level%20Sorting&descAlignY=58&descAlign=50" width="100%"/>

![Java](https://img.shields.io/badge/Java-17+-orange?style=for-the-badge&logo=openjdk&logoColor=white)
![Day](https://img.shields.io/badge/Day-15%2F30-blue?style=for-the-badge)
![Topic](https://img.shields.io/badge/Topic-Generics%20%7C%20Sorting-brightgreen?style=for-the-badge)
![Backend](https://img.shields.io/badge/Backend%20Interview-Critical-red?style=for-the-badge)

### 🎯 Today's Mission
**Master type-safe reusable code with Generics, and flexible object ordering with `Comparable` and `Comparator` — then apply both to real Employee sorting scenarios.**

![Progress](https://img.shields.io/badge/Progress-15%2F30%20Days%20(50%25)-success?style=for-the-badge)

</div>

---

## 📖 Table of Contents
- [Why This Day Matters](#-why-this-day-matters)
- [Concept 1: Generics](#-concept-1-generics)
- [Concept 2: Generic Methods](#-concept-2-generic-methods)
- [Concept 3: Generic Interfaces](#-concept-3-generic-interfaces)
- [Concept 4: Wildcards](#-concept-4-wildcards)
- [Concept 5: Comparable](#-concept-5-comparable)
- [Concept 6: Comparator](#-concept-6-comparator)
- [Concept 7: Comparator.comparing()](#-concept-7-comparatorcomparing)
- [Concept 8: Multi-Level Sorting](#-concept-8-multi-level-sorting)
- [Concept 9: Descending Order & reversed() Placement](#-concept-9-descending-order--reversed-placement)
- [Comparable vs Comparator](#-comparable-vs-comparator)
- [Project Structure](#-project-structure)
- [How Each Concept Is Used](#-how-each-concept-is-used-in-this-project)
- [Real-World Business Usage](#-real-world-business-usage)
- [Interview Questions](#-interview-questions)
- [How to Run](#-how-to-run)
- [Key Takeaways](#-key-takeaways)
- [What's Next](#-whats-next--day-16)

---

## 🤔 Why This Day Matters

Two problems come up constantly in real Java code:
1. **"I want this class/method to work with any type, safely"** — without casting, without runtime surprises.
2. **"I want to sort these objects, but the rule keeps changing"** — by salary today, by name tomorrow, by both with ties broken a third way.

Java's answer to both:

| Problem | Old Way (fragile) | Modern Way (safe) |
|---|---|---|
| "This collection needs to hold any type safely" | Raw `List`, manual casting, runtime `ClassCastException` | `List<T>` — compile-time type checking, no casts |
| "How should these objects be ordered?" | One hardcoded sort inside the class | `Comparable` for a default order, `Comparator` for any number of custom orders |

Today's build proves it with a working **Employee sorting system** — sorted by salary, by name, by joining date, and by combinations of all three.

---

## 🧩 Concept 1: Generics

> Generics let a class, interface, or method work with different data types while keeping **compile-time type safety**.

**Without generics:**

```java
List list = new ArrayList();
list.add("Java");
list.add(100);
String value = (String) list.get(1); // Runtime problem
```

**With generics:**

```java
List<String> names = new ArrayList<>();
names.add("Java");
// names.add(100); // Compile-time error
```

### Why Generics?
- Type safety
- Fewer explicit casts
- Reusable classes and methods
- Errors caught at compile time, not runtime
- Cleaner, more maintainable code

### Generic Class

```java
class Box<T> {
    private T value;
    public void setValue(T value) { this.value = value; }
    public T getValue() { return value; }
}
```

```java
Box<String> stringBox = new Box<>();
stringBox.setValue("Java");

Box<Integer> integerBox = new Box<>();
integerBox.setValue(100);
```

`T` is a **type parameter**:

```
Box<T>
  |
  +-- T can become String
  +-- T can become Integer
  +-- T can become Employee
```

---

## 🧩 Concept 2: Generic Methods

> A generic method works with different types independently of the class it lives in.

```java
public static <T> void printValue(T value) {
    System.out.println(value);
}
```

```java
printValue("Java");
printValue(100);
printValue(25.5);
```

The `<T>` before the return type declares the type parameter:

```java
public static <T> void method(T value)
```

---

## 🧩 Concept 3: Generic Interfaces

> Interfaces can use type parameters too, making them reusable across type combinations.

```java
interface Pair<T, U> {
    T getFirst();
    U getSecond();
}
```

---

## 🧩 Concept 4: Wildcards

> `?` means "I don't know the exact type."

```java
List<?> list
```

Can refer to `List<String>`, `List<Integer>`, `List<Employee>`, etc.

**Upper Bound** — `List<? extends Number>`: the list contains `Number` or a subclass (`Integer`, `Double`).

**Lower Bound** — `List<? super Integer>`: the list accepts `Integer` or one of its supertypes.

**Memory rule:**

```
? extends  → read / producer
? super    → write / consumer
```

**PECS — Producer Extends, Consumer Super.**

---

## 🧩 Concept 5: Comparable

> `Comparable` defines a class's own **natural ordering**.

```java
class Employee implements Comparable<Employee> {
    private int id;
    private String name;
    private double salary;

    @Override
    public int compareTo(Employee other) {
        return Double.compare(this.salary, other.salary);
    }
}
```

Now `Employee` sorts naturally by salary:

```java
Collections.sort(employees);
// or
employees.sort(null);
```

**How `compareTo()` is interpreted:**

```
negative → e1 comes before e2
0        → e1 and e2 are equal for this ordering
positive → e1 comes after e2
```

You don't need to return exactly `-1`, `0`, or `1` — only the sign matters.

---

## 🧩 Concept 6: Comparator

> `Comparator` defines a **custom, external** sorting rule — without touching the original class.

The same `Employee` class can be sorted by salary, name, joining date, ID, or several fields at once, all without modification.

**Lambda Comparator:**

```java
Comparator<Employee> salaryComparator =
    (e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary());
```

```
Take Employee e1 and Employee e2
              ↓
Get e1 salary
              ↓
Get e2 salary
              ↓
Compare both salaries
              ↓
Return negative / zero / positive
```

```java
employees.sort(salaryComparator);
```

This lambda is shorthand for the traditional anonymous-class version:

```java
Comparator<Employee> salaryComparator =
    new Comparator<Employee>() {
        @Override
        public int compare(Employee e1, Employee e2) {
            return Double.compare(e1.getSalary(), e2.getSalary());
        }
    };
```

---

## 🧩 Concept 7: `Comparator.comparing()`

> Java provides a factory method so you don't write the comparison manually.

```java
// Instead of:
Comparator<Employee> salaryComparator =
    (e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary());

// Use:
Comparator<Employee> salaryComparator =
    Comparator.comparing(Employee::getSalary);
```

`Employee::getSalary` is a **method reference** — it tells Java: *"When comparing two Employees, use their salary value."*

```
Employee A → getSalary()
Employee B → getSalary()
        ↓
Compare the two salary values
```

---

## 🧩 Concept 8: Multi-Level Sorting

> `thenComparing()` chains a secondary rule for when the primary comparison ties.

```java
employees.sort(
    Comparator.comparing(Employee::getSalary)
        .thenComparing(Employee::getName)
        .thenComparing(Employee::getJoiningDate)
);
```

```
1. Salary
      ↓
2. If salary is equal → Name
      ↓
3. If name is also equal → Joining Date
```

**Example:**

```
Employee      Salary     Name
--------------------------------
Rahul         50000      Rahul
Anil          50000      Anil
Vamsi         60000      Vamsi
```

**After sorting:**

```
Anil          50000
Rahul         50000
Vamsi         60000
```

Salary is the primary key; name only breaks ties when salary matches; joining date only breaks ties when both salary and name match.

---

## 🧩 Concept 9: Descending Order & `reversed()` Placement

By default, `Comparator.comparing(...)` sorts **ascending**. For descending:

```java
Comparator.comparing(Employee::getSalary).reversed()
```

### ⚠️ Where you put `reversed()` changes the result

This is one of the most common multi-level sorting mistakes. `reversed()` only flips whatever it's **directly attached to** — it doesn't know or care about the rest of the chain.

**Data:**

```
Employee      Salary     Name
--------------------------------
Anil          50000      Anil
Rahul         50000      Rahul
Vamsi         60000      Vamsi
```

**Case A — reverse the whole chain**

```java
employees.sort(
    Comparator.comparing(Employee::getSalary)
        .thenComparing(Employee::getName)
        .reversed()
);
```

`reversed()` is called last, on the *entire* combined comparator — flipping everything, including the tie-break, as one unit:

```
Vamsi         60000
Rahul         50000
Anil          50000
```

Salary is descending, and within the 50000 tie, Rahul comes before Anil — the name ordering was flipped too.

**Case B — reverse only the salary key**

```java
employees.sort(
    Comparator.comparing(Employee::getSalary)
        .reversed()
        .thenComparing(Employee::getName)
);
```

`reversed()` is attached only to the salary comparator, *before* `thenComparing()` is added. Salary is descending, but the name tie-break stays ascending:

```
Vamsi         60000
Anil          50000
Rahul         50000
```

Salary is still descending, but now Anil comes before Rahul in the tie — the opposite of Case A, because the name comparator was never reversed.

**The rule:**

```
Comparator.comparing(A).thenComparing(B).reversed()
   → reverses A AND B together (reverses the final combined result)

Comparator.comparing(A).reversed().thenComparing(B)
   → reverses only A; B still breaks ties in its own natural order
```

If you want "highest paid first, alphabetical for ties," use Case B. If you want the entire list flipped end-to-end, use Case A. They are not the same comparator, even starting from the same two fields.

---

## ⚖️ Comparable vs Comparator

| Feature | Comparable | Comparator |
|---|---|---|
| Package | `java.lang` | `java.util` |
| Main method | `compareTo()` | `compare()` |
| Ordering | Natural/default | Custom |
| Defined inside class? | Yes | Usually outside |
| Multiple sorting strategies | Not convenient | Excellent |
| Modifies class? | Class implements interface | No |
| Lambda friendly | No | Yes |

```
Comparable
    ↓
"What is the natural/default order of this object?"

Comparator
    ↓
"How do I want to sort this object right now?"
```

---

## 📁 Project Structure

```
day-15/
└── src/
    ├── Generics/
    │   ├── BoxMain.java              # Generic class — Box<T>
    │   ├── GenericInterface.java     # Generic interface — Pair<T,U>
    │   ├── GenericMethod.java        # Generic method syntax
    │   └── PairMain.java             # Pair<T,U> usage
    │
    ├── Sorting/
    │   ├── ComparableExample.java    # Natural ordering via compareTo()
    │   ├── ComparatorExample.java    # Custom ordering via compare()
    │   ├── Employee.java             # Shared model: id, name, salary, joiningDate
    │   └── EmployeeSorting.java      # comparing(), thenComparing(), reversed()
    │
    └── WildCard/
        ├── GenericInheritance.java
        ├── LowerBoundExample.java
        ├── LowerBoundInheritance.java
        ├── UpperBoundExample.java
        └── WildcardExample.java
```

---

## 🔗 How Each Concept Is Used in This Project

| File | Concepts Applied |
|---|---|
| `BoxMain.java` | Generic class `Box<T>` — same container, different types |
| `GenericMethod.java` | `<T>` generic method syntax |
| `GenericInterface.java` / `PairMain.java` | Generic interface `Pair<T,U>` with two type parameters |
| `WildcardExample.java` / `GenericInheritance.java` | `?` wildcard usage |
| `UpperBoundExample.java` | `? extends Number` — producer/read scenarios |
| `LowerBoundExample.java` / `LowerBoundInheritance.java` | `? super Integer` — consumer/write scenarios |
| `Employee.java` | Shared model reused by every sorting example |
| `ComparableExample.java` | `Employee implements Comparable<Employee>` — natural salary ordering |
| `ComparatorExample.java` | Lambda comparators for custom ordering |
| `EmployeeSorting.java` | `Comparator.comparing()`, `thenComparing()`, `reversed()` placement (Case A vs Case B) |

**The throughline:** `Generics` and `WildCard` build the type-safety foundation, while `Sorting` applies it to one real, shared `Employee` model — mirroring how backend services define one domain object and then sort/filter it in multiple ways depending on the request.

---

## 🏢 Real-World Business Usage

**Employee Management**
```
Sort employees by salary
Sort employees by name
Sort employees by joining date
```

**E-commerce**
```
Products by price
Products by rating
Products by stock
Products by newest arrival
```

**Banking**
```
Transactions by amount
Transactions by date
Transactions by transaction ID
```

**Logistics / Fleet Systems**
```
Vehicles by status
Vehicles by registration date
Drivers by name
Trips by start time
```

**Search Results**
```
Highest rated first
Lowest price first
Newest records first
```

---

## 🎤 Interview Questions

**Easy**
1. **What are Generics?** — Type-safe, reusable code by allowing types to be specified as parameters.
2. **What is Comparable?** — Defines the natural ordering of objects through `compareTo()`.
3. **What is Comparator?** — Defines custom ordering through `compare()`.
4. **What does a negative result from `compare()` mean?** — The first object should come before the second according to that comparator.

**Medium**
5. **Why use Comparator instead of Comparable?** — When multiple sorting strategies are needed without changing the domain class.
6. **What is `Comparator.comparing()`?** — A factory method that builds a comparator from a key extracted from each object, e.g. `Comparator.comparing(Employee::getSalary)`.
7. **What does `thenComparing()` do?** — Adds a secondary comparison rule for when the previous comparison considers two objects equal.

**Hard**
8. **Difference between natural and custom ordering?** — Natural ordering is defined by the class via `Comparable`; custom ordering is supplied externally via `Comparator`.
9. **Why is `Double.compare()` preferred over subtraction for doubles?** — It handles floating-point comparison semantics correctly. Prefer `Double.compare(e1.getSalary(), e2.getSalary())` over `(int)(e1.getSalary() - e2.getSalary())`.
10. **Explain:** `Comparator.comparing(Employee::getSalary).thenComparing(Employee::getName)` — Employees are first sorted by salary; if two share a salary, their names determine relative order.
11. **Difference between `.thenComparing(B).reversed()` and `.reversed().thenComparing(B)`?** — The first reverses the whole combined comparator (primary key and tie-break together); the second reverses only the comparator it's directly attached to, leaving anything chained afterward in its own natural direction.

---

## ▶️ How to Run

```bash
# From day-15/src/
javac Generics/*.java Sorting/*.java WildCard/*.java

java Generics.BoxMain
java Generics.GenericMethod
java Generics.PairMain
java WildCard.UpperBoundExample
java WildCard.LowerBoundExample
java Sorting.ComparableExample
java Sorting.ComparatorExample
java Sorting.EmployeeSorting
```

---

## 💡 Key Takeaways

- ✅ Generics provide compile-time type safety — `<T>` is a type parameter, `?` is an unknown type
- ✅ `? extends T` for producers (reading), `? super T` for consumers (writing) — **PECS**
- ✅ `Comparable` defines one natural ordering inside the class; `Comparator` defines any number of custom orderings outside it
- ✅ `Comparator.comparing()` + method references (`Employee::getSalary`) eliminate manual comparison boilerplate
- ✅ `thenComparing()` builds multi-level sorting — primary key first, then tie-breakers in order
- ✅ `reversed()` only flips what it's directly attached to — placement before or after `thenComparing()` produces genuinely different orderings, not just a stylistic difference
- ✅ Real feature built today: a working **Employee sorting system** — by salary, name, joining date, and combinations, ascending or descending

<div align="center">

![Complete](https://img.shields.io/badge/Day%2015-Complete%20✅-success?style=for-the-badge)

</div>

---

## 🔮 What's Next — Day 16

<div align="center">

**Day 15 ✅ → Day 16 🔜**

From type-safe generics and object sorting into **Lambda Expressions** — functional interfaces (`Predicate`, `Function`, `Consumer`, `Supplier`) and method references, the foundation the `Comparator` lambdas from today are built on.

![Progress](https://img.shields.io/badge/Progress-15%2F30%20Days-success?style=for-the-badge)
![Next](https://img.shields.io/badge/Next-Day%2016-yellow?style=for-the-badge)

</div>

<img src="https://capsule-render.vercel.app/api?type=waving&color=0:22c55e,100:8b5cf6&height=150&section=footer&animation=fadeIn"/>

<div align="center">

⭐ **Part of the [JAVA-30-day-BootCamp](../../) series** ⭐

</div>

---

**One heads-up before you paste this in:** `capsule-render.vercel.app` is a free third-party service, and it has genuinely been intermittent for you across Day 15, 17, and 18 — that's why it broke again even after working once. If it fails to load again after this fix, it's the service having a moment, not something wrong with your markdown. Replace your entire `day-15/README.md` with the block above (delete the old content first, don't append) so the stray sentence doesn't linger in the file.
