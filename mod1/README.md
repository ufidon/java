# Module 1: Fundamental Java programming

## Topics
Chapter 1-7

1. Introduction to computers, programs, and Java
2. Elementary programming
3. Selections and loops
4. Mathematical functions, characters, and strings
5. Methods
6. Single-dimensional arrays

## Elementary programming
Java is a general purpose programming language. It can be used to develop and deploy applications on desktop computers, small hand-held devices, and the Internet for servers.

Java is simple, object-oriented, interpreted, secure, architecture-neutral, portable, multi-threaded, distributed, and dynamic.

Java evolves dynamically. It has many versions. Please use Java 11 and above.

JDK (Java Development Kit) has three editions:
* Java SE - Standard Edition
* Java EE - Enterprise Edition
* Java ME - Micro Edition


Java elementary programming shares many common features with C++.

* Numerical data types: byte, short, int, long, float, double
* Printing numbers using methods from the [out](https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/io/PrintStream.html) data member of class  [System](https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/lang/System.html)
* Reading numbers from keyboard with a [Scanner](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Scanner.html) object by its methods: nextByte(), nextShort(), nextInt(), nextLong(), nextFloat(), nextDouble
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


## Selections and loops

* Boolean type and relational operators:
  * boolean b = (1>2)?
  * <, <=, >, >=, ==, !=
* Logical operators: ! (not), && (and), || (or), ^ (exclusive or)

If statements
* One-way if statements: 
  ```java
  if(boolean-expression){
    statements;
  }
  ```
* Two-way if statements:  
  ```java
  if(boolean-expression){
    statements1; // for the true case
  }else{
    statements2; // for the false case
  }
  ```
* Multiple alternative if statements
  ```java
  if(score >= 90.0)
    System.out.print("A");
  else if(score >= 80.0)
    System.out.print("B");
  else if(score >= 70.0);
    System.out.print("C");
  else if(score >= 60.0)
    System.out.print("D");
  else
    System.out.print("F");    
  ```
* Notes: 
  * The else clause matches the most recent if clause in the same block.
  * Adding a semicolon at the end of an if clause is a common mistake: 
    ```java
    if (radius >= 0); 
    {
      statements;
    } 
    ```   
  * if(even==true) is equivalent to if(even)



**Lottery of guessing two digits**

```java
import java.util.Scanner;

public class Lottery {
  public static void main(String[] args) {
    // Generate a lottery
    int lottery = (int)(Math.random() * 100);

    // Prompt the user to enter a guess
    Scanner input = new Scanner(System.in);
    System.out.print("Enter your lottery pick (two digits): ");
    int guess = input.nextInt();

    // Get digits from lottery
    int lotteryDigit1 = lottery / 10;
    int lotteryDigit2 = lottery % 10;

    // Get digits from guess
    int guessDigit1 = guess / 10;
    int guessDigit2 = guess % 10;

    System.out.println("The lottery number is " + lottery);

    // Check the guess
    if (guess == lottery)
      System.out.println("Exact match: you win $10,000");
    else if (guessDigit2 == lotteryDigit1
          && guessDigit1 == lotteryDigit2)
      System.out.println("Match all digits: you win $3,000");
    else if (guessDigit1 == lotteryDigit1 
          || guessDigit1 == lotteryDigit2 
          || guessDigit2 == lotteryDigit1 
          || guessDigit2 == lotteryDigit2)
      System.out.println("Match one digit: you win $1,000");
    else
      System.out.println("Sorry, no match"); 
  }
}
```

**Exercises**

1. Write a program to calculate BMI (Body Mass Index)

| BMI                | Interpretation |
| ------------------ | -------------- |
| BMI < 18.5         | Underweight    |
| 18.5 <= BMI < 25.0 | Normal         |
| 25.0 <= BMI < 30.0 | Overweight     |
| 30.0 <= BMI        | Obese          |

2. Compute taxes: 2022 Single Filers Tax Brackets

| If taxable income is:               | The tax due is:                                     |
| ----------------------------------- | --------------------------------------------------- |
| Not over $10,275                    | 10% of the taxable income                           |
| Over $10,275 but not over $41,775   | $1,027.50 plus 12% of the excess over $10,275       |
| Over $41,775 but not over $89,075   | $4,807.50 plus 22% of the excess over $41,775       |
| Over $89,075 but not over $170,050  | $15,213.50 plus 24% of the excess over $89,075      |
| Over $170,050 but not over $215,950 | $34,647.50 plus 32% of the the excess over $170,050 |
| Over $215,950 but not over $539,900 | $49,335.50 plus 35% of the excess over $215,950     |
| Over $539,900                       | $162,718 plus 37% of the excess over $539,900       |

3. Determine leap year. A year is a leap year if it is divisible by 4 but not by 100, or it is divisible by 400.


* Switch statements
  ```java
  switch(day){
    case 1: case 2: case 3: case 4:
    case 5: System.out.println("Weekday"); break;
    case 0:
    case 6:
      System.out.println("Weekend");
  } 
  ```  
* Conditional operators: (boolean-expression)?expression-when-true:expression-when-false

**Chinese zodiac**

```java
import java.util.Scanner;

public class ChineseZodiac {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    
    System.out.print("Enter a year: ");
    int year = input.nextInt();
    
    switch (year % 12) {
      case 0: System.out.println("monkey"); break;
      case 1: System.out.println("rooster"); break;
      case 2: System.out.println("dog"); break;
      case 3: System.out.println("pig"); break;
      case 4: System.out.println("rat"); break;
      case 5: System.out.println("ox"); break;
      case 6: System.out.println("tiger"); break;
      case 7: System.out.println("rabbit"); break;
      case 8: System.out.println("dragon"); break;
      case 9: System.out.println("snake"); break;
      case 10: System.out.println("horse"); break;
      case 11: System.out.println("sheep"); break;
      default: 
        System.out.println("This won't happen"); 
        System.exit(1);
        break;
    }
  }
}
```

* Operator Precedence

| Precedence | Operator                                     | Type                                                                                                                                                   | Associativity |
| ---------- | -------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------ | ------------- |
| 15         | ()<br>[]<br>·                                | Parentheses<br>Array subscript<br>Member selection<br>                                                                                                 | Left to Right |
| 14         | ++<br>\--                                    | Unary post-increment<br>Unary post-decrement                                                                                                           | Left to Right |
| 13         | ++<br>\--<br>+<br>\-<br>!<br>~<br>( _type_ ) | Unary pre-increment<br>Unary pre-decrement<br>Unary plus<br>Unary minus<br>Unary logical negation<br>Unary bitwise complement<br>Unary type cast       | Right to left |
| 12         | \*<br>/<br>%                                 | Multiplication<br>Division<br>Modulus                                                                                                                  | Left to right |
| 11         | +<br>\-                                      | Addition<br>Subtraction                                                                                                                                | Left to right |
| 10         | <<<br>\>><br>\>>>                            | Bitwise left shift<br>Bitwise right shift with sign extension<br>Bitwise right shift with zero extension                                               | Left to right |
| 9          | <<br><=<br>\><br>\>=<br>instanceof           | Relational less than<br>Relational less than or equal<br>Relational greater than<br>Relational greater than or equal<br>Type comparison (objects only) | Left to right |
| 8          | \==<br>!=                                    | Relational is equal to<br>Relational is not equal to                                                                                                   | Left to right |
| 7          | &                                            | Bitwise AND                                                                                                                                            | Left to right |
| 6          | ^                                            | Bitwise exclusive OR                                                                                                                                   | Left to right |
| 5          | |                                            | Bitwise inclusive OR                                                                                                                                   | Left to right |
| 4          | &&                                           | Logical AND                                                                                                                                            | Left to right |
| 3          | ||                                           | Logical OR                                                                                                                                             | Left to right |
| 2          | ? :                                          | Ternary conditional                                                                                                                                    | Right to left |
| 1          | \=<br>+=<br>\-=<br>\*=<br>/=<br>%=           | Assignment<br>Addition assignment<br>Subtraction assignment<br>Multiplication assignment<br>Division assignment<br>Modulus assignment                  | Right to left |



* Operator Associativity
  * left-associative: a – b + c – d is equivalent to  ((a – b) + c) – d
  * right-associative: a = b += c = 5 is equivalent to a = (b += (c = 5))

## Mathematical functions, characters, and strings
### Mathematical functions
* The [Math class](https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html):
  * Class constants: PI (𝜋), E (e - the natural number)
  * Class methods: 
    * trigonometric: double trigfuns(double)
      * sin, cos, tan, asin, acos, atan
    * exponent: double expfuns(double)
      * exp, log, log10, pow, sqrt
    * rounding: 
      * double ceil(double x) // x rounded up to its nearest integer. This integer is  returned as a double value.
      * double floor(double x) // x is rounded down to its nearest integer. This integer is  returned as a double value.
      * doube rint(double x) // x is rounded to its nearest integer. If x is equally close to two integers, the even one is returned as a double  
      * int round(float x)  // Return (int)Math.floor(x+0.5)
      * long round(double x) // Return (long)Math.floor(x+0.5)
    * min, max, abs 
    * random // Returns a random double value in the range [0.0, 1.0).

**Examples**
1. Mathematical functions
```java
Math.sin(0); // returns 0.0 
Math.sin(Math.PI / 6); //  returns 0.5 
Math.sin(Math.PI / 2); //  returns 1.0
Math.cos(0); //  returns 1.0
Math.cos(Math.PI / 6); //  returns 0.866 
Math.cos(Math.PI / 2); //  returns 0 

Math.exp(1); //  returns 2.71 
Math.log(2.71); //  returns 1.0 
Math.pow(2, 3); //  returns 8.0 
Math.pow(3, 2); //  returns 9.0 
Math.pow(3.5, 2.5); //  returns 22.91765 
Math.sqrt(4); //  returns 2.0
Math.sqrt(10.5); //  returns 3.24

Math.ceil(2.1); // returns 3.0 
Math.ceil(2.0); //  returns 2.0
Math.ceil(-2.0); //  returns –2.0
Math.ceil(-2.1); //  returns -2.0
Math.floor(2.1); //  returns 2.0
Math.floor(2.0); //  returns 2.0
Math.floor(-2.0); //  returns –2.0
Math.floor(-2.1); //  returns -3.0
Math.rint(2.1); //  returns 2.0
Math.rint(2.0); //  returns 2.0
Math.rint(-2.0); //  returns –2.0
Math.rint(-2.1); //  returns -2.0
Math.rint(2.5); //  returns 2.0
Math.rint(-2.5); //  returns -2.0
Math.round(2.6f); //  returns 3 
Math.round(2.0); //  returns 2   
Math.round(-2.0f); //  returns -2   
Math.round(-2.6); //  returns -3

Math.max(2, 3); //  returns 3 
Math.max(2.5, 3); //  returns 3.0 
Math.min(2.5, 3.6); //  returns 2.5 
Math.abs(-2); //  returns 2
Math.abs(-2.1); //  returns 2.1

a + Math.random()*b; //  returns a random number ∊ [a,b)
a + Math.random()*(b+1); //  returns a random number ∊ [a,b]

```
1. Compute the sides and angles of a triangle giving the coordinates of its three [vertices](../bookcode/chapter4/ComputeAngles.java).
  $${\displaystyle \alpha =\arccos \left({\frac {b^{2}+c^{2}-a^{2}}{2bc}}\right)}$$
  $${\displaystyle \beta =\arccos \left({\frac {a^{2}+c^{2}-b^{2}}{2ac}}\right)}$$
  $${\displaystyle \gamma =\arccos \left({\frac {a^{2}+b^{2}-c^{2}}{2ab}}\right)}$$


### Character data type
A char type is 16 bits, i.e. two bytes. Unicode takes two bytes, preceded by \u, expressed in four hexadecimal numbers that run from '\u0000' to '\uFFFF'. So, Unicode can represent 65535 + 1 characters.

```java
char letter = 'A'; //(ASCII)       
char numChar = '4'; //(ASCII)
char letter = '\u0041'; //(Unicode)
char numChar = '\u0034'; //(Unicode)
```


The increment and decrement operators can also be used on char variables to get the next or preceding Unicode character. 
```java
char ch = 'b';
System.out.println(++ch); // displays 'c'
System.out.println(--ch); // displays 'b'
System.out.println(--ch); // displays 'a'

```

char and numeric types can be casted into each other.

```java
int i = 'a'; // Same as int i = (int)'a';
char c = 97; // Same as char c = (char)97;
```

Comparing and Testing Characters

```java
if (ch >= 'A' && ch <= 'Z') 
  System.out.println(ch + " is an uppercase letter"); 
else if (ch >= 'a' && ch <= 'z') 
  System.out.println(ch + " is a lowercase letter"); 
else if (ch >= '0' && ch <= '9') 
  System.out.println(ch + " is a numeric character"); 
```  

[Character](https://docs.oracle.com/javase/7/docs/api/java/lang/Character.html) class has many methods such as

* isDigit, isLetter, isLetterOfDigit
* isLowerCase, isUpperCase
* toLowerCase, toUpperCase, etc.

The char type only represents one character.

### String
To represent a string of characters, use the data type called String.
* String is actually a predefined class in the Java library just like the System class and Scanner class. 
* The String type is not a primitive type. It is known as a reference type. 
* Popular methods of String objects
  * length, charAt, concat, toUpperCase, toLowerCase, trim

**Examples**

```java
// 1. Getting String Length
String message = "Welcome to Java";
System.out.println("The length of " + message + " is " + message.length());

// 2. Getting Characters from a String
System.out.println("The first character in message is " + message.charAt(0));

// 3. Case conversion
"Welcome".toLowerCase(); // returns a new string, welcome.
"Welcome".toUpperCase(); // returns a new string, WELCOME.

// 4. Trim leading and trailing spaces
"  Welcome  ".trim(); // returns a new string, Welcome.

// 5. String Concatenation
String s3 = s1.concat(s2); or String s3 = s1 + s2;

// Three strings are concatenated
String message = "Welcome " + "to " + "Java";
 
// String Chapter is concatenated with number 2
String s = "Chapter" + 2; // s becomes Chapter2
 
// String Supplement is concatenated with character B
String s1 = "Supplement" + 'B'; // s1 becomes SupplementB

// 6. Reading a String from the Console 
Scanner input = new Scanner(System.in);
System.out.print("Enter three words separated by spaces: ");
String s1 = input.next();
String s2 = input.next();
String s3 = input.next();
System.out.println("s1 is " + s1);
System.out.println("s2 is " + s2);
System.out.println("s3 is " + s3);

// 7. Reading a line then extract individual Characters from the Console
System.out.print("Enter a character: ");
String s = input.nextLine();
char ch = s.charAt(0);
System.out.println("The character entered is " + ch);

```

Methods for 
* comparing Strings:
  * equals(s1) // this string == s1?
  * equalsIgnoreCase(s1) 
  * compareTo(s1)
  * compareToIgnoreCase(s1)
  * startsWtih(prefix)
  * endsWith(suffix)
* obtaining substrings
  * substring(beginIndex)
  * substring(beginIndex, endIndex)
* finding a character or a substring in a string
  * indexOf(ch)
  * indexOf(ch, fromIndex)
  * indexOf(s)
  * indexOf(s, fromIndex)
  * lastIndexOf(ch)
  * lastIndexOf(ch, fromIndex)
  * lastIndexOf(s)
  * lastIndexOf(s, fromIndex)

```java
String s="Donald Trump";
int k = s.indexOf(' '); // returns 6
String fistName = s.substring(0,k); // returns Donald
String lastName = s.substring(k+1); // returns Trump
```

Conversion between strings and numbers

```java
String intString = "12345";
String doubleString = "3.1415";
int intValue = Integer.parseInt(intString);
double doubleValue = Double.parseDouble(doubleString);

int number = 54321;
String s = number + "";
```

**Examples**

1. [Guessing birthday](../bookcode/chapter4/GuessBirthday.java)
2. [Converting a hexadecimal digit to a decimal value](../bookcode/chapter4/HexDigit2Dec.java)
3. [Revising the lottery program using strings](../bookcode/chapter4/LotteryUsingStrings.java)
4. Format output using the printf statement: System.out.printf(format, items). Write a [program](../bookcode/chapter4/FormatDemo.java) to generate the following table

| Degrees | Radians | Sine  | Cosine | Tangent |
| ------- | ------- | ----- | ------ | ------- |
| 30      | 0.5236  | 0.5   | 0.866  | 0.5774  |
| 60      | 1.0472  | 0.866 | 0.5    | 1.7321  |



## Loops
* while:
  ```java
  while(loop-continuation-condition){
    statements;
  }
  ```
* do while:
  ```java
  do{
    statements;
  }while(loop-continuation-condition);
  ```
* for:
```java
for(initial-actions; loop-continuation-condition; action-after-each-iteration)
{
  statements;
}
```
* These loops can be nested.
* The loops can be terminated with break. The iteration can be terminated with continue.
* **Notes**:
  * Don’t use floating-point values for equality checking in a loop control. Since floating-point values are approximations for some values, using them could result in imprecise counter values and inaccurate results. For example, the following code for computing 1 + 0.9 + 0.8 + ... + 0.1:
  ```java
  double item = 1; double sum = 0;
  while (item != 0) { // No guarantee item will be 0
    sum += item;
    item -= 0.1;
  }
  System.out.println(sum);
  ```
  * The initial-action in a for loop can be a list of zero or more comma-separated expressions. The action-after-each-iteration in a for loop can be a list of zero or more comma-separated statements. 
  * If the loop-continuation-condition in a for loop is omitted, it is implicitly true. for(;;) is equivalent to while(true), both are infinite loop.
  * Adding a semicolon at the end of the for clause before the loop body is a common mistake.
  ```java
  for (int i=0; i<10; i++); // logic error
  {
    System.out.println("i is " + i);
  }
  while (i < 10); // logic error
  {
    System.out.println("i is " + i);
    i++;
  }
  do {
  System.out.println("i is " + i);
    i++;
  } while (i<10); // here the ; must have
  ```

**Examples**
1. [Guessing number one time](../bookcode/chapter5/GuessNumberOneTime.java)
2. [Guessing number until get it](../bookcode/chapter5/GuessNumber.java)
3. [Subtraction quiz loop](../bookcode/chapter5/SubtractionQuizLoop.java)
4. [Ending a loop with a sentinel value](../bookcode/chapter5/SentinelValue.java)
5. [Minimizing numerical errors](../bookcode/chapter5/TestSum.java)
6. [Finding the greatest commond divisor(gcd)](../bookcode/chapter5/GreatestCommonDivisor.java)
7. [Predicting future tuition](../bookcode/chapter5/FutureTuition.java)
8. [Converting decimals to hexadecimals](../bookcode/chapter5/Dec2Hex.java)
9. [Test break](../bookcode/chapter5/TestBreak.java)
10. [Test continue](../bookcode/chapter5/TestContinue.java)
11. [Checking palindrome](../bookcode/chapter5/Palindrome.java)
12. [Displaying prime numbers](../bookcode/chapter5/PrimeNumber.java)


## Methods
A method is a collection of statements that are grouped together to perform an operation. 
* Method signature is the combination of the method name and the parameter list.
  * The variables defined in the method header are known as formal parameters.
  * When a method is invoked, you pass a value to the parameter. This value is referred to as actual parameter or argument. 
* A method may return a value. The returnValueType is the data type of the value the method returns. If the method does not return a value, the returnValueType is the keyword void. For example, the returnValueType in the main method is void.
  * A return statement is required for a value-returning method. 
* Reuse methods from other classes using ClassName.methodName
* Java methods pass actual parameters by value
* Methods can be used to reduce redundant coding and enable code reuse.
* Methods can be overloaded.
  * Sometimes there may be two or more possible matches for an invocation of a method, but the compiler cannot determine the most specific match. This is referred to as ambiguous invocation. Ambiguous invocation is a compile error.
* Instance methods vs static methods.


**Examples**

1. Find the sum from integer i1 to i2
  ```java
  // define a method
  public static int sum(int i1, int i2){
    int sum = 0;
    for(int i=i1; i<=i2; i++) 
      sum += i;
    return sum;
  }
  public static void main(String[] args) {
    // invoke a method
    System.out.println("Sum from 1 to 10 is " + sum(1, 10));
    System.out.println("Sum from 20 to 30 is " + sum(20, 30));
    System.out.println("Sum from 35 to 45 is " + sum(35, 45));
  }
  ```
2. Ambiguous invocation
  ```java
  public class AmbiguousOverloading {
    public static void main(String[] args) {
      System.out.println(max(1, 2));  
    }
   
    public static double max(int num1, double num2) { 
      if (num1 > num2)
        return num1;
      else
        return num2;
    }
    
    public static double max(double num1, int num2) {
      if (num1 > num2)
        return num1;
      else
        return num2;     
    }
  }
  ```

**Examples**

1. [Method does not return value](../bookcode/chapter6/TestVoidMethod.java)
2. [Method returns value](../bookcode/chapter6/TestReturnGradeMethod.java)
3. [Pass by value](../bookcode/chapter6/TestPassByValue.java)
4. [gcd method](../bookcode/chapter6/GreatestCommonDivisorMethod.java)
5. [prime number method](../bookcode/chapter6/PrimeNumberMethod.java)
6. [Hexadecimal to decimal conversion method](../bookcode/chapter6/Hex2Dec.java)
7. [Method overloading](../bookcode/chapter6/TestMethodOverloading.java)


Scope of Local Variables:

* A local variable: a variable defined inside a method.
* Scope: the part of the program where the variable can be referenced.
* The scope of a local variable starts from its declaration and continues to the end of the block that contains the variable. 
* A local variable must be declared before it can be used.
* You can declare a local variable with the same name multiple times in different non-nesting blocks in a method, 
  ```java
  // Fine with no errors
  public static void correctMethod() {
    int x = 1;
    int y = 1;
    // i is declared 
    for (int i = 1; i < 10; i++) {
      x += i;
    }
    // i is declared again
    for (int i = 1; i < 10; i++) {
      y += i;
    }
  }
  ```
* but you cannot declare a local variable twice in nested blocks.
  ```java
  // With errors
  public static void incorrectMethod() {
    int x = 1;
    int y = 1;
    for (int i = 1; i < 10; i++) {
      int x = 0;
      x += i;
    }
  }
  ```
* A variable declared in the initial action part of a for loop header has its scope in the entire loop. But a variable declared inside a for loop body has its scope limited in the loop body from its declaration and to the end of the block that contains the variable.

**Examples**

1. [Generating random characters](../bookcode/chapter6/TestRandomCharacter.java) with [RandomCharacter class](../bookcode/chapter6/RandomCharacter.java)
2. [Print calendar](../bookcode/chapter6/PrintCalendar.java)

## Single-dimensional arrays
Array is a data structure that represents a collection of the same types of data. There are two styles to declare array variables.

```java
// 1. Preferred: datatype[] arrayRefVar;
double[] myList1;
// 2. Not preferred: datatype arrayRefVar[];
double myList2[];
```

Arrays are created with keyword **new**: 
* Creation after declaration: datatype[] arrayRefVar; arrayRefVar = new datatype[arraySize];
* Creation while declaration: datatype[] arrayRefVar = new datatype[arraySize];

```java
// 1. Creation after declaration
double[] myList; // declaration
myList = new double[10]; // creation

// myList[0] references the first element in the array.
// myList[9] references the last element in the array.

// 2. Creation while declaration
double[] myList = new double[10];
```

Once an array is created, its size is fixed. It cannot be changed. You can find its size using: arrayRefVar.length

```java
myList.length // returns 10
```

When an array is created, its elements are assigned the default value of 

* 0 for the numeric primitive data types, 
* '\u0000' for char types, and 
* false for boolean types.

The array elements are accessed through the index. The array indices are 0-based, i.e., it starts from 0 to arrayRefVar.length-1. Each element in the array is represented using the following syntax, known as an indexed variable: arrayRefVar[index];

Array can be declared, created, and initialized in one step with an initializer. 

```java
double[] myList = {1.9, 2.9, 3.4, 3.5};
```

This shorthand syntax must be in one statement. Splitting it would cause a syntax error.

Popular array processing includes
* Initializing arrays with input values
  ```java
  java.util.Scanner input = new java.util.Scanner(System.in);
  System.out.print("Enter " + myList.length + " values: ");
  for (int i = 0; i < myList.length; i++) 
    myList[i] = input.nextDouble();
  ```
* Initializing arrays with random values
  ```java
  for (int i = 0; i < myList.length; i++) {
    myList[i] = Math.random() * 100;
  }
  ```
* Printing arrays
  ```java
  for (int i = 0; i < myList.length; i++) {
    System.out.print(myList[i] + " ");
  }
  ```
* Summing all elements
  ```java
  double total = 0;
  for (int i = 0; i < myList.length; i++) {
    total += myList[i];
  }
  ```
* Finding the largest element and the smallest index of the largest element
  ```java
  double max = myList[0];
  int minIndex = 0;
  for (int i = 1; i < myList.length; i++) {
    if (myList[i] > max) {
      max = myList[i];
      minIndex = i;
    }
  }
  ```
* Random shuffling 
  ```java
  for(int i=0; i<myList.length-1; i++){
    // Generate an index j randomly
    int j = (int)(Math.random()*myList.length);
    // Swap myList[i] with myList[j]
    double temp = myList[i];
    myList[i] = myList[j];
    myList[j] = myList[i];
  }
  ```
* Shifting (rotating) elements left
```java
double head = myList[0];
// Shift elements left
for(int i=1; i<myList.length; i++){
  myList[i-1] = myList[i];
}
// Move the first element to fill in the last position
myList[myList.length-1] = temp;
```

for-each loop (enhanced for loop) enables you to traverse the complete array sequentially without using an index variable.

```java
// for (elementType element: arrayRefVar) {
//   // Process the element
// }
for (double e: myList) 
  System.out.println(e);
```

**Examples**

* [Analyze numbers](../bookcode/chapter7/AnalyzeNumbers.java)
* [Deck of cards](../bookcode/chapter7/DeckOfCards.java)

Copying arrays includes two types:
* Shallow copy: Share array elements using assignment statement: list2 = list1. list2 now refers to the same array as list1. Because the assignment only copies the reference value from list1 to list2, not its elements. 
* Deep copy: copy element-wisely.
  * Using a loop to copy elements.
  ```java
  int[] sourceArray = {2, 3, 1, 5, 10};
  int[] targetArray = new int[sourceArray.length];

  for (int i = 0; i < sourceArrays.length; i++)
    targetArray[i] = sourceArray[i];
  ```
  * Using the arraycopy utility: arraycopy(sourceArray, src_pos, targetArray, tar_pos, length);
  ```java
  System.arraycopy(sourceArray, 0, targetArray, 0, sourceArray.length);
  ```

Arrays can be passed to and returned from methods.

```java
// 1. pass arrays to methods
public static void printArray(int[] array) {
  for (int i = 0; i < array.length; i++) {
    System.out.print(array[i] + " ");
  }
} 
// to invoke it
int[] list = {3, 1, 2, 6, 4, 2};
printArray(list);
// or
printArray(new int[]{3, 1, 2, 6, 4, 2}); // anomymous array

```

Java uses pass by value to pass arguments to a method. 

* For a parameter of a primitive type value, the actual value is passed. Changing the value of the local parameter inside the method does not affect the value of the variable outside the method.
* For a parameter of an array type, the value of the parameter contains a reference to an array; this reference is passed to the method. Any changes to the array that occur inside the method body will affect the original array that was passed as the argument. 

**Examples**

```java
// 1. pass an array to a method
public class Test {
  public static void main(String[] args) {
    int x = 1; // x represents an int value
    int[] y = new int[10]; // y represents an array of int values
 
    m(x, y); // Invoke m with arguments x and y
 
    System.out.println("x is " + x);
    System.out.println("y[0] is " + y[0]);
  }
 
  public static void m(int number, int[] numbers) {
    number = 1001; // Assign a new value to number
    numbers[0] = 5555; // Assign a new value to numbers[0]
  }
}

// 2. return an array from a method
public static int[] reverse(int[] list) {
  int[] result = new int[list.length];
 
  for (int i = 0, j = result.length - 1; 
       i < list.length; i++, j--) {
    result[j] = list[i];
  }
 
  return result;
}
int[] list1 = {1, 2, 3, 4, 5, 6};
int[] list2 = reverse(list1);
```

1. [Passing Arrays as Arguments](../bookcode/chapter7/TestPassArray.java)
2. [Counting occurrence of each letter](../bookcode/chapter7/CountLettersInArray.java)
3. [Variable-length arguments](../bookcode/chapter7/VarArgsDemo.java)
4. [Searching arrays linearly](../bookcode/chapter7/LinearSearch.java)
5. [Searching arrays binarily](../bookcode/chapter7/BinarySearch.java)
6. [Sorting arrays](../bookcode/chapter7/SelectionSort.java)

Java provides several overloaded sort methods for sorting an array of int, double, char, short, long, and float in the java.util.Arrays class.

```java
double[] numbers = {6.0, 4.4, 1.9, 2.9, 3.4, 3.5};
java.util.Arrays.sort(numbers);
 
char[] chars = {'a', 'A', '4', 'F', 'D', 'P'};
java.util.Arrays.sort(chars);
```

The Arrays.toString(list) method can be used to return a string representation for the list.

Main method is just a regular method.

```java
class TestMain {	
  public static void main(String[] args) { 
  ... 
  }
}

java TestMain arg0 arg1 arg2 ... argn
```

In the main method, get the arguments from args[0], args[1], ..., args[n], which corresponds to arg0, arg1, ..., argn in the command line.

**Examples**

1. [A simple calculator](../bookcode/chapter7/Calculator.java)

## Reference textbooks
* [Introduction to Java Programming, Comprehensive, 12/E](https://media.pearsoncmg.com/bc/abp/cs-resources/products/product.html#product,isbn=0136519350)
  * [Student resources](https://media.pearsoncmg.com/ph/esm/ecs_liang_ijp_12/cw/)
  * [Source code](https://media.pearsoncmg.com/ph/esm/ecs_liang_ijp_12/cw/content/source-code.php)
    * [By chapters](https://media.pearsoncmg.com/ph/esm/ecs_liang_ijp_12/cw/content/ExampleByChapters.html)