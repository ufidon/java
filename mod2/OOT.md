# Object-oriented thinking

**Class Abstraction and Encapsulation**
* Abstraction means to separate class implementation from the use of the class
* Encapsulation means to pack data and related operations in one class
* Classes provide more flexibility and modularity for building reusable software

**Examples**
* [Loan](../bookcode/chapter10/Loan.java)
  * [Test](../bookcode/chapter10/TestLoanClass.java)
* [BMI](../bookcode/chapter10/BMI.java)
  * [Test](../bookcode/chapter10/UseBMIClass.java)
* [Course](../bookcode/chapter10/Course.java)
  * [Test](../bookcode/chapter10/TestCourse.java)
* [Stack of integers](../bookcode/chapter10/StackOfIntegers.java)

**[Wrapper Classes](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/package-summary.html)**
* [Boolean](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Boolean.html)
* [Character](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Character.html)
* Numerical wrapper classes
  * Byte, Short, [Integer](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Integer.html), Long, Float, [Double](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Double.html)
  * Constructors
  * Class constants MAX_VALUE, MIN_VALUE
  * Conversion methods
    * to other numerical types, for example, *shortValue*
    * from String: 
      * *valueOf(String s)*
      * parsing String into numbers
* The wrapper classes do not have no-arg constructors. 
* The instances of all wrapper classes are immutable, i.e., their internal values cannot be changed once the objects are created. 
* Automatic conversion between primitive types and Wrapper class types
  * Boxing:
    ```java
    Integer[] intArray = {2, 3, 4}; is equivalent to Integer[] intArray = {new Integer(2), new Integer(3), new Integer(4)}
    ```
  * Unboxing:
    ```java
    System.out.println(intArray[0], intArray[1], intArray[2]);
    ```

**Big numbers from package [java.math](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/math/package-summary.html)**
```java
BigInteger a = new BigInteger("9223372036854775807");
BigInteger b = new BigInteger("122345678901234567890");
BigInteger c = a.multiply(b); 
System.out.println(c); // 1128439713607660245768935175104471037230

 BigDecimal f = new BigDecimal(Math.PI);
System.out.println(f); // 3.141592653589793115997963468544185161590576171875
```
* [BigInteger](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/math/BigInteger.html) supports very large integers
* [BigDecimal](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/math/BigDecimal.html) supports high precision floating-point values
* Both are immutable 
* Both extend the Number class and implement the Comparable interface

**String, StringBuilder, StringBuffer**
* A String object is immutable; its contents cannot be changed.
* The StringBuilder/StringBuffer class is an alternative to the String class but *mutable* 
  * In general, a StringBuilder/StringBuffer can be used wherever a string is used. 
  * StringBuilder/StringBuffer is more flexible than String. 
  * You can add, insert, or append new contents into a string buffer, whereas the value of a String object is fixed once the string is created.
  * String concatenation operator (+) internally uses StringBuffer or StringBuilder class 
  * StringBuffer is thread-safe and synchronized whereas StringBuilder is not so it is faster than StringBuffer.

```java
// 1. Constructing a String
String s2 = new String(); // an empty string
// from string literal
String s3 = new String("Java is fun!");
// shorthand initializer
String s1 = "Java is simple!"; 
// is done implicitly: String s1 = new String("Java is simple!");

// 2. Strings are immutable
String s = "Java";
s = "C++"; // is the content of the string changed? 
// No, s is a reference variable, it just refers to another string

// 3. Interned string is used to improve efficiency and save memory
// JVM uses a unique instance for string literals with the same character sequence. Such an instance is called interned

String s4 = "Java is powerful!";
String s5 = new String("Java is powerful!");
String s6 = "Java is powerful!"; // s6 and s4 refer to the same instance

System.out.println("s4 == s5 " + (s4 == s5)); // false
System.out.println("s4 == s6 " + (s4 == s6)); // true

// compare contents
if(s4.compareTo(s6) == 0) System.out.println("The strings refered by s4 and s6 have identical contents.");

// 4. Replacing and Splitting Strings
"banana".replace('n','m'); // returns a new string "bamama"
"banana".replace("n","m"); // returns a new string "bamama"
"banana".replaceAll("n","m"); // returns a new string "bamama"
"banana".replaceFirst("n","m"); // returns a new string "bamana"

String[] names = "Donald Trump".split(' '); // returns String[2] { "Donald", "Trump" }

// 5. Matching, Replacing and Splitting by Patterns: regular expression
// The following 4 statements all return true
"Java".matches("Java");
"Java".equals("Java");
"Java is fun".matches("Java.*");
"Java is cool".matches("Java.*");

"Today=is$a@wonderful*day!".replaceAll("[=$@*]"," "); // returns a new string: "Today is a wonderful day!"
"Java,C?C#,C++".split("[.,:;?]"); // returns String[4] { "Java", "C", "C#", "C++" }

// 6. Convert Character and Numbers to Strings
String.valueOf('A'); // returns a new string "A"
String.valueOf(3.14); // returns a new string "3.14"
String.valueOf(314); // returns a new string "314"
String.valueOf(new char[]{'b','a','n','a','n','a'}); // returns a new string "banana"

// 7. Modify strings with StringBuilder or StringBuffer
StringBuilder sb = new StringBuilder("String builder is mutable");
sb.append('.'); // ==> String builder is mutable.
sb.toString().length(); // ==> 26
sb.deleteCharAt(sb.toString().length()-1); // ==> String builder is mutable
sb.insert(0, "StringBuffer"); // ==> StringBufferString builder is mutable
sb.insert(12, " "); // ==> StringBuffer String builder is mutable
sb.insert(12, "and"); // ==> StringBufferand String builder is mutable
sb.reverse(); // ==> elbatum si redliub gnirtS dnareffuBgnirtS
sb.reverse(); // StringBufferand String builder is mutable
sb.replace(0,1,"string"); // ==> stringtringBufferand String builder is mutable
sb.delete(0, sb.indexOf("String")); // ==> String builder is mutable
```

**Examples**
* [Checking Palindromes Ignoring Non-alphanumeric Characters](../bookcode/chapter10/PalindromeIgnoreNonAlphanumeric.java)


**Regular expressions**

```java
"Java Java Java".replaceAll("v\\w", "wi"); // returns a new string "Jawi Jawi Jawi"
"Java Java Java".replaceFirst("v\\w", "wi"); // returns a new string "Jawi Java Java"
"Java1Java2Java".split("\\d"); // returns String[3] { "Java", "Java", "Java" }
```

[A regular expressions](https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/util/regex/Pattern.html) (abbreviated *regex*) is a string that describes a *pattern* for matching *a set of strings*. 
* It is a powerful tool for [string manipulations](https://www.baeldung.com/regular-expressions-java). 
* It can be used for matching, replacing, and splitting strings.


# Reference textbooks
* [Introduction to Java Programming, Comprehensive, 12/E](https://media.pearsoncmg.com/bc/abp/cs-resources/products/product.html#product,isbn=0136519350)
  * [Student resources](https://media.pearsoncmg.com/ph/esm/ecs_liang_ijp_12/cw/)
  * [Source code](https://media.pearsoncmg.com/ph/esm/ecs_liang_ijp_12/cw/content/source-code.php)