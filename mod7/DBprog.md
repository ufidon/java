# Java Database Programming
- [Chapter 34](../bookextra/ch34.pdf)

Objectives
---


Prerequisites: Setup MySQL
---
- Download and install [XAMPP](https://www.apachefriends.org/download.html)
  - In XAMPP Control Panel, start MySQL, click Shell, setup a password for root
    ```cmd
     mysqladmin -u root password <your_password>
    ```
  - Check MySQL works, in the previous shell (a command window)
    ```cmd
    mysql -u root -p <your_password>
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