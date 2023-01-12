# cop3809

Online resources and examples

# Module 2: Java OOP
Chapter 9-12

## Objects and classes

```java
public class TestSimpleCircle {
  /** Main method */
  public static void main(String[] args) {
    // Create a circle with radius 1
    SimpleCircle circle1 = new SimpleCircle();
    System.out.println("The area of the circle of radius "  + circle1.radius + " is " + circle1.getArea());

    // Modify circle radius
    circle1.radius = 100; // or circle1.setRadius(100)
    System.out.println("The area of the circle of radius "  + circle1.radius + " is " + circle1.getArea());
  }
}

// Define the circle class with two constructors
class SimpleCircle {
  double radius; // default accessing qualifier is package

  /** no-arg Construct */
  SimpleCircle() {  radius = 1;  }

  /** Construct a circle with a specified radius */
  SimpleCircle(double newRadius) { radius = newRadius;  }

  /** Return the area of this circle */
  double getArea() {  return radius * radius * Math.PI;  }

  /** Set a new radius for this circle */
  void setRadius(double newRadius) {
    radius = newRadius;
  }
}
```

An object represents an entity in the real world that can be distinctly identified. 
- The state of an object consists of a set of data fields (also known as properties) with their current values.
  - The data fields can be of reference types. 
  - The default value of a data field 
    - is null for a reference type 
    - 0 for a numeric type, false for a boolean type, and '\u0000' for a char type
    - no default value to a local variable inside a method
  - Instance variables belong to a specific instance
  - Static variables are shared by all the instances of the class.
    - Static constants are final variables shared by all the instances of the class.
- The behavior of an object is defined by a set of methods.
  - Instance methods are invoked by an instance of the class. 
  - Static methods are not tied to a specific object
- To declare static variables, constants, and methods, use the static modifier.

**Examples**

* [Circle with static members](../bookcode/chapter9/CircleWithStaticMembers.java)
  * [Test](../bookcode/chapter9/TestCircleWithStaticMembers.java)

Classes are constructs that define objects of the same type. 
- Constructors are **invoked using the new operator** when an object is created. 
- A default constructor, is provided automatically only if no constructors are explicitly defined in the class.
- Non-static methods must be invoked from an object using: objectRefVar.methodName(arguments).

To reference an object, assign the object to a **reference** variable.
- Declare a reference variable, use the syntax: ClassName objectRefVar;
  - Example: Circle myCircle; Note: *doesn't create myCircle*
- Garbage Collection
  - You can explicitly assign null to a reference variable for the object no longer needed. 
  - The JVM will automatically collect the space if the object is not referenced by any variable


**The Date Class** 

```java
// get the current date and time 
java.util.Date date = new java.util.Date();
System.out.println(date.toString());
```
* The [java.util.Date](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Date.html) class is a system-independent encapsulation of date and time 


**The Random Class**

```java
Random random1 = new Random(3);
System.out.print("From random1: ");
for (int i = 0; i < 10; i++)
  System.out.print(random1.nextInt(1000) + " ");

Random random2 = new Random(3);
System.out.print("\nFrom random2: ");
for (int i = 0; i < 10; i++)
  System.out.print(random2.nextInt(1000) + " ");
```

* The [java.util.Random](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Random.html) 
  * is a more useful random number generator than Math.random()
  * If two Random objects have the same seed, they will generate identical sequences of numbers. 


**Visibility Modifiers and Accessor/Mutator Methods**

* public > protected > package > private

```java
// C1.java
package p1;
public class C1{
  public int x;
  int y;
  private int z;

  public void m1(){}
  void m2(){}
  private void m3(){}
}

// C2.java
package p1;
public class C2{
  void aMethod(){
    C1 c1 = new C1();
    // access c1.x OK
    // access c1.y OK
    // access c1.z NO

    // invoke c1.m1() OK
    // invoke c1.m2() OK
    // invoke c1.m3() NO
  }
}

// C3.java
package p2;
public class C3{
  void aMethod(){
    C1 c1 = new C1();
    // access c1.x OK
    // access c1.y NO
    // access c1.z NO

    // invoke c1.m1() OK
    // invoke c1.m2() NO
    // invoke c1.m3() NO    
  }
}

```


By default, the class, variable, or method can be accessed by any class in the *same package*. 
* public: the class, data, or method is visible to any class in any package. 
* private: the data or methods can be accessed only by the declaring class.
  * The get and set methods are used to read and modify private properties.

**Examples**

* [Circle with private data fields](./../bookcode/chapter9/CircleWithPrivateDataFields.java)
  * [Test](../bookcode/chapter9/TestCircleWithPrivateDataFields.java)


**Passing Objects to Methods - Passing by Value**
* For primitive type value (the value is copied/passed to the parameter)
* For reference type value (the value is the reference to the object)

**Array of Objects**
```java
Circle[] circleArray = new Circle[10]; 
```

* An array of objects is actually an array of *reference variables*
  * circleArray[1].getArea() involves two levels of referencing 
    * circleArray references to the entire array
    * circleArray[1] references to a Circle object

**Example**
* [Total area of circles](../bookcode/chapter9/TotalArea.java)


**Immutable Objects and Classes**
```java
public class Student{
  private int id;
  private Date birthday;

  public Student(int id1, Date bd1)
  {
    id = id1;
    birthday = bd1;
  }
  public int getId(){ return id; }
  public Date getBirthDay() { return birthday; }
}
```

* If the contents of an object cannot be changed once the object is created, 
  * the object is called an immutable object 
  * its class is called an immutable class. 
* A class with all private data fields and without mutators is not necessarily immutable
* For a class to be immutable, 
  * it must mark all data fields private and provide no mutator methods and
  * *no accessor methods that would return a reference to a mutable data field object*


**The this Keyword** 
```java
public class Circle{
  private double radius;

  public Circle(double radius){
    // refer to shadowed (hidden) data field
    this.radius = radius;
  }

  public Circle(){
    this(1.0); // call the previous constructor
  }

  public double getArea(){
    return this.radius * radius * Math.PI;
  }
}
```

* is the name of a reference that refers to an object itself. It is used to 
  * reference a class’s hidden data fields
  * enable a constructor to invoke another constructor of the same class

**Scope of Variables**
* The scope of instance and static variables is the entire class. 
  * They can be declared anywhere inside a class.
* The scope of a local variable starts from its declaration and continues to the end of the block that contains the variable. 
  * A local variable must be initialized explicitly before it can be used.

## Object-oriented thinking

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


## Inheritance and polymorphism

## Exception handling and text I/O


# Reference textbooks
* [Introduction to Java Programming, Comprehensive, 12/E](https://media.pearsoncmg.com/bc/abp/cs-resources/products/product.html#product,isbn=0136519350)
  * [Student resources](https://media.pearsoncmg.com/ph/esm/ecs_liang_ijp_12/cw/)
  * [Source code](https://media.pearsoncmg.com/ph/esm/ecs_liang_ijp_12/cw/content/source-code.php)