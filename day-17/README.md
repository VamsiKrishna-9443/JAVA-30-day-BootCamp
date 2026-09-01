<div align="center">

<img src="https://capsule-render.vercel.app/api?type=waving&color=0:F7A41D,100:2ECC71&height=220&section=header&text=Day%2017%20%7C%20Streams%20API&fontSize=50&fontColor=ffffff&animation=fadeIn&fontAlignY=38&desc=filter%20%E2%86%92%20map%20%E2%86%92%20flatMap%20%E2%86%92%20sorted%20%E2%86%92%20distinct%20%E2%86%92%20collect%20%E2%86%92%20reduce%20%E2%86%92%20group&descAlignY=58&descAlign=50" width="100%"/>

![Java](https://img.shields.io/badge/Java-17+-orange?style=for-the-badge&logo=openjdk&logoColor=white)
![Day](https://img.shields.io/badge/Day-17%2F30-blue?style=for-the-badge)
![Topic](https://img.shields.io/badge/Topic-Streams%20API-brightgreen?style=for-the-badge)
![Backend Critical](https://img.shields.io/badge/Backend%20Interview-Critical-red?style=for-the-badge)

<img src="https://readme-typing-svg.demolab.com/?font=Fira+Code&weight=600&size=24&duration=2800&pause=900&color=2ECC71&center=true&vCenter=true&multiline=true&repeat=true&width=700&height=90&lines=employees.stream();.filter(e+-%3E+e.getSalary()+%3E+60000);.map(Employee%3A%3AgetName);.collect(Collectors.toList())%3B" alt="Streams Pipeline Typing Animation" />


</div>

---

## 📖 Table of Contents
- [Why Streams Matter for Backend](#-why-streams-matter-for-backend-engineers)
- [The Stream Pipeline Model](#-the-stream-pipeline-model)
- [Concept 1: filter()](#-concept-1-filter)
- [Concept 2: map()](#-concept-2-map)
- [Concept 3: flatMap()](#-concept-3-flatmap)
- [Concept 4: sorted()](#-concept-4-sorted)
- [Concept 5: distinct()](#-concept-5-distinct)
- [Concept 6: collect()](#-concept-6-collect)
- [Concept 7: reduce()](#-concept-7-reduce)
- [Concept 8: Grouping (groupingBy)](#-concept-8-grouping-groupingby)
- [Project Structure](#-project-structure)
- [How Each Concept Is Used](#-how-each-concept-is-used-in-this-project)
- [8 Transformation Exercises](#-8-transformation-exercises-solved)
- [How to Run](#-how-to-run)
- [Key Takeaways](#-key-takeaways)
- [What's Next](#-whats-next--day-18)

---

## 💼 Why Streams Matter for Backend Engineers

In real backend code, you almost never loop with `for` anymore. You transform collections — DB query results, API responses, DTOs — declaratively:

```java
// ❌ Old imperative style
List<String> names = new ArrayList<>();
for (Employee e : employees) {
    if (e.getSalary() > 50000) {
        names.add(e.getName().toUpperCase());
    }
}

// ✅ Stream style — reads like the requirement itself
List<String> names = employees.stream()
    .filter(e -> e.getSalary() > 50000)
    .map(e -> e.getName().toUpperCase())
    .collect(Collectors.toList());
```

This isn't stylistic preference — Spring Boot services, REST controllers mapping entities to DTOs, and data-processing layers are built on exactly this pattern. **This is the single most-asked topic in Java backend interviews.**

---

## 🔄 The Stream Pipeline Model

<div align="center">

```
   SOURCE                INTERMEDIATE OPS                    TERMINAL OP
┌──────────┐      ┌──────┐   ┌──────┐   ┌────────┐        ┌──────────┐
│Collection│ ───▶ │filter│──▶│ map  │──▶│ sorted │  ───▶  │ collect()│ ──▶ Result
└──────────┘      └──────┘   └──────┘   └────────┘        └──────────┘
   list.stream()   lazy       lazy        lazy              EAGER
                  (nothing runs until a terminal op is called)
```

</div>

> 🔑 **The core mental model:** intermediate operations (`filter`, `map`, `sorted`, `distinct`) are **lazy** — they just build up a pipeline. Nothing executes until a **terminal operation** (`collect`, `reduce`, `forEach`) is called. This is why streams can be efficient even on large data.

---

## 🧩 Concept 1: `filter()`

> Keeps only elements that match a `Predicate` (a condition returning `boolean`). Removes everything else from the stream.

```java
List<Employee> highEarners = employees.stream()
    .filter(e -> e.getSalary() > 60000)
    .collect(Collectors.toList());
```

**Signature:** `Stream<T> filter(Predicate<T> predicate)` — input and output types stay the same.

---

## 🧩 Concept 2: `map()`

> Transforms each element into something else — a **1-to-1** conversion. Input type can differ from output type.

```java
List<String> names = employees.stream()
    .map(Employee::getName)   // Employee -> String
    .collect(Collectors.toList());

List<Double> bonuses = employees.stream()
    .map(e -> e.getSalary() * 0.1)  // Employee -> Double
    .collect(Collectors.toList());
```

**Signature:** `<R> Stream<R> map(Function<T, R> mapper)`

---

## 🧩 Concept 3: `flatMap()`

> Transforms each element into a **stream of elements**, then flattens all those streams into one. Essential for "list of lists" scenarios.

```java
// Each Employee has List<String> skills — we want ONE flat list of all skills
List<String> allSkills = employees.stream()
    .flatMap(e -> e.getSkills().stream())   // Stream<List<String>> -> Stream<String>
    .distinct()
    .collect(Collectors.toList());
```

**`map` vs `flatMap`:**

| | `map()` | `flatMap()` |
|---|---|---|
| Input → Output | 1 element → 1 element | 1 element → many elements (flattened) |
| Use case | `Employee → String` | `Employee → List<String> → flattened stream of Strings` |

---

## 🧩 Concept 4: `sorted()`

> Orders stream elements — natural order (`Comparable`) or a custom `Comparator`.

```java
// Natural order
List<String> sortedNames = names.stream().sorted().collect(Collectors.toList());

// Custom: by salary descending
List<Employee> bySalaryDesc = employees.stream()
    .sorted(Comparator.comparing(Employee::getSalary).reversed())
    .collect(Collectors.toList());

// Multi-level: department, then name
employees.stream()
    .sorted(Comparator.comparing(Employee::getDepartment)
        .thenComparing(Employee::getName))
    .collect(Collectors.toList());
```

---

## 🧩 Concept 5: `distinct()`

> Removes duplicates using `equals()`. For custom objects, `equals()`/`hashCode()` must be overridden correctly or `distinct()` won't behave as expected.

```java
List<String> uniqueDepartments = employees.stream()
    .map(Employee::getDepartment)
    .distinct()
    .collect(Collectors.toList());
```

---

## 🧩 Concept 6: `collect()`

> The most common **terminal operation** — gathers stream elements into a `List`, `Set`, `Map`, or custom structure via `Collectors`.

```java
List<String> asList   = stream.collect(Collectors.toList());
Set<String> asSet     = stream.collect(Collectors.toSet());
String joined         = stream.collect(Collectors.joining(", "));
Map<String,Double> map = employees.stream()
    .collect(Collectors.toMap(Employee::getName, Employee::getSalary));
```

---

## 🧩 Concept 7: `reduce()`

> Combines all stream elements into a **single value** using a `BinaryOperator`. Think: sum, max, min, product, string concatenation.

```java
double totalSalary = employees.stream()
    .map(Employee::getSalary)
    .reduce(0.0, Double::sum);

Optional<Employee> topEarner = employees.stream()
    .reduce((e1, e2) -> e1.getSalary() > e2.getSalary() ? e1 : e2);
```

> ⚠️ Note the return type: the no-identity overload returns `Optional<T>` — because if the stream is empty, there's no result. This connects directly back to what we learned on **Day 18** about `Optional`.

---

## 🧩 Concept 8: Grouping (`groupingBy`)

> The most powerful `Collector` — buckets stream elements into a `Map<K, List<V>>` based on a classifier function. This is your **GROUP BY** in SQL, expressed in Java.

```java
Map<String, List<Employee>> byDepartment = employees.stream()
    .collect(Collectors.groupingBy(Employee::getDepartment));

// Grouped + counted (like SQL: SELECT dept, COUNT(*) GROUP BY dept)
Map<String, Long> countByDepartment = employees.stream()
    .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

// Grouped + averaged
Map<String, Double> avgSalaryByDept = employees.stream()
    .collect(Collectors.groupingBy(Employee::getDepartment,
        Collectors.averagingDouble(Employee::getSalary)));
```

---

## 📁 Project Structure

```
day-17/
└── src/
    └── Stream/
        ├── Employees.java              # Model class — name, department, salary, skills
        │
        ├── FilterExample.java          # filter() — condition-based selection
        ├── MapExample.java             # map() — 1-to-1 transformation
        ├── FlatMapExample.java         # flatMap() — flatten nested lists
        ├── SortedExample.java          # sorted() — natural & custom Comparators
        ├── DistinctExample.java        # distinct() — dedupe via equals()/hashCode()
        ├── CollectExample.java         # collect() — toList, toSet, toMap, joining
        ├── ReduceExample.java          # reduce() — sum, max, aggregate to single value
        ├── Group.java                  # groupingBy() — basic grouping
        └── GroupingCountExample.java   # groupingBy() + counting() — grouped analytics
```

---

## 🔗 How Each Concept Is Used in This Project

| File | Concepts Applied |
|---|---|
| `Employees.java` | Model backing every exercise — `name`, `department`, `salary`, `skills` (List) |
| `FilterExample.java` | `filter()` → e.g., employees earning above a threshold |
| `MapExample.java` | `map()` → extract/transform fields (names, salary × bonus rate) |
| `FlatMapExample.java` | `flatMap()` → flatten each employee's `List<String> skills` into one company-wide skill stream |
| `SortedExample.java` | `sorted()` → order employees by salary, name, or department |
| `DistinctExample.java` | `distinct()` → unique department list across all employees |
| `CollectExample.java` | `collect()` → gather results into `List`, `Set`, joined `String`, or `Map` |
| `ReduceExample.java` | `reduce()` → total salary, highest earner, aggregate metrics |
| `Group.java` | `groupingBy()` → bucket employees by department |
| `GroupingCountExample.java` | `groupingBy()` + `counting()` → headcount per department |

**The throughline — Employee Analytics:** every file operates on the same `Employees` model, so together they form one cohesive analytics pipeline: filter who qualifies → map to the field you need → flatten nested skill lists → sort and dedupe → group by department → collect or reduce into a final report. This mirrors exactly what a Spring Boot `@Service` layer does when turning repository query results into a response DTO.

---

## ✅ 8 Transformation Exercises Solved

| # | Exercise | Stream Ops Combined |
|---|---|---|
| 1 | Employees earning above ₹X, names only, uppercase | `filter` → `map` |
| 2 | All unique skills across the company | `flatMap` → `distinct` |
| 3 | Employees sorted by salary (highest first) | `sorted` (reversed Comparator) |
| 4 | Total company salary spend | `map` → `reduce` |
| 5 | Headcount per department | `groupingBy` → `counting` |
| 6 | Average salary per department | `groupingBy` → `averagingDouble` |
| 7 | Comma-separated list of all employee names | `map` → `collect(joining)` |
| 8 | Highest-paid employee overall | `reduce` (max by salary) |

---

## ▶️ How to Run

```bash
# From day-17/src/
javac Stream/*.java

java Stream.FilterExample
java Stream.MapExample
java Stream.FlatMapExample
java Stream.SortedExample
java Stream.DistinctExample
java Stream.CollectExample
java Stream.ReduceExample
java Stream.Group
java Stream.GroupingCountExample
```

---

## 💡 Key Takeaways

- ✅ Streams are **lazy** — nothing runs until a terminal operation (`collect`, `reduce`, `forEach`) is called
- ✅ `map()` is 1-to-1; `flatMap()` is 1-to-many-flattened — mixing these up is the #1 Streams mistake
- ✅ `distinct()` depends entirely on correct `equals()`/`hashCode()` for custom objects
- ✅ `groupingBy()` is your Java equivalent of SQL's `GROUP BY` — combine with `counting()`, `averagingDouble()`, `summingDouble()` for real analytics
- ✅ `reduce()` without an identity returns `Optional<T>` — ties directly back to Day 18's `Optional` learning
- ✅ Real feature built today: an **Employee Analytics engine** answering 8 real business questions declaratively — no manual loops

<div align="center">

![Progress](https://progress-bar.dev/100/?width=500&color=2ecc71&title=Day%2017%20complete)

</div>

---

## 🔮 What's Next — Day 18

<div align="center">

**Day 17 ✅ → Day 18 🔜**

From transforming collections with Streams into safe null-handling with `Optional`, and precise date math with `LocalDate`, `Duration`, and `Period`.

![Progress](https://img.shields.io/badge/Progress-17%2F30%20Days-success?style=for-the-badge)
![Next](https://img.shields.io/badge/Next-Day%2018-yellow?style=for-the-badge)

</div>

<img src="https://capsule-render.vercel.app/api?type=waving&color=0:2ECC71,100:F7A41D&height=150&section=footer&animation=fadeIn"/>

<div align="center">

⭐ **Part of the [JAVA-30-day-BootCamp](../../) series** ⭐

</div>
