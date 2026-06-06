
package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
    public static Connection getConnection() throws Exception {
        String url = "jdbc:mysql://localhost:3306/parking_management";
        String user = "root";
        String password = "123456";
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, user, password);
    }
}
