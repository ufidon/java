# Generics

Objectives
---
- Explain the benefits of generics 
  - can improve reliability and readability
- Declare, use, design and implement 
  - generic classes and interfaces 
  - generic methods and bounded generic types 
  - wildcard types 
- Understand that
  - generic type information is erased by the compiler and all instances of a generic class share the same runtime class file 
  - certain restrictions on generic types caused by type erasure 


Generics
---
- Generics is the capability to parameterize types
- A class or a method with generic types 
  - allows the generic types be substituted with allowable concrete types by the compiler
    - Replacing a generic type with a concrete type is called generic instantiation
  - substitutions with incompatible objects cause compile errors
- benefits
  - enable errors to be detected at compile time rather than at runtime
  - improve readability

```java
package java.lang;
// prior to JDK 1.5, no generics
public interface Comparable {
  public int compareTo(Object o)
}

Comparable c = new Date();
System.out.println(c.compareTo("red")); // runtime error

// JDK 1.5+, generics introduced

public interface Comparable<T> {// <T> - formal generic type
  public int compareTo(T o)
}
Comparable<Date> c = new Date(); // <Date> - actual concrete type
System.out.println(c.compareTo("red")); // compile error
```

* Example: [generic ArrayList\<E\>](https://devdocs.io/openjdk~11/java.base/java/util/arraylist)
  ```java
  ArrayList<Double> list = new ArrayList<>();
  list.add(5.5); // 5.5 is automatically converted to new Double(5.5)
  list.add(3.0); // 3.0 is automatically converted to new Double(3.0)
  Double doubleObject = list.get(0); // No casting is needed
  double d = list.get(1); // Automatically converted to double
  // Auto boxing and unboxsing happened implicitly
  ```


Declaring Generic Classes and Interfaces 
---

```java
public class GenericStack<E> {
  private java.util.ArrayList<E> list = new java.util.ArrayList<>();

  public int getSize() {
    return list.size();
  }

  public E peek() {
    return list.get(getSize() - 1);
  }

  public void push(E o) {
    list.add(o);
  }

  public E pop() {
    E o = list.get(getSize() - 1);
    list.remove(getSize() - 1);
    return o;
  }

  public boolean isEmpty() {
    return list.isEmpty();
  }
  
  @Override
  public String toString() {
	return "stack: " + list.toString();
  }
  public static void main(String[] args) {
    GenericStack<String> cities = new GenericStack<>();
    System.out.println(cities);
    
    cities.push("New York");
    System.out.println(cities);

    cities.push("Miami"); cities.push("Orlando");
    System.out.println(cities);

    cities.pop();
    System.out.println(cities);
  }
}
```


Generic Static Methods
---

```java
public class GenericMethodDemo {
  public static void main(String[] args ) {
    Integer[] integers = {1, 2, 3, 4, 5};
    String[] strings = {"London", "Paris", "New York", "Austin"};

    // compare the generic static method instatiation with
    // generic class instantiation
    GenericMethodDemo.<Integer>print(integers); // compare with GenericStack<String> cities
    GenericMethodDemo.<String>print(strings);

    // or simply
    print(integers);
    print(strings);
  }

  public static <E> void print(E[] list) {
    for (int i = 0; i < list.length; i++)
      System.out.print(list[i] + " ");
    System.out.println();
  }
}
```


Bounded Generic Type
---
- A generic type specified as a subtype of another type is called bounded
- An unbounded generic type \<E\> is the same as \<E extends Object\>

```java
public class BoundedTypeDemo {
    public static void main(String[] args) {
        GeometricObject rectangle = new Rectangle(2, 2);
        GeometricObject circle = new Circle(2);

        System.out.println("Same area? " +
                equalArea(rectangle, circle));
    }

    public static <E extends GeometricObject> boolean equalArea(
            E object1, E object2) {
        return object1.getArea() == object2.getArea();
    }
}

abstract class GeometricObject {
    public abstract double getArea();
}

class Circle extends GeometricObject {
    private double radius = 1;

    public Circle(double radius){
        this.radius = radius;
    }
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends GeometricObject {
    private double width, height;

    public Rectangle(double width, double height){
        this.width  =width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }
}
```


Case Study: Sorting an Array of Comparable Objects
---

```java
public class GenericSort {
  public static void main(String[] args) {
    Integer[] intArray = {2, Integer.valueOf(4), 3};
    Double[] doubleArray = {3.7, 2.8, Double.valueOf(6.9)};
    //Character[] charArray = {'☘', '⚽', Character.valueOf('⚾')};
    Character[] charArray = {'S', 'P', Character.valueOf('X')};

    String[] stringArray = {"Tom", "Susan", "Kim"};

    sort(intArray);
    sort(doubleArray);
    sort(charArray);
    sort(stringArray);

    System.out.print("Sorted Integer objects: ");
    printList(intArray);
    System.out.print("Sorted Double objects: ");
    printList(doubleArray);
    System.out.print("Sorted Character objects: ");
    printList(charArray);
    System.out.print("Sorted String objects: ");
    printList(stringArray);
  }

  public static <E extends Comparable<E>> void sort(E[] list) {
    E currentMin;
    int currentMinIndex;

    for (int i = 0; i < list.length - 1; i++) {
      currentMin = list[i];
      currentMinIndex = i;

      for (int j = i + 1; j < list.length; j++) {
        if (currentMin.compareTo(list[j]) > 0) {
          currentMin = list[j];
          currentMinIndex = j;
        }
      }

      if (currentMinIndex != i) {
        list[currentMinIndex] = list[i];
        list[i] = currentMin;
      }
    }
  }

  public static void printList(Object[] list) {
    for (int i = 0; i < list.length; i++)
      System.out.print(list[i] + " ");
    System.out.println();
  }
}
```


Raw Types and Backward Compatibility
---
- A generic type used without a type parameter is called a raw type
  ```java
  // raw type
  ArrayList list = new ArrayList(); 
  // is roughly equivalent to 
  ArrayList<Object> list = new ArrayList<Object>(); 
  ```
- Using raw types allows for backward compatibility with earlier versions of Java
  - but, raw types are unsafe

```java
public class Max {
    public static void main(String[] args) {
        // no compile error
        Comparable c = max("Hello", "2023"); // runtime error
        System.out.println(c);
    }
    public static Comparable max(Comparable o1, Comparable o2) {
        if (o1.compareTo(o2) > 0)
            return o1;
        else
            return o2;
    }
}
```

# Reference textbooks
* [Introduction to Java Programming, Comprehensive, 12/E](https://media.pearsoncmg.com/bc/abp/cs-resources/products/product.html#product,isbn=0136519350)
  * [Student resources](https://media.pearsoncmg.com/ph/esm/ecs_liang_ijp_12/cw/)
  * [Source code](https://media.pearsoncmg.com/ph/esm/ecs_liang_ijp_12/cw/content/source-code.php)
* [OpenJDK 11.0.11 Documentation](https://devdocs.io/openjdk~11/)
* _old JDK documentations_
  * [Java 2 SDK, Standard Edition](https://nick-lab.gs.washington.edu/java/jdk1.4.2/index.html)
  * [JDK 5.0 Documentation](https://web.mit.edu/java_v1.5.0_22/distrib/share/docs/index.html)
