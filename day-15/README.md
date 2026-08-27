<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 1200 260">
<defs>
  <linearGradient id="g" x1="0" x2="1">
    <stop offset="0%" stop-color="#7c3aed"/>
    <stop offset="50%" stop-color="#2563eb"/>
    <stop offset="100%" stop-color="#06b6d4"/>
  </linearGradient>
</defs>

<rect width="1200" height="260" rx="28" fill="#0b1020"/>

<circle cx="150" cy="130" r="70"
        fill="none"
        stroke="url(#g)"
        stroke-width="8"
        stroke-dasharray="18 14">
  <animateTransform
    attributeName="transform"
    type="rotate"
    from="0 150 130"
    to="360 150 130"
    dur="8s"
    repeatCount="indefinite"/>
</circle>

<text x="150" y="150"
      text-anchor="middle"
      font-family="Arial, sans-serif"
      font-size="62"
      font-weight="700"
      fill="#ffffff">
  J15
</text>

<text x="300" y="105"
      font-family="Arial, sans-serif"
      font-size="42"
      font-weight="700"
      fill="#ffffff">
  Java Day 15
</text>

<text x="300" y="155"
      font-family="Arial, sans-serif"
      font-size="25"
      fill="#b9c7e6">
  Generics • Comparable • Comparator • Sorting
</text>

<rect x="300" y="185"
      width="680"
      height="6"
      rx="3"
      fill="url(#g)">
  <animate
    attributeName="width"
    from="0"
    to="680"
    dur="2s"
    fill="freeze"/>
</rect>

<text x="300" y="225"
      font-family="Arial, sans-serif"
      font-size="18"
      fill="#7dd3fc">
  Type-safe code. Flexible sorting. Practical Java.
</text>

</svg>
# ☕ Java Day 15 --- Generics, Comparable & Comparator

### A practical deep dive into type-safe reusable code and flexible object sorting

![Java](https://img.shields.io/badge/Java-17%2B-orange?style=for-the-badge&logo=openjdk)
![Collections](https://img.shields.io/badge/Collections-Generics-blue?style=for-the-badge)
![Sorting](https://img.shields.io/badge/Sorting-Comparable%20%7C%20Comparator-success?style=for-the-badge)
![Status](https://img.shields.io/badge/Day-15-purple?style=for-the-badge)
:::

------------------------------------------------------------------------

## 🎯 Day 15 Objective

Day 15 focuses on two important areas of Java development:

1.  **Generics** --- writing reusable, type-safe code.
2.  **Object Sorting** --- defining how custom objects should be ordered
    using `Comparable` and `Comparator`.

The goal is not just to memorize syntax, but to understand **why these
features exist, how Java uses them internally, and where they appear in
real applications**.

------------------------------------------------------------------------

# 📚 1. Generics

## What are Generics?

Generics allow a class, interface, or method to work with different data
types while maintaining **compile-time type safety**.

Without generics:

``` java
List list = new ArrayList();

list.add("Java");
list.add(100);

String value = (String) list.get(1); // Runtime problem
```

With generics:

``` java
List<String> names = new ArrayList<>();

names.add("Java");
// names.add(100); // Compile-time error
```

### Why Generics?

-   Type safety
-   Fewer explicit casts
-   Reusable classes and methods
-   Errors are detected at compile time
-   Cleaner and more maintainable code

------------------------------------------------------------------------

## Generic Class

``` java
class Box<T> {

    private T value;

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}
```

Usage:

``` java
Box<String> stringBox = new Box<>();
stringBox.setValue("Java");

Box<Integer> integerBox = new Box<>();
integerBox.setValue(100);
```

Here `T` is a **type parameter**.

Think of it as:

``` text
Box<T>
  |
  +-- T can become String
  +-- T can become Integer
  +-- T can become Employee
```

------------------------------------------------------------------------

# 🧩 2. Generic Methods

A generic method can work with different types independently of the
class.

``` java
public static <T> void printValue(T value) {
    System.out.println(value);
}
```

Usage:

``` java
printValue("Java");
printValue(100);
printValue(25.5);
```

### Important syntax

``` java
<T> 
```

appears before the return type:

``` java
public static <T> void method(T value)
```

The first `<T>` declares the type parameter.

------------------------------------------------------------------------

# 🔗 3. Generic Interfaces

Interfaces can also use type parameters.

``` java
interface Pair<T, U> {

    T getFirst();

    U getSecond();
}
```

This makes the interface reusable with different combinations of types.

------------------------------------------------------------------------

# 🃏 4. Wildcards

A wildcard is represented by:

``` java
?
```

It means:

> "I don't know the exact type."

Example:

``` java
List<?> list
```

This can refer to:

``` java
List<String>
List<Integer>
List<Employee>
```

## Upper Bound

``` java
List<? extends Number>
```

Means:

> The list contains Number or a subclass of Number.

Examples:

``` java
List<Integer>
List<Double>
```

## Lower Bound

``` java
List<? super Integer>
```

Means:

> The list can accept Integer or one of Integer's supertypes.

### Easy memory rule

``` text
? extends  → read / producer
? super    → write / consumer
```

A common memory aid is:

**PECS --- Producer Extends, Consumer Super.**

------------------------------------------------------------------------

# ⚖️ 5. Comparable

## What is Comparable?

`Comparable` is used when a class defines its own **natural ordering**.

Example:

``` java
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

Now `Employee` has a default sorting rule:

> Employees are naturally ordered by salary.

Sorting:

``` java
Collections.sort(employees);
```

or:

``` java
employees.sort(null);
```

can use that natural ordering.

------------------------------------------------------------------------

## How `compareTo()` Works

``` java
int result = e1.compareTo(e2);
```

The result is interpreted by its sign:

``` text
negative → e1 comes before e2
0        → e1 and e2 are equal for this ordering
positive → e1 comes after e2
```

You do not need to return exactly `-1`, `0`, or `1`.

------------------------------------------------------------------------

# 🔀 6. Comparator

## What is Comparator?

`Comparator` is used when we want to define a **custom/external sorting
rule**.

For example, the same `Employee` class can be sorted by:

-   Salary
-   Name
-   Joining date
-   ID
-   Multiple fields

without changing the `Employee` class.

------------------------------------------------------------------------

## Lambda Comparator

``` java
Comparator<Employee> salaryComparator =
        (e1, e2) ->
                Double.compare(
                        e1.getSalary(),
                        e2.getSalary()
                );
```

This means:

``` text
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

Then:

``` java
employees.sort(salaryComparator);
```

------------------------------------------------------------------------

# 🧠 7. Understanding the Lambda

This:

``` java
Comparator<Employee> salaryComparator =
        (e1, e2) ->
                Double.compare(
                        e1.getSalary(),
                        e2.getSalary()
                );
```

is effectively providing the implementation of:

``` java
int compare(Employee e1, Employee e2)
```

The traditional anonymous-class version is:

``` java
Comparator<Employee> salaryComparator =
        new Comparator<Employee>() {

            @Override
            public int compare(Employee e1, Employee e2) {
                return Double.compare(
                        e1.getSalary(),
                        e2.getSalary()
                );
            }
        };
```

The lambda is simply a shorter and cleaner way to express the same
comparison behavior.

------------------------------------------------------------------------

# 🏗️ 8. `Comparator.comparing()`

Instead of writing the comparison manually:

``` java
Comparator<Employee> salaryComparator =
        (e1, e2) ->
                Double.compare(
                        e1.getSalary(),
                        e2.getSalary()
                );
```

Java provides:

``` java
Comparator<Employee> salaryComparator =
        Comparator.comparing(Employee::getSalary);
```

### What does `Employee::getSalary` mean?

It is a **method reference**.

It tells Java:

> "When comparing two Employees, use their salary value."

Conceptually:

``` text
Employee A → getSalary()
Employee B → getSalary()
        ↓
Compare the two salary values
```

------------------------------------------------------------------------

# 🥇 9. Multi-Level Sorting

One of the most useful Comparator features is chained sorting.

``` java
employees.sort(
        Comparator.comparing(Employee::getSalary)
                .thenComparing(Employee::getName)
                .thenComparing(Employee::getJoiningDate)
);
```

The priority is:

``` text
1. Salary
      ↓
2. If salary is equal → Name
      ↓
3. If name is also equal → Joining Date
```

Example:

``` text
Employee      Salary     Name
--------------------------------
Rahul         50000      Rahul
Anil          50000      Anil
Vamsi         60000      Vamsi
```

After sorting:

``` text
Anil          50000
Rahul         50000
Vamsi         60000
```

Salary is the **primary key**.

Name becomes the **secondary key only when salary is equal**.

Joining date becomes the **third-level key only when salary and name are
both equal**.

------------------------------------------------------------------------

# 🔽 10. Descending Order

By default:

``` java
Comparator.comparing(Employee::getSalary)
```

sorts in ascending order.

For descending order:

``` java
Comparator.comparing(Employee::getSalary).reversed()
```

Example:

``` java
employees.sort(
        Comparator.comparing(Employee::getSalary)
                .reversed()
);
```

For multi-level sorting:

``` java
employees.sort(
        Comparator.comparing(Employee::getSalary)
                .reversed()
                .thenComparing(Employee::getName)
);
```

Be careful about **where `reversed()` is applied**, because reversing
the whole comparator chain and reversing an individual field can produce
different ordering rules.

------------------------------------------------------------------------

# 📅 11. Sorting by `LocalDate`

For an employee:

``` java
private LocalDate joiningDate;
```

You can sort using:

``` java
Comparator.comparing(Employee::getJoiningDate)
```

Earlier dates come first in ascending order.

Example:

``` text
2023-02-15
2024-05-10
2025-01-20
```

This is useful for:

-   Employee joining date
-   Order date
-   Booking date
-   Transaction date
-   Application submission date

------------------------------------------------------------------------

# 🏢 12. Real-World Business Usage

These concepts appear frequently in backend applications.

### Employee Management

``` text
Sort employees by salary
Sort employees by name
Sort employees by joining date
```

### E-commerce

``` text
Products by price
Products by rating
Products by stock
Products by newest arrival
```

### Banking

``` text
Transactions by amount
Transactions by date
Transactions by transaction ID
```

### Logistics / Fleet Systems

``` text
Vehicles by status
Vehicles by registration date
Drivers by name
Trips by start time
```

### Search Results

``` text
Highest rated first
Lowest price first
Newest records first
```

------------------------------------------------------------------------

# 🔥 13. Comparable vs Comparator

  Feature                       Comparable                   Comparator
  ----------------------------- ---------------------------- -----------------
  Package                       `java.lang`                  `java.util`
  Main method                   `compareTo()`                `compare()`
  Ordering                      Natural/default              Custom
  Defined inside class?         Yes                          Usually outside
  Multiple sorting strategies   Not convenient               Excellent
  Modifies class?               Class implements interface   No
  Lambda friendly               No                           Yes

### Simple rule

``` text
Comparable
    ↓
"What is the natural/default order of this object?"

Comparator
    ↓
"How do I want to sort this object right now?"
```

------------------------------------------------------------------------

# 🧪 14. Employee Sorting Example

A practical example:

``` java
List<Employee> employees = new ArrayList<>();

employees.add(
        new Employee(
                101,
                "Vamsi",
                60000,
                LocalDate.of(2024, 5, 10)
        )
);

employees.add(
        new Employee(
                102,
                "Rahul",
                50000,
                LocalDate.of(2023, 2, 15)
        )
);

employees.add(
        new Employee(
                103,
                "Anil",
                70000,
                LocalDate.of(2025, 1, 20)
        )
);
```

Sort by salary:

``` java
employees.sort(
        Comparator.comparing(Employee::getSalary)
);
```

Sort by name:

``` java
employees.sort(
        Comparator.comparing(Employee::getName)
);
```

Sort by joining date:

``` java
employees.sort(
        Comparator.comparing(Employee::getJoiningDate)
);
```

Multi-level sorting:

``` java
employees.sort(
        Comparator.comparing(Employee::getSalary)
                .thenComparing(Employee::getName)
                .thenComparing(Employee::getJoiningDate)
);
```

------------------------------------------------------------------------

# 🧩 15. What Happens During `sort()`?

When you write:

``` java
employees.sort(salaryComparator);
```

Java's sorting mechanism repeatedly needs to compare two employees.

Conceptually:

``` text
Employee A
     +
Employee B
     ↓
salaryComparator.compare(A, B)
     ↓
Compare salaries
     ↓
negative / zero / positive
     ↓
Sorting algorithm decides their order
```

You provide the **comparison rule**.

Java's sorting algorithm handles the actual rearrangement.

------------------------------------------------------------------------

# 🎤 16. Interview Questions

## Easy

### 1. What are Generics?

Generics provide type-safe and reusable code by allowing types to be
specified as parameters.

### 2. What is `Comparable`?

`Comparable` defines the natural ordering of objects through
`compareTo()`.

### 3. What is `Comparator`?

`Comparator` defines custom ordering through `compare()`.

### 4. What does a negative result from `compare()` mean?

The first object should come before the second according to that
comparator.

------------------------------------------------------------------------

## Medium

### 5. Why use Comparator instead of Comparable?

When multiple sorting strategies are required without changing the
domain class.

### 6. What is `Comparator.comparing()`?

It is a factory method that creates a comparator based on a key
extracted from each object.

Example:

``` java
Comparator.comparing(Employee::getSalary)
```

### 7. What does `thenComparing()` do?

It adds a secondary comparison rule when the previous comparison
considers two objects equal.

------------------------------------------------------------------------

## Hard

### 8. What is the difference between natural and custom ordering?

Natural ordering is defined by the class through `Comparable`; custom
ordering is supplied externally through `Comparator`.

### 9. Why is `Double.compare()` preferred for comparing doubles?

It provides a proper comparison result while handling floating-point
comparison semantics better than naïve subtraction.

Prefer:

``` java
Double.compare(e1.getSalary(), e2.getSalary());
```

instead of:

``` java
(int)(e1.getSalary() - e2.getSalary());
```

### 10. Explain this:

``` java
employees.sort(
        Comparator.comparing(Employee::getSalary)
                .thenComparing(Employee::getName)
);
```

Answer:

> Employees are first sorted by salary. If two employees have the same
> salary, their names are compared to determine their relative order.

------------------------------------------------------------------------

# 🧭 17. Day 15 Learning Path

``` text
Generics
   ↓
Generic Classes
   ↓
Generic Methods
   ↓
Generic Interfaces
   ↓
Wildcards
   ↓
Comparable
   ↓
Comparator
   ↓
Lambda Comparator
   ↓
Method References
   ↓
Multi-Level Sorting
   ↓
Real-World Employee Sorting
```

------------------------------------------------------------------------

# 💡 18. Key Takeaways

-   Generics provide **compile-time type safety**.
-   `<T>` represents a type parameter.
-   `?` represents an unknown type.
-   `? extends T` is commonly used for producers.
-   `? super T` is commonly used for consumers.
-   `Comparable` defines **natural ordering**.
-   `Comparator` defines **custom ordering**.
-   `compare()` returns a negative, zero, or positive value based on
    ordering.
-   `Comparator.comparing()` reduces comparison boilerplate.
-   `Employee::getSalary` is a method reference.
-   `thenComparing()` creates multi-level sorting.
-   `reversed()` can be used for descending order.
-   These concepts are heavily used with Java Collections and backend
    business logic.

------------------------------------------------------------------------

# 🚀 Practice Tasks

### Task 1

Sort employees by salary in ascending order.

### Task 2

Sort employees by salary in descending order.

### Task 3

Sort employees alphabetically by name.

### Task 4

Sort employees by joining date.

### Task 5

Sort by salary and then name.

### Task 6

Sort by salary descending, then name ascending.

### Task 7

Create an `Employee` class implementing `Comparable<Employee>` and
define salary as its natural ordering.

### Task 8

Create three separate `Comparator<Employee>` strategies:

``` text
SalaryComparator
NameComparator
JoiningDateComparator
```

### Task 9

Rewrite an anonymous `Comparator` using a lambda.

### Task 10

Rewrite a lambda comparator using `Comparator.comparing()`.

------------------------------------------------------------------------

# 📁 Suggested Day 15 Structure

``` text
day-15/
└── src/
    ├── Generics/
    │   ├── BoxMain.java
    │   ├── GenericInterface.java
    │   ├── GenericMethod.java
    │   └── PairMain.java
    │
    ├── Sorting/
    │   ├── ComparableExample.java
    │   ├── ComparatorExample.java
    │   ├── Employee.java
    │   └── EmployeeSorting.java
    │
    └── WildCard/
        ├── GenericInheritance.java
        ├── LowerBoundExample.java
        ├── LowerBoundInheritance.java
        ├── UpperBoundExample.java
        └── WildcardExample.java
```

------------------------------------------------------------------------

# 🏆 Day 15 Completion Checklist

-   [x] Generic classes
-   [x] Generic methods
-   [x] Generic interfaces
-   [x] Wildcards
-   [x] Upper bounds
-   [x] Lower bounds
-   [x] Comparable
-   [x] Comparator
-   [x] Lambda expressions with Comparator
-   [x] Method references
-   [x] `Comparator.comparing()`
-   [x] `thenComparing()`
-   [x] Sorting custom objects
-   [x] Employee sorting practice

------------------------------------------------------------------------

<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 1200 220">

<defs>
  <linearGradient id="g" x1="0" x2="1">
    <stop offset="0%" stop-color="#22c55e"/>
    <stop offset="50%" stop-color="#06b6d4"/>
    <stop offset="100%" stop-color="#8b5cf6"/>
  </linearGradient>
</defs>

<rect width="1200" height="220" rx="28" fill="#0b1020"/>

<circle cx="105" cy="110" r="52"
        fill="none"
        stroke="url(#g)"
        stroke-width="7"
        stroke-dasharray="12 10">
  <animateTransform
    attributeName="transform"
    type="rotate"
    from="0 105 110"
    to="360 105 110"
    dur="6s"
    repeatCount="indefinite"/>
</circle>

<path d="M78 110 l18 18 l38 -45"
      fill="none"
      stroke="#4ade80"
      stroke-width="9"
      stroke-linecap="round"
      stroke-linejoin="round">
  <animate
    attributeName="stroke-dasharray"
    from="0,100"
    to="100,0"
    dur="1.2s"
    fill="freeze"/>
</path>

<text x="190" y="100"
      font-family="Arial, sans-serif"
      font-size="38"
      font-weight="700"
      fill="#ffffff">
  DAY 15 COMPLETE
</text>

<text x="190" y="145"
      font-family="Arial, sans-serif"
      font-size="23"
      fill="#b9c7e6">
  Generics mastered • Sorting logic practiced • Git-ready
</text>

<text x="190" y="180"
      font-family="Arial, sans-serif"
      font-size="17"
      fill="#7dd3fc">
  Next stop: Day 16 → keep building.
</text>

</svg>

### ☕ Learn → Code → Test → Understand → Repeat

**Java 30-Day Bootcamp \| Day 15**
:::
