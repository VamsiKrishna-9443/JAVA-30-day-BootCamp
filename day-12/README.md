# 🚀 Day 12 — Exception Handling in Java

> **Java 30-Day Developer Bootcamp**  
> **Focus:** Learn checked and unchecked exceptions, `try` / `catch` / `finally`, `throw`, `throws`, and custom exceptions through a Bank Account example.

---

## 🎬 Day 12 Opening Animation

![Day 12 Opening Animation](./day12-opening.gif)
<img width="1400" height="800" alt="day12-opening" src="https://github.com/user-attachments/assets/49d6d296-9f88-4e17-b677-dc883c1df016" />


---

# 🎯 Learning Objectives

By the end of Day 12, I learned:

- What an exception is.
- Why exception handling is required.
- The Java exception hierarchy.
- Difference between checked and unchecked exceptions.
- How `try`, `catch`, and `finally` work.
- Multiple `catch` blocks.
- Nested `try` blocks.
- How `throw` works.
- How `throws` works.
- Difference between `throw` and `throws`.
- What custom exceptions are.
- How to create a custom exception class.
- How to use custom exceptions in real applications.
- How to build a Bank Account with an `InsufficientFundsException`.

---

# 1. What is an Exception?

An **exception** is an event that occurs during program execution and disrupts the normal flow of the program.

Example:

```java
int a = 10;
int b = 0;

System.out.println(a / b);
```

This causes:

```text
ArithmeticException
```

Instead of allowing the program to terminate unexpectedly, Java provides exception-handling mechanisms.

```text
Normal Program
      ↓
Unexpected Condition
      ↓
Exception
      ↓
Handle Exception
      ↓
Continue / Terminate Gracefully
```

---

# 2. Why Do We Need Exception Handling?

Without exception handling:

```text
Exception occurs
      ↓
Program terminates
```

With exception handling:

```text
Exception occurs
      ↓
catch block handles it
      ↓
Program can continue
```

### Benefits

- Prevents abnormal program termination.
- Separates error-handling code from normal logic.
- Makes applications more robust.
- Provides meaningful error messages.
- Allows cleanup operations.
- Helps applications handle expected failure conditions gracefully.

---

# 3. Java Exception Hierarchy

The basic hierarchy is:

```text
                 Throwable
                    │
          ┌─────────┴─────────┐
          │                   │
       Error              Exception
                              │
                    ┌─────────┴──────────┐
                    │                    │
             RuntimeException       Other Exceptions
                    │                    │
              Unchecked              Checked
```

### `Throwable`

`Throwable` is the root class for objects that can be thrown by Java.

It has two major branches:

```text
Error
Exception
```

---

# 4. Error vs Exception

## Error

Errors generally represent serious problems that applications usually should not try to recover from.

Examples:

```text
OutOfMemoryError
StackOverflowError
```

## Exception

Exceptions represent conditions that an application may be able to handle.

Examples:

```text
IOException
SQLException
ArithmeticException
NullPointerException
```

For normal application-level exception handling, the focus is primarily on `Exception` and its subclasses.

---

# 5. Checked Exceptions

A **checked exception** is checked by the compiler.

The compiler requires the programmer to either:

1. Handle the exception using `try-catch`, or
2. Declare it using `throws`.

Examples:

```text
IOException
SQLException
ClassNotFoundException
```

Conceptually:

```text
Checked Exception
       ↓
Compiler checks
       ↓
Must handle OR declare
```

Example:

```java
import java.io.FileReader;
import java.io.IOException;

public class CheckedExceptionDemo
{
    public static void main(String[] args)
    {
        try
        {
            FileReader file = new FileReader("data.txt");
        }
        catch (IOException e)
        {
            System.out.println("File not found.");
        }
    }
}
```

---

# 6. Unchecked Exceptions

Unchecked exceptions are generally detected at runtime.

They are subclasses of:

```java
RuntimeException
```

Examples:

```text
ArithmeticException
NullPointerException
ArrayIndexOutOfBoundsException
NumberFormatException
```

Example:

```java
int number = Integer.parseInt("abc");
```

This causes:

```text
NumberFormatException
```

Conceptually:

```text
Program starts
      ↓
Runtime operation
      ↓
Invalid condition
      ↓
Unchecked Exception
```

---

# 7. Checked vs Unchecked Exceptions

| Checked Exception | Unchecked Exception |
|---|---|
| Checked by compiler | Occurs at runtime |
| Must handle or declare | No mandatory handling |
| Usually extends `Exception` | Extends `RuntimeException` |
| Often external/resource-related | Often programming/input-related |
| Example: `IOException` | Example: `ArithmeticException` |

### Easy way to remember

```text
Checked
   ↓
Compiler checks it

Unchecked
   ↓
Runtime checks it
```

---

# 🎬 Exception Handling Concept Animation

![Day 12 Concepts Animation](./day12-concepts.gif)
<img width="1400" height="800" alt="day12-concepts" src="https://github.com/user-attachments/assets/0a9ec60c-5ba8-4903-abe9-fb51986dd14c" />


---

# 8. `try` Block

The `try` block contains code that may produce an exception.

Syntax:

```java
try
{
    // risky code
}
```

Example:

```java
try
{
    int result = 10 / 0;
}
```

The `try` block itself does not handle the exception.

A `catch` block is used for handling it.

---

# 9. `catch` Block

The `catch` block handles an exception thrown from the corresponding `try` block.

Syntax:

```java
try
{
    // risky code
}
catch (Exception e)
{
    // handling code
}
```

Example:

```java
try
{
    int result = 10 / 0;
}
catch (ArithmeticException e)
{
    System.out.println("Cannot divide by zero.");
}
```

Output:

```text
Cannot divide by zero.
```

---

# 10. `finally` Block

The `finally` block contains cleanup code.

Syntax:

```java
try
{
    // risky code
}
catch (Exception e)
{
    // handling
}
finally
{
    // cleanup
}
```

Example:

```java
try
{
    System.out.println("Inside try");
}
catch (Exception e)
{
    System.out.println("Exception");
}
finally
{
    System.out.println("Finally executed");
}
```

Output:

```text
Inside try
Finally executed
```

### Typical use

`finally` is traditionally used for cleanup operations such as closing resources.

Modern Java code often prefers **try-with-resources** for `AutoCloseable` resources, but understanding `finally` remains important.

---

# 11. `try` / `catch` / `finally` Flow

```text
             try
              │
              ▼
       Exception occurs?
          /        \
        No          Yes
        │            │
        ▼            ▼
    Continue       catch
                       │
                       ▼
                    finally
                       │
                       ▼
                    Continue
```

---

# 12. Multiple `catch` Blocks

A single `try` block can have multiple `catch` blocks.

Example:

```java
try
{
    int[] arr = {10, 20, 30};

    System.out.println(arr[5]);
}
catch (ArithmeticException e)
{
    System.out.println("Arithmetic problem");
}
catch (ArrayIndexOutOfBoundsException e)
{
    System.out.println("Invalid array index");
}
catch (Exception e)
{
    System.out.println("Some other exception");
}
```

### Important Rule

Specific exceptions should come before general exceptions.

Correct:

```java
catch (ArithmeticException e)
{
}
catch (Exception e)
{
}
```

Incorrect:

```java
catch (Exception e)
{
}
catch (ArithmeticException e)
{
}
```

The second form causes a compilation error because the general `Exception` catch already handles the subclass.

---

# 13. Nested `try`

A `try` block can exist inside another `try` block.

Example:

```java
try
{
    try
    {
        int result = 10 / 0;
    }
    catch (ArithmeticException e)
    {
        System.out.println("Inner catch");
    }
}
catch (Exception e)
{
    System.out.println("Outer catch");
}
```

Nested exception handling should be used only when it improves the structure of the program.

---

# 14. `throw`

The `throw` keyword is used to **explicitly create and throw an exception**.

Syntax:

```java
throw new ExceptionType("message");
```

Example:

```java
int age = 15;

if (age < 18)
{
    throw new IllegalArgumentException("Age must be 18 or above.");
}
```

Here the programmer explicitly decides when the exception should occur.

### Think:

```text
throw
  ↓
I am explicitly throwing an exception NOW.
```

---

# 15. `throws`

The `throws` keyword is used in a method declaration to indicate that the method may pass an exception to its caller.

Example:

```java
public static void readFile() throws IOException
{
    FileReader file = new FileReader("data.txt");
}
```

The method is saying:

```text
"This method may throw IOException.
The caller is responsible for handling it."
```

### Think:

```text
throws
  ↓
This method may pass an exception to the caller.
```

---

# 16. `throw` vs `throws`

| `throw` | `throws` |
|---|---|
| Used to explicitly throw an exception | Used to declare possible exceptions |
| Used inside method/block | Used in method declaration |
| Throws one exception object at a time | Can declare multiple exception types |
| Creates/raises the exception | Transfers responsibility to caller |

Example:

```java
throw new Exception("Something went wrong");
```

versus:

```java
public void test() throws Exception
{
}
```

### Easy memory trick

```text
throw
  ↓
DO IT

throws
  ↓
DECLARE IT
```

---

# 17. Custom Exceptions

A **custom exception** is an exception created by the programmer for a specific application requirement.

Java provides many built-in exceptions, but sometimes business logic needs a meaningful exception.

Example:

```text
InsufficientFundsException
InvalidAgeException
InvalidAccountException
InvalidSalaryException
```

Instead of using a generic exception:

```text
Exception
```

we can create:

```text
InsufficientFundsException
```

This makes the code more meaningful.

---

# 18. Creating a Custom Checked Exception

A custom checked exception can extend:

```java
Exception
```

Example:

```java
class InsufficientFundsException extends Exception
{
    InsufficientFundsException(String message)
    {
        super(message);
    }
}
```

### What is happening?

```text
InsufficientFundsException
          ↓
       extends
          ↓
       Exception
```

Therefore it becomes a checked exception.

---

# 19. Why Use `super(message)`?

The constructor:

```java
InsufficientFundsException(String message)
{
    super(message);
}
```

passes the message to the parent `Exception` class.

Then:

```java
e.getMessage()
```

can return that message.

Example:

```java
throw new InsufficientFundsException(
    "Insufficient balance"
);
```

The message can later be displayed using:

```java
System.out.println(e.getMessage());
```

---

# 20. Bank Account — Real-World Example

Now we combine the concepts.

### Business rule

An account should not allow a withdrawal greater than the available balance.

```text
Balance = ₹10,000
Withdrawal = ₹12,000

₹12,000 > ₹10,000
        ↓
Insufficient Funds
        ↓
Throw InsufficientFundsException
```

---

# 21. Bank Account with Custom Exception

```java
package Exercise;

class InsufficientFundsException extends Exception
{
    InsufficientFundsException(String message)
    {
        super(message);
    }
}

public class BankAccount
{
    int accountNumber;
    String name;
    double balance;

    BankAccount(int accountNumber, String name, double balance)
    {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }

    void withdraw(double amount) throws InsufficientFundsException
    {
        if (amount > balance)
        {
            throw new InsufficientFundsException(
                "Insufficient balance"
            );
        }

        balance = balance - amount;

        System.out.println(
            "Withdrawal successful. Remaining balance: " + balance
        );
    }

    public static void main(String[] args)
    {
        BankAccount account =
            new BankAccount(101, "Vamsi", 10000);

        try
        {
            account.withdraw(12000);
        }
        catch (InsufficientFundsException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
```

Output:

```text
Insufficient balance
```

---

# 22. Bank Account Exception Flow

```text
                withdraw(12000)
                       │
                       ▼
              amount > balance?
                    /      \
                  No        Yes
                  │          │
                  ▼          ▼
              Withdraw    throw
              amount      InsufficientFundsException
                             │
                             ▼
                           catch
                             │
                             ▼
                    Display message
```

This is a practical example of:

```text
Custom Exception
       +
throw
       +
throws
       +
try
       +
catch
```

---

# 23. Why `throws` Is Used in `withdraw()`

The method:

```java
void withdraw(double amount)
    throws InsufficientFundsException
```

declares that it may throw:

```text
InsufficientFundsException
```

The caller then handles it:

```java
try
{
    account.withdraw(12000);
}
catch (InsufficientFundsException e)
{
    System.out.println(e.getMessage());
}
```

Therefore:

```text
withdraw()
   │
   │ throws
   ▼
InsufficientFundsException
   │
   ▼
caller handles it
   │
   ▼
catch
```

---

# 24. Complete Exception Handling Flow

```text
              Program
                 │
                 ▼
            Risky Operation
                 │
                 ▼
             Exception?
             /        \
           No          Yes
           │            │
           ▼            ▼
       Continue       catch
                         │
                         ▼
                     Handle Error
                         │
                         ▼
                      finally
                         │
                         ▼
                      Continue
```

---

# 25. Common Exceptions to Know

### `ArithmeticException`

```java
int x = 10 / 0;
```

---

### `NullPointerException`

```java
String name = null;
System.out.println(name.length());
```

---

### `ArrayIndexOutOfBoundsException`

```java
int[] arr = {10, 20};
System.out.println(arr[5]);
```

---

### `NumberFormatException`

```java
int n = Integer.parseInt("abc");
```

---

### `IOException`

Commonly associated with input/output operations such as file handling.

---

# 26. Exception Handling Best Practices

### 1. Catch specific exceptions

Prefer:

```java
catch (ArithmeticException e)
```

over unnecessarily broad handling:

```java
catch (Exception e)
```

when you know the specific failure.

### 2. Do not silently ignore exceptions

Avoid:

```java
catch (Exception e)
{
}
```

Handle the problem meaningfully.

### 3. Use meaningful messages

Example:

```java
throw new InsufficientFundsException(
    "Withdrawal amount exceeds available balance"
);
```

### 4. Do not use exceptions for normal program flow

Exceptions should represent exceptional conditions, not ordinary branching.

### 5. Use custom exceptions for meaningful business rules

Examples:

```text
InsufficientFundsException
InvalidAccountException
InvalidAgeException
```

---

# 27. Day 12 Project Structure

Based on the Day 12 implementation:

```text
day-12/
│
├── src/
│   │
│   ├── Exercise/
│   │   └── BankAccount.java
│   │
│   └── practice/
│       ├── ArithmeticExceptionDemo.java
│       ├── CheckedExceptionDemo.java
│       ├── CustomExceptionDemo.java
│       ├── FinallyDemo.java
│       ├── FinallyExceptionDemo.java
│       ├── MultipleCatchDemo.java
│       ├── NullPointerDemo.java
│       ├── NumberFormatDemo.java
│       ├── ThrowDemo.java
│       └── ThrowsDemo.java
│
├── test-output/
│
└── README.md
```

### `practice`

Contains individual programs for learning each exception-handling concept.

```text
ArithmeticExceptionDemo
        ↓
CheckedExceptionDemo
        ↓
CustomExceptionDemo
        ↓
FinallyDemo
        ↓
MultipleCatchDemo
        ↓
NullPointerDemo
        ↓
NumberFormatDemo
        ↓
ThrowDemo
        ↓
ThrowsDemo
```

### `Exercise`

Contains the practical application:

```text
BankAccount
     ↓
withdraw()
     ↓
InsufficientFundsException
```

---

# 28. Interview Questions

### Q1. What is an exception?

An exception is an event that disrupts the normal flow of program execution.

### Q2. What is the difference between checked and unchecked exceptions?

Checked exceptions are verified by the compiler and must be handled or declared. Unchecked exceptions occur at runtime and generally extend `RuntimeException`.

### Q3. What is the purpose of `try`?

It contains code that may produce an exception.

### Q4. What is the purpose of `catch`?

It handles an exception thrown from the corresponding `try` block.

### Q5. What is the purpose of `finally`?

It is used for cleanup code that should execute after the try/catch processing.

### Q6. What is `throw`?

`throw` explicitly throws an exception object.

### Q7. What is `throws`?

`throws` declares that a method may pass one or more exceptions to its caller.

### Q8. Can we have multiple `catch` blocks?

Yes.

### Q9. Can we have `try` without `catch`?

Yes, a `try` can be followed by `finally`.

### Q10. What is a custom exception?

An exception class created by the programmer for a specific application requirement.

### Q11. Why extend `Exception`?

To create a checked custom exception.

### Q12. What happens when withdrawal exceeds balance?

The Bank Account throws:

```text
InsufficientFundsException
```

and the caller handles it using `catch`.

---

# 🧠 29. Day 12 Key Takeaways

```text
                 Exception Handling
                         │
        ┌────────────────┼────────────────┐
        ▼                ▼                ▼
     Checked         Unchecked        Custom
        │                │                │
        ▼                ▼                ▼
    IOException    ArithmeticException  InsufficientFunds
                         │
                         ▼
                  try / catch / finally
                         │
                  ┌──────┴──────┐
                  ▼             ▼
                throw         throws
```

### Remember:

```text
Checked
   → Compiler checks

Unchecked
   → Runtime checks

try
   → Risky code

catch
   → Handle exception

finally
   → Cleanup

throw
   → Explicitly throw exception

throws
   → Declare possible exception

Custom Exception
   → Application-specific error
```

---

## 🎬 Day 12 Closing Animation

![Day 12 Closing Animation](./day12-closing.gif)

---

# ✅ Day 12 Completed

### Concepts Covered

- [x] Exception Handling
- [x] Exception Hierarchy
- [x] Checked Exceptions
- [x] Unchecked Exceptions
- [x] `try`
- [x] `catch`
- [x] `finally`
- [x] Multiple `catch`
- [x] Nested `try`
- [x] `throw`
- [x] `throws`
- [x] `throw` vs `throws`
- [x] Custom Exceptions
- [x] `InsufficientFundsException`
- [x] Bank Account Exception Handling
- [x] Exception Handling Best Practices
- [x] Interview Questions

---

# 🚀 Next — Day 13

```text
Day 12
Exception Handling
       ↓
Checked / Unchecked
       ↓
try / catch / finally
       ↓
throw / throws
       ↓
Custom Exceptions
       ↓
Bank Account
       ↓
Day 13 → Next Java Concept
```

> **Day 12 completed. Building strong Java fundamentals one concept at a time. 🚀**
