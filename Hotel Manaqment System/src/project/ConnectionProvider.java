package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConnectionProvider {
    public static Connection getCon() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Ensure the driver class is correct for your DB
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "ddty32#s");
            return con;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}

