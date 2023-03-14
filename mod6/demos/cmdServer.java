import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Server
 */
public class cmdServer {
  public static void main(String[] args) throws Exception {
    int port = 9000;
    DataInputStream in;
    DataOutput out;
    ServerSocket server;
    Socket socket;

    server = new ServerSocket(port);
    socket = server.accept();

    in = new DataInputStream(socket.getInputStream());
    out = new DataOutputStream(socket.getOutputStream());

    double aNumber = in.readDouble();
    System.out.println("server received: " + aNumber);

    out.writeDouble(aNumber);
    System.out.println("server sent: " + aNumber);

    server.close();
    
  }

}