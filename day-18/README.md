<div align="center">

<img src="https://capsule-render.vercel.app/api?type=waving&color=0:2ECC71,100:3498DB&height=220&section=header&text=Day%2018%20%7C%20Optional%20%26%20java.time&fontSize=44&fontColor=ffffff&animation=fadeIn&fontAlignY=38&desc=Optional%20%E2%86%92%20LocalDate%20%E2%86%92%20LocalDateTime%20%E2%86%92%20Duration%20%E2%86%92%20Period&descAlignY=58&descAlign=50" width="100%"/>

![Java](https://img.shields.io/badge/Java-17+-orange?style=for-the-badge&logo=openjdk&logoColor=white)
![Day](https://img.shields.io/badge/Day-18%2F30-blue?style=for-the-badge)
![Topic](https://img.shields.io/badge/Topic-Optional%20%7C%20java.time-brightgreen?style=for-the-badge)

<img src="https://readme-typing-svg.demolab.com/?font=Fira+Code&weight=600&size=22&duration=2800&pause=900&color=3498DB&center=true&vCenter=true&multiline=true&repeat=true&width=700&height=90&lines=Optional%3CString%3E+u+%3D+Optional.of(name)%3B;Period.between(joinDate%2C+today)%3B;Duration.between(now%2C+expiry)%3B" alt="Optional and Time Typing Animation" />

<img src="https://progress-bar.dev/60/?width=500&color=babaca&title=Day%2018%20of%2030" alt="progress bar"/>

</div>

---

## 📖 Table of Contents
- [Why This Day Matters](#-why-this-day-matters)
- [Concept 1: Optional](#-concept-1-optional)
- [Concept 2: LocalDate & LocalDateTime](#-concept-2-localdate--localdatetime)
- [Concept 3: Duration & Period](#-concept-3-duration--period)
- [Project Structure](#-project-structure)
- [How Each Concept Is Used](#-how-each-concept-is-used-in-this-project)
- [How to Run](#-how-to-run)
- [Key Takeaways](#-key-takeaways)
- [What's Next](#-whats-next--day-19)

---

## 🤔 Why This Day Matters

Two of the most common bugs in real Java applications are:
1. **`NullPointerException`** — from methods that return `null` instead of a real value.
2. **Manual date math gone wrong** — off-by-one errors, ignoring leap years, mixing up time zones.

Java's answer to both is a pair of modern APIs:

| Problem | Old Way (fragile) | Modern Way (safe) |
|---|---|---|
| "This value might not exist" | Return `null`, hope the caller checks | Return `Optional<T>`, force the caller to handle it |
| "How much time between these dates?" | Manual `Calendar` math, millisecond subtraction | `Duration` / `Period` — readable, correct, leap-year-aware |

Today's build proves it with two real calculators: **how long has an employee worked here?** and **how many days are left on a user's subscription?**

---

## 🧩 Concept 1: `Optional`

> `Optional<T>` is a container object that **may or may not hold a non-null value**. It forces you to explicitly handle the "no value" case instead of accidentally hitting a `NullPointerException` three method calls later.

### Creating an Optional

```java
Optional<String> present = Optional.of("Vamsi");        // must be non-null
Optional<String> empty    = Optional.empty();            // deliberately empty
Optional<String> safe     = Optional.ofNullable(maybeNullValue); // null-safe
```

### Reading the value safely

| Method | Behavior |
|---|---|
| `.get()` | Returns value **or throws** `NoSuchElementException` if empty — avoid using this directly |
| `.isPresent()` / `.isEmpty()` | Boolean check before acting |
| `.ifPresent(consumer)` | Runs code only if a value exists |
| `.orElse(default)` | Returns value, or a fallback if empty |
| `.orElseGet(supplier)` | Like `orElse`, but the fallback is computed lazily |
| `.orElseThrow()` | Returns value, or throws `NoSuchElementException` if empty |
| `.orElseThrow(() -> new CustomException())` | Returns value, or throws **your own** exception |

### From the code (`OptionalExample.java`)

```java
Optional<String> employee = Optional.of("Vamsi");
String employeeValue = employee.orElseThrow();
System.out.println("Using orElseThrow(): " + employeeValue);
// Output: Using orElseThrow(): Vamsi

Optional<String> employee1 = Optional.empty();
String employeeValue1 = employee1.orElseThrow();
// Throws: java.util.NoSuchElementException: No value present
```

> ⚠️ **Lesson learned today:** `orElseThrow()` on an empty `Optional` throws immediately — this is by design. It's how `Optional` forces you to *decide* what happens on absence, instead of silently returning `null`.

---

## 🧩 Concept 2: `LocalDate` & `LocalDateTime`

> Part of `java.time` (introduced in Java 8), these classes represent dates and date-times **without timezone confusion**, and are **immutable** — every "change" returns a new object.

| Class | Represents | Example |
|---|---|---|
| `LocalDate` | Date only (no time) | `2026-09-01` |
| `LocalDateTime` | Date + time | `2026-09-01T15:45:00` |

### Common operations

```java
LocalDate today = LocalDate.now();
LocalDate joiningDate = LocalDate.of(2022, 3, 15);

LocalDate future = today.plusMonths(6);
LocalDate past   = today.minusYears(1);

boolean isBefore = joiningDate.isBefore(today);
boolean isAfter  = today.isAfter(joiningDate);
```

```java
LocalDateTime now = LocalDateTime.now();
LocalDateTime meeting = LocalDateTime.of(2026, 9, 5, 10, 30);
```

---

## 🧩 Concept 3: `Duration` & `Period`

> Both measure the **gap between two time points** — the difference is granularity.

| Class | Best for | Unit |
|---|---|---|
| `Period` | Human-scale gaps: years, months, days | Calendar-based |
| `Duration` | Machine-scale gaps: hours, minutes, seconds, nanos | Time-based |

```java
// Period — "how many years/months/days" (great for tenure, age)
Period tenure = Period.between(joiningDate, today);
System.out.println(tenure.getYears() + "y " + tenure.getMonths() + "m " + tenure.getDays() + "d");

// Duration — "how many hours/minutes" (great for countdowns, session length)
Duration remaining = Duration.between(LocalDateTime.now(), expiryDateTime);
System.out.println(remaining.toDays() + " days, " + remaining.toHoursPart() + " hours left");
```

---

## 📁 Project Structure

```
day-18/
└── src/
    ├── LocalDate_and_Time/
    │   ├── Employee.java                    # Model: name, joiningDate (LocalDate)
    │   ├── EmployeeTenureCalculator.java     # Uses Period.between() to compute tenure
    │   ├── User.java                         # Model: name, subscriptionExpiry (LocalDateTime)
    │   └── UserSubscriptionCalculator.java   # Uses Duration.between() for days remaining
    │
    └── Optional/
        └── OptionalExample.java              # of(), empty(), orElseThrow(), and more
```

---

## 🔗 How Each Concept Is Used in This Project

| File | Concepts Applied |
|---|---|
| `Employee.java` | Stores `LocalDate joiningDate` as a field |
| `EmployeeTenureCalculator.java` | `LocalDate.now()` + `Period.between()` → prints years/months/days employed |
| `User.java` | Stores `LocalDateTime subscriptionExpiry` as a field |
| `UserSubscriptionCalculator.java` | `LocalDateTime.now()` + `Duration.between()` → prints time left on subscription; wraps lookups in `Optional` to safely handle a missing/expired user |
| `OptionalExample.java` | Standalone playground for every `Optional` method — `of`, `empty`, `ofNullable`, `orElse`, `orElseGet`, `orElseThrow` |

**The throughline:** `Optional` protects the *lookup* (does this employee/user exist?), while `LocalDate`/`Duration`/`Period` handle the *math* (how long have they been here / how long until it expires?). Together they replace two classic sources of bugs — null checks and date arithmetic — with expressive, safe, one-line calls.

---

## ▶️ How to Run

```bash
# From day-18/src/
javac LocalDate_and_Time/*.java Optional/*.java

java LocalDate_and_Time.EmployeeTenureCalculator
java LocalDate_and_Time.UserSubscriptionCalculator
java Optional.OptionalExample
```

---

## 💡 Key Takeaways

- ✅ `Optional` replaces defensive `null` checks with expressive, chainable calls
- ✅ `orElseThrow()` throws on an empty `Optional` — decide your fallback deliberately, don't call it blindly
- ✅ `LocalDate` / `LocalDateTime` are **immutable** — `plusDays()` etc. return a new object, they don't mutate the original
- ✅ Use `Period` for calendar-scale gaps (tenure, age), `Duration` for clock-scale gaps (countdowns, session time)
- ✅ Real feature built today: an **Employee Tenure Calculator** and a **User Subscription Calculator** — not just syntax practice

<div align="center">

![Progress](https://progress-bar.dev/100/?width=500&color=2ecc71&title=Day%2018%20complete)

</div>

---

## 🔮 What's Next — Day 19

<div align="center">

**Day 18 ✅ → Day 19 🔜**

Moving from `java.time` into the next chapter of the bootcamp.

![Progress](https://img.shields.io/badge/Progress-18%2F30%20Days-success?style=for-the-badge)
![Next](https://img.shields.io/badge/Next-Day%2019-yellow?style=for-the-badge)

</div>

<img src="https://capsule-render.vercel.app/api?type=waving&color=0:3498DB,100:2ECC71&height=150&section=footer&animation=fadeIn"/>

<div align="center">

⭐ **Part of the [JAVA-30-day-BootCamp](../../) series** ⭐

</div>
