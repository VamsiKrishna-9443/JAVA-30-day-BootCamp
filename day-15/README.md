<div align="center">

<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 1200 300" width="100%" role="img" aria-label="Java Day 15 animated banner">
<defs>
  <linearGradient id="day15bg" x1="0" y1="0" x2="1" y2="1">
    <stop offset="0%" stop-color="#090d1a"/>
    <stop offset="50%" stop-color="#111a33"/>
    <stop offset="100%" stop-color="#071b2b"/>
  </linearGradient>
  <linearGradient id="day15accent" x1="0" x2="1">
    <stop offset="0%" stop-color="#8b5cf6"/>
    <stop offset="50%" stop-color="#06b6d4"/>
    <stop offset="100%" stop-color="#22c55e"/>
  </linearGradient>
</defs>

<rect width="1200" height="300" rx="30" fill="url(#day15bg)"/>

<circle cx="150" cy="150" r="82" fill="none" stroke="#243253" stroke-width="2"/>

<circle cx="150" cy="150" r="62"
     fill="none"
     stroke="url(#day15accent)"
     stroke-width="7"
     stroke-dasharray="18 14">
<animateTransform attributeName="transform"
                 type="rotate"
                 from="0 150 150"
                 to="360 150 150"
                 dur="7s"
                 repeatCount="indefinite"/>
</circle>

<text x="150" y="169"
   text-anchor="middle"
   font-family="Arial, sans-serif"
   font-size="58"
   font-weight="800"
   fill="#ffffff">
J15
<animate attributeName="opacity"
        values="0.65;1;0.65"
        dur="2.2s"
        repeatCount="indefinite"/>
</text>

<text x="285" y="105"
   font-family="Arial, sans-serif"
   font-size="46"
   font-weight="800"
   fill="#ffffff">
JAVA DAY 15
</text>

<text x="285" y="150"
   font-family="Arial, sans-serif"
   font-size="25"
   fill="#c7d2fe">
Generics • Comparable • Comparator • Sorting
</text>

<text x="285" y="188"
   font-family="Arial, sans-serif"
   font-size="18"
   fill="#93c5fd">
Type-safe code. Flexible sorting. Practical Java.
</text>

<rect x="285" y="220" width="700" height="7" rx="4" fill="#1e293b"/>

<rect x="285" y="220" width="0" height="7" rx="4" fill="url(#day15accent)">
  <animate attributeName="width"
           values="0;700;700;0"
           keyTimes="0;0.45;0.8;1"
           dur="5s"
           repeatCount="indefinite"/>
</rect>

<circle cx="285" cy="223.5" r="8" fill="#67e8f9">
  <animate attributeName="cx"
           values="285;985;985;285"
           keyTimes="0;0.45;0.8;1"
           dur="5s"
           repeatCount="indefinite"/>
</circle>

<text x="285" y="262"
   font-family="Arial, sans-serif"
   font-size="16"
   fill="#64748b">
JAVA 30-DAY BOOTCAMP
</text>
</svg>

☕ Java Day 15 — Generics, Comparable & Comparator

A practical deep dive into type-safe reusable code and flexible object sorting

</div>

## 🎯 Day 15 Objective

Day 15 focuses on two important areas of Java development:

Generics --- writing reusable, type-safe code.

Object Sorting --- defining how custom objects should be ordered
using Comparable and Comparator.

The goal is not just to memorize syntax, but to understand why these
features exist, how Java uses them internally, and where they appear in
real applications.

## 📚 1. Generics

### What are Generics?

Generics allow a class, interface, or method to work with different data
types while maintaining compile-time type safety.

Without generics:

```java
List list = new ArrayList();

list.add("Java");
list.add(100);

String value = (String) list.get(1); // Runtime problem
```

With generics:

```java
List<String> names = new ArrayList<>();

names.add("Java");
// names.add(100); // Compile-time error
```

### Why Generics?

- Type safety
- Fewer explicit casts
- Reusable classes and methods
- Errors are detected at compile time
- Cleaner and more maintainable code

### Generic Class

```java
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

```java
Box<String> stringBox = new Box<>();
stringBox.setValue("Java");

Box<Integer> integerBox = new Box<>();
integerBox.setValue(100);
```

Here T is a type parameter.

Think of it as:

```
Box<T>
  |
  +-- T can become String
  +-- T can become Integer
  +-- T can become Employee
```

## 🧩 2. Generic Methods

A generic method can work with different types independently of the
class.

```java
public static <T> void printValue(T value) {
    System.out.println(value);
}
```

Usage:

```java
printValue("Java");
printValue(100);
printValue(25.5);
```

### Important syntax

```
<T>
```

appears before the return type:

```java
public static <T> void method(T value)
```

The first `<T>` declares the type parameter.

## 🔗 3. Generic Interfaces

Interfaces can also use type parameters.

```java
interface Pair<T, U> {

    T getFirst();

    U getSecond();
}
```

This makes the interface reusable with different combinations of types.

## 🃏 4. Wildcards

A wildcard is represented by:

```
?
```

It means:

"I don't know the exact type."

Example:

```java
List<?> list
```

This can refer to:

```
List<String>
List<Integer>
List<Employee>
```

### Upper Bound

```java
List<? extends Number>
```

Means:

The list contains Number or a subclass of Number.

Examples:

```
List<Integer>
List<Double>
```

### Lower Bound

```java
List<? super Integer>
```

Means:

The list can accept Integer or one of Integer's supertypes.

### Easy memory rule

```
? extends  → read / producer
? super    → write / consumer
```

A common memory aid is:

**PECS --- Producer Extends, Consumer Super.**

## ⚖️ 5. Comparable

### What is Comparable?

Comparable is used when a class defines its own natural ordering.

Example:

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

Now Employee has a default sorting rule:

Employees are naturally ordered by salary.

Sorting:

```java
Collections.sort(employees);
```

or:

```java
employees.sort(null);
```

can use that natural ordering.

### How compareTo() Works

```java
int result = e1.compareTo(e2);
```

The result is interpreted by its sign:

```
negative → e1 comes before e2
0        → e1 and e2 are equal for this ordering
positive → e1 comes after e2
```

You do not need to return exactly -1, 0, or 1.

## 🔀 6. Comparator

### What is Comparator?

Comparator is used when we want to define a custom/external sorting
rule.

For example, the same Employee class can be sorted by:

- Salary
- Name
- Joining date
- ID
- Multiple fields

without changing the Employee class.

### Lambda Comparator

```java
Comparator<Employee> salaryComparator =
        (e1, e2) ->
                Double.compare(
                        e1.getSalary(),
                        e2.getSalary()
                );
```

This means:

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

Then:

```java
employees.sort(salaryComparator);
```

## 🧠 7. Understanding the Lambda

This:

```java
Comparator<Employee> salaryComparator =
        (e1, e2) ->
                Double.compare(
                        e1.getSalary(),
                        e2.getSalary()
                );
```

is effectively providing the implementation of:

```java
int compare(Employee e1, Employee e2)
```

The traditional anonymous-class version is:

```java
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

## 🏗️ 8. Comparator.comparing()

Instead of writing the comparison manually:

```java
Comparator<Employee> salaryComparator =
        (e1, e2) ->
                Double.compare(
                        e1.getSalary(),
                        e2.getSalary()
                );
```

Java provides:

```java
Comparator<Employee> salaryComparator =
        Comparator.comparing(Employee::getSalary);
```

### What does Employee::getSalary mean?

It is a method reference.

It tells Java:

"When comparing two Employees, use their salary value."

Conceptually:

```
Employee A → getSalary()
Employee B → getSalary()
        ↓
Compare the two salary values
```

## 🥇 9. Multi-Level Sorting

One of the most useful Comparator features is chained sorting.

```java
employees.sort(
        Comparator.comparing(Employee::getSalary)
                .thenComparing(Employee::getName)
                .thenComparing(Employee::getJoiningDate)
);
```

The priority is:

```
1. Salary
      ↓
2. If salary is equal → Name
      ↓
3. If name is also equal → Joining Date
```

Example:

```
Employee      Salary     Name
--------------------------------
Rahul         50000      Rahul
Anil          50000      Anil
Vamsi         60000      Vamsi
```

After sorting:

```
Anil          50000
Rahul         50000
Vamsi         60000
```

Salary is the primary key.

Name becomes the secondary key only when salary is equal.

Joining date becomes the third-level key only when salary and name are
both equal.

## 🔽 10. Descending Order

By default:

```java
Comparator.comparing(Employee::getSalary)
```

sorts in ascending order.

For descending order:

```java
Comparator.comparing(Employee::getSalary).reversed()
```

Example:

```java
employees.sort(
        Comparator.comparing(Employee::getSalary)
                .reversed()
);
```

For multi-level sorting:

```java
employees.sort(
        Comparator.comparing(Employee::getSalary)
                .reversed()
                .thenComparing(Employee::getName)
);
```

Be careful about where reversed() is applied, because reversing
the whole comparator chain and reversing an individual field can produce
different ordering rules.

### 🔍 Where you put reversed() changes the result

This is one of the most common mistakes with multi-level sorting. `reversed()`
only flips whatever it is directly attached to — it does not know or care
about the rest of the chain.

Consider this data:

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

`reversed()` is called last, on the *entire* combined comparator. That
flips everything — including the tie-break — as one unit:

```
Vamsi         60000
Rahul         50000
Anil          50000
```

Salary is now descending, and within the 50000 tie, Rahul comes before
Anil — the name ordering was flipped too, because `reversed()` wraps
the whole chain built so far.

**Case B — reverse only the salary key**

```java
employees.sort(
        Comparator.comparing(Employee::getSalary)
                .reversed()
                .thenComparing(Employee::getName)
);
```

Here `reversed()` is attached only to the salary comparator, *before*
`thenComparing()` is added. Salary is descending, but the name
tie-break that follows is untouched — it stays ascending:

```
Vamsi         60000
Anil          50000
Rahul         50000
```

Salary is still descending (same as Case A), but now Anil comes before
Rahul in the tie — the opposite order from Case A, because the name
comparator was never reversed.

**The rule:**

```
Comparator.comparing(A).thenComparing(B).reversed()
   → reverses A AND B together (reverses the final combined result)

Comparator.comparing(A).reversed().thenComparing(B)
   → reverses only A; B still breaks ties in its own natural order
```

If you want salary descending but name ascending as the tie-break
(a very common real-world request — "highest paid first, alphabetical
for ties"), Case B is what you want. If you want the entire sorted list
flipped end-to-end, Case A is what you want. They are not the same
comparator, even though both start from the same two fields.

## 📅 11. Sorting by LocalDate

For an employee:

```java
private LocalDate joiningDate;
```

You can sort using:

```java
Comparator.comparing(Employee::getJoiningDate)
```

Earlier dates come first in ascending order.

Example:

```
2023-02-15
2024-05-10
2025-01-20
```

This is useful for:

- Employee joining date
- Order date
- Booking date
- Transaction date
- Application submission date

## 🏢 12. Real-World Business Usage

These concepts appear frequently in backend applications.

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

## 🔥 13. Comparable vs Comparator

| Feature | Comparable | Comparator |
|---|---|---|
| Package | java.lang | java.util |
| Main method | compareTo() | compare() |
| Ordering | Natural/default | Custom |
| Defined inside class? | Yes | Usually outside |
| Multiple sorting strategies | Not convenient | Excellent |
| Modifies class? | Class implements interface | No |
| Lambda friendly | No | Yes |

### Simple rule

```
Comparable
    ↓
"What is the natural/default order of this object?"

Comparator
    ↓
"How do I want to sort this object right now?"
```

## 🧪 14. Employee Sorting Example

A practical example:

```java
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

```java
employees.sort(
        Comparator.comparing(Employee::getSalary)
);
```

Sort by name:

```java
employees.sort(
        Comparator.comparing(Employee::getName)
);
```

Sort by joining date:

```java
employees.sort(
        Comparator.comparing(Employee::getJoiningDate)
);
```

Multi-level sorting:

```java
employees.sort(
        Comparator.comparing(Employee::getSalary)
                .thenComparing(Employee::getName)
                .thenComparing(Employee::getJoiningDate)
);
```

## 🧩 15. What Happens During sort()?

When you write:

```java
employees.sort(salaryComparator);
```

Java's sorting mechanism repeatedly needs to compare two employees.

Conceptually:

```
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

You provide the comparison rule.

Java's sorting algorithm handles the actual rearrangement.

## 🎤 16. Interview Questions

### Easy

**1. What are Generics?**

Generics provide type-safe and reusable code by allowing types to be
specified as parameters.

**2. What is Comparable?**

Comparable defines the natural ordering of objects through
`compareTo()`.

**3. What is Comparator?**

Comparator defines custom ordering through `compare()`.

**4. What does a negative result from compare() mean?**

The first object should come before the second according to that
comparator.

### Medium

**5. Why use Comparator instead of Comparable?**

When multiple sorting strategies are required without changing the
domain class.

**6. What is Comparator.comparing()?**

It is a factory method that creates a comparator based on a key
extracted from each object.

Example:

```java
Comparator.comparing(Employee::getSalary)
```

**7. What does thenComparing() do?**

It adds a secondary comparison rule when the previous comparison
considers two objects equal.

### Hard

**8. What is the difference between natural and custom ordering?**

Natural ordering is defined by the class through Comparable; custom
ordering is supplied externally through Comparator.

**9. Why is Double.compare() preferred for comparing doubles?**

It provides a proper comparison result while handling floating-point
comparison semantics better than naïve subtraction.

Prefer:

```java
Double.compare(e1.getSalary(), e2.getSalary());
```

instead of:

```java
(int)(e1.getSalary() - e2.getSalary());
```

**10. Explain this:**

```java
employees.sort(
        Comparator.comparing(Employee::getSalary)
                .thenComparing(Employee::getName)
);
```

Answer:

Employees are first sorted by salary. If two employees have the same
salary, their names are compared to determine their relative order.

**11. What's the difference between `.thenComparing(B).reversed()` and `.reversed().thenComparing(B)`?**

`.thenComparing(B).reversed()` reverses the whole combined comparator —
both the primary key and the tie-break are flipped together. `.reversed()`
placed before `.thenComparing(B)` reverses only the comparator it's
directly attached to; anything chained afterward keeps its own natural
direction. Placement matters because `reversed()` only affects the
comparator instance it's called on at that point in the chain, not the
comparator that hasn't been built yet.

## 🧭 17. Day 15 Learning Path

```
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

## 💡 18. Key Takeaways

- Generics provide compile-time type safety.
- `<T>` represents a type parameter.
- `?` represents an unknown type.
- `? extends T` is commonly used for producers.
- `? super T` is commonly used for consumers.
- Comparable defines natural ordering.
- Comparator defines custom ordering.
- `compare()` returns a negative, zero, or positive value based on
  ordering.
- `Comparator.comparing()` reduces comparison boilerplate.
- `Employee::getSalary` is a method reference.
- `thenComparing()` creates multi-level sorting.
- `reversed()` can be used for descending order — but where you place
  it in the chain determines whether it reverses one key or the entire
  combined ordering.

These concepts are heavily used with Java Collections and backend
business logic.

## 🚀 Practice Tasks

**Task 1**

Sort employees by salary in ascending order.

**Task 2**

Sort employees by salary in descending order.

**Task 3**

Sort employees alphabetically by name.

**Task 4**

Sort employees by joining date.

**Task 5**

Sort by salary and then name.

**Task 6**

Sort by salary descending, then name ascending.

**Task 7**

Create an Employee class implementing `Comparable<Employee>` and
define salary as its natural ordering.

**Task 8**

Create three separate `Comparator<Employee>` strategies:

```
SalaryComparator
NameComparator
JoiningDateComparator
```

**Task 9**

Rewrite an anonymous Comparator using a lambda.

**Task 10**

Rewrite a lambda comparator using `Comparator.comparing()`.

**Task 11**

Write two versions of a salary + name comparator — one where
`reversed()` flips the entire chain, and one where it flips only the
salary key. Print both outputs and confirm they produce different
orderings for employees who share a salary.

## 📁 Suggested Day 15 Structure

```
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

## 🏆 Day 15 Completion Checklist

- [ ] Generic classes
- [ ] Generic methods
- [ ] Generic interfaces
- [ ] Wildcards
- [ ] Upper bounds
- [ ] Lower bounds
- [ ] Comparable
- [ ] Comparator
- [ ] Lambda expressions with Comparator
- [ ] Method references
- [ ] Comparator.comparing()
- [ ] thenComparing()
- [ ] reversed() placement (whole-chain vs single-key)
- [ ] Sorting custom objects
- [ ] Employee sorting practice

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

<div align="center">

<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 1200 250" width="100%" role="img" aria-label="Day 15 complete animation">
<defs>
  <linearGradient id="completebg" x1="0" y1="0" x2="1" y2="1">
    <stop offset="0%" stop-color="#081018"/>
    <stop offset="55%" stop-color="#0f1f2b"/>
    <stop offset="100%" stop-color="#10152a"/>
  </linearGradient>
  <linearGradient id="completeaccent" x1="0" x2="1">
    <stop offset="0%" stop-color="#22c55e"/>
    <stop offset="50%" stop-color="#06b6d4"/>
    <stop offset="100%" stop-color="#8b5cf6"/>
  </linearGradient>
</defs>

<rect width="1200" height="250" rx="30" fill="url(#completebg)"/>

<circle cx="120" cy="125" r="62"
     fill="none"
     stroke="url(#completeaccent)"
     stroke-width="7"
     stroke-dasharray="12 10">
<animateTransform attributeName="transform"
                 type="rotate"
                 from="0 120 125"
                 to="360 120 125"
                 dur="6s"
                 repeatCount="indefinite"/>
</circle>

<path d="M88 125 l20 20 l43 -52"
   fill="none"
   stroke="#4ade80"
   stroke-width="10"
   stroke-linecap="round"
   stroke-linejoin="round"
   stroke-dasharray="0 120">
<animate attributeName="stroke-dasharray"
        values="0 120;120 0;120 0"
        dur="2.2s"
        repeatCount="indefinite"/>
</path>

<text x="215" y="105"
   font-family="Arial, sans-serif"
   font-size="42"
   font-weight="800"
   fill="#ffffff">
DAY 15 COMPLETE
</text>

<text x="215" y="148"
   font-family="Arial, sans-serif"
   font-size="23"
   fill="#cbd5e1">
Generics mastered • Sorting logic practiced • Git-ready
</text>

<text x="215" y="184"
   font-family="Arial, sans-serif"
   font-size="17"
   fill="#7dd3fc">
Learn → Code → Test → Understand → Repeat
</text>

<text x="215" y="215"
   font-family="Arial, sans-serif"
   font-size="15"
   fill="#64748b">
NEXT STOP: DAY 16
</text>
</svg>

☕ Learn → Code → Test → Understand → Repeat

Java 30-Day Bootcamp | Day 15

</div>
