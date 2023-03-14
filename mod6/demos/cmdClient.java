import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class cmdClient {
  public static void main(String[] args) throws Exception {
    int port = 9000;
    String host = "localhost";
    DataInputStream in;
    DataOutputStream out;
    Socket socket;

    socket  = new Socket(host, port);
    in =  new DataInputStream(socket.getInputStream());
    out = new DataOutputStream(socket.getOutputStream());

    double aNumber = 2.3;
    out.writeDouble(aNumber);
    System.out.println("client sent: " + aNumber);

    System.out.println(in.readDouble());
    System.out.println("client received: " + aNumber);

    socket.close();
  }
}
