import java.sql.*;

public class TestResultSetMetaData {
  public static void main(String[] args)
      throws SQLException, ClassNotFoundException {
    Class.forName("com.mysql.cj.jdbc.Driver");
    System.out.println("Driver loaded");

    Connection connection = DriverManager.getConnection
      ("jdbc:mysql://localhost/test", "root", "your_password");
    System.out.println("Database connected");

    Statement statement = connection.createStatement();

    ResultSet resultSet = statement.executeQuery
      ("select * from Enrollment");
    
    ResultSetMetaData rsMetaData = resultSet.getMetaData();
    for (int i = 1; i <= rsMetaData.getColumnCount(); i++)
      System.out.printf("%-12s\t", rsMetaData.getColumnName(i));
    System.out.println();
    
    while (resultSet.next()) {
      for (int i = 1; i <= rsMetaData.getColumnCount(); i++)
        System.out.printf("%-12s\t", resultSet.getObject(i));
      System.out.println();
    }

    connection.close();
  }
}
