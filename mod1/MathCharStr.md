# Mathematical functions, characters, and strings
## Mathematical functions
* The [Math class](https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html):
  * Class constants: PI (𝜋), E (e - the natural number)
  * Class methods: 
    * trigonometric: double trigfuns(double)
      * sin, cos, tan, asin, acos, atan
    * exponent: double expfuns(double)
      * exp, log, log10, pow, sqrt
    * rounding: 
      * double ceil(double x) // x rounded up to its nearest integer. This integer is  returned as a double value.
      * double floor(double x) // x is rounded down to its nearest integer. This integer is  returned as a double value.
      * doube rint(double x) // x is rounded to its nearest integer. If x is equally close to two integers, the even one is returned as a double  
      * int round(float x)  // Return (int)Math.floor(x+0.5)
      * long round(double x) // Return (long)Math.floor(x+0.5)
    * min, max, abs 
    * random // Returns a random double value in the range [0.0, 1.0).

**Examples**
1. Mathematical functions
```java
Math.sin(0); // returns 0.0 
Math.sin(Math.PI / 6); //  returns 0.5 
Math.sin(Math.PI / 2); //  returns 1.0
Math.cos(0); //  returns 1.0
Math.cos(Math.PI / 6); //  returns 0.866 
Math.cos(Math.PI / 2); //  returns 0 

Math.exp(1); //  returns 2.71 
Math.log(2.71); //  returns 1.0 
Math.pow(2, 3); //  returns 8.0 
Math.pow(3, 2); //  returns 9.0 
Math.pow(3.5, 2.5); //  returns 22.91765 
Math.sqrt(4); //  returns 2.0
Math.sqrt(10.5); //  returns 3.24

Math.ceil(2.1); // returns 3.0 
Math.ceil(2.0); //  returns 2.0
Math.ceil(-2.0); //  returns –2.0
Math.ceil(-2.1); //  returns -2.0
Math.floor(2.1); //  returns 2.0
Math.floor(2.0); //  returns 2.0
Math.floor(-2.0); //  returns –2.0
Math.floor(-2.1); //  returns -3.0
Math.rint(2.1); //  returns 2.0
Math.rint(2.0); //  returns 2.0
Math.rint(-2.0); //  returns –2.0
Math.rint(-2.1); //  returns -2.0
Math.rint(2.5); //  returns 2.0
Math.rint(-2.5); //  returns -2.0
Math.round(2.6f); //  returns 3 
Math.round(2.0); //  returns 2   
Math.round(-2.0f); //  returns -2   
Math.round(-2.6); //  returns -3

Math.max(2, 3); //  returns 3 
Math.max(2.5, 3); //  returns 3.0 
Math.min(2.5, 3.6); //  returns 2.5 
Math.abs(-2); //  returns 2
Math.abs(-2.1); //  returns 2.1

a + Math.random()*b; //  returns a random number ∊ [a,b)
a + Math.random()*(b+1); //  returns a random number ∊ [a,b]

```
1. Compute the sides and angles of a triangle giving the coordinates of its three [vertices](../bookcode/chapter4/ComputeAngles.java).
  $${\displaystyle \alpha =\arccos \left({\frac {b^{2}+c^{2}-a^{2}}{2bc}}\right)}$$
  $${\displaystyle \beta =\arccos \left({\frac {a^{2}+c^{2}-b^{2}}{2ac}}\right)}$$
  $${\displaystyle \gamma =\arccos \left({\frac {a^{2}+b^{2}-c^{2}}{2ab}}\right)}$$


## Character data type
A char type is 16 bits, i.e. two bytes. Unicode takes two bytes, preceded by \u, expressed in four hexadecimal numbers that run from '\u0000' to '\uFFFF'. So, Unicode can represent 65535 + 1 characters.

```java
char letter = 'A'; //(ASCII)       
char numChar = '4'; //(ASCII)
char letter = '\u0041'; //(Unicode)
char numChar = '\u0034'; //(Unicode)
```


The increment and decrement operators can also be used on char variables to get the next or preceding Unicode character. 
```java
char ch = 'b';
System.out.println(++ch); // displays 'c'
System.out.println(--ch); // displays 'b'
System.out.println(--ch); // displays 'a'

```

char and numeric types can be casted into each other.

```java
int i = 'a'; // Same as int i = (int)'a';
char c = 97; // Same as char c = (char)97;
```

Comparing and Testing Characters

```java
if (ch >= 'A' && ch <= 'Z') 
  System.out.println(ch + " is an uppercase letter"); 
else if (ch >= 'a' && ch <= 'z') 
  System.out.println(ch + " is a lowercase letter"); 
else if (ch >= '0' && ch <= '9') 
  System.out.println(ch + " is a numeric character"); 
```  

[Character](https://docs.oracle.com/javase/7/docs/api/java/lang/Character.html) class has many methods such as

* isDigit, isLetter, isLetterOfDigit
* isLowerCase, isUpperCase
* toLowerCase, toUpperCase, etc.

The char type only represents one character.

## String
To represent a string of characters, use the data type called String.
* String is actually a predefined class in the Java library just like the System class and Scanner class. 
* The String type is not a primitive type. It is known as a reference type. 
* Popular methods of String objects
  * length, charAt, concat, toUpperCase, toLowerCase, trim

**Examples**

```java
// 1. Getting String Length
String message = "Welcome to Java";
System.out.println("The length of " + message + " is " + message.length());

// 2. Getting Characters from a String
System.out.println("The first character in message is " + message.charAt(0));

// 3. Case conversion
"Welcome".toLowerCase(); // returns a new string, welcome.
"Welcome".toUpperCase(); // returns a new string, WELCOME.

// 4. Trim leading and trailing spaces
"  Welcome  ".trim(); // returns a new string, Welcome.

// 5. String Concatenation
String s3 = s1.concat(s2); or String s3 = s1 + s2;

// Three strings are concatenated
String message = "Welcome " + "to " + "Java";
 
// String Chapter is concatenated with number 2
String s = "Chapter" + 2; // s becomes Chapter2
 
// String Supplement is concatenated with character B
String s1 = "Supplement" + 'B'; // s1 becomes SupplementB

// 6. Reading a String from the Console 
Scanner input = new Scanner(System.in);
System.out.print("Enter three words separated by spaces: ");
String s1 = input.next();
String s2 = input.next();
String s3 = input.next();
System.out.println("s1 is " + s1);
System.out.println("s2 is " + s2);
System.out.println("s3 is " + s3);

// 7. Reading a line then extract individual Characters from the Console
System.out.print("Enter a character: ");
String s = input.nextLine();
char ch = s.charAt(0);
System.out.println("The character entered is " + ch);

```

Methods for 
* comparing Strings:
  * equals(s1) // this string == s1?
  * equalsIgnoreCase(s1) 
  * compareTo(s1)
  * compareToIgnoreCase(s1)
  * startsWtih(prefix)
  * endsWith(suffix)
* obtaining substrings
  * substring(beginIndex)
  * substring(beginIndex, endIndex)
* finding a character or a substring in a string
  * indexOf(ch)
  * indexOf(ch, fromIndex)
  * indexOf(s)
  * indexOf(s, fromIndex)
  * lastIndexOf(ch)
  * lastIndexOf(ch, fromIndex)
  * lastIndexOf(s)
  * lastIndexOf(s, fromIndex)

```java
String s="Donald Trump";
int k = s.indexOf(' '); // returns 6
String fistName = s.substring(0,k); // returns Donald
String lastName = s.substring(k+1); // returns Trump
```

Conversion between strings and numbers

```java
String intString = "12345";
String doubleString = "3.1415";
int intValue = Integer.parseInt(intString);
double doubleValue = Double.parseDouble(doubleString);

int number = 54321;
String s = number + "";
```

**Examples**

1. [Guessing birthday](../bookcode/chapter4/GuessBirthday.java)
2. [Converting a hexadecimal digit to a decimal value](../bookcode/chapter4/HexDigit2Dec.java)
3. [Revising the lottery program using strings](../bookcode/chapter4/LotteryUsingStrings.java)
4. Format output using the printf statement: System.out.printf(format, items). Write a [program](../bookcode/chapter4/FormatDemo.java) to generate the following table

| Degrees | Radians | Sine  | Cosine | Tangent |
| ------- | ------- | ----- | ------ | ------- |
| 30      | 0.5236  | 0.5   | 0.866  | 0.5774  |
| 60      | 1.0472  | 0.866 | 0.5    | 1.7321  |




# Reference textbooks
* [Introduction to Java Programming, Comprehensive, 12/E](https://media.pearsoncmg.com/bc/abp/cs-resources/products/product.html#product,isbn=0136519350)
  * [Student resources](https://media.pearsoncmg.com/ph/esm/ecs_liang_ijp_12/cw/)
  * [Source code](https://media.pearsoncmg.com/ph/esm/ecs_liang_ijp_12/cw/content/source-code.php)
    * [By chapters](https://media.pearsoncmg.com/ph/esm/ecs_liang_ijp_12/cw/content/ExampleByChapters.html)