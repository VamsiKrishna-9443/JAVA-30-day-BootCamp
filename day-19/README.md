<div align="center">

# 📅 Day 19: File Handling, Path & Buffered I/O

![Java](https://img.shields.io/badge/Java-17+-orange?style=for-the-badge&logo=openjdk&logoColor=white)
![Day](https://img.shields.io/badge/Day-19%2F30-blue?style=for-the-badge)
![Topic](https://img.shields.io/badge/Topic-Files%20%7C%20Path%20%7C%20Serialization-brightgreen?style=for-the-badge)

### 🎯 Today's Mission
**Master `Path`, `Files`, `BufferedReader`/`BufferedWriter`, try-with-resources, and Java Serialization — then use them to build a real Employee CSV Import/Export system.**

![Progress](https://img.shields.io/badge/Progress-19%2F30%20Days%20(63%25)-success?style=for-the-badge)

</div>

![](https://img.shields.io/badge/⚡-INITIALIZING-orange?style=for-the-badge)
![](https://img.shields.io/badge/Path-✓-brightgreen?style=flat-square)
![](https://img.shields.io/badge/Files-✓-brightgreen?style=flat-square)
![](https://img.shields.io/badge/BufferedIO-✓-brightgreen?style=flat-square)
![](https://img.shields.io/badge/Serialization-✓-brightgreen?style=flat-square)
![](https://img.shields.io/badge/CSV_System-✓-brightgreen?style=flat-square)


![](https://img.shields.io/badge/🚀-DAY_19_START-blue?style=for-the-badge)

## 📖 Table of Contents
- [Why This Day Matters](#-why-this-day-matters)
- [Concept 1: Path](#-concept-1-path)
- [Concept 2: Files](#-concept-2-files)
- [Concept 3: Buffered I/O & Try-With-Resources](#-concept-3-buffered-io--try-with-resources)
- [Concept 4: Serialization](#-concept-4-serialization)
- [Project Structure](#-project-structure)
- [How Each Concept Is Used](#-how-each-concept-is-used-in-this-project)
- [How to Run](#-how-to-run)
- [Key Takeaways](#-key-takeaways)
- [What's Next](#-whats-next--day-20)

---

## 🤔 Why This Day Matters

Two of the most common needs in real Java applications are:
1. **Persisting data** — reading and writing files instead of losing everything when the program exits.
2. **Doing it safely** — not leaking file handles, not letting one bad row crash an entire import.

Java's answer to both is a pair of modern APIs plus a language feature:

| Problem | Old Way (fragile) | Modern Way (safe) |
|---|---|---|
| "Where is this file?" | Raw string paths, manual separator handling | `Path` — platform-safe, composable |
| "Read/write this file" | Manual `FileInputStream` boilerplate | `Files` — one-line `readString()`, `writeString()`, `copy()` |
| "Forgot to close the stream" | Manual `finally { close() }` | Try-with-resources — closes automatically |
| "Save an object's exact state" | Manually serialize every field to text | `Serializable` + `ObjectOutputStream` |

Today's build proves it with a real feature: an **Employee CSV Import/Export system** with validation, error handling, and a backup step.

---

## 🧩 Concept 1: `Path`

> `Path` represents **where a file or directory is located**. It does not read or write anything by itself — it just describes a location.

```text
Path  = Where is it?
Files = What should I do with it?
```

### Creating and using a Path

```java
Path path = Path.of("data", "employees", "employees.csv");

path.getFileName();      // employees.csv
path.getParent();        // data/employees
path.getRoot();          // null for relative paths
path.toAbsolutePath();   // full absolute path
path.resolve("backup");  // combines paths safely
path.normalize();        // removes . and .. segments
```

> ⚠️ **Lesson learned today:** `getRoot()` returns `null` for a relative path like `Path.of("data", "employees.csv")` — it only returns something for absolute paths (e.g. `C:\`). This is by design, not a bug.

---

## 🧩 Concept 2: `Files`

> `Files` is the utility class that actually **performs operations** — create, read, write, copy, move, delete — on the location a `Path` describes.

| Method | Behavior |
|---|---|
| `exists()` / `isRegularFile()` / `isDirectory()` | Check what's at the path |
| `createFile()` / `createDirectories()` | Create files or full directory chains |
| `readString()` / `writeString()` | Whole-file text in one call |
| `readAllLines()` / `write(path, lines)` | Line-based text I/O |
| `copy()` / `move()` | Duplicate or relocate a file (`REPLACE_EXISTING` to overwrite) |
| `delete()` / `deleteIfExists()` | Remove a file safely |
| `newBufferedReader()` / `newBufferedWriter()` | Hand off to buffered I/O for larger files |

```java
Files.createDirectories(Path.of("data", "employees"));
Files.writeString(path, "101,Vamsi,50000");
List<String> lines = Files.readAllLines(path);
Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
```

---

## 🧩 Concept 3: Buffered I/O & Try-With-Resources

> `BufferedReader`/`BufferedWriter` wrap raw streams with an in-memory buffer, so line-by-line text I/O doesn't hit the disk on every call.

```java
try (BufferedReader reader = Files.newBufferedReader(path)) {
    String line;
    while ((line = reader.readLine()) != null) {
        System.out.println(line);
    }
} // reader.close() is called automatically, even on exception
```

> ⚠️ **Lesson learned today:** try-with-resources is what makes this safe — without it, a forgotten `close()` leaks file handles. `readLine()` returns `null` at end-of-file, which is how the loop knows to stop.

---

## 🧩 Concept 4: Serialization

> Serialization converts an object's **entire state into a byte stream** so it can be saved and later reconstructed — as opposed to CSV, which is text-based and human-readable.

```java
class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    private transient String sessionToken; // excluded from serialization
}

// Serialize
try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("employee.ser"))) {
    out.writeObject(employee);
}

// Deserialize
try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("employee.ser"))) {
    Employee restored = (Employee) in.readObject();
}
```

| CSV | Serialization |
|---|---|
| Text-based, human-readable | Binary, object-state oriented |
| Easy to inspect and exchange | Used to store/restore exact Java object state |

---

## 📁 Project Structure

```
day-19/
├── README.md
├── src
│   └── main
│       └── java
│           └── day19
│               ├── files/FileDemo.java
│               ├── path/PathDemo.java
│               ├── bufferedio/BufferedIODemo.java
│               ├── serialization/
│               │   ├── Employee.java
│               │   └── SerializationDemo.java
│               └── employee/
│                   ├── Employee.java
│                   ├── EmployeeCsvExporter.java
│                   ├── EmployeeCsvImporter.java
│                   └── EmployeeApp.java
└── data
    ├── files/
    ├── buffered/
    ├── serialization/
    └── employees/
        ├── employees.csv
        └── employees-backup.csv
```

---

## 🔗 How Each Concept Is Used in This Project

| File | Concepts Applied |
|---|---|
| `PathDemo.java` | `Path.of()`, `resolve()`, `normalize()`, `getParent()`/`getRoot()` |
| `FileDemo.java` | `Files.createDirectories()`, `readString()`, `writeString()`, `copy()`, `move()`, `delete()` |
| `BufferedIODemo.java` | `newBufferedReader()`/`newBufferedWriter()` with try-with-resources |
| `SerializationDemo.java` / `Employee.java` | `Serializable`, `serialVersionUID`, `transient`, `ObjectOutputStream`/`ObjectInputStream` |
| `EmployeeCsvExporter.java` | Writes `Employee` objects out to `employees.csv` |
| `EmployeeCsvImporter.java` | Reads and validates each CSV row into an `Employee`, skipping bad rows without stopping the import |
| `EmployeeApp.java` | Ties export → import → backup (`Files.copy` to `employees-backup.csv`) into one flow |

**The throughline:** `Path` describes *where*, `Files` performs the *operation*, buffered I/O makes text I/O *efficient and safe*, and serialization captures an object's *exact state* — together they turn raw data into a persistent, recoverable Employee CSV system.

---

## ▶️ How to Run

```bash
# From day-19/src/main/java/
javac day19/files/*.java day19/path/*.java day19/bufferedio/*.java day19/serialization/*.java day19/employee/*.java

java day19.path.PathDemo
java day19.files.FileDemo
java day19.bufferedio.BufferedIODemo
java day19.serialization.SerializationDemo
java day19.employee.EmployeeApp
```

---

## 💡 Key Takeaways

- ✅ `Path` represents a location; `Files` performs operations on it — they're always used together
- ✅ `Files.createDirectories()` creates the full parent chain, unlike `createDirectory()`
- ✅ Try-with-resources auto-closes `BufferedReader`/`BufferedWriter`, even when an exception is thrown
- ✅ `readLine()` returns `null` at end-of-file — that's the loop's exit signal, not an error
- ✅ Serialization saves an object's exact state as bytes; `transient` fields are deliberately excluded
- ✅ Real feature built today: an **Employee CSV Import/Export system** with row-level validation, error handling, and an automatic backup — not just syntax practice

<div align="center">

![Complete](https://img.shields.io/badge/Day%2019-Complete%20✅-success?style=for-the-badge)

</div>

```text
   ┌─────────────────────────────────┐
   │  💾 SAVING PROGRESS...           │
   └─────────────────────────────────┘
         ▓ ░░░░░░░░░░░░░░░░░░░  10%
         ▓▓▓▓▓▓ ░░░░░░░░░░░░░  40%
         ▓▓▓▓▓▓▓▓▓▓▓▓ ░░░░░░░  70%
         ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓ 100%
         [ commit -m "Day 19 done" ]

   ╔═══════════════════════════════════╗
   ║       ✅  DAY 19 COMPLETE  ✅       ║
   ║  ✔ Path & Files mastered           ║
   ║  ✔ Buffered I/O + Try-With-        ║
   ║    Resources done                  ║
   ║  ✔ Serialization understood        ║
   ║  ✔ Employee CSV Import/Export      ║
   ║    built                           ║
   ╚═══════════════════════════════════╝
        [ XP +100 | Level: Day 19 ]
        ➜ Next stop → Day 20: Multithreading
```

---

## 🔮 What's Next — Day 20

<div align="center">

**Day 19 ✅ → Day 20 🔜**

Moving from file persistence into Multithreading & Concurrency.

![Progress](https://img.shields.io/badge/Progress-19%2F30%20Days-success?style=for-the-badge)
![Next](https://img.shields.io/badge/Next-Day%2020-yellow?style=for-the-badge)

</div>

---

<div align="center">

⭐ **Part of the [JAVA-30-day-BootCamp](../../) series** ⭐

</div>
