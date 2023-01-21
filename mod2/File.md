#  File accessment

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


**Reading Data from the Web**

```java
// local file url: file://absolutepath
// for example: 
// on Unix: file:///tmp/scores.txt
// on Windows: file:///C:/Users/User/scores.txt
import java.util.Scanner;

public class ReadFileFromURL {
  public static void main(String[] args) {
    // user enters a URL string
    System.out.print("Enter a URL: ");   
    String URLString = new Scanner(System.in).next();
       
    try {
      // create a url object
      java.net.URL url = new java.net.URL(URLString); 

      int count = 0;
      // create a scanner object
      Scanner input = new Scanner(url.openStream());
      while (input.hasNext()) {
        String line = input.nextLine(); // Note: '\n' excluded
        // count the number of characters in each line
        count += line.length();
      } 
      
      System.out.println("The file size is " + count + " characters");
    }
    catch (java.net.MalformedURLException ex) {
      System.out.println("Invalid URL");
    }
    catch (java.io.IOException ex) {
      System.out.println("IO Errors");
    }
  }
} 
```

**Examples**
* [A web crawler](../bookcode/chapter12/WebCrawler.java)


# Reference textbooks
* [Introduction to Java Programming, Comprehensive, 12/E](https://media.pearsoncmg.com/bc/abp/cs-resources/products/product.html#product,isbn=0136519350)
  * [Student resources](https://media.pearsoncmg.com/ph/esm/ecs_liang_ijp_12/cw/)
  * [Source code](https://media.pearsoncmg.com/ph/esm/ecs_liang_ijp_12/cw/content/source-code.php)