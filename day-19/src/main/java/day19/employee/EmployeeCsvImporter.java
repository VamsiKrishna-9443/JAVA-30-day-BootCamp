package main.java.day19.employee;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class EmployeeCsvImporter {

    public List<Employee> importEmployees(Path path) throws IOException {

        List<Employee> employees = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(path))
        {
            // Skip header
            String header = reader.readLine();

            if (header == null) {
                return employees;
            }

            String line;
            int lineNumber = 1;

            while ((line = reader.readLine()) != null)
            {
                lineNumber++;
                if (line.isBlank())
                {
                    continue;
                }

                try
                {
                    String[] data = line.split(",");
                    // Validate column count
                    if (data.length != 3) {
                        System.out.println("Invalid row at line " + lineNumber + ": " + line);
                        continue;
                    }

                    int id = Integer.parseInt(data[0].trim());

                    String name = data[1].trim();

                    double salary = Double.parseDouble(data[2].trim());

                    if (name.isEmpty()) {
                        System.out.println("Invalid employee name at line " + lineNumber);
                        continue;
                    }

                    Employee employee = new Employee(id, name, salary);
                    employees.add(employee);

                }
                catch (NumberFormatException e)
                {
                    System.out.println("Invalid number at line " + lineNumber + ": " + line);
                }
            }
        }
        return employees;
    }
}