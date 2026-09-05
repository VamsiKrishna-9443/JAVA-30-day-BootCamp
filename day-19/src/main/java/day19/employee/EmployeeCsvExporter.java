package main.java.day19.employee;


import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class EmployeeCsvExporter {

    public void export(List<Employee> employees, Path path) throws IOException {

        // Create parent directory
        if (path.getParent() != null)
        {
            Files.createDirectories(path.getParent());
        }

        try (BufferedWriter writer =Files.newBufferedWriter(path)) {
            // Header
            writer.write("id,name,salary");
            writer.newLine();

            // Employee records
            for (Employee employee : employees) {
                writer.write(employee.getId() + "," + employee.getName() + "," + employee.getSalary());
                writer.newLine();
            }
        }
    }
}
