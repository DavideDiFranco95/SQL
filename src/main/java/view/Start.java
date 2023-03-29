package main.java.view;

import java.sql.*;
import java.util.ArrayList;

public class Start {
    public static void main(String[] args) throws NullPointerException {
        Connection conn = null;
        try {
            String url = "jdbc:mysql://localhost:3306/newdb";
            String user = "developer";
            String password = "Irisviel95!";
            conn = DriverManager.getConnection(url,user,password);
            Statement statement;
            ResultSet italians;
            ResultSet germans;
            ArrayList<Student> italianStudents = new ArrayList<>();
            ArrayList<Student> germanStudents = new ArrayList<>();
            try {
                statement = conn.createStatement();
                italians = statement.executeQuery("SELECT * FROM italian_students");
                while (italians.next()){


                    for (Student student:italianStudents) {
                        student.surname = italians.getString("first_name");
                        student.name = italians.getString(2);
                        italianStudents.add(student);
                    }

                    System.out.println(italianStudents);

                }
                germans = statement.executeQuery("SELECT * FROM german_students");
                while (germans.next()){
                    for (Student student:germanStudents) {
                        student.surname = germans.getString("first_name");
                        student.name = germans.getString(2);
                        germanStudents.add(student);
                    }
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
