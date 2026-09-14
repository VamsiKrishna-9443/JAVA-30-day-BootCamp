package Statement;

import java.sql.*;

public class JdbcDemo {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/CIOTLabs";
        String username = "root";
        String password = "root123";

        String sql = "SELECT * FROM employees";

        try {
            Connection con = DriverManager.getConnection(url, username, password);

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // 4. Print table heading
            System.out.println("---------------------------------------------------------------");
            System.out.printf("%-5s %-15s %-25s %-25s %-10s%n", "ID", "NAME", "EMAIL", "DESIGNATION", "SALARY");
            System.out.println("---------------------------------------------------------------");

            // 5. Read ResultSet
            while (rs.next())
            {

                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String designation = rs.getString("designation");
                double salary = rs.getDouble("salary");

                System.out.printf("%-5d %-15s %-25s %-25s %-10.2f%n", id, name, email, designation, salary);
            }

            stmt.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}