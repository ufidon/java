import java.sql.*;
import java.io.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class StoreAndRetrieveImage extends Application {
  private Connection connection;
  private Statement stmt;

  private PreparedStatement pstmt = null;
  private DescriptionPane descriptionPane = new DescriptionPane();
  private ComboBox<String> cboCountry = new ComboBox<>();

  @Override
  public void start(Stage primaryStage) {
    try {
      connectDB();
      storeDataToTable();
      fillDataInComboBox();
      retrieveFlagInfo(cboCountry.getSelectionModel().getSelectedItem());
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }

    BorderPane paneForComboBox = new BorderPane();
    paneForComboBox.setLeft(new Label("Select a country: "));
    paneForComboBox.setCenter(cboCountry);
    cboCountry.setPrefWidth(400);
    BorderPane pane = new BorderPane();
    pane.setTop(paneForComboBox);
    pane.setCenter(descriptionPane);
    
    Scene scene = new Scene(pane, 350, 150);
    primaryStage.setTitle("StoreAndRetrieveImage"); 
    primaryStage.setScene(scene);
    primaryStage.show();
    
    cboCountry.setOnAction(e -> retrieveFlagInfo(cboCountry.getValue()));
  }

  private void connectDB() throws Exception {
    Class.forName("com.mysql.cj.jdbc.Driver");
    System.out.println("Driver loaded");

    connection = DriverManager.getConnection
      ("jdbc:mysql://localhost/test", "root", "your_password");
    System.out.println("Database connected");
    stmt = connection.createStatement();
    pstmt = connection.prepareStatement("select flag, description " +
      "from Country where name = ?");
  }

  private void storeDataToTable() {
    String[] countries = {"Canada", "UK", "USA", "Germany",
      "Indian", "China"};

    String[] imageFilenames = {"image/ca.gif", "image/uk.gif",
      "image/us.gif", "image/germany.gif", "image/india.gif",
      "image/china.gif"};

    String[] descriptions = {"A text to describe Canadian " +
      "flag is omitted", "British flag ...", "American flag ...",
      "German flag ...", "Indian flag ...", "Chinese flag ..."};

    try {
      PreparedStatement pstmt = connection.prepareStatement(
        "insert into Country values(?, ?, ?)");

      for (int i = 0; i < countries.length; i++) {
        pstmt.setString(1, countries[i]);

        java.net.URL url =
          this.getClass().getResource(imageFilenames[i]);
        InputStream inputImage = url.openStream();
        pstmt.setBinaryStream(2, inputImage,
          (int)(inputImage.available()));

        pstmt.setString(3, descriptions[i]);
        pstmt.executeUpdate();
      }

      System.out.println("Table Country populated");
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  private void fillDataInComboBox() throws Exception {
    ResultSet rs = stmt.executeQuery("select name from Country");
    while (rs.next()) {
      cboCountry.getItems().add(rs.getString(1));
    }
    cboCountry.getSelectionModel().selectFirst();
  }

  private void retrieveFlagInfo(String name) {
    try {
      pstmt.setString(1, name);
      ResultSet rs = pstmt.executeQuery();
      if (rs.next()) {
        Blob blob = rs.getBlob(1);     
        ByteArrayInputStream in = new ByteArrayInputStream
          (blob.getBytes(1, (int)blob.length()));
        Image image = new Image(in);
        ImageView imageView = new ImageView(image);
        descriptionPane.setImageView(imageView);
        descriptionPane.setTitle(name);
        String description = rs.getString(2);
        descriptionPane.setDescription(description);
      }
    }
    catch (Exception ex) {
      System.err.println(ex);
    }
  }
  
  public static void main(String[] args) { 
    launch(args);
  }
}

class DescriptionPane extends BorderPane {
  private Label lblImageTitle = new Label();
  private TextArea taDescription = new TextArea();

  public DescriptionPane() {
      lblImageTitle.setContentDisplay(ContentDisplay.TOP);
      lblImageTitle.setPrefSize(200, 100);

      lblImageTitle.setFont(new Font("SansSerif", 16));
      taDescription.setFont(new Font("Serif", 14));

      taDescription.setWrapText(true);
      taDescription.setEditable(true);

      ScrollPane scrollPane = new ScrollPane(taDescription);

      setLeft(lblImageTitle);
      setCenter(scrollPane);
      setPadding(new Insets(5, 5, 5, 5));
  }

  public void setTitle(String title) {
      lblImageTitle.setText(title);
  }

  public void setImageView(ImageView icon) {
      lblImageTitle.setGraphic(icon);
  }

  public void setDescription(String text) {
      taDescription.setText(text);
  }
}
