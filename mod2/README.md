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

* public > protected > package(default) > private (visibility decrease)
* no visibility modifier is default

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

Circle and Rectangle are inherited from GeometricObject.
* GeometricObject is called superclass, parent class, base class or supertype
* Circle and Rectangle are called subclass, child class, extended class or subtype
* Inheritance is declared as subclass extends superclass
* Inheritance is used to model the **is-a** relationship
  * for example, a Circle is a GeometricObject
* Not all is-a relationships should be modeled using inheritance
  * for example, a Square is a Rectangle, but it better extends GeometricObject instead of Rectangle
* Java supports single inheritance only not multiple inheritance
  * multiple inheritance can be achieved through *interfaces*

```java
// GeometricObject.java
public class GeometricObject {
  private String color = "white";
  private boolean filled;
  private java.util.Date dateCreated;
  
  /** Construct a default geometric object */
  public GeometricObject() {
    dateCreated = new java.util.Date();
  }

  /** Construct a geometric object with the specified color 
    *  and filled value */
  public GeometricObject(String color, boolean filled) {
    dateCreated = new java.util.Date();
    this.color = color;
    this.filled = filled;
  }

  /** Return color */
  public String getColor() {
    return color;
  }

  /** Set a new color */
  public void setColor(String color) {
    this.color = color;
  }

  /** Return filled. Since filled is boolean, 
     its get method is named isFilled */
  public boolean isFilled() {
    return filled;
  }

  /** Set a new filled */
  public void setFilled(boolean filled) {
    this.filled = filled;
  }
  
  /** Get dateCreated */
  public java.util.Date getDateCreated() {
    return dateCreated;
  }
  
  /** Return a string representation of this object */
  public String toString() {
    return "created on " + dateCreated + "\ncolor: " + color + 
      " and filled: " + filled;
  }
}

// Circle.java
public class Circle  extends GeometricObject {
  private double radius;

  public Circle() {
  }

  public Circle(double radius) {
    this.radius = radius;
  }

  public Circle(double radius, 
      String color, boolean filled) {
    this.radius = radius;
    setColor(color);
    setFilled(filled); // or super.setFilled(filled);
  }

  /** Return radius */
  public double getRadius() {
    return radius;
  }

  /** Set a new radius */
  public void setRadius(double radius) {
    this.radius = radius;
  }

  /** Return area */
  public double getArea() {
    return radius * radius * Math.PI;
  }
  
  /** Return diameter */
  public double getDiameter() {
    return 2 * radius;
  }
  
  /** Return perimeter */
  public double getPerimeter() {
    return 2 * radius * Math.PI;
  }

  /* Print the circle info */
  public void printCircle() {
    System.out.println("The circle is created " + getDateCreated() +
      " and the radius is " + radius);
  }
}

// Rectangle.java
public class Rectangle extends GeometricObject {
  private double width;
  private double height;

  public Rectangle() {
  }

  public Rectangle(double width, double height) {
    this.width = width;
    this.height = height;
  }

  public Rectangle(
      double width, double height, String color, boolean filled) {
    this.width = width;
    this.height = height;
    setColor(color);
    setFilled(filled);
  }

  /** Return width */
  public double getWidth() {
    return width;
  }

  /** Set a new width */
  public void setWidth(double width) {
    this.width = width;
  }

  /** Return height */
  public double getHeight() {
    return height;
  }

  /** Set a new height */
  public void setHeight(double height) {
    this.height = height;
  }

  /** Return area */
  public double getArea() {
    return width * height;
  }

  /** Return perimeter */
  public double getPerimeter() {
    return 2 * (width + height);
  }
}

// Test.java
public class Test {
    public static void main(String[] args) {
        Circle circle = new Circle(1);
        System.out.println("A circle " + circle.toString());
        System.out.println("The color is " + circle.getColor());
        System.out.println("The radius is " + circle.getRadius());
        System.out.println("The area is " + circle.getArea());
        System.out.println("The diameter is " + circle.getDiameter());

        Rectangle rectangle = new Rectangle(2, 4);
        System.out.println("\nA rectangle " + rectangle.toString());
        System.out.println("The area is " + rectangle.getArea());
        System.out.println("The perimeter is " + rectangle.getPerimeter());
    }
}
```

* What are inherited from Superclass?
  * data fields and methods
  * Superclass's constructors are NOT inherited
    * Subclasses' constructors can only be invoked using the keyword super
      ```java
      super(); // call the no-arg constructor, or
      super(arguments); // other constructors
      ```
    * If the keyword super is not explicitly used, the superclass's no-arg constructor is automatically invoked.
      ```java
      public C(){} // is equivalent to
      public C(){
        super(); // added by the compiler implicitly
        // Invoking a superclass constructor’s name in a subclass causes a syntax error. 
        // Java requires that the statement that uses the keyword super appear first in the constructor
        // other statements...
      }
      ```
    * The super keywork can be used to call a superclass constructor or method  
      ```java
        super.method(arguments);
      ```


**Constructor Chaining**

Constructing an instance of a class invokes all the superclasses’ constructors along the inheritance chain. This is known as constructor chaining.

```java
// 1. Demonstrate constructor chaining
// Faculty.java
public class Faculty extends Employee {
    public static void main(String[] args) {
      new Faculty();
    }
    
    public Faculty() {
      System.out.println("(4) Faculty's no-arg constructor is invoked");
    }
  }
  
  class Employee extends Person {
    public Employee() {
      this("(2) Invoke Employee's overloaded constructor");
      System.out.println("(3) Employee's no-arg constructor is invoked");
    }
  
    public Employee(String s) {
      System.out.println(s);
    }
  }
  
  class Person {
    public Person() {
      System.out.println("(1) Person's no-arg constructor is invoked");
    }
  }
// outputs:
// (1) Person's no-arg constructor is invoked
// (2) Invoke Employee's overloaded constructor
// (3) Employee's no-arg constructor is invoked
// (4) Faculty's no-arg constructor is invoked

// 2. The impact of a Superclass without no-arg Constructor
// Apple.java: compile this file, find and fix the errors
public class Apple extends Fruit {
}
 
class Fruit {
  public Fruit(String name) {
    System.out.println("Fruit's constructor is invoked");
  }
}

```

* A subclass is not a subset of its superclass but usually contains more information and methods than its superclass
* Private data fields in a superclass are not accessible outside the class
  * They can be accessed/mutated through public accessors/mutators if defined in the superclass.
* In the subclass, you can
  * Add new properties and new methods
  * Override the methods of the superclass

**Overriding Methods inherited from the Superclass**

The subclass modifying the implementation of a method defined in the superclass is called *method overriding*.
The overriding method must have the same signature as the overridden method and same or compatible return type. Compatible means that the overriding method’s return type is a subtype of the overridden method’s return type.

* An instance method can be overridden only if it is accessible. 
* Thus a private method cannot be overridden, because it is not accessible outside its own class. 
* If a method defined in a subclass is private in its superclass, the two methods are completely unrelated.
* Placing the override annotation @Override before the overriding method in the subclass help avoid mistakes
* **Note**: 
  * a static method can be inherited but cannot be overridden. 
  * If it is redefined in a subclass, the static method defined in the superclass is hidden. 
    * The hidden static methods can be invoked using the syntax SuperClassName.staticMethodName.

What are the differences between overriding and overloading?

**The Object Class and Its Methods**

Every class in Java is descended from the **java.lang.Object** class. If no inheritance is specified in the definition of a class, then its superclass is Object. 

```java
public class Person{ ... } // is equivalent to
public class Person extends Object{ ... }
```

The Object class has a *toString()* method 
* returns a string representation of the object. 
* The default implementation returns a string consisting of 
  * a class name of which the object is an instance, 
  * the at sign (@), and a number representing this object
  ```java
   Object o = new Object();
   o.toString(); // returns  "java.lang.Object@3c09711b"

   System.out.println(o); // is preferred over
   System.out.println(o.toString());
   ```
* The toString method is usually overridden to return a meaningful string representation of the object.


**Polymorphism**

Polymorphism means that a variable of a supertype can refer to an object of any of its subtypes. Which models
* A person could be a faculty, student, instructor, etc.
* A geometric object could a circle, square, rectangle, etc.
* A method can be implemented in several classes along the inheritance chain. 
  * The JVM decides which method is invoked at runtime, which is called *dynamic binding*
  * If o invokes a method m, the JVM searches and invokes the first-found implementation upward along the inheritance chain

```java
// DynamicBindingDemo.java
// The inheritance chain: GraduateStudent -> Student -> Person -> Object
public class DynamicBindingDemo {
    public static void main(String[] args) {
        m(new GraduateStudent()); // ==> Student
        m(new Student()); // ==> Student
        m(new Person()); // ==> Person
        m(new Object()); // ==> java.lang.Object@73a28541
    }

    public static void m(Object x) {
        System.out.println(x.toString());
    }
}

class GraduateStudent extends Student {
}

class Student extends Person {
    @Override
    public String toString() {
        return "Student";
    }
}

class Person extends Object {
    @Override
    public String toString() {
        return "Person";
    }
}

```

**Casting objects**
* Casting a primitive-type value returns a new value. 
* Casting an object reference does not create a new object.

```java
// implicity casting from a subclass to a superclass
Object o = new Student(); 
m(o);

// explicit casting from a superclass to a subclass
Student s = (Student) o; 

// Use the instanceof operator to test whether an object is an instance of a class
Object o2 = new Circle();
if(o2 instanceof Circle)
  System.out.println("The circle area is " + ((Circle)o2).getArea());

```

**Examples**
* [Casting demonstration](../bookcode/chapter11/CastingDemo.java)


**Comparing two objects**
* The equals() method compares the contents of two objects. 

```java
// test whether two objects are equal
object1.equals(object2);

// The default implementation of the equals method in the Object class is
public boolean equals(Object obj) {
  // checks whether two reference variables point to the same object using the == operator
  return this == obj;

}

// override equals in custom class to test whether two distinct objects have the same content.
@Override
public boolean equals(Object o) {
  if (o instanceof Circle)
    return radius == ((Circle)o).radius;
  else
    return false;
}

```

**The [ArrayList](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/ArrayList.html) Class**
*  can be used to store an unlimited number of objects
   *  the elements stored in an ArrayList must be of an object type
   *  so use Wrapper class for primitive types
*  is known as a generic class with a generic type E. You can specify a concrete type to replace E when creating an ArrayList


```java
// 1. creates an ArrayList of Strings 
ArrayList<String> cities = new ArrayList<String>(); 
// or
ArrayList<String> cities = new ArrayList<>(); 

// 2. Creating an ArrayList from an array of objects
String[] array = {"red", "green", "blue"};
ArrayList<String> list = new ArrayList<>(Arrays.asList(array));

// 3. Creating an array of objects from an ArrayList:
String[] array1 = new String[list.size()];
list.toArray(array1);

// 4. Useful Methods for Lists
java.util.Collections.sort(list);
java.util.Collections.max(list);
ava.util.Collections.min(list);
java.util.Collections.shuffle(list);
```

**Examples**
* [Test ArrayList](../bookcode/chapter11/TestArrayList.java)
* [Differences and Similarities between Arrays and ArrayList](../bookcode/chapter11/DistinctNumbers.java)
* [use an ArrayList to implement Stack](../bookcode/chapter11/MyStack.java)

**The protected Modifier**

![accessibility](../bookimages/11.modifiers.png)

* **private** modifier hides the members of the class completely
* **default** modifier allows the members of the class to be accessed directly from any class within the same package
* **protected** modifier enables the members of the class to be accessed by the subclasses in any package
* **public** modifier enables the members of the class to be accessed by any class
* change visibility
  * A subclass may override a protected method defined in its superclass and change its visibility to public
  * a subclass cannot weaken the accessibility of a method defined in the superclass
* Applicability
  * The private and protected modifiers can be used only for members of the class
  * The public modifier and the default modifier (i.e., no modifier) can be used on members of the class as well as on the class


**The final Modifier**

```java
// A final class cannot be extended
public final class A{}

public class B{
// A final method cannot be overridden by its subclasses
  public final void m(){}  
}

// A final variable is a constant
public class C{
  public final static double 𝛑 = 3.1415926;
  public final double PI = 3.1415926;
  public void m(){
    // The final modifier can also be used on local variables to make them constant
    final double e = 2.71828;
  }
}

```

## Exception handling
Exceptions are objects represent runtime errors or conditions that prevent execution from proceeding normally.
* They are thrown from methods
* The callers of the methods can catch and handle the exceptions
* The key benefit of exception handling is separating 
  * the detection of an error (done in a called method) from 
  * the handling of an error (done in the calling method).

```java
// Quotient.java: possible runtime error - integer divides by 0
import java.util.Scanner;

public class Quotient {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    // Prompt the user to enter two integers
    System.out.print("Enter two integers: ");
    int number1 = input.nextInt();
    int number2 = input.nextInt();

    // try entering number2 as 0 to see what happens?
    // Note a floating-point number divided by 0 does not raise an ­exception.
    // 1.0/0=inifinity
    System.out.println(number1 + " / " + number2 + " is " +
      (number1 / number2));
  }
}

// QuotientWithIf.java: fix the error with an if statement

import java.util.Scanner;

public class QuotientWithIf {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    // Prompt the user to enter two integers
    System.out.print("Enter two integers: ");
    int number1 = input.nextInt();
    int number2 = input.nextInt();

    if (number2 != 0) // fix the error of dividing an integer by 0
      System.out.println(number1 + " / " + number2
        + " is " + (number1 / number2));
    else
      System.out.println("Divisor cannot be zero ");
  }
}

// QuotientWithMethod.java: let a method to handle the error
import java.util.Scanner;

public class QuotientWithMethod {
  // Let the method to handle the error
  public static int quotient(int number1, int number2) {
    if (number2 == 0) {
      System.out.println("Divisor cannot be zero");
      System.exit(1);
    }

    return number1 / number2;
  }

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    // Prompt the user to enter two integers
    System.out.print("Enter two integers: ");
    int number1 = input.nextInt();
    int number2 = input.nextInt();

    int result = quotient(number1, number2);
    System.out.println(number1 + " / " + number2 + " is "
      + result);
  }
}

// QuotientWithException.java: let the caller handle the error with a catch block
import java.util.Scanner;

public class QuotientWithException { 
  public static int quotient(int number1, int number2) {
    if (number2 == 0) // create and throw an exception
      throw new ArithmeticException("Divisor cannot be zero");

    return number1 / number2;
  }
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    
    // Prompt the user to enter two integers
    System.out.print("Enter two integers: ");
    int number1 = input.nextInt();
    int number2 = input.nextInt();
    
    try { // run normally
      int result = quotient(number1, number2);
      System.out.println(number1 + " / " + number2 + " is " 
        + result);
    }
    catch (ArithmeticException ex) {
      // process catched exception
      System.out.println("Exception: an integer " + 
        "cannot be divided by zero ");
    }

    System.out.println("Execution continues ...");
  }
}

```

**Exception types**

Exceptions are objects defined using classes. The root class for exceptions is 
*[java.lang.Throwable](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Throwable.html)*.

![exception hierarchy](../bookimages/12.exceptionTree.jpg)

The exception classes can be classified into three major types: 
* system errors
  * thrown by the JVM and represented in the **Error** class
  * little you can do beyond notifying the user and trying to terminate the program gracefully
* exceptions 
  * represented in the **Exception** class 
  * describes errors caused by your program and by external circumstance
  * can be caught and handled by your program
* runtime exceptions
  * represented in the **RuntimeException** class, 
  * describes programming errors, such as bad casting, accessing an out-of-bounds array, and numeric errors. 

**Checked Exceptions vs. Unchecked Exceptions**
* *RuntimeException, Error and their subclasses* are known as *unchecked* exceptions. 
  * reflect programming logic errors that are unrecoverable
* *All other exceptions* are known as *checked* exceptions, meaning that the compiler forces the programmer to check and deal with the exceptions.

**Examples**
* [Input mismatch exception](../bookcode/chapter12/InputMismatchExceptionDemo.java)


**Declaring, Throwing, and Catching Exceptions**

Java’s exception-handling model is based on three operations: 
* declaring an exception 
  * states the types of checked exceptions it might throw from a method
  ```java
  public void aMethod() throws Exception1, Exception2, ..., ExceptionN
  ```
  * A method without exception declaration cannot be overridden to declare exceptions
* throwing an exception
  * detects an error then create an instance of an appropriate exception type and throw it.
  ```java
  throw new TheException(); 
  // or
  TheException ex = new TheException();
  throw ex;
  ```
* catching an exception
  * The code that handles the exception is called the exception handler
  * it is found by propagating the exception backward through a chain of method calls, starting from the current method
  * The process of finding a handler is called *catching an exception*
  * If no handler is found in the chain of methods being invoked, the program terminates and prints an error message on the console.
  ```java
  try {
    statements; // Statements that may throw exceptions
  }
  catch (Exception1 exVar1) {
    handler for exception1;
  }
  catch (Exception2 exVar2) {
    handler for exception2;
  }
  ...
  catch (ExceptionN exVarN) {
    handler for exceptionN;
  }
  ```
* multicatch catches and handles multiple exceptions with the same handling code 
  ```java
  catch (Exception1 | Exception2 | ... | ExceptionN e){
    // Same code for handling these exceptions
  }
  ```
* If a method declares a checked exception, you must 
  * invoke it in a try-catch block
  ```java
  void m1(){
    try{ m2(); }
    catch(Exception1 e){ ... }
  }
  ```
  * declare to throw the exception in the calling method
  ```java
  void m1() throws Exception1 { m2(); }
  ```
* Rethrowing Exceptions
  ```java
  try{ statements; }
  catch (Exception1 e1){
    partly handle e1;
    throw e1; // rethrow
  }
  ```
  * Throwing an exception along with another exception forms a [chained exception](../bookcode/chapter12/ChainedExceptionDemo.java/)  
* The [finally clause](https://www.baeldung.com/java-finally-keyword) is always executed regardless of whether an exception occurred or not.
  ```java
  try{ statements; }
  catch(Exception1 e1){ handle e1; }
  // finally block is always executed 
  finally { finalStatements; }
  nextStatements;
  ```
  * finalStatements are often for closing files and for cleaning up resources
  * The catch block may be omitted when the finally clause is used
* Getting Information from Exceptions with methods in Throwable such as
  * getMessage, printStackTrace, getStackTrace
  * demonstrated in [Test exception](../bookcode/chapter12/TestException.java) 
* Use the exception classes in the API whenever possible. Define custom exception classes
  * if the predefined classes are not sufficient
  * by extending Exception or a subclass of Exception

**Examples**

```java
/** Set a new radius */
public void setRadius(double newRadius) 
throws IllegalArgumentException // declare an exception
{
  if (newRadius >= 0)
    radius =  newRadius;
  else // throw an exception
    throw new IllegalArgumentException("Radius cannot be negative");
}
```

* [Invalid radius exception](../bookcode/chapter12/InvalidRadiusException.java)
  * [Circle with radius exception](../bookcode/chapter12/CircleWithException.java)
  * [Test](../bookcode/chapter12/TestCircleWithException.java)


Exception handling usually requires more time and resources because it requires instantiating a new exception object, rolling back the call stack, and propagating the errors to the calling methods.
* Do not use a try-catch block to deal with simple, expected situations.
  ```java
  // prefer
  if(refVar != null)
    System.out.println(refVar.toString());
  else
    System.out.println("refVar is null!");
  // over 
  try{
    System.out.println(refVar.toString());
  }catch(NullPointerException e){
    System.out.println("refVar is null!");
  }
  ```
* A method should throw an exception if the error needs to be handled by its caller.

**[Assertions](https://docs.oracle.com/javase/7/docs/technotes/guides/language/assert.html)**

* An assertion is a Java statement that enables you to assert an assumption about your program. 
* An assertion contains a Boolean expression that should be true during program execution. 
* Assertions can be used to assure program correctness and avoid logic errors.
* Declaring assertions
  ```java
  assert assertion; // or
  assert assertion : detailMessage; // 
  ```
  * assertion is a Boolean expression 
  * detailMessage is a primitive-type or an Object value
* Executing assertions
  * Java evaluates the assertion. If it is false, an [AssertionError](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/AssertionError.html) will be thrown
    * The AssertionError class has a no-arg constructor and 
    * seven overloaded single-argument constructors of type int, long, float, double, boolean, char, and Object
  * For the first assert statement with no detail message, the no-arg constructor of AssertionError is used. 
  * For the second assert statement with a detail message, an appropriate AssertionError constructor is used to match the data type of the message. 
  * Since AssertionError is a subclass of Error, when an assertion becomes false, the program displays a message on the console and exits.
  * By default, the assertions are disabled at runtime. Use the switch –enableassertions, or –ea for short, to enable it:
  ```java
  java -ea ProgramWithAssertions
  ```
    * Assertions can be selectively enabled or disabled at class level or package level.
    ```java
    java -ea:package1 -da:Class1 ProgramWithAssertions
    ```

**Examples**

```java
// AssertionDemo.java
public class AssertionDemo {
  public static void main(String[] args) {
    int i; int sum = 0;
    for (i = 0; i < 10; i++) {
      sum += i; 
    }
    assert i == 10;
    assert sum > 10 && sum < 5 * 10 : "sum is " + sum;
  }
}
```

**Using Exception Handling or Assertions**
* Assertion should not be used to replace exception handling
  * Assertions assure the correctness of the program
  * Use assertions to reaffirm assumptions
  * Use assertions in a switch statement without a default case
    ```java
    switch (month) {
      case 1: ... ; break;
      case 2: ... ; break;
      ...
      case 12: ... ; break;
      default: assert false : "Invalid month: " + month;
    }
    ```
* Exception handling deals with unusual circumstances during program execution. 
  * Exception handles addresses robustness.
* Like exception handling, assertions are not used for normal tests, but for internal consistency and validity checks 
* Assertions are checked at runtime and can be turned on or off at startup time
* Do not use assertions for argument checking in public methods 
  * Validating arguments using exception handling


##  File accessment
The [File class](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/File.html) is intended to provide an abstraction that deals with most of the machine-dependent complexities of files and path names in a *machine-independent* fashion, which is similar to Linux style.
* It is a wrapper class for the file name and its directory path. 
* It does not contain the methods for reading/writing data from/to a file

```java
// FileProp.java
public class FileProp {
  public static void main(String[] args) {
    if(args.length != 1){
      System.out.println("Usage: java FileProp filename");
      System.exit(1);
    }
    // relative path is preferred
    java.io.File file = new java.io.File(args[0]);
    System.out.println("Does it exist? " + file.exists());
    System.out.println("The file has " + file.length() + " bytes");
    System.out.println("Can it be read? " + file.canRead());
    System.out.println("Can it be written? " + file.canWrite());
    System.out.println("Is it a directory? " + file.isDirectory());
    System.out.println("Is it a file? " + file.isFile());
    System.out.println("Is it absolute? " + file.isAbsolute());
    System.out.println("Is it hidden? " + file.isHidden());
    System.out.println("Absolute path is " + file.getAbsolutePath());
    System.out.println("Last modified on " +  new java.util.Date(file.lastModified()));
  }
}
```

**Text I/O**

Use the PrintWriter class for writing text data to a file.
* Writing Data Using [PrintWriter](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/PrintWriter.html)
  ```java
  public class WriteData {
    // specify throws Exception for main to disregard possible exceptions
    public static void main(String[] args) throws Exception {
      java.io.File file = new java.io.File("scores.txt");
      if (file.exists()) {
        System.out.println("File already exists");
        System.exit(0);
      }

      // Create a file
      // Note: create a new file if the file does not exist. 
      // If the file already exists, the current content in the file will be discarded
      // could throw an I/O exception, disregarded by main's throws specification 
      java.io.PrintWriter output = new java.io.PrintWriter(file);

      // Write formatted output to the file: Name,Score
      output.print("John T Smith,");
      output.println(90);
      output.print("Eric K Jones,");
      output.println(85);
      output.println("Joe Biden," + 98);
      output.printf("%s,%d\n", "Donald Trump", 99);

      // Close the file
      output.close();
    }
  }
  ```
  * You can append data to an existing file using new PrintWriter(new FileOutputStream(file, true)) to create a PrintWriter object
  * The file must be closed to ensure that all data are saved to the disk  
* **Try-with-resources** automatically closes the files
  * The resources must be a subtype of AutoCloseable such as a PrinterWriter that has the close() method
  ```java
  try (declare and create resources) {
    Use the resource to process the file;
  }

  // WriteDataWithAutoClose.java
  public class WriteDataWithAutoClose {
    public static void main(String[] args) throws Exception {
      java.io.File file = new java.io.File("scores.txt");
      if (file.exists()) {
        System.out.println("File already exists");
        System.exit(0);
      }
      
      try (
        // Create a file
        java.io.PrintWriter output = new java.io.PrintWriter(file);
        // A resource must be declared and created in the same statement, 
        // and multiple resources can be declared and created inside the parentheses
      ) {
        // Write formatted output to the file
        output.print("John T Smith ");
        output.println(90);
        output.print("Eric K Jones ");
        output.println(85);
        // After the block is finished, the resource’s close() method 
        // is automatically invoked to close the resource.
        // The catch clause may be omitted in a try-with-resources statement
      }
    }
  }
  ```

Use the [Scanner](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Scanner.html) class for reading text data from a file.
* To read from a file, create a Scanner for a file
  ```java
  import java.util.Scanner; 

  public class ReadData {
    public static void main(String[] args) throws Exception {
      // Create a File instance
      java.io.File file = new java.io.File("scores.txt");

      // Create a Scanner for the file
      try(
        Scanner input = new Scanner(file);        
      ){
        input.useDelimiter("[,\n]");

        // Read data from a file
        while (input.hasNext()) {
          String name = input.next();
          int score = input.nextInt();
          System.out.println(name + ": " + score);
        }        
      }
    }
  }
  ```
* Read from a String
  ```java
  import java.util.Scanner; 

  public class ReadData {
    public static void main(String[] args) throws Exception {
      // Create a File instance
      java.io.File file = new java.io.File("scores.txt");

      // Create a Scanner for the file
      try(
        Scanner input = new Scanner(file);      
      ){
        // Read data from a file
        while (input.hasNextLine()) {
          String line = input.nextLine();
          Scanner string = new Scanner(line);
          string.useDelimiter(",");
          String name = string.next();
          int score = string.nextInt();
          System.out.println(name + ": " + score);
          string.close();
        }        
      }
    }
  }  
  ```

**Examples**
* [Replace text](../bookcode/chapter12/ReplaceText.java)

**How Does Scanner Work?**

- The token-based input methods nextByte(), nextShort(), nextInt(), nextLong(), nextFloat(), nextDouble(), and next() read input separated by *delimiters*. 
- By default, the delimiters are *whitespace characters*. 
- You can use the *useDelimiter(String regex)* method to set a new pattern for delimiters.
- A token-based input first skips any delimiters (whitespace characters by default) then reads a token ending at a delimiter. 
- The token is then automatically converted into a value of the byte, short, int, long, float, or double type for ­nextByte(), nextShort(), nextInt(), nextLong(), nextFloat(), and ­nextDouble(), respectively. For the next() method, no conversion is performed. 
- If the token does not match the expected type, a runtime exception java.util.InputMismatchException will be thrown
- Both methods next() and nextLine() read a string. 
  - The next() method reads a string separated by delimiters 
  - nextLine() reads a line ending with a line separator.
* The line-separator string is defined by the system. 
  * It is \r\n on Windows and \n on UNIX. 
  * To get the line separator on a particular platform, use
    ```java
    String lineSeparator = System.getProperty("line.separator");
    ```
  * If you enter input from a keyboard, a line ends with the Enter key, which corresponds to the \n character.
* The token-based input method does not read the delimiter after the token. 
  * If the nextLine() method is invoked after a token-based input method, this method reads characters that start *from* this delimiter and end with the line separator. 
  * The line separator is read, but it is not part of the string returned by nextLine().
  ```java
  // test.txt contains: 12 345
  Scanner input = new Scanner(new File("test.txt"));
  int intValue = input.nextInt(); // =>34->intValue
  String line = input.nextLine(); // =>" 345"->line

  // type 12 Enter then 345 Enter
  Scanner input = new Scanner(System.in);
  int intValue2 = input.nextInt(); // 12->intValue2
  String line2 = input.nextLine(); // ""->line2
  ```
  * Don't not use a line-based input after a token-based input


# Reference textbooks
* [Introduction to Java Programming, Comprehensive, 12/E](https://media.pearsoncmg.com/bc/abp/cs-resources/products/product.html#product,isbn=0136519350)
  * [Student resources](https://media.pearsoncmg.com/ph/esm/ecs_liang_ijp_12/cw/)
  * [Source code](https://media.pearsoncmg.com/ph/esm/ecs_liang_ijp_12/cw/content/source-code.php)