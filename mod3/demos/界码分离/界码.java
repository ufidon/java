import java.io.File;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class 界码 extends Application {
    
    @Override
    public void start(Stage 台) throws Exception {
        //Parent 根 = FXMLLoader.load((new File("登.fxml")).toURI().toURL());
        Parent 根 = FXMLLoader.load(getClass().getResource("登.fxml"));
        // Parent 根 = FXMLLoader.load(new URL("file:///home/x/scratch/java/界码分离/登.fxml"));
        // Parent 根 = FXMLLoader.load(new URL("file://localhost/home/x/scratch/java/界码分离/登.fxml"));

        
        // https://en.wikipedia.org/wiki/File_URI_scheme
        //https://stackoverflow.com/questions/126141/how-do-you-find-out-which-version-of-gtk-is-installed-on-ubuntu
         
        台.setTitle("面码分离");
        台.setScene(new Scene(根, 300, 250));
        台.getIcons().add(new Image("城门.png"));
        台.show();
    }
    
    public static void main(String[] args) {
        Application.launch(界码.class, args);
    }
}
