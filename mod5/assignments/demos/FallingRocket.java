import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.application.Platform;

public class FallingRocket extends Application {
  @Override
  public void start(Stage primaryStage) {
    Pane pane = new Pane();
    double sceneWidth = 200;
    double sceneHeight = 200;
    
    ImageView rocket = new ImageView("rocket.png");
    double rocketHeight = rocket.getLayoutBounds().getHeight();
    double rocketWidth = rocket.getLayoutBounds().getWidth();

    pane.getChildren().add(rocket);
    
    // initial location of the rocket is set to be just 
    // on the center line of the scene
    rocket.setX(sceneWidth/2 - rocketWidth/2); 
    // and above the scene
    rocket.setY(-rocketHeight); 
        
    Scene scene = new Scene(pane, sceneWidth, sceneHeight);
    primaryStage.setTitle("Fall rocket by thread");
    primaryStage.setScene(scene);
    primaryStage.show();
    
    new Thread(() -> {
      try {
        while (true) {
          Platform.runLater(() -> {
            if (rocket.getY() > sceneHeight) {
              rocket.setY(-rocketHeight);
            } else {
              rocket.setY(rocket.getY() + 1);
            }
          });

          Thread.sleep(10);
        }
      }
      catch (InterruptedException ex) { }
    }).start();
  }
  
  public static void main(String[] args) {
    launch(args);
  }
}
