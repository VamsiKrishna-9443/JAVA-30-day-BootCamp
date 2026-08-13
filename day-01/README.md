# Day 01 — Java Setup & Basics

**Repository:** JAVA-30-day-BootCamp  
**Status:** ✅ Completed

---

## 📌 Objective

Set up the Java development environment and build a working understanding of core Java fundamentals — JVM, JDK, JRE, class structure, variables, data types, and conditional logic.

---

## 🛠️ Environment Setup

| Tool | Status |
|---|---|
| JDK | ✅ Installed |
| IntelliJ IDEA | ✅ Configured |
| Git | ✅ Configured |
| GitHub Repository | ✅ Connected |

---

## 📚 Concepts Covered

### JDK, JRE, JVM

- **JDK (Java Development Kit)** — Toolset for writing and compiling Java programs.
- **JRE (Java Runtime Environment)** — Provides the libraries and environment needed to run Java applications.
- **JVM (Java Virtual Machine)** — Executes compiled bytecode and enables Java's platform independence.

### Java Basics

- Class structure and the `main()` method
- Variables and data types
- Reading user input with `Scanner`
- Conditional statements: `if`, `if-else`, `else-if`

---

## 💻 Programs Implemented

| Program | Description |
|---|---|
| `HelloWorld.java` | Prints a greeting message |
| `SUM.java` | Calculates the sum of two numbers |
| `SwapUsingTemp.java` | Swaps two numbers using a temporary variable |
| `SwapWithoutTemp.java` | Swaps two numbers without a temporary variable |
| `EvenOrOdd.java` | Checks whether a number is even or odd |
| `LargestAmongThree.java` | Finds the largest among three numbers |

---

## 📂 Project Structure

```
day-01/
├── README.md
├── src/
│   ├── HelloWorld.java
│   ├── SUM.java
│   ├── SwapUsingTemp.java
│   ├── SwapWithoutTemp.java
│   ├── EvenOrOdd.java
│   └── LargestAmongThree.java
└── test-output/
    ├── hello-world.png
    ├── sum-output.png
    ├── swap-temp-output.png
    ├── swap-no-temp-output.png
    ├── even-odd-output.png
    └── largest-three-output.png
```

---

## 🧪 Verification

All programs were:

- ✅ Compiled successfully in IntelliJ IDEA
- ✅ Executed without runtime errors
- ✅ Captured as output screenshots stored in `test-output/`

---

## ⚠️ Issues Encountered & Fixes

**1. Git remote configuration**  
Used an incorrect placeholder path initially — resolved by running Git commands from the project root directory.

**2. Git branch rename error**

```bash
# ❌ Incorrect
git branch - M main

# ✅ Correct
git branch -M main
```

**3. Missing Scanner import**

```java
import java.util.Scanner;
```

---

## 📝 Self-Assessment

**What I learned:**
- Java program structure
- Variables and data types
- User input handling
- Conditional statements
- Basic problem-solving logic
- Git workflow (`add` → `commit` → `push`)

**Areas to improve:**
- Follow Java naming conventions consistently
- Write reusable utility methods
- Practice more edge cases in input validation

---

## 🔧 Git Commands Used

```bash
git add .
git commit -m "Day 01 completed: Java setup and basic programs"
git push
```

---

## ⏱️ Time Spent

| Activity | Duration |
|---|---|
| Environment setup | 30 min |
| Concept learning | 45 min |
| Hands-on coding | 90 min |
| Testing & verification | 30 min |
| GitHub documentation | 20 min |
| **Total** | **~3 hr 35 min** |

---

## ✅ Completion Checklist

- [✅] JDK installed
- [x] IntelliJ IDEA configured
- [x] Git configured
- [x] GitHub connected
- [x] Hello World completed
- [x] Sum program completed
- [x] Swap using temporary variable completed
- [x] Swap without temporary variable completed
- [x] Even/Odd program completed
- [x] Largest among three completed
- [x] Test output screenshots added
- [x] Code pushed to GitHub

---

## 🎯 Final Status

**Day 01 — Successfully Completed ✅**

This day laid the foundation for upcoming modules: OOP, Collections, Streams, problem-solving, JDBC, and Spring Boot backend development.
