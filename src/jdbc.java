import java.sql.*;

public class jdbc {
    Connection connection;
    Statement statement;
    ResultSet resultSet;


    jdbc(String db, String account, String password) throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db, account, password);
        System.out.println("SUCCESSFULLY");
    }

    /*public void conn(String db, String account, String password) throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db, account, password);
    }*/

    /*Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery("select * from vn");
                    while (resultSet.next()) {
                        System.out.println(resultSet.getString("username"));
                    }*/
}
