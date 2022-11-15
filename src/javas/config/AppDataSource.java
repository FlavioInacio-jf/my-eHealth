package javas.config;

import javas.errors.CustomError;
import javas.exceptions.AppDataSourceMessages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AppDataSource {
    private static Connection connection;
    public static Boolean connect() {

        String address = "jdbc:sqlite:src/database/database.db";

        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(address);
            return true;
        } catch (SQLException error) {
            throw new CustomError(AppDataSourceMessages.FAILED_USE_CONNECTION , error.getMessage());
        }catch (ClassNotFoundException error) {
            throw new CustomError(AppDataSourceMessages.FAILED_CONNECT_DATABASE, error.getMessage());
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
            throw new CustomError(AppDataSourceMessages.FAILED_DISCONNECT_DATABASE, error.getMessage());
        }
        return false;
    }

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connect();
            }
        }catch (SQLException error) {
            throw new CustomError(AppDataSourceMessages.FAILED_OPEN_DATABASE_CONNECTION, error.getMessage());
        }
        return connection;
    }

    public static void createTables(ArrayList<String> tables) {
        try {
            Statement stm = execute();
            for (String table : tables) {
                stm.execute(table);
            }
            stm.close();
        }catch(Exception error) {
            throw new CustomError(AppDataSourceMessages.FAILED_CREATE_TABLES_DATABASE, error.getMessage());
        }
    }

    public static Statement execute() {
        try {
            if (connection == null || connection.isClosed()) {
                connect();
            }
            return connection.createStatement();
        }catch (SQLException error) {
            throw new CustomError(AppDataSourceMessages.FAILED_EXECUTE_QUERY, error.getMessage());
        }
    }
}
