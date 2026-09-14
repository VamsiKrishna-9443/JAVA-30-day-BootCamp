package PreparedStatement;

import java.sql.*;
import java.util.Scanner;

public class DeleteEmployee {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/ciotlabs";
        String username = "root";
        String password = "root123";

        String deleteQuery = "DELETE FROM EMPLOYEES WHERE id = ?";

        try (Connection con = DriverManager.getConnection(url, username, password); Scanner scan = new Scanner(System.in); PreparedStatement pstmt = con.prepareStatement(deleteQuery))
        {
            System.out.print("Enter Employee ID to delete: ");
            int id = scan.nextInt();
            pstmt.setInt(1, id);
            int rows = pstmt.executeUpdate();
            System.out.println("Rows deleted: " + rows);

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}