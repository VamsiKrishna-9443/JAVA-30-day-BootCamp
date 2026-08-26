# 🚀 Day 09 – Getters, Setters, Inheritance, `super` & Method Overriding

<p align="center">
  <img src="https://readme-typing-svg.demolab.com?font=Fira+Code&size=24&duration=3000&pause=1000&color=36BCF7&center=true&vCenter=true&width=750&lines=Day+09+%7C+Java+OOP;Getters+%26+Setters+%7C+Inheritance;super+Keyword+%7C+Method+Overriding;Person+%E2%86%92+Employee+%E2%86%92+Manager" alt="Typing Animation"/>
</p>

<p align="center">
  <img src="https://skillicons.dev/icons?i=java" width="80" alt="Java"/>
</p>

<p align="center">
  <img src="https://capsule-render.vercel.app/api?type=rect&color=gradient&height=3" width="90%" alt="Animated separator"/>
</p>

---

## 🎯 Learning Objective

Understand how Java uses **encapsulation and inheritance** to create reusable and maintainable classes.

### 📚 Topics Covered

```text
🔐 Getters & Setters
       ↓
🧬 Inheritance
       ↓
⬆️ super Keyword
       ↓
🔄 Method Overriding
       ↓
👤 Person
       ↓
💼 Employee
       ↓
👨‍💼 Manager
```

---

# 🔐 1. Getters and Setters

Getters and setters are methods used to **access and modify private variables**.

They are an important part of **encapsulation**.

### Getter

A getter is used to retrieve a value.

```java
public String getName() {
    return name;
}
```

### Setter

A setter is used to modify a value.

```java
public void setName(String name) {
    this.name = name;
}
```

### Example

```java
class Person {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```

Usage:

```java
Person person = new Person();

person.setName("Vamsi");

System.out.println(person.getName());
```

### 🔒 Why use getters and setters?

```text
Private Data
     ↓
Getter / Setter
     ↓
Controlled Access
     ↓
Better Encapsulation
```

They allow us to add validation or business rules before changing data.

---

# 🧬 2. Inheritance

**Inheritance** is a mechanism where one class acquires the properties and behaviors of another class.

It promotes:

* ♻️ Code reusability
* 🧹 Less duplicate code
* 🔗 Relationship between classes
* 🛠️ Easier maintenance

### Syntax

```java
class Child extends Parent {
    
}
```

Example:

```java
class Person {

    String name;

    void displayPerson() {
        System.out.println("I am a Person");
    }
}

class Employee extends Person {

    int employeeId;
}
```

Here:

```text
Person
   ↑
Employee
```

`Employee` inherits members from `Person`.

---

# ⬆️ 3. `super` Keyword

The `super` keyword refers to the **immediate parent class**.

It is mainly used to:

1. Access parent class variables
2. Call parent class methods
3. Call parent class constructors

---

## 🔹 `super` with Variables

```java
class Person {

    String name = "Person";
}

class Employee extends Person {

    String name = "Employee";

    void display() {
        System.out.println(name);
        System.out.println(super.name);
    }
}
```

Output:

```text
Employee
Person
```

---

## 🔹 `super` with Methods

```java
class Person {

    void display() {
        System.out.println("Person");
    }
}

class Employee extends Person {

    void display() {

        super.display();

        System.out.println("Employee");
    }
}
```

Output:

```text
Person
Employee
```

---

## 🔹 `super` with Constructor

```java
class Person {

    Person() {
        System.out.println("Person Constructor");
    }
}

class Employee extends Person {

    Employee() {

        super();

        System.out.println("Employee Constructor");
    }
}
```

Output:

```text
Person Constructor
Employee Constructor
```

> 💡 `super()` calls the constructor of the immediate parent class.

---

# 🔄 4. Method Overriding

**Method overriding** occurs when a child class provides its own implementation of a method already defined in the parent class.

### Example

```java
class Person {

    void work() {
        System.out.println("Person is working");
    }
}

class Employee extends Person {

    @Override
    void work() {
        System.out.println("Employee is working");
    }
}
```

The `Employee` class overrides the `work()` method of `Person`.

### Important Rules

* Same method name
* Same parameters
* Compatible return type
* Child class must inherit the parent method
* `final` methods cannot be overridden
* `private` methods are not overridden
* `static` methods are hidden, not overridden
* Use `@Override` to clearly indicate overriding

---

# 🏢 5. Person → Employee → Manager Hierarchy

The main practical task for Day 09 is to build a **multilevel inheritance hierarchy**.

```text
              👤 Person
                 │
                 ▼
            💼 Employee
                 │
                 ▼
            👨‍💼 Manager
```

---

# 👤 Person Class

```java
class Person {

    private String name;
    private int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}
```

---

# 💼 Employee Class

`Employee` extends `Person`.

```java
class Employee extends Person {

    private int employeeId;
    private double salary;

    Employee(String name, int age, int employeeId, double salary) {

        super(name, age);

        this.employeeId = employeeId;
        this.salary = salary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    void display() {

        super.display();

        System.out.println("Employee ID: " + employeeId);
        System.out.println("Salary: " + salary);
    }
}
```

---

# 👨‍💼 Manager Class

`Manager` extends `Employee`.

```java
class Manager extends Employee {

    private String department;

    Manager(
            String name,
            int age,
            int employeeId,
            double salary,
            String department
    ) {

        super(name, age, employeeId, salary);

        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    void display() {

        super.display();

        System.out.println("Department: " + department);
    }
}
```

---

# 🚀 Complete Example

```java
class Person {

    private String name;
    private int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}


class Employee extends Person {

    private int employeeId;
    private double salary;

    Employee(String name, int age, int employeeId, double salary) {

        super(name, age);

        this.employeeId = employeeId;
        this.salary = salary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    void display() {

        super.display();

        System.out.println("Employee ID: " + employeeId);
        System.out.println("Salary: " + salary);
    }
}


class Manager extends Employee {

    private String department;

    Manager(
            String name,
            int age,
            int employeeId,
            double salary,
            String department
    ) {

        super(name, age, employeeId, salary);

        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    void display() {

        super.display();

        System.out.println("Department: " + department);
    }
}


public class Management {

    public static void main(String[] args) {

        Manager manager = new Manager(
                "Vamsi",
                22,
                101,
                75000,
                "Engineering"
        );

        manager.display();
    }
}
```

### Output

```text
Name: Vamsi
Age: 22
Employee ID: 101
Salary: 75000.0
Department: Engineering
```

---

# 🧠 How the Constructor Chain Works

When we create:

```java
Manager manager = new Manager(...);
```

The constructor execution follows the inheritance hierarchy:

```text
Manager Constructor
        ↓
Employee Constructor
        ↓
Person Constructor
        ↓
Person initialization
        ↓
Employee initialization
        ↓
Manager initialization
```

This happens because each child constructor calls its parent constructor using `super()`.

---

# 🔄 Method Overriding Flow

```text
Person
  │
  │ display()
  ▼
Employee
  │
  │ overrides display()
  ▼
Manager
  │
  │ overrides display()
  ▼
Manager.display()
  │
  ├── super.display()
  │       ↓
  │   Employee.display()
  │       ↓
  │   Person.display()
  │
  └── Manager-specific details
```

---

# 📊 Quick Revision

| Concept        | Meaning                                                |
| -------------- | ------------------------------------------------------ |
| 🔐 Getter      | Reads a private variable                               |
| 🔐 Setter      | Modifies a private variable                            |
| 🧬 Inheritance | Acquiring properties and behavior from a parent        |
| ⬆️ `super`     | Refers to the immediate parent class                   |
| 🔄 Overriding  | Child provides a new implementation of a parent method |
| 👤 Person      | Base/parent class                                      |
| 💼 Employee    | Child of `Person`                                      |
| 👨‍💼 Manager  | Child of `Employee`                                    |

---

# ⚡ Key Takeaways

```text
🔐 Encapsulation
      ↓
Getters + Setters
      ↓
🧬 Inheritance
      ↓
⬆️ super
      ↓
🔄 Method Overriding
      ↓
👤 Person
      ↓
💼 Employee
      ↓
👨‍💼 Manager
```

* ✅ Getters and setters provide controlled access to private data.
* ✅ `extends` is used for inheritance.
* ✅ `super` accesses the immediate parent class.
* ✅ `super()` calls the parent constructor.
* ✅ Method overriding enables a child class to provide specialized behavior.
* ✅ `@Override` clearly indicates that a method is being overridden.
* ✅ `Person → Employee → Manager` demonstrates **multilevel inheritance**.

---

# 🎯 Day 09 Completed

<p align="center">

### 🔐 Encapsulation → 🧬 Inheritance → 🔄 Overriding → 🚀 Real-World Models

</p>

<p align="center">
  <img src="https://capsule-render.vercel.app/api?type=waving&color=gradient&height=100&section=footer" width="100%" alt="Animated footer"/>
</p>

**Next → Day 10 🚀**
