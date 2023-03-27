import java.sql.*;

public class ScrollUpdateResultSet {
  public static void main(String[] args)
      throws SQLException, ClassNotFoundException {
    Class.forName("com.mysql.cj.jdbc.Driver");
    System.out.println("Driver loaded");
    
    Connection connection = DriverManager.getConnection
      ("jdbc:mysql://localhost:3306/test", 
       "root", "your_password");
    connection.setAutoCommit(true);
    System.out.println("Database connected");

    Statement statement = connection.createStatement(
      ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    
    ResultSet resultSet = statement.executeQuery
      ("select state, capital from StateCapital");

    System.out.println("Before update ");
    displayResultSet(resultSet);

    resultSet.absolute(2);
    resultSet.updateString("state", "New S");
    resultSet.updateString("capital", "New C");
    resultSet.updateRow();

    resultSet.last();
    resultSet.moveToInsertRow();
    resultSet.updateString("state", "Florida"); 
    resultSet.updateString("capital", "Tallahassee"); 
    resultSet.insertRow();
    resultSet.moveToCurrentRow();

    resultSet.absolute(4);
    resultSet.deleteRow();

    System.out.println("After update ");
    resultSet = statement.executeQuery
      ("select state, capital from StateCapital");
    displayResultSet(resultSet);

    resultSet.close();
  }
  
  private static void displayResultSet(ResultSet resultSet) 
      throws SQLException {
    ResultSetMetaData rsMetaData = resultSet.getMetaData();
    resultSet.beforeFirst();
    while (resultSet.next()) {
      for (int i = 1; i <= rsMetaData.getColumnCount(); i++)
        System.out.printf("%-12s\t", resultSet.getObject(i));
      System.out.println();
    }
  }
} 
