package javas;

import javas.config.AppDataSource;

public class Main {
    public static void main(String[] args) {
        AppDataSource conection = new AppDataSource();
        conection.connect();
    }
}