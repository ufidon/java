import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class TypeCharacter extends Application {
  private String text = "";
  private Label label = new Label(text);

  public void start(Stage stage) {
    label.setWrapText(true);
    label.setTextAlignment(TextAlignment.JUSTIFY);

    Scene scene = new Scene(label, 200, 150, Color.BEIGE);
    stage.setTitle("Typing Chars");
    stage.setScene(scene);
    stage.show();

    Thread addLoop = new Thread(new AddSymbol('⌘', 50));
    Thread addAlarm = new Thread(new AddSymbol('⏰', 50));
    addLoop.start();
    addAlarm.start();
  }

  public static void main(String args[]) {
    launch(args);
  }

  class AddSymbol implements Runnable {
    private char symbol;
    private int number;

    public AddSymbol(char sym, int n) {
      symbol = sym;
      number = n;
    }

    @Override
    public void run() {
      for (int i = 0; i < number; i++) {
        synchronized(text){ text += symbol; }     
        try {Thread.sleep(100);} catch (Exception e) {}
        Platform.runLater(() -> label.setText(text));
      }
    }
  }
}