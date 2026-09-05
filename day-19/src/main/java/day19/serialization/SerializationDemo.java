package main.java.day19.serialization;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class SerializationDemo {

    public static void main(String[] args) {

        Path path = Path.of("day-19/data/serialization/employee.txt");

        Employee employee = new Employee(101, "Vamsi", 50000, "secret123");

        // =========================
        // SERIALIZATION
        // =========================
        try
        {
            Files.createDirectories(path.getParent());
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path.toFile())))
            {
                out.writeObject(employee);
                System.out.println("Employee serialized successfully.");
            }
        }
        catch (IOException e)
        {
            System.out.println("Serialization error: " + e.getMessage());
        }

        // =========================
        // DESERIALIZATION
        // =========================

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(path.toFile())))
        {
            Employee restoredEmployee = (Employee) in.readObject();
            System.out.println("\nRestored Employee:");
            System.out.println(restoredEmployee);
        }
        catch (IOException | ClassNotFoundException e) {
            System.out.println("Deserialization error: " + e.getMessage());
        }
    }
}