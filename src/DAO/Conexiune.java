package DAO;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexiune {
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3308/fmi_pao";
    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PASSWORD = "password";

    public static java.sql.Connection getConnection() {
        java.sql.Connection connection = null;
        try {
            connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
