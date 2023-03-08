package main.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class LoadDriver {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            String url = "jdbc:mysql://localhost:3306/newdb";
            String user = "developer";
            String password = "Irisviel95!";
            conn = DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (conn != null) conn.close();
            }catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
