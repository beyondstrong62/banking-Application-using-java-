package com.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
    static Connection con = null;
    static String driver = "com.mysql.cj.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/training";

    public static Connection get() {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, "root", ""); // Updated username and password
            return con;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Exception: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        Connection connection = get();
        if (connection != null) {
            System.out.println("Connection established successfully!");
            try {
                connection.close(); // Close the connection when done
            } catch (SQLException e) {
                System.out.println("Exception while closing connection: " + e.getMessage());
            }
        } else {
            System.out.println("Failed to establish connection!");
        }
    }
}
