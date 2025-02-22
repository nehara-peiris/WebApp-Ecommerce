package lk.ijse.myclosetecom_web.db;

import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Getter
public class DBConnection {
    private static DBConnection dbConnection;
    private final Connection connection;

    private DBConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "Ijse@123");
    }

    public static DBConnection getDbConnection() throws SQLException, ClassNotFoundException {
        return dbConnection == null ? dbConnection= new DBConnection() : dbConnection;
    }

}
