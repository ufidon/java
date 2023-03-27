import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CopyFileToTable extends Application {
  private TextField tfFilename = new TextField();
  private TextArea taFile = new TextArea();

  private ComboBox<String> cboURL = new ComboBox<>();
  private ComboBox<String> cboDriver = new ComboBox<>();
  private TextField tfUsername = new TextField();
  private PasswordField pfPassword = new PasswordField();
  private TextField tfTableName = new TextField();

  private Button btViewFile = new Button("View File");
  private Button btCopy = new Button("Copy");
  private Label lblStatus = new Label();

  @Override
  public void start(Stage primaryStage) {
    cboURL.getItems().addAll(FXCollections.observableArrayList(
      "jdbc:mysql://localhost/test",
      "jdbc:sqlite:sample.db"));
    cboURL.getSelectionModel().selectFirst();
    
    cboDriver.getItems().addAll(FXCollections.observableArrayList(
      "com.mysql.cj.jdbc.Driver", "org.sqlite.jdbc"));
    cboDriver.getSelectionModel().selectFirst();
    
    GridPane gridPane = new GridPane();
    gridPane.add(new Label("JDBC Driver"), 0, 0);
    gridPane.add(new Label("Database URL"), 0, 1);
    gridPane.add(new Label("Username"), 0, 2);
    gridPane.add(new Label("Password"), 0, 3);
    gridPane.add(new Label("Table Name"), 0, 4);
    gridPane.add(cboURL, 1, 0);
    gridPane.add(cboDriver, 1, 1);
    gridPane.add(tfUsername, 1, 2);
    gridPane.add(pfPassword, 1, 3);
    gridPane.add(tfTableName, 1, 4);
    
    HBox hBoxConnection = new HBox(10);
    hBoxConnection.getChildren().addAll(lblStatus, btCopy);
    hBoxConnection.setAlignment(Pos.CENTER_RIGHT);

    VBox vBoxConnection = new VBox(5);
    vBoxConnection.getChildren().addAll(
      new Label("Target Database Table"),
      gridPane, hBoxConnection);
    
    gridPane.setStyle("-fx-border-color: black;");

    BorderPane borderPaneFileName = new BorderPane();
    borderPaneFileName.setLeft(new Label("Filename"));
    borderPaneFileName.setCenter(tfFilename);
    borderPaneFileName.setRight(btViewFile);
            
    BorderPane borderPaneFileContent = new BorderPane();
    borderPaneFileContent.setTop(borderPaneFileName);
    borderPaneFileContent.setCenter(taFile);
    
    BorderPane borderPaneFileSource = new BorderPane();
    borderPaneFileSource.setTop(new Label("Source Text File"));
    borderPaneFileSource.setCenter(borderPaneFileContent);
                
    SplitPane sp = new SplitPane();
    sp.getItems().addAll(borderPaneFileSource, vBoxConnection);
    
    Scene scene = new Scene(sp, 680, 230);
    primaryStage.setTitle("CopyFileToTable");
    primaryStage.setScene(scene);
    primaryStage.show();

    btViewFile.setOnAction(e -> showFile());
    btCopy.setOnAction(e -> {
        try {
          copyFile();
        }
        catch (Exception ex) {
          lblStatus.setText(ex.toString());
        }
    });
  }

  private void showFile() {
    Scanner input = null;
    try {
      input = new Scanner(new File(tfFilename.getText().trim()));

      while (input.hasNext()) 
        taFile.appendText(input.nextLine() + '\n');
    }
    catch (FileNotFoundException ex) {
      System.out.println("File not found: " + tfFilename.getText());
    }
    catch (IOException ex) {
      ex.printStackTrace();
    }
    finally {
      if (input != null) input.close();
    }
  }

  private void copyFile() throws Exception {
    Class.forName(cboDriver.getSelectionModel()
      .getSelectedItem().trim());
    System.out.println("Driver loaded");

    Connection conn = DriverManager.getConnection(
      cboURL.getSelectionModel().getSelectedItem().trim(),
      tfUsername.getText().trim(),
      String.valueOf(pfPassword.getText()).trim());
    System.out.println("Database connected");

    insertRows(conn);
  }

  private void insertRows(Connection connection) {
    String sqlInsert = "insert into " + tfTableName.getText()
      + " values (";

    Scanner input = null;

    String filename = tfFilename.getText().trim();

    try {
      input = new Scanner(new File(filename));

      Statement statement = connection.createStatement();

      System.out.println("Driver major version? " +
        connection.getMetaData().getDriverMajorVersion());

      boolean batchUpdatesSupported = false;

      try {
        if (connection.getMetaData().supportsBatchUpdates()) {
          batchUpdatesSupported = true;
          System.out.println("batch updates supported");
        }
        else {
          System.out.println("The driver " +
            "does not support batch updates");
        }
      }
      catch (UnsupportedOperationException ex) {
        System.out.println("The operation is not supported");
      }

      if (batchUpdatesSupported) {
        while (input.hasNext()) {
          statement.addBatch(sqlInsert + input.nextLine() + ")");
        }

        statement.executeBatch();

        lblStatus.setText("Batch updates completed");
      }
      else {
        while (input.hasNext()) {
          statement.executeUpdate(sqlInsert + input.nextLine() + ")");
        }

        lblStatus.setText("Single row update completed");
      }
    }
    catch (SQLException ex) {
      System.out.println(ex);
    }
    catch (FileNotFoundException ex) {
      System.out.println("File not found: " + filename);
    }
    finally {
      if (input != null) input.close();
    }
  }

  public static void main(String[] args) {
    launch(args);
  }
}

