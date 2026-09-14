package Statement;

import java.sql.*;
import java.util.Scanner;

public class DeleteEmployee {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/ciotlabs";
        String username = "root";
        String password = "root123";

        try (
                Connection con = DriverManager.getConnection(
                        url, username, password);

                Scanner scan = new Scanner(System.in);

                Statement stmt = con.createStatement()
        ) {

            System.out.print("Enter Employee ID to delete: ");
            int id = scan.nextInt();

            String deleteQuery = "DELETE FROM EMPLOYEES WHERE id = " + id;

            int rows = stmt.executeUpdate(deleteQuery);

            System.out.println("Rows deleted: " + rows);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}