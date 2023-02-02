# Review for exam 1

[Math functions](https://devdocs.io/openjdk~11/java.base/java/lang/math)
---

- What is output of each statement below?

```java
Math.cos(90);
Math.cos(Math.PI);
Math.cos(Math.PI/2);
Math.cos(Math.toRadians(90));
```

What is constructor chaining?
---
- Show your answer with an example.


How to create an array of objects?
---
```java
Crocodile[] crocodiles = new Crocodile[10];
// is crocodiles a reference variable? what does it refer to?
// is crocodiles[5] a reference variable? what does it refer to?
```

Does every user defined class has a parent?
---
- Confirm your answer with an example.


What is the output of the following statements?
---
```java
Date d1 = new Date(112233);
System.out.println(d1.getTime());
```

- [Java Date class](https://devdocs.io/openjdk~11/java.base/java/util/date)


What of the following function can change the value of a passing variable?
---
```java
void changeMe(int i){ i=10; }
void changeMe(String name){ name = "Trump"; }
void changeMe(Date date){ date.setTime(332211); }
```

Demonstrate variable scopes with examples
---


How to use keywords this and super?
---
- Demonstrate their usages with an example.


Design and use a class
---

Create a Crocodile class consisting of the following members.

- Data fields (private)
  - name: String
  - weight: double
  - cute: boolean
- Constructors (public)
  - no-arg constructor: sets the data fields to be
    - name = "George Soros";
    - weight = 100.25;
    - cute = true;
  - all-set constructor: sets each data fields to be the parameter respectively
- Methods (public)
  - Getters and setters for all data fields
  - override *String toString()* inherited implicitly from Object class, return a string representation of a Crocodile object with all its data fields.
- Write a *public static void main(String[] args)* method that does the following
  - Create a Crocodile object crocodile1 with the no-argument constructor, 
    - print crocodile1's information
  - Create another Crocodile object crocodile2 with  the all-set constructor
    - Before calling the all-set constructor, three actual parameter values for setting every property should be read from the user with proper prompts
    - print crocodile2's information
  - call crocodile1's three setters with values read from the user with proper prompts
  - print crocodile1's new information