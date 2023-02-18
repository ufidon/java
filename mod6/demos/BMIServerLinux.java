import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

// test: nc localhost 8000
// http://web.mit.edu/6.031/www/sp19/classes/23-sockets-networking/

public class BMIServerLinux extends Application {
  private TextArea ta = new TextArea();

  @Override
  public void start(Stage primaryStage) {
    ta.setWrapText(true);

    Scene scene = new Scene(new ScrollPane(ta), 500, 200);
    primaryStage.setTitle("BMI Server Linux");
    primaryStage.setScene(scene);
    primaryStage.show();

    new Thread(() -> connectToClient()).start();
  }

  public void connectToClient() {
    try {
      ServerSocket serverSocket = new ServerSocket(8000);
      Platform.runLater(() -> ta.appendText("BMI server started at " + new Date() + '\n'));

      Socket connectToClient = serverSocket.accept();

      Platform.runLater(() -> {
        ta.appendText("Connected to a client " + " at " + new Date() + '\n');
      });

      BufferedReader isFromClient = new BufferedReader(new InputStreamReader(connectToClient.getInputStream(), StandardCharsets.UTF_8));
      PrintWriter osToClient = new PrintWriter(new OutputStreamWriter(connectToClient.getOutputStream(), StandardCharsets.UTF_8));

      while (true) {
        System.out.println("serving the client...");

        double weight = Double.parseDouble(isFromClient.readLine());
        System.out.println("Weight: " + weight);

        double height = Double.parseDouble(isFromClient.readLine());
        System.out.println("Height: " + height);

        BMI bmi = new BMI("", weight, height);
        String report = "BMI is " + bmi.getBMI() + ". " + bmi.getStatus();

        osToClient.println(report);

        Platform.runLater(() -> {
          ta.appendText("Weight: " + weight + "\nHeight: " + height + "\n");
          ta.appendText(report + '\n');
        });
      }
    } catch (IOException e) {
      System.err.println(e);
    }
  }

  public static void main(String[] args) {
    launch(args);
  }
}

class BMI {
  private String name = "";
  private double weight, height;
  final double KILOGRAMS_PER_POUND = 0.45359237;
  final double METERS_PER_INCH = 0.0254;

  public BMI(String name, double weight, double height) {
    this.name = name;
    this.weight = weight;
    this.height = height;
    System.out.println("Name:" + name + ", " + "Weight:" + weight + ", "+"Height:" + height);
  }

  public double getBMI() {
    double weightInKilograms = weight * KILOGRAMS_PER_POUND;
    double heightInMeters = height * METERS_PER_INCH;
    double bmi = weightInKilograms / (heightInMeters * heightInMeters);
    return bmi;
  }

  public String getStatus() {
    double bmi = getBMI();
    String status = "Normal";

    System.out.println("Hello " + name);
    System.out.println("your BMI is " + bmi);
    if (bmi < 18.5)
      status = "Underweight";
    else if (bmi < 25)
      status = "Normal";
    else if (bmi < 30)
      status = "Overweight";
    else
      status = "Obese";

    System.out.println("Your status is " + status);
    return status;
  }
}
