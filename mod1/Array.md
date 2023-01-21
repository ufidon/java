# Single-dimensional arrays
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

# Reference textbooks
* [Introduction to Java Programming, Comprehensive, 12/E](https://media.pearsoncmg.com/bc/abp/cs-resources/products/product.html#product,isbn=0136519350)
  * [Student resources](https://media.pearsoncmg.com/ph/esm/ecs_liang_ijp_12/cw/)
  * [Source code](https://media.pearsoncmg.com/ph/esm/ecs_liang_ijp_12/cw/content/source-code.php)
    * [By chapters](https://media.pearsoncmg.com/ph/esm/ecs_liang_ijp_12/cw/content/ExampleByChapters.html)