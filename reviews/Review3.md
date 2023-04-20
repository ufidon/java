# Review for exam 3
Covers module 5-7, chapter 

- 32 ▶️ Multithreading and Parallel Programming
- 33 ▶️ Networking
- 34 ▶️ Java Database Programming
- 35 ▶️ Advanced Database Programming


# 32 ▶️ Multithreading and Parallel Programming
- 32.1 How to create multiple thread programs?
  - How to define a task?
  - How to start a thread?
    - In the main method, do the following change then analyze the output
      - case 1: change the three start to run
      - case 2: change 
        - thread1.start() to printA.run()
        - thread2.start() to printB.run()
        - thread3.start() to print100.run()

```java
public class TaskThreadDemo {
  public static void main(String[] args) {
    Runnable printA = new PrintChar('a', 100);
    Runnable printB = new PrintChar('b', 100);
    Runnable print100 = new PrintNum(100);

    Thread thread1 = new Thread(printA);
    Thread thread2 = new Thread(printB);
    Thread thread3 = new Thread(print100);

    thread1.start();
    thread2.start();
    thread3.start();
  }
}

class PrintChar implements Runnable {
  private char charToPrint;
  private int times;

  public PrintChar(char c, int t) {
    charToPrint = c;
    times = t;
  }

  @Override
  public void run() {
    for (int i = 0; i < times; i++) {
      System.out.print(charToPrint);
    }
  }
}

class PrintNum implements Runnable {
  private int lastNum;

  public PrintNum(int n) {
    lastNum = n;
  }

  @Override
  public void run() {
    for (int i = 1; i <= lastNum; i++) {
      System.out.print(" " + i);
    }
  }
}
```

- 32.2  In the program above, the Runnable interface is implemented in inner class, rewrite it using
  - anonymous inner class
  - lambda expression

- 32.3 How to create animation manually using a nonapplication thread and the Platform.runLater Method?
  - Layout JavaFX GUI in the JavaFX *application* thread
  - In the nonapplication thread
    - update GUI in the application thread by invoking Platform.runLater(Runnable r)
      - this Runnable object will be executed in the application thread
      - modify GUI in the run method of this Runnable object
    - adjust animation speed using Thread.sleep(long milliseconds)

```java
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class BouncingBall extends Application {
  private Circle ball = new Circle(100,100,30);
  private double centerX = ball.getCenterX();
  private int direction = 1;
  
  @Override
  public void start(Stage primaryStage) {   
    Pane pane = new Pane();
    pane.getChildren().add(ball);
    
    new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          while (true) {
            // generate animation 
            Platform.runLater(()->{
              if (centerX >= pane.getWidth()) {
                direction = -1;
              } 
              if(centerX <= 0){
                direction = 1;
              }
              centerX += direction;
              ball.setCenterX(centerX);
            });
            
            // adjust animation speed
            Thread.sleep(20);
          }
        }
        catch (InterruptedException ex) {
        }
      }
    }).start();
    
    Scene scene = new Scene(pane, 200, 200);
    primaryStage.setTitle("Bouncing Ball");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
```

- 32.4 What is race condition? How to avoid it?
- 32.5 Describe the five thread states and their transition


# 33 ▶️ Networking
- 33.1 Describe the steps in Client/Server communications
- 33.2 How to serve multiple clients from one server?
- 33.3 How to send/receive objects over network?
- 33.4 Compare stream socket and datagram socket
- 33.5 Compare stream socket programming and datagram programming


# 34 ▶️ Java Database Programming
- 34.1 Describe the major steps developing JDBC programs
- 34.2 Compare Statement, PreparedStatement and CallableStatement
- 34.3 When do we need execute, executeQuery and executeUpdate
- 34.4 Is a preparedStatement more efficient than its counterpart Statement?
- 34.5 How to get database and table information during runtime?



# 35 ▶️ Advanced Database Programming
- 35.1 Could a Java program connect to multiple databases?
  - If yes, how?
- 35.2 How to create an interactive SQL client?
- 35.3 Can batch update be used to run multiple select SQL commands?
- 35.4 What can a scrollable and updatable ResultSet do?
- 35.5 How to create a scrollable and updatable ResultSet?
- 35.6 Compare connected RowSet and disconnected RowSet
- 35.7 Does RowSet support parameterized SQL statements?
  - If yes, how?
- 35.8 Can a RowSet get meta data?
- 35.9 Is a RowSet scrollable and updatable?
- 35.10 What events does a RowSet support?
- 35.11 How to store and retrieve images in JDBC?



