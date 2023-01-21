# Loops and Methods
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


# Reference textbooks
* [Introduction to Java Programming, Comprehensive, 12/E](https://media.pearsoncmg.com/bc/abp/cs-resources/products/product.html#product,isbn=0136519350)
  * [Student resources](https://media.pearsoncmg.com/ph/esm/ecs_liang_ijp_12/cw/)
  * [Source code](https://media.pearsoncmg.com/ph/esm/ecs_liang_ijp_12/cw/content/source-code.php)
    * [By chapters](https://media.pearsoncmg.com/ph/esm/ecs_liang_ijp_12/cw/content/ExampleByChapters.html)