# 🚀 Day 08 – Java Classes, Objects, Constructors & Members

<p align="center">
  <img src="https://readme-typing-svg.demolab.com?font=Fira+Code&size=24&duration=3000&pause=1000&color=36BCF7&center=true&vCenter=true&width=700&lines=Day+08+%7C+Java+OOP+Fundamentals;Classes+%7C+Objects+%7C+Constructors;Instance+%7C+Static+%7C+this+Keyword;Building+Student+%26+Employee+Models" alt="Typing Animation"/>
</p>

<p align="center">
  <img src="https://skillicons.dev/icons?i=java" width="80" alt="Java"/>
</p>

<p align="center">
  <img src="https://capsule-render.vercel.app/api?type=rect&color=gradient&height=3" width="90%" alt="Animated separator"/>
</p>

---

## 🎯 Learning Objective

> 💡 Understand how Java uses **classes and objects** to model real-world entities.

### 📚 Topics Covered

```text
🏗️ Class
   ↓
📦 Object
   ↓
🔧 Constructor
   ↓
🧩 Instance Members
   ↓
⚡ Static Members
   ↓
👉 this Keyword
   ↓
👨‍🎓 Student Model
   ↓
👨‍💼 Employee Model
```

---

# 🏗️ 1. Class

A **class** is a blueprint or template used to create objects.

```java
class Student {
    String name;
    int age;
}
```

The `Student` class defines what data a student object can contain.

---

# 📦 2. Object

An **object** is an instance of a class.

```java
Student student = new Student();
```

### 🔍 Breakdown

```text
Student       → Class
student       → Reference Variable
new Student() → Object Creation
```

---

# 🔧 3. Constructor

A **constructor** is a special member used to initialize an object.

```java
class Student {

    String name;
    int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
```

Creating an object:

```java
Student student = new Student("Vamsi", 22);
```

### ✨ Constructor Characteristics

* 🔹 Same name as the class
* 🔹 No return type
* 🔹 Called automatically during object creation
* 🔹 Used for object initialization
* 🔹 Can be overloaded

---

# 🧩 4. Instance Members

Instance members belong to a **particular object**.

```java
class Student {

    String name;
    int age;

    void display() {
        System.out.println(name);
        System.out.println(age);
    }
}
```

Each object has its own instance data.

```java
Student s1 = new Student();
Student s2 = new Student();

s1.name = "Vamsi";
s2.name = "Rahul";
```

```text
        Student Class
             │
      ┌──────┴──────┐
      ↓             ↓
   Object 1       Object 2
   Vamsi           Rahul
```

---

# ⚡ 5. Static Members

Static members belong to the **class**, rather than individual objects.

```java
class Student {

    String name;

    static String college = "SVCE";
}
```

Access using the class name:

```java
System.out.println(Student.college);
```

### 🔥 Static Concept

```text
             Student Class
                  │
          static college
                  │
        ┌─────────┴─────────┐
        ↓                   ↓
    student1             student2
      Vamsi                Rahul
        │                   │
        └──── Shared Data ──┘
```

---

# 👉 6. `this` Keyword

The `this` keyword refers to the **current object**.

```java
class Student {

    String name;
    int age;

    Student(String name, int age) {

        this.name = name;
        this.age = age;
    }
}
```

### 🧠 Remember

```text
this.name
   ↑
Current object's instance variable

name
   ↑
Constructor parameter
```

---

# 👨‍🎓 Student Model

```java
class Student {

    int id;
    String name;
    int age;

    static String college = "SVCE";

    Student(int id, String name, int age) {

        this.id = id;
        this.name = name;
        this.age = age;
    }

    void displayStudent() {

        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("College: " + college);
    }

    public static void main(String[] args) {

        Student student1 =
                new Student(101, "Vamsi", 22);

        Student student2 =
                new Student(102, "Rahul", 21);

        student1.displayStudent();
        student2.displayStudent();
    }
}
```

### 🎬 Object Flow

```text
new Student(101, "Vamsi", 22)
             │
             ↓
       Constructor
             │
             ↓
     this.id = 101
     this.name = Vamsi
     this.age = 22
             │
             ↓
        Student Object
```

---

# 👨‍💼 Employee Model

```java
class Employee {

    int id;
    String name;
    double salary;

    static String company = "TechCorp";

    Employee(int id, String name, double salary) {

        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    void displayEmployee() {

        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary);
        System.out.println("Company: " + company);
    }

    public static void main(String[] args) {

        Employee employee1 =
                new Employee(101, "Vamsi", 50000);

        Employee employee2 =
                new Employee(102, "Rahul", 60000);

        employee1.displayEmployee();
        employee2.displayEmployee();
    }
}
```

---

# 🧠 Concept Map

<p align="center">

```text
             ☕ JAVA OOP
                 │
       ┌─────────┴─────────┐
       ↓                   ↓
    🏗️ Class             📦 Object
       │                   │
       └─────────┬─────────┘
                 ↓
           🔧 Constructor
                 │
        ┌────────┴────────┐
        ↓                 ↓
   🧩 Instance         ⚡ Static
        │                 │
        └────────┬────────┘
                 ↓
             👉 this
                 │
        ┌────────┴────────┐
        ↓                 ↓
   👨‍🎓 Student        👨‍💼 Employee
```

</p>

---

# 📊 Quick Revision

| Concept              | Meaning                        |
| -------------------- | ------------------------------ |
| 🏗️ Class            | Blueprint for creating objects |
| 📦 Object            | Instance of a class            |
| 🔧 Constructor       | Initializes an object          |
| 🧩 Instance Variable | Belongs to an object           |
| 🧩 Instance Method   | Works with object data         |
| ⚡ Static Variable    | Shared by the class            |
| ⚡ Static Method      | Belongs to the class           |
| 👉 `this`            | Refers to the current object   |

---

# 💡 Key Takeaways

```text
🏗️ Class
   ↓
📦 Object
   ↓
🔧 Constructor
   ↓
🧩 Instance Members
   ↓
⚡ Static Members
   ↓
👉 this Keyword
   ↓
🚀 Real-World Models
```

* ✅ Class defines the structure.
* ✅ Object represents a real instance.
* ✅ Constructor initializes the object.
* ✅ Instance members belong to individual objects.
* ✅ Static members belong to the class.
* ✅ `this` refers to the current object.
* ✅ Student and Employee models demonstrate practical usage.

---

<p align="center">

### 🎉 DAY 08 COMPLETED!

<img src="https://capsule-render.vercel.app/api?type=waving&color=gradient&height=100&section=footer" width="100%" alt="Animated footer"/>

</p>

**Next → Day 09 🚀**
