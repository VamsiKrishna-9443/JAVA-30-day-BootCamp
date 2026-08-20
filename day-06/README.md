# Day 06 — Packages, Access Modifiers, Static & Final

## 📌 Topics Covered

Today I learned and practiced:

* Packages
* Imports
* Access Modifiers
* `static`
* `final`
* Encapsulation
* Utility classes

## 🎬 Day 06 Animation

![Day 06 Java Animation](./assets/day-06-animation.gif)

> Animation demonstrating the concepts and implementation completed on Day 06.

## 🎯 Objectives

* Understand packages and imports.
* Learn Java access modifiers.
* Understand `static` members.
* Understand the `final` keyword.
* Build reusable utility classes.
* Practice clean package organization and encapsulation.

## 📂 Project Structure

```text
day-06/
├── assets/
│   └── day-06-animation.gif
├── src/
│   ├── mathutils/
│   │   └── MathUtils.java
│   └── utils/
│       └── StringUtils.java
└── README.md
```

## 🔑 Key Learnings

### Packages

Packages organize related Java classes and help avoid naming conflicts.

```java
package utils;
```

### Import

```java
import utils.StringUtils;
```

### Access Modifiers

| Modifier    | Access                                                |
| ----------- | ----------------------------------------------------- |
| `public`    | Accessible from anywhere                              |
| `private`   | Accessible only within the same class                 |
| `protected` | Accessible within the package and through inheritance |
| default     | Accessible within the same package                    |

### Static

A `static` member belongs to the class rather than an object.

```java
public static String reverse(String str) {
    return new StringBuilder(str).reverse().toString();
}
```

### Final

`final` prevents reassignment or modification depending on how it is used.

```java
final int MAX_VALUE = 100;
```

## 🛠️ Practical Implementation

Created utility classes:

### MathUtils

* Mathematical utility methods
* Static methods
* Reusable functionality

### StringUtils

* Reverse a string
* Check palindrome
* Count characters
* Static utility methods
* Private constructor to prevent unnecessary object creation

## 🧠 Problems Faced

* Understanding static vs instance members.
* Understanding access between different packages.
* Understanding the purpose of a private constructor.
* Understanding when to use `final`.

## ✅ Outcome

Successfully completed **Day 06** and practiced:

* Packages
* Imports
* Access modifiers
* Static members
* Final keyword
* Encapsulation
* Utility class design

## 📊 Day 06 Status

**Status:** ✅ Completed
**Day:** 06/30
**Week:** 1 — Java Fundamentals & Problem Solving

## 🔗 GitHub Commit

`Add Day 06 - Packages, Access Modifiers, Static & Final`

> Add your GitHub commit URL here after pushing the changes.
