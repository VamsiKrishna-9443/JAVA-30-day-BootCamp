<p align="center">
  <img src="https://capsule-render.vercel.app/api?type=waving&color=0:F7A41D,100:4B8BBE&height=180&section=header&text=Day%2021%20-%20JDBC%20%26%20SQL%20Basics&fontSize=32&fontColor=ffffff&animation=fadeIn" width="100%"/>
</p>

<p align="center">
  <img src="https://readme-typing-svg.demolab.com?font=Fira+Code&size=22&pause=1000&color=F7A41D&center=true&vCenter=true&width=700&lines=Connecting+Java+to+MySQL+with+JDBC;Statement+vs+PreparedStatement;ResultSet+%7C+CRUD+Operations;Parameterized+Queries+Only+%F0%9F%94%92" alt="Typing SVG" />
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white"/>
  <img src="https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white"/>
  <img src="https://img.shields.io/badge/JDBC-Database%20Connectivity-4B8BBE?style=for-the-badge"/>
  <img src="https://img.shields.io/badge/Day-21%2F30-success?style=for-the-badge"/>
</p>

<p align="center">
  <b>⬅️ <a href="../day-20">Day 20</a> &nbsp;|&nbsp; <a href="../day-22">Day 22</a> ➡️</b>
</p>

---

## 📑 Table of Contents
- [Overview](#-overview)
- [Learning Objectives](#-learning-objectives)
- [What is JDBC?](#-what-is-jdbc)
- [JDBC Architecture](#-jdbc-architecture)
- [Types of JDBC Drivers](#-types-of-jdbc-drivers)
- [Steps to Connect Java with a Database](#-steps-to-connect-java-with-a-database)
- [Statement vs PreparedStatement](#-statement-vs-preparedstatement)
- [Why Parameterized Queries Only?](#-why-parameterized-queries-only)
- [ResultSet](#-resultset)
- [SQL CRUD Operations](#-sql-crud-operations)
- [Project: Employee CRUD](#-project-employee-crud)
- [Project Structure](#-project-structure)
- [File-by-File Breakdown](#-file-by-file-breakdown)
- [Prerequisites & Setup](#-prerequisites--setup)
- [How to Run](#-how-to-run)
- [Key Takeaways](#-key-takeaways)
- [What's Next](#-whats-next)

---

## 🎯 Overview

Day 21 moves from pure Java into **database connectivity**. This day covers how a Java
application talks to a relational database using **JDBC (Java Database Connectivity)**,
starting with the basic `Statement` API and moving to the safer, production-standard
`PreparedStatement` API. Every write operation in this day's code uses **parameterized
queries only** — no string-concatenated SQL — to build the habit of writing SQL injection
free code from day one.

The day's centerpiece is a small **Employee CRUD** application that performs Create,
Read, Update, and Delete operations against a MySQL `employees` table entirely through
`PreparedStatement` and `ResultSet`.

---

## 🎯 Learning Objectives

By the end of Day 21, the goals were to be able to:

- [x] Explain what JDBC is and how it fits between a Java app and a database
- [x] Connect a Java application to a MySQL database
- [x] Execute SQL queries using `Statement`
- [x] Execute safe, parameterized SQL queries using `PreparedStatement`
- [x] Read query results row-by-row using `ResultSet`
- [x] Implement all four CRUD operations (Create, Read, Update, Delete) in Java
- [x] Understand *why* `PreparedStatement` is preferred over `Statement` for real applications

---

## 🔌 What is JDBC?

**JDBC (Java Database Connectivity)** is a Java API (`java.sql.*`) that lets a Java
program connect to, query, and update a relational database — regardless of which
database vendor is behind it (MySQL, PostgreSQL, Oracle, etc.). JDBC works through a
**driver**: a vendor-specific library that translates standard JDBC calls into the
database's own wire protocol. Swap the driver, and the same JDBC code can talk to a
different database.

---

## 🏗️ JDBC Architecture

```
   Java Application (your code)
              │
              ▼
     JDBC API  (java.sql.*)
              │
              ▼
        DriverManager
              │
              ▼
   JDBC Driver (MySQL Connector/J)
              │
              ▼
      Database  (MySQL Server)
```

The `DriverManager` is responsible for picking the right driver for the connection
`URL` you provide and handing back a `Connection` object — the live channel your code
uses to send SQL and receive results.

---

## 🚦 Types of JDBC Drivers

| Type | Name | Description |
|:---:|---|---|
| Type 1 | JDBC-ODBC Bridge | Routes calls through ODBC; deprecated, not used today |
| Type 2 | Native-API Driver | Calls the database's native client library directly |
| Type 3 | Network Protocol Driver | Middleware server translates JDBC calls for the DB |
| Type 4 | **Thin Driver (Pure Java)** | Converts JDBC calls straight into the DB's own protocol — **what MySQL Connector/J uses**, and the one used in this project |

---

## 🔢 Steps to Connect Java with a Database

1. **Add the driver** — MySQL Connector/J on the classpath (JAR or Maven dependency)
2. **Open a connection** — `DriverManager.getConnection(url, user, password)`
3. **Create a statement** — `Statement` or `PreparedStatement`
4. **Execute the query** — `executeQuery()` for reads, `executeUpdate()` for writes
5. **Process the result** — loop through the returned `ResultSet`
6. **Close resources** — close `ResultSet`, `Statement`, and `Connection` (or use try-with-resources)

```java
String url = "jdbc:mysql://localhost:3306/employee_db";
String user = "root";
String password = "yourpassword";

try (Connection conn = DriverManager.getConnection(url, user, password)) {
    System.out.println("Connected to database!");
} catch (SQLException e) {
    e.printStackTrace();
}
```

---

## ⚔️ Statement vs PreparedStatement

| Feature | `Statement` | `PreparedStatement` |
|---|---|---|
| SQL compilation | Re-compiled on every execution | Pre-compiled once, reused |
| Passing values | Manual string concatenation | `?` placeholders + `setX()` methods |
| SQL Injection | ❌ Vulnerable | ✅ Prevented |
| Performance (repeated calls) | Slower | Faster |
| Readability with dynamic data | Messy | Clean |
| Best suited for | Static, fixed SQL (e.g. DDL) | Any query with user-supplied values |

This is exactly why the `Statement/` examples in this repo are kept to simple, static
demo queries, while every CRUD operation lives under `PreparedStatement/`.

---

## 🛡️ Why Parameterized Queries Only?

Concatenating user input directly into SQL text opens the door to **SQL injection** —
a malicious input can change the meaning of the query entirely.

```java
// ❌ Vulnerable — Statement with string concatenation
String query = "SELECT * FROM employees WHERE name = '" + userInput + "'";
stmt.executeQuery(query);
// If userInput is  ' OR '1'='1   the WHERE clause becomes always-true,
// and the query returns every row in the table.
```

```java
// ✅ Safe — PreparedStatement with bound parameters
String query = "SELECT * FROM employees WHERE name = ?";
PreparedStatement ps = conn.prepareStatement(query);
ps.setString(1, userInput);
ResultSet rs = ps.executeQuery();
// The driver treats userInput strictly as data, never as SQL syntax.
```

This is the reasoning behind the day's rule: **use parameterized queries only.**

---

## 📊 ResultSet

A `ResultSet` is a cursor over the rows returned by a `SELECT` query. It starts
positioned *before* the first row, so `next()` must be called once to reach row one.

| Method | Purpose |
|---|---|
| `next()` | Moves the cursor to the next row; returns `false` when there are no more rows |
| `getInt(col)` | Reads a column as an `int` |
| `getString(col)` | Reads a column as a `String` |
| `getDouble(col)` | Reads a column as a `double` |
| `close()` | Releases the `ResultSet`'s resources |

```java
ResultSet rs = ps.executeQuery();
while (rs.next()) {
    int id = rs.getInt("id");
    String name = rs.getString("name");
    double salary = rs.getDouble("salary");
    System.out.println(id + " | " + name + " | " + salary);
}
```

---

## 🔄 SQL CRUD Operations

| Operation | SQL Keyword | Example |
|---|---|---|
| **C**reate | `INSERT INTO` | `INSERT INTO employees (name, salary) VALUES (?, ?)` |
| **R**ead | `SELECT` | `SELECT * FROM employees` |
| **U**pdate | `UPDATE` | `UPDATE employees SET salary = ? WHERE id = ?` |
| **D**elete | `DELETE FROM` | `DELETE FROM employees WHERE id = ?` |

---

## 🧑‍💼 Project: Employee CRUD

A small console application (`EmployeeCRUD.java`) that performs all four CRUD
operations against an `employees` table, using `PreparedStatement` end-to-end so no
raw user input ever touches the SQL string directly.

**Table schema used throughout the examples:**

```sql
CREATE DATABASE IF NOT EXISTS employee_db;

USE employee_db;

CREATE TABLE employees (
    id      INT PRIMARY KEY AUTO_INCREMENT,
    name    VARCHAR(100) NOT NULL,
    salary  DOUBLE
);
```

**Core features:**
- ➕ Add a new employee (single insert, and batch insert of multiple records)
- 📋 Display all employees
- 🗑️ Delete an employee by ID
- 🔁 Delete a record and immediately re-display the remaining ones

---

## 📁 Project Structure

```
day-21/
└── src/
    ├── Statement/
    │   ├── JdbcDemo.java          # First JDBC connection using Statement
    │   ├── JdbcDemo1.java         # Extended Statement-based query demo
    │   └── DeleteEmployee.java    # DELETE using plain Statement
    │
    └── PreparedStatement/
        ├── JdbcInsert.java        # INSERT with parameterized query
        ├── JdbcDisplay.java       # SELECT + ResultSet iteration
        ├── MultipleInsert.java    # Batch insert of several employees
        ├── DeleteEmployee.java    # DELETE with parameterized query
        ├── DeleteAndDisplay.java  # DELETE, then re-display remaining rows
        └── EmployeeCRUD.java      # Full Create-Read-Update-Delete menu app
```

---

## 📄 File-by-File Breakdown

| File | Approach | What it demonstrates |
|---|:---:|---|
| `Statement/JdbcDemo.java` | `Statement` | Establishing the first JDBC connection and running a basic query |
| `Statement/JdbcDemo1.java` | `Statement` | A second, extended `Statement` query example |
| `Statement/DeleteEmployee.java` | `Statement` | Deleting a row the *unsafe* way — used to contrast with the `PreparedStatement` version |
| `PreparedStatement/JdbcInsert.java` | `PreparedStatement` | Inserting a single employee using `?` placeholders |
| `PreparedStatement/JdbcDisplay.java` | `PreparedStatement` | Reading and printing all employees via `ResultSet` |
| `PreparedStatement/MultipleInsert.java` | `PreparedStatement` | Inserting several employee records in one run (batching) |
| `PreparedStatement/DeleteEmployee.java` | `PreparedStatement` | Deleting a row safely by binding the ID parameter |
| `PreparedStatement/DeleteAndDisplay.java` | `PreparedStatement` | Deleting a record and immediately showing the updated table |
| `PreparedStatement/EmployeeCRUD.java` | `PreparedStatement` | Combines all four CRUD operations into one menu-driven program |

---

## ⚙️ Prerequisites & Setup

- JDK 17+ and IntelliJ IDEA
- A running MySQL server
- MySQL Connector/J on the classpath

**Maven:**
```xml
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <version>8.3.0</version>
</dependency>
```

**Connection URL format:**
```
jdbc:mysql://localhost:3306/employee_db
```

---

## ▶️ How to Run

1. Run the `CREATE DATABASE` / `CREATE TABLE` script from the [Project](#-project-employee-crud) section above in MySQL.
2. Open any file in `day-21/src/` and update the `url`, `user`, and `password` fields to match your local MySQL setup.
3. Run `Statement/JdbcDemo.java` first to confirm the connection works.
4. Run the files under `PreparedStatement/` in order — `JdbcInsert` → `MultipleInsert` → `JdbcDisplay` → `DeleteEmployee` → `DeleteAndDisplay` — to see the CRUD flow build up.
5. Run `EmployeeCRUD.java` for the full menu-driven experience.

---

## 🔑 Key Takeaways

- JDBC is the bridge between Java code and any relational database
- `Connection → Statement/PreparedStatement → ResultSet` is the core JDBC flow
- `PreparedStatement` should be the **default choice** for any query touching user input
- String-concatenated SQL is a direct path to SQL injection — parameterized queries close that gap
- `ResultSet` is cursor-based: always call `next()` before reading the first row
- Closing `Connection`, `Statement`, and `ResultSet` (ideally via try-with-resources) prevents connection leaks

---

## ➡️ What's Next

**Day 22** builds on this foundation — moving further into JDBC-backed applications
and closer to Spring Data JPA.

---

<p align="center">
  <img src="https://capsule-render.vercel.app/api?type=waving&color=0:4B8BBE,100:F7A41D&height=150&section=footer&text=Day%2021%20Complete!%20%F0%9F%8E%89&fontSize=24&fontColor=ffffff&animation=fadeIn"/>
</p>

<p align="center"><i>⭐ Part of the <b>JAVA-30-day-BootCamp</b> — if this helped, consider starring the repo!</i></p>
