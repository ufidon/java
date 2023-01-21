# Selections

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


# Reference textbooks
* [Introduction to Java Programming, Comprehensive, 12/E](https://media.pearsoncmg.com/bc/abp/cs-resources/products/product.html#product,isbn=0136519350)
  * [Student resources](https://media.pearsoncmg.com/ph/esm/ecs_liang_ijp_12/cw/)
  * [Source code](https://media.pearsoncmg.com/ph/esm/ecs_liang_ijp_12/cw/content/source-code.php)
    * [By chapters](https://media.pearsoncmg.com/ph/esm/ecs_liang_ijp_12/cw/content/ExampleByChapters.html)