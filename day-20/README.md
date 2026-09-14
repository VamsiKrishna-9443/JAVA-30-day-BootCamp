<!-- ================= START ANIMATION ================= -->
<p align="center">
  <img src="https://readme-typing-svg.herokuapp.com?font=Fira+Code&size=28&pause=1000&color=00FF9C&center=true&vCenter=true&width=700&lines=Day+20+%7C+Multithreading+%26+Concurrency;Thread+%7C+Runnable+%7C+Callable;ExecutorService+%7C+Synchronization;Concurrent+Collections+%26+Race+Conditions" alt="Typing SVG" />
</p>

<p align="center">
  <img src="https://user-images.githubusercontent.com/74038190/212284100-561aa473-3905-4a80-b561-0d28506553ee.gif" width="500" alt="Java animation">
</p>

<h1 align="center">🧵 Day 20 — Multithreading and Concurrency</h1>

<p align="center">
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java">
  <img src="https://img.shields.io/badge/Topic-Concurrency-blue?style=for-the-badge" alt="Concurrency">
  <img src="https://img.shields.io/badge/Bootcamp-Day%2020%2F30-success?style=for-the-badge" alt="Day 20 of 30">
</p>

<p align="center">
  Part of the <b>JAVA-30-day-BootCamp</b> series — building Java fundamentals from the ground up.
</p>

---

## 📚 Table of Contents

- [📌 Overview](#-overview)
- [🎯 Learning Objectives](#-learning-objectives)
- [🗂️ Project Structure](#️-project-structure)
- [🧠 Concepts in Detail](#-concepts-in-detail)
  - [1. Process and Thread](#1-process-and-thread)
  - [2. Creating a Thread](#2-creating-a-thread)
  - [3. Thread Lifecycle](#3-thread-lifecycle)
  - [4. Runnable](#4-runnable)
  - [5. Callable and Future](#5-callable-and-future)
  - [6. ExecutorService](#6-executorservice)
  - [7. Synchronization](#7-synchronization)
  - [8. Race Conditions](#8-race-conditions)
  - [9. Atomic Variables](#9-atomic-variables)
  - [10. Concurrent Collections](#10-concurrent-collections)
  - [11. BlockingQueue and Producer-Consumer](#11-blockingqueue-and-producer-consumer)
  - [12. Graceful Executor Shutdown](#12-graceful-executor-shutdown)
- [🎯 Hands-On Project](#-hands-on-project)
- [▶️ How to Run](#️-how-to-run)
- [📚 Key Takeaways](#-key-takeaways)
- [🔗 Useful Java APIs](#-useful-java-apis)

---

## 📌 Overview

Day 20 introduces Java's **multithreading and concurrency** model.

A normal Java program executes statements on one main thread. Multithreading allows multiple tasks to make progress concurrently. This is useful for:

- Running independent tasks at the same time.
- Improving application responsiveness.
- Processing multiple requests.
- Performing background work.
- Using available CPU resources efficiently.

Concurrency also introduces risks. When multiple threads access shared mutable data, the result may become unpredictable. Therefore, this day focuses not only on creating threads, but also on coordinating them safely.

---

## 🎯 Learning Objectives

By the end of this day, I should be able to:

1. Explain the difference between a process, a thread, and a task.
2. Create threads using `Thread` and `Runnable`.
3. Understand the thread lifecycle.
4. Use `Callable` and `Future` when a task must return a result.
5. Execute tasks using `ExecutorService` and thread pools.
6. Explain race conditions and critical sections.
7. Protect shared data using `synchronized`.
8. Use atomic variables and concurrent collections.
9. Implement the producer-consumer pattern with `BlockingQueue`.
10. Shut down executors correctly.

---

## 🗂️ Project Structure

```text
day-20/
│
├── src/
│   ├── Thread/
│   │   ├── ThreadBasics.java
│   │   └── ThreadLifecycleDemo.java
│   │
│   ├── Runnable/
│   │   ├── RunnableBasics.java
│   │   └── RunnableWithLambda.java
│   │
│   ├── Callable/
│   │   ├── CallableBasics.java
│   │   └── CallableWithResult.java
│   │
│   ├── ExecutorService/
│   │   ├── FixedThreadPoolDemo.java
│   │   ├── CachedThreadPoolDemo.java
│   │   └── ScheduledExecutorDemo.java
│   │
│   ├── RaceCondition/
│   │   ├── UnsafeCounter.java
│   │   └── SafeCounter.java
│   │
│   ├── BlockingQueue/
│   │   └── ProducerConsumerDemo.java
│   │
│   ├── ConcurrentCollections/
│   │   ├── ConcurrentHashMapDemo.java
│   │   └── CopyOnWriteArrayListDemo.java
│   │
│   ├── Exercise/
│   │   └── ConcurrentTaskProcessor.java
│   │
│   └── README.md
│
└── out/
```

Each folder isolates one concept so it can be studied and executed independently. The `RaceCondition` folder contains both an unsafe and a safe implementation, making the problem and its solution easy to compare.

---

## 🧠 Concepts in Detail

### 1. Process and Thread

A **process** is a running application with its own memory space and resources.

A **thread** is a smaller unit of execution inside a process. Threads in the same process share resources such as heap memory, but each thread has its own stack and execution path.

Example:

```text
Application / Process
│
├── Main Thread
├── Worker Thread 1
└── Worker Thread 2
```

Important points:

- A process is heavier than a thread.
- Threads share the process heap.
- Each thread has its own stack.
- Shared memory makes communication easy, but can create race conditions.

### 2. Creating a Thread

A thread can be created by extending the `Thread` class.

```java
class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println(
            "Running on: " + Thread.currentThread().getName()
        );
    }
}

public class ThreadBasics {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
    }
}
```

`start()` creates a new execution path and eventually calls `run()`.

Do not call `run()` directly when you want a new thread:

```java
thread.run();   // normal method call on the current thread
thread.start(); // starts a new thread
```

### 3. Thread Lifecycle

A Java thread moves through several states:

```text
NEW
  ↓
RUNNABLE
  ↓
BLOCKED / WAITING / TIMED_WAITING
  ↓
TERMINATED
```

| State | Meaning |
|---|---|
| `NEW` | Thread object exists, but `start()` has not been called. |
| `RUNNABLE` | Thread is ready to run or is running under the JVM scheduler. |
| `BLOCKED` | Thread is waiting to acquire a monitor lock. |
| `WAITING` | Thread is waiting indefinitely for another thread or action. |
| `TIMED_WAITING` | Thread is waiting for a specified amount of time. |
| `TERMINATED` | The `run()` method has completed. |

Useful methods:

- `start()` — starts the thread.
- `sleep()` — pauses the current thread for a period.
- `join()` — waits for another thread to finish.
- `isAlive()` — checks whether a thread is still running.
- `getState()` — returns the current thread state.

### 4. Runnable

`Runnable` represents a task that does not return a result.

It is usually preferred over extending `Thread` because it separates the **task** from the **thread** that executes it.

```java
Runnable task = () -> {
    System.out.println(
        "Task running on: " + Thread.currentThread().getName()
    );
};

Thread thread = new Thread(task);
thread.start();
```

Advantages:

- A class can still extend another class.
- The same task can be executed by different threads.
- It works naturally with `ExecutorService`.
- Lambda expressions make simple tasks concise.

### 5. Callable and Future

`Callable<T>` is similar to `Runnable`, but it can:

- Return a value.
- Throw checked exceptions.

`Future<T>` represents the result of an asynchronous computation.

```java
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableBasics {
    public static void main(String[] args) throws Exception {

        ExecutorService executor =
                Executors.newSingleThreadExecutor();

        Callable<Integer> task = () -> {
            Thread.sleep(1000);
            return 42;
        };

        Future<Integer> future = executor.submit(task);

        System.out.println("Result: " + future.get());

        executor.shutdown();
    }
}
```

Important methods:

- `submit()` — submits a task.
- `get()` — waits for and returns the result.
- `isDone()` — checks whether the task is complete.
- `cancel()` — attempts to cancel the task.

`future.get()` is a blocking operation. It pauses the calling thread until the result is available.

### 6. ExecutorService

Creating threads manually for every task is difficult to manage. `ExecutorService` provides a thread pool that reuses worker threads.

```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolDemo {
    public static void main(String[] args) {

        ExecutorService executor =
                Executors.newFixedThreadPool(4);

        for (int i = 1; i <= 10; i++) {
            int taskId = i;

            executor.submit(() -> {
                System.out.println(
                    "Task " + taskId + " running on "
                    + Thread.currentThread().getName()
                );
            });
        }

        executor.shutdown();
    }
}
```

Common executor types:

| Method | Purpose |
|---|---|
| `newFixedThreadPool(n)` | Uses a fixed number of worker threads. |
| `newSingleThreadExecutor()` | Executes tasks sequentially using one worker. |
| `newCachedThreadPool()` | Creates and reuses threads according to demand. |
| `newScheduledThreadPool(n)` | Runs delayed or periodic tasks. |

Why use a thread pool?

- Reduces the cost of creating threads repeatedly.
- Controls the number of concurrent tasks.
- Reuses existing threads.
- Simplifies task submission and shutdown.

### 7. Synchronization

A **critical section** is a part of code that accesses shared data and must not be executed by multiple threads at the same time.

The `synchronized` keyword allows only one thread at a time to enter a synchronized method or block protected by the same lock.

```java
class Counter {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public synchronized int getCount() {
        return count;
    }
}
```

Synchronization can be applied to:

```java
public synchronized void method() {
    // locks on this object
}
```

or:

```java
public void method() {
    synchronized (this) {
        // critical section
    }
}
```

A synchronized block can use a separate lock object:

```java
private final Object lock = new Object();

public void increment() {
    synchronized (lock) {
        count++;
    }
}
```

Synchronization provides:

- Mutual exclusion: only one thread enters the critical section.
- Visibility: changes made by one thread become visible to another thread using the same lock.

### 8. Race Conditions

A **race condition** happens when the correctness of a program depends on the unpredictable timing of multiple threads.

This code is unsafe:

```java
class UnsafeCounter {
    private int count = 0;

    public void increment() {
        count++;
    }
}
```

Although `count++` looks like one operation, it contains three steps:

1. Read the current value.
2. Add one.
3. Write the new value.

Possible execution:

```text
Thread A reads count = 5
Thread B reads count = 5
Thread A writes count = 6
Thread B writes count = 6
```

The expected result is `7`, but the actual result becomes `6`. One update is lost.

A synchronized solution:

```java
class SafeCounter {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public synchronized int getCount() {
        return count;
    }
}
```

Other solutions include:

- `AtomicInteger`
- `ReentrantLock`
- Concurrent collections
- Immutable objects
- Avoiding shared mutable state

### 9. Atomic Variables

Atomic classes provide thread-safe operations without manually writing synchronized blocks.

```java
import java.util.concurrent.atomic.AtomicInteger;

class AtomicCounter {
    private final AtomicInteger count = new AtomicInteger();

    public void increment() {
        count.incrementAndGet();
    }

    public int getCount() {
        return count.get();
    }
}
```

Common methods:

- `get()`
- `set()`
- `incrementAndGet()`
- `getAndIncrement()`
- `compareAndSet()`

Atomic classes are useful for simple shared values such as counters, flags, and sequence numbers.

### 10. Concurrent Collections

Normal collections such as `ArrayList` and `HashMap` are not automatically safe for concurrent modification.

Java provides concurrent alternatives:

| Normal Collection | Concurrent Alternative | Best Use |
|---|---|---|
| `HashMap` | `ConcurrentHashMap` | Shared key-value data |
| `ArrayList` | `CopyOnWriteArrayList` | Many reads and few writes |
| Queue implementation | `BlockingQueue` | Producer-consumer communication |

Example:

```java
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

Map<Integer, String> results = new ConcurrentHashMap<>();

results.put(1, "Completed");
results.put(2, "Pending");
```

`ConcurrentHashMap` allows multiple threads to read and update the map safely without locking the entire map for every operation.

### 11. BlockingQueue and Producer-Consumer

The producer-consumer pattern separates task creation from task processing.

- A producer adds tasks to a queue.
- A consumer takes tasks from the queue.
- The queue coordinates access between them.

```java
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerDemo {
    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<String> queue =
                new LinkedBlockingQueue<>(3);

        queue.put("Task 1");
        queue.put("Task 2");

        System.out.println(queue.take());
        System.out.println(queue.take());
    }
}
```

Important methods:

- `put()` — waits if the queue is full.
- `take()` — waits if the queue is empty.
- `offer()` — attempts to add without waiting indefinitely.
- `poll()` — attempts to remove without waiting indefinitely.

### 12. Graceful Executor Shutdown

An executor should be shut down after all required tasks are submitted.

```java
executor.shutdown();
```

`shutdown()`:

- Stops accepting new tasks.
- Allows already submitted tasks to finish.

To wait for completion:

```java
executor.shutdown();
executor.awaitTermination(5, TimeUnit.SECONDS);
```

`shutdownNow()` attempts to interrupt running tasks and returns tasks that were waiting in the queue. It should be used carefully.

---

## 🎯 Hands-On Project

### Concurrent Task Processor

The capstone project combines the concepts from this day.

### Goal

Build a task processor that:

- Submits multiple tasks to a fixed thread pool.
- Uses `Callable` to return task results.
- Stores results in a `ConcurrentHashMap`.
- Demonstrates an unsafe counter and a synchronized counter.
- Shuts down the executor gracefully.

Example:

```java
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConcurrentTaskProcessor {

    public static void main(String[] args)
            throws InterruptedException {

        ExecutorService executor =
                Executors.newFixedThreadPool(5);

        Map<Integer, String> results =
                new ConcurrentHashMap<>();

        for (int i = 1; i <= 10; i++) {
            final int taskId = i;

            executor.submit(() -> {
                String result =
                        "Processed by "
                        + Thread.currentThread().getName();

                results.put(taskId, result);
            });
        }

        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);

        results.forEach((id, result) ->
                System.out.println("Task " + id + ": " + result));
    }
}
```

### Expected Learning

This project demonstrates how to:

1. Submit work instead of manually creating every thread.
2. Execute several tasks concurrently.
3. Safely update shared result data.
4. Wait for tasks to complete.
5. Release executor resources correctly.

---

## ▶️ How to Run

From the `day-20` directory:

```bash
cd day-20/src
javac Exercise/ConcurrentTaskProcessor.java
java Exercise.ConcurrentTaskProcessor
```

If the project uses packages, compile and run using the correct package path or run the class directly from IntelliJ IDEA.

---

## 📚 Key Takeaways

- A thread is an execution path inside a process.
- Use `start()` to begin a new thread; calling `run()` directly does not create one.
- Prefer `Runnable` for tasks that do not return a result.
- Use `Callable` and `Future` when a task must return a result.
- Prefer `ExecutorService` for managing groups of tasks.
- Shared mutable state is a common source of race conditions.
- Use `synchronized`, atomic variables, or concurrent collections to protect shared data.
- Always shut down executors after use.
- Avoid unnecessary shared state whenever possible.

---

## 🔗 Useful Java APIs

- [`Thread`](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Thread.html)
- [`Runnable`](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Runnable.html)
- [`Callable`](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/concurrent/Callable.html)
- [`Future`](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/concurrent/Future.html)
- [`ExecutorService`](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/concurrent/ExecutorService.html)
- [`AtomicInteger`](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/concurrent/atomic/AtomicInteger.html)
- [`ConcurrentHashMap`](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/concurrent/ConcurrentHashMap.html)
- [`BlockingQueue`](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/concurrent/BlockingQueue.html)

---

<p align="center">
  <img src="https://raw.githubusercontent.com/mayhemantt/mayhemantt/Update/svg/Bottom.svg" width="100%" alt="Footer">
</p>

<p align="center">
  <b>✅ Day 20 Complete — Next Up → Day 21</b>
</p>
