import java.io.*;
import java.net.*;

public class StudentServer {
  private ObjectOutputStream outputToFile;
  private ObjectInputStream inputFromClient;

  public static void main(String[] args) {
    new StudentServer();
  }

  public StudentServer() {
    try {
      ServerSocket serverSocket = new ServerSocket(8000);
      System.out.println("Server started ");

      outputToFile = new ObjectOutputStream(
        new FileOutputStream("student.dat", true));

      while (true) {
        Socket socket = serverSocket.accept();
        inputFromClient = new ObjectInputStream(socket.getInputStream());
        Object object = inputFromClient.readObject();

        outputToFile.writeObject(object);
        System.out.println("A new student object is stored");

        ObjectInputStream inputFromFile = new ObjectInputStream(new FileInputStream("student.dat"));
        StudentAddress sa = (StudentAddress)inputFromFile.readObject();
        System.out.printf("Name: %s\nStreet: %s\nCity: %s\nState: %s\nZip: %s\n", 
        sa.name, sa.street, sa.city, sa.state, sa.zip);
      }
    }
    catch(ClassNotFoundException ex) {
      ex.printStackTrace();
    }
    catch(IOException ex) {
      ex.printStackTrace();
    }
    finally {
      try {
        inputFromClient.close();
        outputToFile.close();
      }
      catch (Exception ex) {
        ex.printStackTrace();
      }
    }
  }
}