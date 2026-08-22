<p align="center">
  <img src="https://readme-typing-svg.demolab.com?font=Fira+Code&size=26&duration=2500&pause=700&color=36BCF7&center=true&vCenter=true&width=850&lines=🚀+DAY+10+%7C+JAVA+OOP;Polymorphism+%7C+Abstract+Classes+%7C+Interfaces;Compile-Time+%7C+Runtime+Polymorphism;💳+Building+a+PaymentProcessor" alt="Day 10 Animation"/>
</p>

<p align="center">
  <img src="https://capsule-render.vercel.app/api?type=rect&color=gradient&height=3" width="90%" alt="Animated separator"/>
</p>

# 🚀 Day 10 – Polymorphism, Abstract Classes & Interfaces

## 🎯 Learning Objective

Learn how Java achieves **polymorphism** and how **abstract classes and interfaces** are used to create flexible and reusable designs.

### 📚 Topics Covered

```text
🔄 Polymorphism
   │
   ├── ⚡ Compile-Time Polymorphism
   │       └── Method Overloading
   │
   └── 🚀 Runtime Polymorphism
           └── Method Overriding

🧩 Abstract Classes
       ↓
🔌 Interfaces
       ↓
💳 PaymentProcessor
       ↓
💵 UPI
💳 Credit Card
🏦 Net Banking
```

---

# 🔄 1. Polymorphism

**Polymorphism** means **"many forms."**

In Java, polymorphism allows the same method name or reference to represent different behaviors.

```text
        Polymorphism
             │
      ┌──────┴──────┐
      ↓             ↓
Compile-Time    Runtime
      ↓             ↓
Overloading     Overriding
```

---

# ⚡ 2. Compile-Time Polymorphism

Compile-time polymorphism is achieved through **method overloading**.

Method overloading means having multiple methods with the same name but different parameter lists.

### Example

```java
class Calculator {

    int add(int a, int b) {
        return a + b;
    }

    int add(int a, int b, int c) {
        return a + b + c;
    }

    double add(double a, double b) {
        return a + b;
    }
}
```

Usage:

```java
Calculator calculator = new Calculator();

System.out.println(calculator.add(10, 20));
System.out.println(calculator.add(10, 20, 30));
System.out.println(calculator.add(10.5, 20.5));
```

### Why compile-time?

The compiler determines which overloaded method should be called based on the arguments.

```text
add(10, 20)
     ↓
int, int
     ↓
add(int, int)
```

---

# 🚀 3. Runtime Polymorphism

Runtime polymorphism is achieved through **method overriding**.

A child class provides its own implementation of a method defined in the parent class.

```java
class Animal {

    void sound() {
        System.out.println("Animal makes sound");
    }
}

class Dog extends Animal {

    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}
```

Now:

```java
Animal animal = new Dog();

animal.sound();
```

Output:

```text
Dog barks
```

The reference type is `Animal`, but the actual object is `Dog`.

```text
Animal reference
       ↓
     Dog object
       ↓
Dog.sound()
```

---

# 🧩 4. Abstract Class

An **abstract class** is a class declared using the `abstract` keyword.

It can contain:

* Abstract methods
* Concrete methods
* Variables
* Constructors
* Static members
* Instance members

Example:

```java
abstract class Vehicle {

    abstract void start();

    void stop() {
        System.out.println("Vehicle stopped");
    }
}
```

A child class must implement the abstract method:

```java
class Car extends Vehicle {

    @Override
    void start() {
        System.out.println("Car starts with key");
    }
}
```

### Important

An abstract class **cannot be instantiated directly**.

```java
// Not allowed
Vehicle vehicle = new Vehicle();
```

But we can create a reference:

```java
Vehicle vehicle = new Car();
```

---

# 🔌 5. Interface

An **interface** is a contract that defines behavior that implementing classes must provide.

```java
interface PaymentProcessor {

    void processPayment(double amount);
}
```

A class implements an interface using `implements`.

```java
class UpiPayment implements PaymentProcessor {

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing UPI payment: " + amount);
    }
}
```

### Interface Structure

```text
        PaymentProcessor
              │
       ┌──────┼──────┐
       ↓      ↓      ↓
      UPI   Card   NetBanking
```

---

# 💳 6. PaymentProcessor

The main practical task for Day 10 is to build a payment system with multiple implementations.

```text
                 💳 PaymentProcessor
                         │
          ┌──────────────┼──────────────┐
          ↓              ↓              ↓
     💵 UPI Payment   💳 Card       🏦 Net Banking
```

---

# 💵 UPI Payment

```java
class UpiPayment implements PaymentProcessor {

    @Override
    public void processPayment(double amount) {
        System.out.println(
            "Processing UPI payment: ₹" + amount
        );
    }
}
```

---

# 💳 Credit Card Payment

```java
class CreditCardPayment implements PaymentProcessor {

    @Override
    public void processPayment(double amount) {
        System.out.println(
            "Processing Credit Card payment: ₹" + amount
        );
    }
}
```

---

# 🏦 Net Banking Payment

```java
class NetBankingPayment implements PaymentProcessor {

    @Override
    public void processPayment(double amount) {
        System.out.println(
            "Processing Net Banking payment: ₹" + amount
        );
    }
}
```

---

# 🚀 Complete PaymentProcessor Example

```java
interface PaymentProcessor {

    void processPayment(double amount);
}


class UpiPayment implements PaymentProcessor {

    @Override
    public void processPayment(double amount) {

        System.out.println(
            "Processing UPI payment: ₹" + amount
        );
    }
}


class CreditCardPayment implements PaymentProcessor {

    @Override
    public void processPayment(double amount) {

        System.out.println(
            "Processing Credit Card payment: ₹" + amount
        );
    }
}


class NetBankingPayment implements PaymentProcessor {

    @Override
    public void processPayment(double amount) {

        System.out.println(
            "Processing Net Banking payment: ₹" + amount
        );
    }
}


public class Main {

    public static void main(String[] args) {

        PaymentProcessor payment;

        payment = new UpiPayment();
        payment.processPayment(1500);

        payment = new CreditCardPayment();
        payment.processPayment(2500);

        payment = new NetBankingPayment();
        payment.processPayment(5000);
    }
}
```

### Output

```text
Processing UPI payment: ₹1500.0
Processing Credit Card payment: ₹2500.0
Processing Net Banking payment: ₹5000.0
```

---

# 🔥 Runtime Polymorphism in PaymentProcessor

The most important concept in this example is:

```java
PaymentProcessor payment;
```

The same reference can point to different implementations.

```java
payment = new UpiPayment();
payment.processPayment(1500);

payment = new CreditCardPayment();
payment.processPayment(2500);

payment = new NetBankingPayment();
payment.processPayment(5000);
```

Conceptually:

```text
PaymentProcessor
       │
       ├── UpiPayment
       │      ↓
       │   processPayment()
       │
       ├── CreditCardPayment
       │      ↓
       │   processPayment()
       │
       └── NetBankingPayment
              ↓
           processPayment()
```

The method that executes depends on the **actual object at runtime**.

---

# 🧠 Abstract Class vs Interface

| Feature              | Abstract Class               | Interface                                 |
| -------------------- | ---------------------------- | ----------------------------------------- |
| Keyword              | `abstract class`             | `interface`                               |
| Inheritance          | `extends`                    | `implements`                              |
| Object creation      | ❌ Cannot instantiate         | ❌ Cannot instantiate                      |
| Abstract methods     | ✅ Yes                        | ✅ Yes                                     |
| Concrete methods     | ✅ Yes                        | ✅ Yes, with `default`/`static` methods    |
| Constructor          | ✅ Yes                        | ❌ No                                      |
| Instance variables   | ✅ Yes                        | ❌ No instance fields                      |
| Multiple inheritance | ❌ Class can extend one class | ✅ Class can implement multiple interfaces |

---

# 🔄 Polymorphism Flow

```text
                  🔄 POLYMORPHISM
                         │
              ┌──────────┴──────────┐
              ↓                     ↓
       ⚡ Compile-Time          🚀 Runtime
              │                     │
              ↓                     ↓
        Method Overloading     Method Overriding
              │                     │
              ↓                     ↓
       Compiler decides       JVM decides at runtime
```

---

# 💡 Key Takeaways

* ✅ Polymorphism means **many forms**.
* ✅ Compile-time polymorphism is achieved through **method overloading**.
* ✅ Runtime polymorphism is achieved through **method overriding**.
* ✅ Abstract classes provide a common base with both abstract and concrete behavior.
* ✅ Abstract classes cannot be instantiated directly.
* ✅ Interfaces define contracts that classes implement.
* ✅ A class can implement multiple interfaces.
* ✅ `PaymentProcessor` demonstrates runtime polymorphism.
* ✅ Different payment implementations can be used through the same `PaymentProcessor` reference.

---

# 🎯 Day 10 Completed

```text
⚡ Overloading
      ↓
🚀 Overriding
      ↓
🧩 Abstract Classes
      ↓
🔌 Interfaces
      ↓
🔄 Polymorphism
      ↓
💳 PaymentProcessor
      ↓
🚀 Multiple Payment Implementations
```

<p align="center">
  <img src="https://readme-typing-svg.demolab.com?font=Fira+Code&size=22&duration=2500&pause=700&color=36BCF7&center=true&vCenter=true&width=800&lines=🎉+DAY+10+COMPLETED!;Java+OOP+%7C+Polymorphism+%7C+Abstraction;Keep+Learning+%7C+Keep+Building+%7C+Keep+Coding+🚀" alt="Completion Animation"/>
</p>

<p align="center">
  <img src="https://capsule-render.vercel.app/api?type=waving&color=gradient&height=120&section=footer" width="100%" alt="Animated footer"/>
</p>

**Next → Day 11 🚀**
