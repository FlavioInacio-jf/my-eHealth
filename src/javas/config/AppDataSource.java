package javas.config;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AppDataSource {
    private Connection connection;
    public Connection connect () {

        String address = "jdbc:sqlite:src/database/database.db";
        try {
            Class.forName("org.sqlite.JDBC");
            this.connection = DriverManager.getConnection(address);
            return this.connection;
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error.getMessage());
            return null;
        }catch (ClassNotFoundException error) {
            JOptionPane.showMessageDialog(null, error.getMessage());
            return null;
        }
    }

    public Connection disconnect () {
        try {
            if (!this.connection.isClosed()) {
                this.connection.close();
                return this.connection;
            }
        }catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error.getMessage());
            return null;
        }
        return null;
    }
}
