package Statement;

import java.sql.*;

public class JdbcDemo1 {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/ciotlabs";
        String username = "root";
        String password = "root123";

        String sql_query = "INSERT INTO EMPLOYEES VALUES (5, 'Surya','surya@gmail.com', 'React Trainee', 26000)";

        try {

            // Establish connection
            Connection con = DriverManager.getConnection(url, username, password);

            // Create Statement
            Statement stmt = con.createStatement();

            // Execute INSERT query
            int rows = stmt.executeUpdate(sql_query);

            if (rows > 0) {
                System.out.println("Employee inserted successfully.");
            } else {
                System.out.println("Employee not inserted.");
            }

            // Close resources
            stmt.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}