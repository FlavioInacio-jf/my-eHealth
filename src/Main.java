import java.config.AppDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Main {
    public static void main(String[] args) {
        Connection conection;
        PreparedStatement pst;

        System.out.println("Hello world!");
        try {
            AppDataSource.Connector();
        }catch (Exception error) {
            System.out.println("Error");
        }

    }
}