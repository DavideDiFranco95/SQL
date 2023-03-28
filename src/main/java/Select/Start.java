package main.java.Select;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Start {
    public static void main(String[] args)throws NullPointerException,SQLException {
        Connection conn = null;
        try {
            String url = "jdbc:mysql://localhost:3306/newdb";
            String user = "developer";
            String password = "Irisviel95!";
            conn = DriverManager.getConnection(url,user,password);
            Statement statement;
            ResultSet resultSet;
            List<String> surnames = new ArrayList<>();
            try {
                statement = conn.createStatement();
                resultSet = statement.executeQuery("SELECT first_name,last_name FROM newdb.students");
                while (resultSet.next()){
                    System.out.print(resultSet.getString("first_name") + " ");
                    System.out.println(resultSet.getString(2));
                    surnames.add(resultSet.getString("last_name"));
                    System.out.println(surnames);
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (conn != null) conn.close();
            }catch (SQLException e){
                System.out.println("SQLException: "+ e.getMessage());
                System.out.println("SQLException: "+ e.getSQLState());
                System.out.println("SQLException: "+ e.getErrorCode());
            }
        }
    }
}
