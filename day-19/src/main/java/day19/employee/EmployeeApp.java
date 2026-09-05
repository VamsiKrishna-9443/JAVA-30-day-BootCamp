package main.java.day19.employee;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class EmployeeApp {

    public static void main(String[] args) {

        Path csvPath = Path.of("day-19/data/employees/employees.csv");

        // =========================
        // EMPLOYEE DATA
        // =========================

        List<Employee> employees = List.of(
                        new Employee(
                                101,
                                "Vamsi",
                                50000
                        ),

                        new Employee(
                                102,
                                "Rahul",
                                60000
                        ),

                        new Employee(
                                103,
                                "Krishna",
                                70000
                        ),

                        new Employee(
                                104,
                                "Anil",
                                55000
                        )
                );

        // =========================
        // EXPORT
        // =========================

        EmployeeCsvExporter exporter =
                new EmployeeCsvExporter();

        try
        {
            exporter.export(employees, csvPath);
            System.out.println("Employees exported successfully.");
        }
        catch (IOException e) {
            System.out.println("Export failed: " + e.getMessage());
        }

        // =========================
        // IMPORT
        // =========================

        EmployeeCsvImporter importer = new EmployeeCsvImporter();

        try
        {
            List<Employee> importedEmployees = importer.importEmployees(csvPath);
            System.out.println("\nImported Employees:");
            for (Employee employee :importedEmployees)
            {
                System.out.println(employee);
            }
        } catch (IOException e) {
            System.out.println("Import failed: " + e.getMessage());
        }
    }
}