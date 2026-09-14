package PreparedStatement;

import java.sql.*;
import java.util.Scanner;

public class EmployeeCRUD {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/company";
        String username = "root";
        String password = "root123";

        Scanner sc = new Scanner(System.in);

        try (Connection con = DriverManager.getConnection(url, username, password)) {

            while (true)
            {
                System.out.println("\n1. Insert Employee");
                System.out.println("2. Display Employees");
                System.out.println("3. Update Employee");
                System.out.println("4. Delete Employee");
                System.out.println("5. Exit");

                System.out.print("Enter choice: ");
                int choice = sc.nextInt();

                switch (choice)
                {

                    case 1:
                        // CREATE
                        System.out.print("Enter employee ID: ");
                        int id = sc.nextInt();

                        sc.nextLine();

                        System.out.print("Enter employee name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter salary: ");
                        double salary = sc.nextDouble();

                        String insertQuery = "INSERT INTO employee VALUES (?, ?, ?)";

                        try (PreparedStatement ps = con.prepareStatement(insertQuery)) {

                            ps.setInt(1, id);
                            ps.setString(2, name);
                            ps.setDouble(3, salary);

                            int rows = ps.executeUpdate();

                            System.out.println(rows + " employee inserted");
                        }

                        break;

                    case 2:
                        // READ
                        String selectQuery = "SELECT * FROM employee";

                        try (PreparedStatement ps = con.prepareStatement(selectQuery);
                             ResultSet rs = ps.executeQuery()) {

                            while (rs.next())
                            {
                                System.out.println("ID: " + rs.getInt("id"));
                                System.out.println("Name: " + rs.getString("name"));
                                System.out.println("Salary: " + rs.getDouble("salary"));
                                System.out.println("----------------");
                            }
                        }

                        break;

                    case 3:
                        // UPDATE
                        System.out.print("Enter employee ID: ");
                        int updateId = sc.nextInt();

                        sc.nextLine();

                        System.out.print("Enter new name: ");
                        String newName = sc.nextLine();

                        System.out.print("Enter new salary: ");
                        double newSalary = sc.nextDouble();

                        String updateQuery = "UPDATE employee SET name = ?, salary = ? " + "WHERE id = ?";

                        try (PreparedStatement ps = con.prepareStatement(updateQuery)) {

                            ps.setString(1, newName);
                            ps.setDouble(2, newSalary);
                            ps.setInt(3, updateId);

                            int rows = ps.executeUpdate();

                            System.out.println(rows + " employee updated");
                        }

                        break;

                    case 4:
                        // DELETE
                        System.out.print("Enter employee ID: ");
                        int deleteId = sc.nextInt();

                        String deleteQuery = "DELETE FROM employee WHERE id = ?";

                        try (PreparedStatement ps = con.prepareStatement(deleteQuery)) {

                            ps.setInt(1, deleteId);

                            int rows = ps.executeUpdate();

                            System.out.println(rows + " employee deleted");
                        }

                        break;

                    case 5:
                        System.out.println("Program ended");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid choice");
                }
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}