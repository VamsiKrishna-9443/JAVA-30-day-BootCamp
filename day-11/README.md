# 🚀 Day 11 — `equals()` & `hashCode()`

> **Java 30-Day Developer Bootcamp**  
> **Focus:** Implement Employee equality correctly and use Employee objects with `HashSet` and `HashMap`.

---

## 🎬 Day 11 Opening

![Day 11 Opening Animation](./day11-opening.gif)
<img width="1400" height="780" alt="day11-start-animation" src="https://github.com/user-attachments/assets/b2eafe99-5670-48ae-8152-8bc3412697cb" />

---

## 🎯 Learning Objectives

By the end of Day 11, I learned:

- Object equality in Java
- `==` vs `equals()`
- Why `equals()` is overridden
- How to implement `equals()` correctly
- What `hashCode()` does
- How to implement `hashCode()` correctly
- The `equals()` / `hashCode()` contract
- Hash collisions
- How `HashSet` uses `hashCode()` and `equals()`
- How `HashMap` uses `hashCode()` and `equals()` for keys
- How to implement Employee equality
- How to use Employee objects in `HashSet`
- How to use Employee objects as `HashMap` keys
- Common mistakes and interview concepts

---

# 1. Object Equality in Java

Java has two important ideas when comparing objects:

### Reference Equality

`==` checks whether two object references point to the **same object**.

```java
Employee e1 = new Employee(101, "Vamsi");
Employee e2 = new Employee(101, "Vamsi");

System.out.println(e1 == e2);
```

Output:

```text
false
```

The objects contain the same data, but they are separate objects in memory.

```text
e1 ───────► Employee Object #1

e2 ───────► Employee Object #2
```

### Logical Equality

`equals()` determines whether two objects should be considered logically equal.

For our Employee example, we can define:

> Two employees are equal when their employee IDs are equal.

Therefore:

```java
e1.equals(e2)
```

can return:

```text
true
```

even when:

```java
e1 == e2
```

is:

```text
false
```

---

# 2. `==` vs `equals()`

| Feature | `==` | `equals()` |
|---|---|---|
| Object comparison | Reference equality | Logical equality |
| Management question | Same object? | Same logical object? |
| Customizable | No | Yes |
| Used with objects | Compares references | Compares object meaning |
| Defined by | Java operator | `Object` method |

### Simple rule

```text
==        → Are these the same object?

equals()  → Should these objects be considered equal?
```

---

# 3. Why Override `equals()`?

Java cannot automatically know what makes two custom objects equal.

Consider:

```java
Employee e1 = new Employee(101, "Vamsi");
Employee e2 = new Employee(101, "Vamsi");
```

Our application may define:

```text
Employee ID = unique identity
```

So:

```text
101 → Vamsi
101 → Vamsi
```

represents the same logical employee.

Therefore, we override `equals()`.

---

# 4. Correct `equals()` Implementation

```java
@Override
public boolean equals(Object obj)
{
    if (this == obj)
        return true;

    if (!(obj instanceof Employee))
        return false;

    Employee e = (Employee) obj;

    return this.id == e.id;
}
```

### Step-by-step

#### Step 1 — Same reference

```java
if (this == obj)
    return true;
```

If both references point to the same object, they are equal.

#### Step 2 — Check type

```java
if (!(obj instanceof Employee))
    return false;
```

An Employee should not be equal to an unrelated object.

#### Step 3 — Cast

```java
Employee e = (Employee) obj;
```

Now we can access Employee fields.

#### Step 4 — Compare identity

```java
return this.id == e.id;
```

Our equality rule is based on employee ID.

---

# 5. The `equals()` Contract

A correct `equals()` method follows five important properties.

## 5.1 Reflexive

An object must equal itself.

```java
x.equals(x) == true
```

---

## 5.2 Symmetric

If:

```java
x.equals(y)
```

is `true`, then:

```java
y.equals(x)
```

must also be `true`.

```text
x.equals(y)
     ↓
   true
     ↓
y.equals(x)
     ↓
  true
```

---

## 5.3 Transitive

If:

```text
x.equals(y) → true
y.equals(z) → true
```

then:

```text
x.equals(z) → true
```

---

## 5.4 Consistent

If the relevant object state has not changed, repeated calls should return the same result.

```java
x.equals(y)
x.equals(y)
x.equals(y)
```

should consistently return the same result.

---

## 5.5 Non-null

For a non-null object:

```java
x.equals(null)
```

must return:

```text
false
```

---

# 6. What is `hashCode()`?

`hashCode()` returns an integer representing an object's hash value.

Example:

```java
@Override
public int hashCode()
{
    return Integer.hashCode(id);
}
```

Hash-based collections use hash codes to organize and locate objects efficiently.

Important examples:

```text
HashSet
HashMap
Hashtable
```

---

# 7. Why Do We Need `hashCode()`?

Suppose a `HashSet` contains thousands of objects.

Checking every object one by one would be inefficient.

Instead, Java uses the object's hash code to determine a likely location called a **bucket**.

Conceptually:

```text
Object
  ↓
hashCode()
  ↓
Bucket
  ↓
equals()
  ↓
Matching Object
```

So:

```text
hashCode() → helps locate
equals()   → confirms equality
```

---

# 🎬 8. Equality + Hashing Animation

![Day 11 Concepts Animation](./day11-concepts.gif)
<img width="1400" height="780" alt="day11-equals-hashcode" src="https://github.com/user-attachments/assets/21fd9911-5aa8-442e-80d1-10dd4f228981" />


---

# 9. The `equals()` / `hashCode()` Contract

This is the most important rule of Day 11.

> **If two objects are equal according to `equals()`, they must have the same hash code.**

Example:

```text
e1.equals(e2)
      ↓
    true
      ↓
e1.hashCode() == e2.hashCode()
```

### Important reverse rule

The reverse is NOT guaranteed.

```text
Same hashCode()
      ↓
does NOT mean
      ↓
equals() == true
```

Two unequal objects can have the same hash code.

This is called a:

## Hash Collision

Example:

```text
Object A → hashCode 500

Object B → hashCode 500
```

They can still be different objects.

---

# 10. Correct Employee Class

```java
package Exercise;

public class Employee
{
    int id;
    String name;

    Employee(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;

        if (!(obj instanceof Employee))
            return false;

        Employee e = (Employee) obj;

        return this.id == e.id;
    }

    @Override
    public int hashCode()
    {
        return Integer.hashCode(id);
    }

    @Override
    public String toString()
    {
        return id + " " + name;
    }
}
```

### Important relationship

```text
equals() uses:
       id

hashCode() uses:
       id
```

Therefore the two methods are consistent.

---

# 11. Employee Objects in `HashSet`

```java
package Exercise;

import java.util.HashSet;

public class EmployeeHashSet
{
    public static void main(String[] args)
    {
        HashSet<Employee> employees = new HashSet<>();

        Employee e1 = new Employee(101, "Vamsi");
        Employee e2 = new Employee(101, "Vamsi");
        Employee e3 = new Employee(102, "Rahul");

        employees.add(e1);
        employees.add(e2);
        employees.add(e3);

        System.out.println(employees);
    }
}
```

### What happens?

We have:

```text
e1 → ID 101
e2 → ID 101
e3 → ID 102
```

Because:

```java
e1.equals(e2)
```

is `true`, the HashSet considers them duplicates.

Conceptually:

```text
Input:

101 Vamsi
101 Vamsi
102 Rahul

HashSet:

101 Vamsi
102 Rahul
```

---

# 12. How `HashSet` Works

When we call:

```java
set.add(employee);
```

the conceptual flow is:

```text
        add(employee)
              ↓
         hashCode()
              ↓
          Find Bucket
              ↓
         equals()
          /       \
       Equal    Not Equal
         ↓          ↓
     Duplicate     Store
```

### Important

`hashCode()` does not by itself determine equality.

It helps find the possible bucket.

Then `equals()` determines whether the objects are logically equal.

---

# 13. Employee Objects in `HashMap`

A `HashMap` stores:

```text
key → value
```

We can use an Employee object as a key.

```java
package Exercise;

import java.util.HashMap;

public class EmployeeHashMap
{
    public static void main(String[] args)
    {
        HashMap<Employee, Double> employees = new HashMap<>();

        Employee e1 = new Employee(101, "Vamsi");
        Employee e2 = new Employee(101, "Vamsi");

        employees.put(e1, 50000.0);

        System.out.println(employees.get(e2));
    }
}
```

Output:

```text
50000.0
```

---

# 14. Why Does `get(e2)` Work?

We inserted:

```java
employees.put(e1, 50000.0);
```

and retrieved using:

```java
employees.get(e2);
```

Although:

```java
e1 != e2
```

we have:

```java
e1.equals(e2) == true
```

and:

```java
e1.hashCode() == e2.hashCode()
```

Therefore the HashMap can locate the same logical key.

### Lookup flow

```text
map.get(e2)
      ↓
e2.hashCode()
      ↓
Find Bucket
      ↓
Compare Key using equals()
      ↓
Find e1
      ↓
Return 50000.0
```

---

# 15. What If `hashCode()` Is Not Overridden?

Suppose we implement:

```java
equals()
```

but forget:

```java
hashCode()
```

We can end up with:

```text
e1.equals(e2)
      ↓
    true

BUT

e1.hashCode() != e2.hashCode()
```

This violates the contract.

Hash-based collections may then fail to correctly identify logically equal objects.

### Golden Rule

```text
Override equals()
        +
Override hashCode()
        ↓
Correct HashSet / HashMap behavior
```

---

# 16. Common Mistakes

### ❌ Mistake 1 — Using `==` for object contents

Do not use:

```java
e1 == e2
```

when you want logical equality.

Use:

```java
e1.equals(e2)
```

---

### ❌ Mistake 2 — Overriding only `equals()`

Wrong:

```text
equals()   ✓
hashCode() ✗
```

Correct:

```text
equals()   ✓
hashCode() ✓
```

---

### ❌ Mistake 3 — Different fields in `equals()` and `hashCode()`

If `equals()` uses:

```java
id
```

then `hashCode()` should also be based on:

```java
id
```

---

### ❌ Mistake 4 — Changing hash-relevant fields

Changing fields used by `equals()` and `hashCode()` after inserting an object into a `HashSet` or using it as a `HashMap` key can make lookup/removal problematic.

---

# 17. Hash Collision

A collision occurs when different objects produce the same hash code.

```text
Employee A
    ↓
hashCode() = 500


Employee B
    ↓
hashCode() = 500
```

This does not mean:

```java
A.equals(B)
```

is `true`.

Java uses `equals()` to distinguish objects that share a bucket.

Therefore:

```text
hashCode()
    ↓
Find possible location

equals()
    ↓
Confirm equality
```

---

# 18. `HashSet` vs `HashMap`

| Feature | HashSet | HashMap |
|---|---|---|
| Stores | Objects | Key-value pairs |
| Duplicate keys/elements | Not allowed | Keys are unique |
| Management method | `add()` | `put()` |
| Lookup | `contains()` | `get()` |
| Uses hashing | Yes | Yes |
| Uses `equals()` | Yes | Yes |
| Example | `HashSet<Employee>` | `HashMap<Employee, Double>` |

---

# 19. Day 11 Project Structure

```text
day-11/
│
└── src/
    │
    ├── Equals/
    │   ├── Car.java
    │   ├── Customer.java
    │   └── Worker.java
    │
    ├── Exercise/
    │   ├── Employee.java
    │   ├── EmployeeHashMap.java
    │   └── EmployeeHashSet.java
    │
    └── HashCode/
        ├── Pen.java
        └── Pencil.java
```

### `Equals`

Contains examples for practicing:

```java
equals()
```

with different classes.

### `HashCode`

Contains examples for practicing:

```java
hashCode()
```

and understanding hashing.

### `Exercise`

Combines both concepts using:

```text
Employee
   ↓
equals()
   +
hashCode()
   ↓
HashSet
HashMap
```

---

# 20. Interview Questions

### Q1. What is the difference between `==` and `equals()`?

`==` checks reference equality for objects, while `equals()` checks logical equality when properly overridden.

### Q2. Why override `hashCode()` with `equals()`?

Because equal objects must have the same hash code.

### Q3. Can two unequal objects have the same hash code?

Yes. This is a hash collision.

### Q4. Does the same hash code guarantee equality?

No.

```text
Same hashCode ≠ Same Object
```

### Q5. What happens if only `equals()` is overridden?

Hash-based collections may behave incorrectly because equal objects can have different hash codes.

### Q6. Which collections depend on `equals()` and `hashCode()`?

Primarily:

```text
HashSet
HashMap
Hashtable
```

---

# 🧠 21. Day 11 Summary

```text
Employee
   │
   ├── equals()
   │      ↓
   │  Logical Equality
   │
   └── hashCode()
          ↓
       Hash Value
          │
          ▼
   Hash-Based Collections
       /          \
      ▼            ▼
 HashSet        HashMap
```

### Three rules to remember

```text
1. equals() defines logical equality.

2. Equal objects MUST have the same hashCode().

3. Same hashCode() does NOT guarantee equality.
```

---

## 🎬 Day 11 Closing Animation

![Day 11 Closing Animation](./day11-closing.gif)
<img width="1400" height="780" alt="day11-end-animation" src="https://github.com/user-attachments/assets/b493983d-b90e-426a-90c4-81265ae4d1a4" />


---

# ✅ Day 11 Completed

### Concepts Covered

- [x] Object Equality
- [x] `==` vs `equals()`
- [x] `equals()` Method
- [x] `equals()` Contract
- [x] `hashCode()`
- [x] `equals()` / `hashCode()` Contract
- [x] Hash Collision
- [x] `HashSet`
- [x] `HashMap`
- [x] Employee Equality
- [x] Employee in `HashSet`
- [x] Employee as `HashMap` Key
- [x] Project Structure
- [x] Interview Questions

---

# 🚀 Next: Day 12

```text
Day 11
equals() + hashCode()
        ↓
HashSet + HashMap
        ↓
Day 12
Collections Framework
        ↓
List | Set | Map
        ↓
ArrayList | LinkedList
HashSet | TreeSet
HashMap
Iterator
```

> **Day 11 completed. Building strong Java fundamentals one concept at a time. 🚀**
