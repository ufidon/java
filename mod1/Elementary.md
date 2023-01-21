# Elementary programming
Java is a general purpose programming language. It can be used to develop and deploy applications on desktop computers, small hand-held devices, and the Internet for servers.

Java is simple, object-oriented, interpreted, secure, architecture-neutral, portable, multi-threaded, distributed, and dynamic.

Java evolves dynamically. It has many versions. Please use Java 11 and above.

JDK (Java Development Kit) has three editions:
* Java SE - Standard Edition
* Java EE - Enterprise Edition
* Java ME - Micro Edition


Java elementary programming shares many common features with C++.

* Numerical data types: byte, short, int, long, float, double
* Printing numbers using methods from the [out](https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/io/PrintStream.html) data member of class  [System](https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/lang/System.html) such as *print, println and printf*.
* Reading numbers from keyboard with a [Scanner](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Scanner.html) object by its methods: *nextByte(), nextShort(), nextInt(), nextLong(), nextFloat(), nextDouble*
* Numeric operators: +, -, *, /, %
  * Integer division 5/2=2 vs. real number division 5.0/2=2.5
  * Calculations involving floating-point numbers are approximated: System.out.println(1.0-0.9); // prints 0.09999999999999998
* Augmented assignment operators: +=, -=, *=, /=, %=
* Increment and decrement operators: ++var, var++, --var, var--


**"Hello World" in Java.**

```java
// filename: Welcome.java
public class Welcome { 
  public static void main(String[] args) { 
    // Display message Welcome to Java! on the console
    System.out.println("Welcome to Java!");

    // Compute and display the result of expression
    System.out.print("(10.5 + 2 * 3) / (45 – 3.5) = ");
    System.out.println((10.5 + 2 * 3) / (45 - 3.5)); 
  }
}

```

**Compute circle area**

```java
import java.util.Scanner; // Scanner is in the java.util package

public class ComputeAreaWithConstant {
  public static void main(String[] args) {
    final double PI = 3.14159; // Declare a constant
    
    // Create a Scanner object
    Scanner input = new Scanner(System.in);
    
    // Prompt the user to enter a radius
    System.out.print("Enter a number for radius: ");
    double radius = input.nextDouble();

    // Compute area
    double area = radius * radius * PI;

    // Display result
    System.out.println("The area for the circle of radius " +
      radius + " is " + area);
  } 
}
```

**Exercises**

1. Write a program that converts a Fahrenheit degree to Celsius using the formula:
  $$celsius=\frac{5}{9}(fahrenheit - 32)$$
2. Write a program that displays current time in GMT in the format hour:minute:second such as 1:45:19. (Hint: The currentTimeMillis method in the System class returns the current time in milliseconds since the midnight, January 1, 1970 GMT.)  

3. Numerical type conversion (type casting): 
   * implicitly: double d = 3; // type widening 
   * explicitly: int i = (int)3.14; // type narrowing

4. Common errors and pitfalls in Java programming:
   * Undeclared/Uninitialized Variables and Unused Variables
     * double interestRate = 0.05; double interest = interestrate * 45; // caused by typo
   * Integer Overflow
     * int value = 2147483647 + 1; // What is value? -2147483648
   * Round-off Errors
     * System.out.println(1.0 - 0.1 - 0.1 - 0.1 - 0.1 - 0.1); // prints 0.5000000000000001
   * Unintended Integer Division
     * celsius = 5/9*(fahrenheit -32); // What is wrong here?
   * Redundant Input Objects: declare more than one Scanner objects in the same scope


# Reference textbooks
* [Introduction to Java Programming, Comprehensive, 12/E](https://media.pearsoncmg.com/bc/abp/cs-resources/products/product.html#product,isbn=0136519350)
  * [Student resources](https://media.pearsoncmg.com/ph/esm/ecs_liang_ijp_12/cw/)
  * [Source code](https://media.pearsoncmg.com/ph/esm/ecs_liang_ijp_12/cw/content/source-code.php)
    * [By chapters](https://media.pearsoncmg.com/ph/esm/ecs_liang_ijp_12/cw/content/ExampleByChapters.html)