# Java Database Programming
- [Chapter 34](../bookextra/ch34.pdf)

Prerequisites: Setup MySQL
---
- Download and install [XAMPP](https://www.apachefriends.org/download.html)
  - Setup with all default options, close XAMPP Control Panel if it runs after installation
  - Run XAMPP Control Panel as Administrator , start MySQL, click Shell, setup a password for root
    ```cmd
     mysqladmin -u root password <your_password>
    ```
  - Check MySQL works, in the previous shell (a command window)
    ```cmd
    mysql -u root -p
    :: enter your password
    :: if you see Welcome to the MariaDB monitor, MySQL works.
    ```
- Download [MySQL Connector/J](https://mvnrepository.com/artifact/com.mysql/mysql-connector-j) jar file and save it in the same folder as your source code for simplicity
- Run the sample Java program below to test the database development environment is setup completely.

```java
// test MySQL is accessible with MySQL Connector/J
// 0. put mysql-connector-j-8.0.31.jar in the same folder as TestCon.java
// 1. Run from Visual Studio Code:
// add  mysql-connector-j-8.0.31.jar to Reference libraries
// 2. Run from command line:
// java -classpath ".;mysql-connector-j-8.0.31.jar"   TestCon
import java.sql.*;

class TestCon {
  public static void main(String args[]) {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/test", "root", "your_password");
      if (con == null) {
        System.out.println("Something wrong with the database development environment.");
        return;
      } else {
        System.out.println("You are good to go.");
        con.close();
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
```


Objectives
---
- Explain the concepts of
  - database and database management systems 
  - the relational data model
    - relational data structures, constraints, and languages 
- use SQL to create and drop tables
  - to retrieve and modify data
- load a driver, connect to a database, 
  - execute statements, and process result sets using JDBC 
  - use prepared statements to execute precompiled SQL statements 
  - use callable statements to execute stored SQL procedures and functions 
- explore database metadata using the DatabaseMetaData and ResultSetMetaData interfaces 


What is a Database System?
---

![database system](./images/dbsys.png)


Database Application Systems
---

![database application](./images/dbapp.png)


Rational Database based on Relational Data Model
---
- A relational data model has three key components: 
  - **Structure** defines the representation of the data
  - **Integrity** imposes constraints on the data
  - **Language** provides the means for accessing and manipulating data


Relational Structure
---
- A relational database consists of a set of relations
- A relation has two things:
  - a schema defines the relation 
  - an instance is the content of the relation at a given time 
    - nothing more than a table with rows and named columns 
    - simply refer instances of relations as just relations or tables


Integrity Constraints
---
- impose conditions that all legal relations must satisfy
- three types of constraints: 
  - A Domain constraint and a primary key constraint
    - intra-relational constraint
    - involves only one relation 
  - A foreign key constraint 
    - inter-relational
    - involves more than one relation


Domain constraints 
---
- specify the permissible values for an attribute
  - using standard data types such as 
    - integers, floating-point numbers, 
    - fixed-length strings, and variant-length strings. 
  - specify whether an attribute can be null


Domain Constraints Example
---

```sql
create table Course (
  courseId char(5),
  subjectId char(4) not null, 
  courseNumber integer, 
  title varchar(50) not null, 
  numOfCredits integer, 
  constraint greaterThanOne 
       check (numOfCredits >= 1));
```



# References
* [Introduction to Java Programming, Comprehensive, 12/E](https://media.pearsoncmg.com/bc/abp/cs-resources/products/product.html#product,isbn=0136519350)
  * [Student resources](https://media.pearsoncmg.com/ph/esm/ecs_liang_ijp_12/cw/)
  * [Source code](https://media.pearsoncmg.com/ph/esm/ecs_liang_ijp_12/cw/content/source-code.php)
* [OpenJDK 11.0.11 Documentation](https://devdocs.io/openjdk~11/)
* [XAMPP](https://www.apachefriends.org/download.html)
  * [How to Change Your MySQL Password in XAMPP](https://kinsta.com/knowledgebase/xampp-mysql-password)
  * [How do I allow remote access to mysql using xampp?](https://serverfault.com/questions/52794/how-do-i-allow-remote-access-to-mysql-using-xampp)
    * [0.0.0.0](https://en.wikipedia.org/wiki/0.0.0.0)
  * [MySQL Connector/J](https://mvnrepository.com/artifact/com.mysql/mysql-connector-j)
  * [Connect Java to a MySQL Database](https://www.baeldung.com/java-connect-mysql)
* [sqlite](https://www.sqlite.org)
  * [SQLite Java](https://www.sqlitetutorial.net/sqlite-java/)
  * [DB Browser for SQLite](https://sqlitebrowser.org/)
  * [SQLite JDBC Driver](https://github.com/xerial/sqlite-jdbc)
* [Java – Set Classpath from Command Line](https://howtodoinjava.com/java-examples/set-classpath-command-line/)
* [VirtualBox: How to set up networking so both host and guest can access internet and talk to each other](https://serverfault.com/questions/225155/virtualbox-how-to-set-up-networking-so-both-host-and-guest-can-access-internet)
  * [How to access a NAT guest from host with VirtualBox](https://www.xmodulo.com/access-nat-guest-from-host-virtualbox.html)
  * [VirtualBox: How To Access Host Port From Guest](https://dev.to/ahmedmusallam/virtualbox-how-to-access-host-port-from-guest-i6n)