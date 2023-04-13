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

- 32.2 How to create animation manually using a nonapplication thread and the Platform.runLater Method?
  - Layout JavaFX GUI in the JavaFX *application* thread
  - In the nonapplication thread
    - update GUI in the application thread by invoking Platform.runLater(Runnable r)
      - this Runnable object will be executed in the application thread
      - modify GUI in the run method of this Runnable object
    - adjust animation speed using Thread.sleep(long millis)

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

