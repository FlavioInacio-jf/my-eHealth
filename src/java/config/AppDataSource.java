package java.config;
import java.sql.*;

public class AppDataSource {
    public static Connection Connector () {
        java.sql.Connection connection;

        String driver = "com.mysql.jdbc.Driver";
        String address = "jdbc:msql://localhost:3333/myHeath";
        String user = "root";
        String password = "";

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(address, user, password);
            return connection;
        } catch (Exception error) {
            return null;
        }

    }
}
