package PreparedStatement;

import java.sql.*;
import java.util.Scanner;

public class DeleteAndDisplay {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/ciotlabs";
        String username = "root";
        String password = "root123";

        String deleteQuery = "DELETE FROM EMPLOYEES WHERE id = ?";

        String selectQuery = "SELECT * FROM EMPLOYEES";

        try (Scanner scan = new Scanner(System.in)) {

            Connection con =
                    DriverManager.getConnection(url, username, password);

            // Delete employee
            PreparedStatement deleteStmt = con.prepareStatement(deleteQuery);

            System.out.print("Enter Employee ID to delete: ");
            int id = scan.nextInt();

            deleteStmt.setInt(1, id);

            int rows = deleteStmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Employee deleted successfully.");
                System.out.println("Rows deleted: " + rows);
            } else {
                System.out.println("Employee ID not found.");
            }

            // Display employees
            PreparedStatement selectStmt = con.prepareStatement(selectQuery);

            ResultSet rs = selectStmt.executeQuery();

            System.out.println("\nEmployee Records:");
            System.out.println("---------------------------------------------");

            while (rs.next()) {

                int empId = rs.getInt(1);
                String name = rs.getString(2);
                String email = rs.getString(3);
                String role = rs.getString(4);
                int salary = rs.getInt(5);

                System.out.println(
                        empId + " | " +
                                name + " | " +
                                email + " | " +
                                role + " | " +
                                salary
                );
            }

            rs.close();
            deleteStmt.close();
            selectStmt.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}