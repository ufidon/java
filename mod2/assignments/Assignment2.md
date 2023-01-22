# Assignment02
Write complete Java programs to complete the following tasks.

## Q1: Fix out-of-bound exception with simple test

1. Ask the user to enter a length n for an integer array
   1. n must be larger than 0. Use a do while loop to keep asking the user enter an positive integer until a positive integer is entered
2. Generate random integers in the range of [1,n] to fill the array
3. In a do while loop, ask the user to enter an index of the array, 
   1. If the specified index is out of bounds, i.e. index<0 or index>=n display the message "Out of Bounds", then quit
   2. otherwise, display the corresponding element value and ask the user to enter a next index

Test cases
---
```
# case 1
Please enter the length of an array: -7
Please enter the length of an array: 0
Please enter the length of an array: 10
Please enter an index: 3
The array element at index 3 is 3
Please enter an index: 8
The array element at index 8 is 3
Please enter an index: 6
The array element at index 6 is 5
Please enter an index: -2
Index -2 is out of bound [0,9]

# case 2
Please enter the length of an array: 5
Please enter an index: 6
Index 6 is out of bound [0,4]

# case 3
Please enter the length of an array: 7
Please enter an index: 7
Index 7 is out of bound [0,6]
```

## Q2: Custom exception class for triangle sides
1. Design a Triangle class that 
   1. extends the GeometricObject class below
    ```java
    public class GeometricObject {
      private String color = "white";
      private boolean filled;
      private java.util.Date dateCreated;

      public GeometricObject() {
          dateCreated = new java.util.Date();
      }

      public GeometricObject(String color, boolean filled) {
          dateCreated = new java.util.Date();
          this.color = color;
          this.filled = filled;
      }

      public String getColor() {
          return color;
      }

      public void setColor(String color) {
          this.color = color;
      }

      public boolean isFilled() {
          return filled;
      }

      public void setFilled(boolean filled) {
          this.filled = filled;
      }

      public java.util.Date getDateCreated() {
          return dateCreated;
      }

      public String toString() {
          return "created on " + dateCreated + "\ncolor: " + color + " and filled: " + filled;
      }
    }
    ```
   2. add three sides a, b, c as private data fields with the following framework
   ```java
    public class Triangle extends GeometricObject {
      private double a, b, c;

      public Triangle(double a, double b, double c) {
        // TODO:
        // if invalid throw InvalidTriangleException
        // else assign the tree sides respectively
      }
    }
   ```
   * Refer to example [Circle](../demos/demo2/Circle.java)
2. Design the custom exception class InvalidTriangleException
  ```java
  public class InvalidTriangleException extends RuntimeException {
    private double a, b, c;

    public InvalidTriangleException(){}
    
    public InvalidTriangleException(double a, double b, double c) {
      // TODO:
      // use keyword super to invoke the constructor of RuntimeException with an error message
      // set the three sides
    }
    // TODO:
    // complete three public getters
  }
  ```
   * Refer to example [InvalidRadiusException](../demos/demo2/InvalidRadiusException.java)
3. Design a test class to create three triangles to trigger the exception with the second triangle
  ```java
  Triangle(3,4,5);
  Triangle(1,2,3);
  Triangle(10,4,5);
  ```
   * Refer to example [TestCircle](../demos/demo2/TestCircle.java)