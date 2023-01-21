# Objects and classes

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


# Reference textbooks
* [Introduction to Java Programming, Comprehensive, 12/E](https://media.pearsoncmg.com/bc/abp/cs-resources/products/product.html#product,isbn=0136519350)
  * [Student resources](https://media.pearsoncmg.com/ph/esm/ecs_liang_ijp_12/cw/)
  * [Source code](https://media.pearsoncmg.com/ph/esm/ecs_liang_ijp_12/cw/content/source-code.php)