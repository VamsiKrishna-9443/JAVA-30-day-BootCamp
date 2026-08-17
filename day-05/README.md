# 🚀 Day 05 — Java Problem Solving II

<p align="center">
  <img src="https://readme-typing-svg.demolab.com?font=Fira+Code&size=24&pause=1000&color=F75C7E&center=true&vCenter=true&width=700&lines=Day+05+%7C+Java+Problem+Solving+II;Big-O+%7C+HashMap+%7C+Two+Pointers;Think+%E2%86%92+Optimize+%E2%86%92+Implement+%E2%86%92+Analyze" alt="Typing Animation" />
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Java-17%2B-orange?style=for-the-badge&logo=openjdk" />
  <img src="https://img.shields.io/badge/DSA-Problem%20Solving-blue?style=for-the-badge" />
  <img src="https://img.shields.io/badge/HashMap-Concept-success?style=for-the-badge" />
  <img src="https://img.shields.io/badge/Two%20Pointers-Technique-purple?style=for-the-badge" />
</p>

---

## 🎯 Day 05 Objective

The goal of Day 05 is to move beyond simply writing working Java programs and start thinking about **efficient problem-solving**.

Today's focus is:

* Understanding **Big-O notation**
* Analyzing **time complexity**
* Analyzing **space complexity**
* Using `HashMap` for fast lookup and frequency counting
* Understanding the **Two-Pointer technique**
* Converting brute-force solutions into optimized solutions
* Solving common interview-style problems
* Explaining the approach before writing code

> 💡 **Core Principle:**
> A good solution works.
> A better solution works efficiently.

---

# 🧠 Topics Covered

| #  | Topic                  | Importance |
| -- | ---------------------- | ---------- |
| 1  | Big-O Notation         | ⭐⭐⭐⭐⭐      |
| 2  | Time Complexity        | ⭐⭐⭐⭐⭐      |
| 3  | Space Complexity       | ⭐⭐⭐⭐       |
| 4  | HashMap                | ⭐⭐⭐⭐⭐      |
| 5  | Frequency Counting     | ⭐⭐⭐⭐⭐      |
| 6  | Two-Pointer Technique  | ⭐⭐⭐⭐⭐      |
| 7  | Two Sum                | ⭐⭐⭐⭐⭐      |
| 8  | First Unique Character | ⭐⭐⭐⭐       |
| 9  | Balanced Brackets      | ⭐⭐⭐⭐⭐      |
| 10 | Longest Word           | ⭐⭐⭐        |
| 11 | Complexity Analysis    | ⭐⭐⭐⭐⭐      |

---

# 1️⃣ Big-O Notation

## What is Big-O?

**Big-O notation** describes how the performance of an algorithm changes as the input size increases.

If the input contains `n` elements, we use `n` to represent the input size.

For example:

```java
for (int i = 0; i < n; i++) {
    System.out.println(i);
}
```

The loop executes `n` times.

Therefore:

```text
Time Complexity = O(n)
```

---

# 📊 Common Time Complexities

| Complexity   | Name         | Example                 |
| ------------ | ------------ | ----------------------- |
| `O(1)`       | Constant     | Array access            |
| `O(log n)`   | Logarithmic  | Binary Search           |
| `O(n)`       | Linear       | Single loop             |
| `O(n log n)` | Linearithmic | Efficient sorting       |
| `O(n²)`      | Quadratic    | Nested loops            |
| `O(2ⁿ)`      | Exponential  | Some recursive problems |
| `O(n!)`      | Factorial    | Permutations            |

### Complexity hierarchy

```text
O(1)
   ↓
O(log n)
   ↓
O(n)
   ↓
O(n log n)
   ↓
O(n²)
   ↓
O(2ⁿ)
   ↓
O(n!)
```

The lower the complexity, generally the better the scalability.

---

# 2️⃣ Time Complexity

Time complexity measures how the **number of operations** grows with the input size.

### Example — O(1)

```java
int first = arr[0];
```

Regardless of whether the array contains:

```text
10 elements
100 elements
1,000,000 elements
```

we access only one element.

```text
Time = O(1)
```

---

## Example — O(n)

```java
for (int i = 0; i < arr.length; i++) {
    System.out.println(arr[i]);
}
```

The loop runs once for every element.

```text
Time = O(n)
```

---

## Example — O(n²)

```java
for (int i = 0; i < n; i++) {

    for (int j = 0; j < n; j++) {
        System.out.println(i + " " + j);
    }

}
```

The outer loop runs `n` times.

The inner loop also runs `n` times.

Therefore:

```text
n × n = n²

Time Complexity = O(n²)
```

---

# 3️⃣ Space Complexity

Space complexity measures the **additional memory** used by an algorithm.

Example:

```java
int sum = 0;

for (int num : arr) {
    sum += num;
}
```

Only a few variables are used.

```text
Auxiliary Space = O(1)
```

---

## HashMap Example

```java
Map<Integer, Integer> frequency = new HashMap<>();

for (int num : nums) {
    frequency.put(num,
        frequency.getOrDefault(num, 0) + 1
    );
}
```

In the worst case, the HashMap can contain `n` unique elements.

Therefore:

```text
Time Complexity = O(n)
Space Complexity = O(n)
```

---

# 4️⃣ HashMap

`HashMap` stores data in **key-value pairs**.

```java
HashMap<Key, Value>
```

Example:

```java
HashMap<String, Integer> marks = new HashMap<>();

marks.put("Vamsi", 90);
marks.put("Rahul", 85);
marks.put("Akhil", 92);
```

Conceptually:

```text
Key       Value
----------------
Vamsi       90
Rahul       85
Akhil       92
```

---

## Important HashMap Methods

```java
put()
get()
getOrDefault()
containsKey()
remove()
size()
isEmpty()
clear()
```

### Example

```java
Map<Character, Integer> frequency = new HashMap<>();

frequency.put('a', 1);

frequency.put(
    'a',
    frequency.getOrDefault('a', 0) + 1
);
```

Result:

```text
a → 2
```

---

# 5️⃣ Frequency Counter Pattern

The frequency-counter pattern is extremely useful for:

* Counting characters
* Counting numbers
* Finding duplicates
* Finding unique elements
* Anagram problems
* Frequency comparison

Example:

```java
String text = "banana";

Map<Character, Integer> frequency = new HashMap<>();

for (char ch : text.toCharArray()) {

    frequency.put(
        ch,
        frequency.getOrDefault(ch, 0) + 1
    );
}
```

Result:

```text
b → 1
a → 3
n → 2
```

### Complexity

```text
Time  = O(n)
Space = O(k)
```

Where `k` is the number of unique characters.

---

# 6️⃣ Two-Pointer Technique

The **Two-Pointer technique** uses two indexes/pointers to process data efficiently.

Usually:

```text
left  → beginning
right → ending
```

Example:

```text
[1, 2, 3, 4, 5, 6]
 ↑              ↑
left           right
```

We move the pointers depending on the problem.

---

## Common Two-Pointer Patterns

### Pattern 1 — Opposite Direction

```java
int left = 0;
int right = arr.length - 1;

while (left < right) {

    // process

    left++;
    right--;
}
```

### Pattern 2 — Same Direction

Used for:

* Removing duplicates
* Sliding-style problems
* Fast/slow pointer problems

---

# 7️⃣ Problem — Two Sum

## Problem

Given an array and a target value, find two numbers whose sum equals the target.

Example:

```text
Input:
nums = [2, 7, 11, 15]
target = 9

Output:
[0, 1]
```

Because:

```text
2 + 7 = 9
```

---

## ❌ Brute Force Approach

Check every possible pair.

```java
for (int i = 0; i < nums.length; i++) {

    for (int j = i + 1; j < nums.length; j++) {

        if (nums[i] + nums[j] == target) {
            return new int[]{i, j};
        }
    }
}
```

### Complexity

```text
Time  = O(n²)
Space = O(1)
```

---

## ✅ Optimized HashMap Approach

Instead of searching for the second number repeatedly, store previously seen values.

```java
Map<Integer, Integer> map = new HashMap<>();

for (int i = 0; i < nums.length; i++) {

    int complement = target - nums[i];

    if (map.containsKey(complement)) {
        return new int[]{
            map.get(complement),
            i
        };
    }

    map.put(nums[i], i);
}
```

### Complexity

```text
Time  = O(n)
Space = O(n)
```

### Key Insight

Instead of asking:

> "Which number should I search for?"

Calculate:

```text
complement = target - currentNumber
```

Then perform a HashMap lookup.

---

# 8️⃣ Problem — First Unique Character

## Problem

Find the first character that appears only once.

Example:

```text
Input:
leetcode

Output:
0
```

Because:

```text
l → 1
e → 3
t → 1
c → 1
o → 1
d → 1
```

The first unique character is:

```text
l
```

---

## Approach

### Step 1

Count every character.

```java
Map<Character, Integer> frequency = new HashMap<>();

for (char ch : s.toCharArray()) {
    frequency.put(
        ch,
        frequency.getOrDefault(ch, 0) + 1
    );
}
```

### Step 2

Traverse again.

```java
for (int i = 0; i < s.length(); i++) {

    if (frequency.get(s.charAt(i)) == 1) {
        return i;
    }
}
```

### Complexity

```text
Time  = O(n)
Space = O(k)
```

---

# 9️⃣ Problem — Balanced Brackets

## Problem

Determine whether brackets are correctly balanced.

Example:

```text
Input:
"{[()]}"

Output:
true
```

Invalid example:

```text
Input:
"{[(])}"

Output:
false
```

---

## Why Stack?

Brackets follow **Last-In-First-Out (LIFO)** behavior.

Example:

```text
(
[
{
}
]
)
```

The most recently opened bracket must be closed first.

Therefore:

```text
Stack → LIFO
```

---

## Approach

```java
Stack<Character> stack = new Stack<>();

for (char ch : s.toCharArray()) {

    if (ch == '(' ||
        ch == '{' ||
        ch == '[') {

        stack.push(ch);

    } else {

        if (stack.isEmpty()) {
            return false;
        }

        char top = stack.pop();

        if ((ch == ')' && top != '(') ||
            (ch == '}' && top != '{') ||
            (ch == ']' && top != '[')) {

            return false;
        }
    }
}

return stack.isEmpty();
```

### Complexity

```text
Time  = O(n)
Space = O(n)
```

---

# 🔟 Problem — Frequency Counter

## Problem

Count how many times each element occurs.

Example:

```text
Input:
[1, 2, 2, 3, 1, 2]

Output:

1 → 2
2 → 3
3 → 1
```

### Solution

```java
Map<Integer, Integer> frequency = new HashMap<>();

for (int num : nums) {

    frequency.put(
        num,
        frequency.getOrDefault(num, 0) + 1
    );
}
```

### Complexity

```text
Time  = O(n)
Space = O(n)
```

---

# 1️⃣1️⃣ Problem — Longest Word

## Problem

Find the longest word from a sentence.

Example:

```text
Input:
"Java is powerful"

Output:
"powerful"
```

### Approach

1. Split the sentence into words.
2. Maintain the longest word.
3. Compare each word length.
4. Update when a longer word is found.

```java
String longest = "";

for (String word : sentence.split(" ")) {

    if (word.length() > longest.length()) {
        longest = word;
    }
}

System.out.println(longest);
```

### Complexity

If the sentence contains `n` characters:

```text
Time  = O(n)
Space = O(n)
```

The exact auxiliary space can depend on how the sentence is split and represented.

---

# 🧩 Problem-Solving Framework

For every DSA problem, follow this process:

```text
       ┌───────────────────┐
       │ Understand Problem│
       └─────────┬─────────┘
                 ↓
       ┌───────────────────┐
       │ Identify Pattern  │
       └─────────┬─────────┘
                 ↓
       ┌───────────────────┐
       │ Brute Force First │
       └─────────┬─────────┘
                 ↓
       ┌───────────────────┐
       │ Find Bottleneck   │
       └─────────┬─────────┘
                 ↓
       ┌───────────────────┐
       │ Optimize           │
       └─────────┬─────────┘
                 ↓
       ┌───────────────────┐
       │ Implement Java     │
       └─────────┬─────────┘
                 ↓
       ┌───────────────────┐
       │ Test Edge Cases    │
       └─────────┬─────────┘
                 ↓
       ┌───────────────────┐
       │ Analyze Complexity │
       └───────────────────┘
```

---

# 🧪 Edge Cases to Consider

Before submitting any solution, test:

* Empty input
* Single element
* Duplicate values
* Negative numbers
* Zero
* Very large input
* Repeated characters
* No valid answer
* Multiple valid answers
* Already sorted input
* Reverse-sorted input

---

# 📚 Key Interview Patterns Learned

| Pattern                | Typical Usage                          |
| ---------------------- | -------------------------------------- |
| Frequency Counter      | Duplicates, anagrams, character counts |
| HashMap Lookup         | Two Sum, fast searching                |
| Two Pointers           | Sorted arrays, pair problems           |
| Stack                  | Balanced brackets                      |
| Single Traversal       | Linear-time optimization               |
| Brute Force → Optimize | Interview problem solving              |

---

# ⚡ Brute Force vs Optimized Thinking

### Example: Two Sum

| Approach     |    Time |  Space |
| ------------ | ------: | -----: |
| Nested loops | `O(n²)` | `O(1)` |
| HashMap      |  `O(n)` | `O(n)` |

The optimized solution uses additional memory to significantly reduce execution time.

This is an important **time-space tradeoff**.

---

# 📝 Day 05 Exercises

* [ ] Implement Two Sum using brute force.
* [ ] Implement Two Sum using HashMap.
* [ ] Find the first unique character.
* [ ] Build a frequency counter.
* [ ] Check balanced brackets.
* [ ] Find the longest word.
* [ ] Write the brute-force approach where applicable.
* [ ] Optimize at least two solutions.
* [ ] Calculate time complexity.
* [ ] Calculate space complexity.
* [ ] Test edge cases.
* [ ] Push all solutions to GitHub.

---

# 💻 Recommended Project Structure

```text
day-05/
│
├── src/
│   ├── TwoSum.java
│   ├── FirstUniqueCharacter.java
│   ├── BalancedBrackets.java
│   ├── FrequencyCounter.java
│   └── LongestWord.java
│
├── test-output/
│   └── output.txt
│
└── README.md
```

---

# 📊 Day 05 Complexity Summary

| Problem                |    Time |  Space |
| ---------------------- | ------: | -----: |
| Two Sum — Brute Force  | `O(n²)` | `O(1)` |
| Two Sum — HashMap      |  `O(n)` | `O(n)` |
| First Unique Character |  `O(n)` | `O(k)` |
| Balanced Brackets      |  `O(n)` | `O(n)` |
| Frequency Counter      |  `O(n)` | `O(k)` |
| Longest Word           |  `O(n)` | `O(n)` |

> `k` = number of unique elements/characters.

---

# 🏆 Self Assessment

Rate yourself honestly:

| Skill               | Rating |
| ------------------- | ------ |
| Big-O understanding | ⭐⭐⭐⭐⭐  |
| Time complexity     | ⭐⭐⭐⭐⭐  |
| Space complexity    | ⭐⭐⭐⭐⭐  |
| HashMap             | ⭐⭐⭐⭐⭐  |
| Frequency counting  | ⭐⭐⭐⭐⭐  |
| Two pointers        | ⭐⭐⭐⭐⭐  |
| Stack               | ⭐⭐⭐⭐⭐  |
| Problem solving     | ⭐⭐⭐⭐⭐  |
| Complexity analysis | ⭐⭐⭐⭐⭐  |

### Reflection

**What I learned:**

> I learned how to analyze the efficiency of Java algorithms using Big-O notation and how HashMap, frequency counting, two-pointer and stack-based approaches can optimize common programming problems.

**Biggest challenge:**

> ---

**How I solved it:**

> ---

**What I need to practice more:**

> ---

---

# 🔐 Verification Checklist

* [ ] All Java programs compile successfully.
* [ ] All test cases pass.
* [ ] Edge cases are tested.
* [ ] Brute-force solutions are understood.
* [ ] Optimized solutions are implemented.
* [ ] Time complexity is documented.
* [ ] Space complexity is documented.
* [ ] Source code is pushed to GitHub.
* [ ] Test output is captured.
* [ ] Self-assessment is completed.

---

# 📈 Day 05 Outcome

By the end of Day 05, I should be able to:

```text
Understand Big-O
       ↓
Analyze Algorithms
       ↓
Identify Bottlenecks
       ↓
Choose the Right Data Structure
       ↓
Apply HashMap / Two Pointers / Stack
       ↓
Optimize Brute Force Solutions
       ↓
Write Clean Java Code
       ↓
Explain Time & Space Complexity
```

---

## 🔥 Key Takeaway

> **Don't just ask: "Does my code work?"**

Ask:

> **"How efficiently does my code work, and how will it behave when the input becomes very large?"**

Day 05 is the transition from **Java syntax → Java problem solving**.

---

<p align="center">

### 🚀 Day 05 Complete

**Think • Code • Optimize • Analyze • Commit**

<img src="https://capsule-render.vercel.app/api?type=waving&color=gradient&height=100&section=footer" />

</p>
