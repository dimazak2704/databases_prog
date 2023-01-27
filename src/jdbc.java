import java.sql.*;

public class jdbc {
    Connection connection;
    Statement statement;
    ResultSet resultSet;


    jdbc(String db, String account, String password) throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db, account, password);
        this.statement = this.connection.createStatement();
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

    public void create(String database, String tablename) throws SQLException {
    int result = this.statement.executeUpdate("create table "+ tablename+ "(id int)");
        System.out.println(result);
    }

    public void delete(String database, String delete, String name) throws SQLException {
        if (delete=="table") {
            int result = this.statement.executeUpdate("drop table " + name);
        }
        else{
            int result = this.statement.executeUpdate("delete from "+ name);
        }
    }
}
