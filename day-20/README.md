<!-- ================= START ANIMATION ================= -->
<p align="center">
  <img src="https://readme-typing-svg.herokuapp.com?font=Fira+Code&size=28&pause=1000&color=00FF9C&center=true&vCenter=true&width=700&lines=Day+20+%7C+Multithreading+%26+Concurrency;Thread+%7C+Runnable+%7C+Callable;ExecutorService+%7C+Synchronization;Concurrent+Collections+%26+Race+Conditions" alt="Typing SVG" />
</p>

<p align="center">
  <img src="https://user-images.githubusercontent.com/74038190/212284100-561aa473-3905-4a80-b561-0d28506553ee.gif" width="500">
</p>

<!-- ===================================================== -->

<h1 align="center">🧵 Day 20 — Multithreading and Concurrency</h1>

<p align="center">
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" />
  <img src="https://img.shields.io/badge/Topic-Concurrency-blue?style=for-the-badge" />
  <img src="https://img.shields.io/badge/Bootcamp-Day%2020%2F30-success?style=for-the-badge" />
</p>

<p align="center">
  Part of the <a href="https://github.com/"><b>JAVA-30-day-BootCamp</b></a> series — building Java fundamentals from the ground up.
</p>

---

## 📌 Overview

Day 20 covers **Java's concurrency model** — how to run multiple tasks at the same time, coordinate them safely, and avoid the classic bugs that come from shared mutable state. The day ends with a hands-on **Concurrent Task Processor** and a written explanation of **race conditions**.

---

## 🗂️ Project Structure

```
day-20/
│
├── src/
│   ├── Thread/
│   │   ├── ThreadBasics.java          # Extending Thread class
│   │   └── ThreadLifecycleDemo.java   # NEW → RUNNABLE → RUNNING → TERMINATED
│   │
│   ├── Runnable/
│   │   ├── RunnableBasics.java        # Implementing Runnable interface
│   │   └── RunnableWithLambda.java    # Functional-style Runnable
│   │
│   ├── Callable/
│   │   ├── CallableBasics.java        # Callable<T> + Future<T>
│   │   └── CallableWithResult.java    # Returning computed values
│   │
│   ├── ExecutorService/
│   │   ├── FixedThreadPoolDemo.java   # Executors.newFixedThreadPool()
│   │   ├── CachedThreadPoolDemo.java  # Executors.newCachedThreadPool()
│   │   └── ScheduledExecutorDemo.java # Delayed / periodic tasks
│   │
│   ├── RaceCondition/
│   │   ├── UnsafeCounter.java         # Demonstrates the bug
│   │   └── SafeCounter.java           # Fixed using synchronization
│   │
│   ├── BlockingQueue/
│   │   └── ProducerConsumerDemo.java  # Producer-Consumer pattern
│   │
│   ├── ConcurrentCollections/
│   │   ├── ConcurrentHashMapDemo.java
│   │   └── CopyOnWriteArrayListDemo.java
│   │
│   ├── Exercise/
│   │   └── ConcurrentTaskProcessor.java   # 🎯 Main hands-on project
│   │
│   └── README.md                      # This file
│
└── out/                                # Compiled class files (IDE-generated)
```

**Why this structure?**
- Each concurrency concept gets its **own folder** so it can be studied and run in isolation.
- `RaceCondition/` deliberately pairs a **broken** version next to the **fixed** version — the best way to *see* the bug before understanding the fix.
- `Exercise/` holds the capstone project that ties every concept together.

---

## 🧠 Concepts in Detail

### 1️⃣ Thread

A `Thread` is the smallest unit of execution the JVM can schedule independently. Two ways to create one:

```java
class MyThread extends Thread {
    public void run() {
        System.out.println("Running in: " + Thread.currentThread().getName());
    }
}

MyThread t = new MyThread();
t.start(); // NEVER call run() directly — that runs on the main thread!
```

**Thread Lifecycle:**

```
NEW → RUNNABLE → RUNNING → (BLOCKED / WAITING / TIMED_WAITING) → TERMINATED
```

| State | Meaning |
|---|---|
| NEW | Thread object created, `start()` not yet called |
| RUNNABLE | Eligible to run, waiting for CPU |
| BLOCKED | Waiting to acquire a lock |
| WAITING / TIMED_WAITING | Waiting indefinitely / for a fixed time |
| TERMINATED | `run()` has completed |

---

### 2️⃣ Runnable

`Runnable` is the preferred way to define a task — it **decouples the task from the thread**, and allows extending other classes (Java has no multiple inheritance).

```java
Runnable task = () -> System.out.println("Task running on: " + Thread.currentThread().getName());
new Thread(task).start();
```

**Thread vs Runnable**

| Thread (extends) | Runnable (implements) |
|---|---|
| Uses up your one allowed superclass | Frees you to extend another class |
| Tightly couples task + thread | Decouples task from execution |
| Less flexible | Preferred, reusable across executors |

---

### 3️⃣ Callable

Unlike `Runnable`, `Callable<T>` can **return a value** and **throw checked exceptions** — essential when a task needs to produce a result.

```java
Callable<Integer> task = () -> {
    Thread.sleep(1000);
    return 42;
};

ExecutorService executor = Executors.newSingleThreadExecutor();
Future<Integer> future = executor.submit(task);
System.out.println("Result: " + future.get()); // blocks until ready
executor.shutdown();
```

---

### 4️⃣ ExecutorService

Manually creating threads doesn't scale. `ExecutorService` manages a **pool of reusable threads**, so you submit tasks instead of managing thread lifecycles yourself.

```java
ExecutorService executor = Executors.newFixedThreadPool(4);

for (int i = 1; i <= 10; i++) {
    int taskId = i;
    executor.submit(() -> System.out.println("Task " + taskId + " on " + Thread.currentThread().getName()));
}

executor.shutdown(); // no new tasks accepted, existing ones finish
```

**Common pool types:**

| Factory Method | Behavior |
|---|---|
| `newFixedThreadPool(n)` | Fixed number of reusable threads |
| `newCachedThreadPool()` | Grows/shrinks based on load |
| `newSingleThreadExecutor()` | One worker thread, tasks run sequentially |
| `newScheduledThreadPool(n)` | Runs tasks after a delay or periodically |

---

### 5️⃣ Synchronization

When multiple threads access shared **mutable** state, updates can interleave unpredictably. `synchronized` ensures only **one thread at a time** can execute a critical section.

```java
class Counter {
    private int count = 0;

    public synchronized void increment() {
        count++; // now atomic w.r.t. other synchronized calls
    }

    public int getCount() {
        return count;
    }
}
```

Synchronization can be applied to:
- **Methods** (`synchronized void method()`) — locks on `this`
- **Blocks** (`synchronized(lockObject) { ... }`) — finer-grained control
- **Static methods** — locks on the `Class` object itself

---

### 6️⃣ Concurrent Collections

Regular collections (`ArrayList`, `HashMap`) are **not thread-safe**. `java.util.concurrent` provides alternatives built for multi-threaded access without external synchronization:

| Regular | Concurrent Alternative | Notes |
|---|---|---|
| `HashMap` | `ConcurrentHashMap` | Segmented locking, high throughput |
| `ArrayList` | `CopyOnWriteArrayList` | Best for read-heavy, rare writes |
| `LinkedList` (as Queue) | `BlockingQueue` (e.g. `LinkedBlockingQueue`) | Built-in wait/notify for producer-consumer |

---

## ⚠️ Race Conditions — Explained

A **race condition** occurs when the correctness of a program depends on the **relative timing** of multiple threads accessing shared data — and that timing isn't guaranteed.

**Classic example — an unsafe counter:**

```java
class UnsafeCounter {
    private int count = 0;
    public void increment() { count++; }  // NOT atomic!
}
```

`count++` looks like one operation but is actually **three**:
1. Read `count` from memory
2. Add 1
3. Write the new value back

If two threads interleave between steps 1–3, one increment can be **lost**:

```
Thread A reads count = 5
Thread B reads count = 5
Thread A writes count = 6
Thread B writes count = 6   ← should have been 7!
```

**Fix — synchronize the critical section:**

```java
class SafeCounter {
    private int count = 0;
    public synchronized void increment() { count++; }
}
```

Now only one thread can execute `increment()` at a time, so the read-modify-write sequence completes atomically before another thread can start it.

**Other ways to avoid race conditions:**
- `AtomicInteger` / `AtomicLong` (lock-free, CAS-based)
- `ReentrantLock` for more control than `synchronized`
- Concurrent collections that internally handle safety
- Immutable objects — no shared mutable state, no race possible

---

## 🎯 Hands-On Project: Concurrent Task Processor

**Goal:** Build a task processor that accepts multiple jobs, executes them concurrently via `ExecutorService`, safely aggregates results using synchronization/concurrent collections, and demonstrates a race condition being fixed live.

**Features implemented:**
- ✅ Submits N tasks to a fixed thread pool
- ✅ Uses `Callable` to return per-task results
- ✅ Aggregates results into a `ConcurrentHashMap`
- ✅ Demonstrates unsafe vs safe counter side-by-side
- ✅ Graceful `executor.shutdown()` + `awaitTermination()`

```java
public class ConcurrentTaskProcessor {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        Map<Integer, String> results = new ConcurrentHashMap<>();

        for (int i = 1; i <= 10; i++) {
            final int taskId = i;
            executor.submit(() -> {
                String result = "Processed by " + Thread.currentThread().getName();
                results.put(taskId, result);
            });
        }

        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);

        results.forEach((id, res) -> System.out.println("Task " + id + ": " + res));
    }
}
```

---

## 📚 Key Takeaways

- Prefer `Runnable`/`Callable` + `ExecutorService` over raw `Thread` management
- Always shut down executors (`shutdown()` / `shutdownNow()`)
- Shared mutable state is the root of race conditions — synchronize it or avoid sharing it
- Reach for concurrent collections before hand-rolling synchronization
- `Callable` + `Future` when you need a **result**; `Runnable` when you don't

---

## ▶️ How to Run

```bash
cd day-20/src
javac Exercise/ConcurrentTaskProcessor.java
java Exercise.ConcurrentTaskProcessor
```

---

<!-- ================= END ANIMATION ================= -->
<p align="center">
  <img src="https://raw.githubusercontent.com/mayhemantt/mayhemantt/Update/svg/Bottom.svg" width="100%">
</p>

<p align="center">
  <img src="https://readme-typing-svg.herokuapp.com?font=Fira+Code&size=18&pause=1000&color=FFA500&center=true&vCenter=true&width=500&lines=%E2%9C%85+Day+20+Complete;Next+Up+%E2%86%92+Day+21" alt="Typing SVG" />
</p>

<p align="center">⭐ Part of the 30-Day Java Bootcamp — <a href="#">Back to main repo</a></p>
