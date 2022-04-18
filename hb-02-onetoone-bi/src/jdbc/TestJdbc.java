package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJdbc {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/db?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String pass = "admin";


        System.out.println("connecting to data base: " + jdbcUrl);

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, user, pass);
            System.out.println("connection success");
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("connection unsuccessful");
        }

    }
}
