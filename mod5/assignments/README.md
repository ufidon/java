# Assignment4: Multithreading and parallel programming

## Q1: Raise flag (textbook programming exercises 32.3)
Rewrite the rising flag animation below **using a thread** to MANUALLY animate the flag being raised.

- You can NOT use any animation classes such as PathTransition, FadeTransition, Timeline, etc.
- Manual animation is changing the visual effect of nodes manually and gradually
  - Raising a flag
    - decreasing the $y$ coordinate of the imageView of a flag
  - Lowering a flag
    - increasing the $y$ coordinate of the imageView of a flag
  - Fading out
    - increasing transparency, or the $\alpha$ channel value
  - Inflating a circle
    - increasing its radius
- Using Thread.sleep to adjust the animation speed

```java
import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FlagRisingAnimation extends Application {
  @Override
  public void start(Stage primaryStage) {
    Pane pane = new Pane();
    
    ImageView imageView = new ImageView("image/us.gif");
    
    double flagHeight = imageView.getLayoutBounds().getHeight();
    Line line = new Line(100, 200+flagHeight/2, 100, -flagHeight/2);
    pane.getChildren().add(imageView);
    // pane.getChildren().add(line);
    
    PathTransition pt = new PathTransition(Duration.millis(2000), line , imageView);
    pt.setCycleCount(Timeline.INDEFINITE);
    pt.play();
    
    Scene scene = new Scene(pane, 250, 200); // sceneHeight = 200
    primaryStage.setTitle("FlagRisingByPathTransition");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
  
  public static void main(String[] args) {
    launch(args);
  }
}
```

Hints
---
- The flag 

![us flag](../../bookmedia/image/us.gif)

  - size is $160\times 84$ pixels by pixels
- The flag moves $200(sceneHeight) + 84(flagHeight)$ pixels in 2 seconds, i.e. the rising speed in the PathTransition animation is about 7 milliseconds per pixel
  - or 0.142 pixel per millisecond
- so in the thread, the flag needs to be raised 1 pixel in about 7 milliseconds
  - however, it will move slower than the PathTransition animation above due to thread scheduling overhead
  - could you change the speed to make the flag rise as fast as the PathTransition animation?
- round the flag back to the bottom when it disappears from the scene
  - the coordinate system is the scene coordinate
    - its origin is the top-left corner of the scene
  - the origin (location relative to the scene) of the ImageView is also its top-left corner
    - the bounds of its $y$ coordinate are shown below
    - **Note**: however, in PathTransition, the pivot point is the center of the ImageView

![flag roundback](./images/flagAnim.png)

- You may refer to the example [Falling Rocket](./demos/FallingRocket.java)
  - ![falling rocket](./images/fallingRocket.png)
  - the rocket image is here ![rocket](./demos/rocket.png)

Sample output
---

![rising flag](./images/risingflag.gif)


## Extra credit (10%) Rewrite Q1 with speed adjustment by arrow keys
- up arrow key: speed up
- down arrow key: slow down