package Unit4;

import java.sql.*;
import java.util.Scanner;

public class JDBCQ1 {
    public static void main(String[] args) {

        // set all the fields
        String dbUrl = "jdbc:mysql://localhost:3306/college";
        String dbUser = "root";
        String dbPass = "";

        try {

            // step 2 checvk for ther driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("driver loaded");

            // step 3 establish connection

            Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPass);
            System.out.println("connected to db!");

            add(con);
            update(con);
            view(con);
            remove(con);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

    public static void add(Connection con){
        try {
            // design preparedStatement
            String query = "INSERT INTO students (name, rollno, age, email) VALUES (?,?,?,?)";
            PreparedStatement psmt = con.prepareStatement(query);

            // take input
            Scanner sc = new Scanner(System.in);

            System.out.println("name:");
            String name = sc.nextLine();

            System.out.println("Enter rollno:");
            int rollno = Integer.valueOf(sc.nextLine());

            System.out.println("age:");
            int age = Integer.valueOf(sc.nextLine());

            System.out.println("Enter email:");
            String email = sc.nextLine();

            psmt.setString(1, name);
            psmt.setInt(2, rollno);
            psmt.setInt(3, age);
            psmt.setString(4, email);




        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void update(Connection con) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter rollno of student to update:");
            int rollno = Integer.parseInt(sc.nextLine());

            System.out.println("New name:");
            String name = sc.nextLine();

            System.out.println("New age:");
            int age = Integer.parseInt(sc.nextLine());

            System.out.println("New email:");
            String email = sc.nextLine();

            String query = "UPDATE students SET name = ?, age = ?, email = ? WHERE rollno = ?";
            PreparedStatement psmt = con.prepareStatement(query);
            psmt.setString(1, name);
            psmt.setInt(2, age);
            psmt.setString(3, email);
            psmt.setInt(4, rollno);

            int rows = psmt.executeUpdate();
            System.out.println(rows + " record(s) updated.");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void remove(Connection con) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter rollno of student to delete:");
            int rollno = Integer.parseInt(sc.nextLine());

            String query = "DELETE FROM students WHERE rollno = ?";
            PreparedStatement psmt = con.prepareStatement(query);
            psmt.setInt(1, rollno);

            int rows = psmt.executeUpdate();
            System.out.println(rows + " record(s) deleted.");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void view(Connection con) {
        try {
            String query = "SELECT * FROM students";
            PreparedStatement psmt = con.prepareStatement(query);
            ResultSet rs = psmt.executeQuery();

            System.out.println("RollNo\tName\tAge\tEmail");
            System.out.println("----------------------------------------");

            while (rs.next()) {
                int rollno = rs.getInt("rollno");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String email = rs.getString("email");

                System.out.println(rollno + "\t" + name + "\t" + age + "\t" + email);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }





}
