import java.sql.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SQLClient extends Application {
  private Connection connection;
  private Statement statement;

  private TextArea tasqlCommand = new TextArea();
  private TextArea taSQLResult = new TextArea();
  private TextField tfUsername = new TextField();
  private PasswordField pfPassword = new PasswordField();
  private ComboBox<String> cboURL = new ComboBox<>();
  private ComboBox<String> cboDriver = new ComboBox<>();

  private Button btExecuteSQL = new Button("Execute SQL Command");
  private Button btClearSQLCommand = new Button("Clear");
  private Button btConnectDB = new Button("Connect to Database");
  private Button btClearSQLResult = new Button("Clear Result");
  private Label lblConnectionStatus 
    = new Label("No connection now");

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
    gridPane.add(cboURL, 1, 0);
    gridPane.add(cboDriver, 1, 1);
    gridPane.add(tfUsername, 1, 2);
    gridPane.add(pfPassword, 1, 3);
    gridPane.add(new Label("Database URL"), 0, 0);
    gridPane.add(new Label("JDBC Driver"), 0, 1);
    gridPane.add(new Label("Username"), 0, 2);
    gridPane.add(new Label("Password"), 0, 3);
    
    HBox hBoxConnection = new HBox();
    hBoxConnection.getChildren().addAll(lblConnectionStatus, btConnectDB);
    hBoxConnection.setAlignment(Pos.CENTER_RIGHT);
    
    VBox vBoxConnection = new VBox(5);
    vBoxConnection.getChildren().addAll(
      new Label("Enter Database Information"),
      gridPane, hBoxConnection);
    
    gridPane.setStyle("-fx-border-color: black;");
    
    HBox hBoxSQLCommand = new HBox(5);
    hBoxSQLCommand.getChildren().addAll(
      btClearSQLCommand, btExecuteSQL);
    hBoxSQLCommand.setAlignment(Pos.CENTER_RIGHT);
    
    BorderPane borderPaneSqlCommand = new BorderPane();
    borderPaneSqlCommand.setTop(new Label("Enter an SQL Command"));
    borderPaneSqlCommand.setCenter(new ScrollPane(tasqlCommand));
    borderPaneSqlCommand.setBottom(hBoxSQLCommand);
    
    HBox hBoxConnectionCommand = new HBox(10);
    hBoxConnectionCommand.getChildren().addAll(vBoxConnection, borderPaneSqlCommand);

    BorderPane borderPaneExecutionResult = new BorderPane();
    borderPaneExecutionResult.setTop(new Label("SQL Execution Result"));
    borderPaneExecutionResult.setCenter(taSQLResult);
    borderPaneExecutionResult.setBottom(btClearSQLResult);
    
    BorderPane borderPane = new BorderPane();
    borderPane.setTop(hBoxConnectionCommand);
    borderPane.setCenter(borderPaneExecutionResult);
    
    Scene scene = new Scene(borderPane, 670, 400);
    primaryStage.setTitle("SQLClient");
    primaryStage.setScene(scene);
    primaryStage.show();

    btConnectDB.setOnAction(e -> connectToDB());
    btExecuteSQL.setOnAction(e -> executeSQL()); 
    btClearSQLCommand.setOnAction(e -> tasqlCommand.setText(null));
    btClearSQLResult.setOnAction(e -> taSQLResult.setText(null));
  }

  private void connectToDB() {
    String driver = cboDriver.getSelectionModel().getSelectedItem();
    String url = cboURL.getSelectionModel().getSelectedItem();
    String username = tfUsername.getText().trim();
    String password = pfPassword.getText().trim();

    try {
      Class.forName(driver);
      connection = DriverManager.getConnection(url, username, password);
      lblConnectionStatus.setText("Connected to " + url);
    }
    catch (java.lang.Exception ex) {
      ex.printStackTrace();
    }
  }

  private void executeSQL() {
    if (connection == null) {
      taSQLResult.setText("Please connect to a database first");
      return;
    }
    else {
      String sqlCommands = tasqlCommand.getText().trim();
      String[] commands = sqlCommands.replace('\n', ' ').split(";");

      for (String aCommand: commands) {
        if (aCommand.trim().toUpperCase().startsWith("SELECT")) {
          processSQLSelect(aCommand);
        }
        else {
          processSQLNonSelect(aCommand);
        }
      }
    }
  }

  private void processSQLSelect(String sqlCommand) {
    try {
      statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery(sqlCommand);
      int columnCount = resultSet.getMetaData().getColumnCount();
      String row = "";

      for (int i = 1; i <= columnCount; i++) {
        row += resultSet.getMetaData().getColumnName(i) + "\t";
      }

      taSQLResult.appendText(row + '\n');

      while (resultSet.next()) {
        row = "";

        for (int i = 1; i <= columnCount; i++) {
          row += resultSet.getString(i) + "\t"; 
        }

        taSQLResult.appendText(row + '\n');
      }
    }
    catch (SQLException ex) {
      taSQLResult.setText(ex.toString());
    }
  }

  private void processSQLNonSelect(String sqlCommand) {
    try {
      statement = connection.createStatement();
      statement.executeUpdate(sqlCommand);
      taSQLResult.setText("SQL command executed");
    }
    catch (SQLException ex) {
      taSQLResult.setText(ex.toString());
    }
  }

  public static void main(String[] args) {
    launch(args);
  }
}
