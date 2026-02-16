package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {

    private static final String URL =
            "jdbc:sqlserver://localhost:1433;databaseName=loan_db;encrypt=true;trustServerCertificate=true;";
    private static final String USER = "sa";
    private static final String PASS = "senha";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}