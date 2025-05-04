import java.sql.*;

public class Que15 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String user = "root";
        String pass = "password";

        try (Connection con = DriverManager.getConnection(url, user, pass);
             Statement stmt = con.createStatement()) {

            // Insert record
            String insert = "INSERT INTO students VALUES (1, 'Alice')";
            stmt.executeUpdate(insert);
            System.out.println("Inserted record");

            // Delete record
            String delete = "DELETE FROM students WHERE id = 1";
            stmt.executeUpdate(delete);
            System.out.println("Deleted record");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
