package javas.config;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AppDataSource {
    private static Connection connection;
    public static Boolean connect() {

        String address = "jdbc:sqlite:src/database/database.db";
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(address);
            return true;
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Não foi possível abrir a conexão com o banco!");
            return false;
        }catch (ClassNotFoundException error) {
            JOptionPane.showMessageDialog(null, "Ocorreu uma falha ao utilizar o driver de conexão!");
            return false;
        }
    }

    public static Boolean disconnect() {
        if (connection == null) {
            return true;
        }
        try {
            if (!connection.isClosed()) {
                connection.close();
                return true;
            }
        }catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Não foi possível fechar a conexão com o banco!");
            return false;
        }
        return false;
    }

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connect();
            }
        }catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Não foi possível abrir a conexão com o banco!");
        }
        return connection;
    }

    public static void init() {

    }
}
