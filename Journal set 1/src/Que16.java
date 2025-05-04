import java.sql.*;

public class Que16 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String user = "root";
        String pass = "password";

        String insert = "INSERT INTO employee (name, age, salary) VALUES (?, ?, ?)";

        try (Connection con = DriverManager.getConnection(url, user, pass);
             PreparedStatement stmt = con.prepareStatement(insert)) {

            // Sample employee data
            String[] names = {"Alice", "Bob", "Charlie"};
            int[] ages = {25, 30, 28};
            double[] salaries = {50000, 60000, 55000};

            for (int i = 0; i < names.length; i++) {
                stmt.setString(1, names[i]);
                stmt.setInt(2, ages[i]);
                stmt.setDouble(3, salaries[i]);
                stmt.executeUpdate();
            }

            System.out.println("Employee records inserted.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
