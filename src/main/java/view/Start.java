package main.java.view;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Start {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            String url = "jdbc:mysql://localhost:3306/newdb";
            String user = "developer";
            String password = "Irisviel95!";
            conn = DriverManager.getConnection(url,user,password);
            Statement statement;
            ResultSet resultSet;
            ResultSet resultSet1;
            List<String> italianStudents = new ArrayList<>();
            List<String> germanStudents = new ArrayList<>();
            try {
                statement = conn.createStatement();
                resultSet = statement.executeQuery("SELECT * FROM italian_students");
                while (resultSet.next()){
                    System.out.print(resultSet.getString("first_name") + " ");
                    System.out.println(resultSet.getString(2));
                    italianStudents.add(resultSet.getString("first_name"));
                    System.out.println(italianStudents);

                }
                resultSet1 = statement.executeQuery("SELECT * FROM german_students");
                while (resultSet1.next()){
                    System.out.print(resultSet1.getString("first_name") + " ");
                    System.out.println(resultSet1.getString(2));
                    germanStudents.add(resultSet1.getString("first_name"));
                    System.out.println(germanStudents);
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
