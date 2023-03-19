import java.sql.*;

public class FindUserTables {
  public static void main(String[] args)
      throws SQLException, ClassNotFoundException {
    Class.forName("com.mysql.cj.jdbc.Driver");
    System.out.println("Driver loaded");

    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/test", 
    "root", "your_password");
    System.out.println("Database connected");

    DatabaseMetaData dbMetaData = connection.getMetaData();

    ResultSet rsTables = dbMetaData.getTables(null, null, null,
        new String[] { "TABLE" });
    System.out.print("User tables: ");
    while (rsTables.next())
      System.out.print(rsTables.getString("TABLE_NAME") + " \n");

    connection.close();
  }
}
