import java.io.File;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class 界码 extends Application {
    
    @Override
    public void start(Stage 台) throws Exception {
        Parent 根 = FXMLLoader.load((new File("登.fxml")).toURI().toURL());
        
        台.setTitle("面码分离");
        台.setScene(new Scene(根, 300, 250));
        台.getIcons().add(new Image("城门.png"));
        台.show();
    }
    
    public static void main(String[] args) {
        Application.launch(界码.class, args);
    }
}
