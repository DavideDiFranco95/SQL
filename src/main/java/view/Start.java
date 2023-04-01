package main.java.view;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Start {
    public static void main(String[] args) throws NullPointerException {
        Connection conn = null;
        try {
            String url = "jdbc:mysql://localhost:3306/newdb";
            String user = "root";
            String password = "Irisviel95!";
            conn = DriverManager.getConnection(url,user,password);
            Statement statement;
            ResultSet italians;
            ResultSet germans;
            List<Student> italianStudents = new ArrayList<>();
            List<Student> germanStudents = new ArrayList<>();
            try {
                statement = conn.createStatement();
                italians = statement.executeQuery("SELECT * FROM newdb.italian_students");
                while (italians.next()){
                    String surname = italians.getString("first_name");
                    String name = italians.getString(2);
                    Student stud = new Student(name,surname);
                    italianStudents.add(stud);
                }

                germans = statement.executeQuery("SELECT * FROM newdb.german_students");
                while (germans.next()){
                    String surname = germans.getString("first_name");
                    String name = germans.getString(2);
                    Student stud = new Student(name,surname);
                    germanStudents.add(stud);
                }
                System.out.println(italianStudents);
                System.out.println(germanStudents);
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
