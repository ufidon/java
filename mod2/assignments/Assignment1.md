# Assignment01
Write complete Java programs to complete the following tasks.

## Q1:

Write three methods main(), primeSum(), and bePrime(). The skeleton of these methods are shown below.

```java
	//Judge if n is a prime number and return the Boolean result to caller
	public static boolean bePrime(int n) {
		Use a loop, better with a logical variable.
	}

	//return the sum of all prime numbers less than or equal to m
	public static int primeSum(int m) {
		// for loop to traverse all integers from 2 to m, both inclusive
		// Call bePrime() in the loop body, preferably using an if statement
	}

	public static void main(String[] args) {
		//call primeSum(100), primeSum(1000)
	}
```

The main function should do following.

1) Input: Read an integer from the user console with proper prompt
2) Processing: Call primeSum() with an assignment statement and save the result in a variable.
3) Output: Print result with proper prompt.

**Test scenarios and sample outputs:**

```
Please enter an integer no less than 2: 2
The sum of all prime numbers between 2 and 2 is 2
 
Please enter an integer no less than 2: 7
The sum of all prime numbers between 2 and 7 is 17
 
Please enter an integer no less than 2: 100
The sum of all prime numbers between 2 and 100 is 1060
 
Please enter an integer no less than 2: 1000
The sum of all prime numbers between 2 and 1000 is 76127
```

## Q2:

1. Create a Panda class and test it with a TestPanda class.
The Panda class consists of the following components.
   - Properties 
     - Instance data fields (using public access modifier) 
       - weight: double
       - age: double
     - Class data fields (using public final static modifier)
       - num_leg: int
   - Constructors 
     - Blank (no-argument) constructor: the constructor that has no parameter
     - Standard constructor: the constructor with the same number of parameters as instance properties.
   - Behaviors (Methods) 
     -toPrint(): no return, print the name and current value of every property.
     - climb(): no return, describe how the panda climbs using an output statement, for example, it climbs slowly after a meal.

1. In the main function of the TestPanda class,
   - Create two Panda objects, one from the no-argument constructor, and the other from the standard constructor. For the latter object from the standard constructor, a value should be read from the user with proper prompts for every property.
   - At the end, call every method from each object.
   - For both objects, change every property's value using assignment statements, with values read from the user.
   - Call every method from each object one more time.


**Test scenarios and sample outputs:**

```
panda1 is created using the no-arg constructor.

panda2 will be created using the standard constructor, please enter its weight and age: 
22.2 2.5

panda1.toPrint(): 
weight: 100.50
age: 2.50
number of legs: 4
panda1.climb(): 
I slowly climb just after a meal of bamboo shooters.

panda2.toPrint(): 
weight: 22.20
age: 2.50
number of legs: 4
panda2.climb(): 
I slowly climb just after a meal of bamboo shooters.


Let's change the properties of panda1, please enter its weight and age: 
11.1 1.5 

Let's change the properties of panda2, please enter its weight and age: 
22.5 2.5

panda1.toPrint(): 
weight: 11.10
age: 1.50
number of legs: 4
panda1.climb(): 
I slowly climb just after a meal of bamboo shooters.

panda2.toPrint(): 
weight: 22.50
age: 2.50
number of legs: 4
panda2.climb(): 
I slowly climb just after a meal of bamboo shooters.
```