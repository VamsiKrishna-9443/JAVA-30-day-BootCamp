package main.java.day19.path;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class PathDemo {

    public static void main(String[] args) {

        Path path = Path.of("day-19", "data", "path", "employees.csv");

        System.out.println("Path of : " + path);
        System.out.println("File Name: " + path.getFileName());
        System.out.println("Parent Name: " + path.getParent());
        System.out.println("Root : " + path.getRoot());
        System.out.println("Absolute Path : " + path.toAbsolutePath());
        System.out.println("Is a Absolute Path T/F : " + path.isAbsolute());
        System.out.println("Path to String : " + path.toString());
        System.out.println("Starts with day-19 : " + path.startsWith("day-19"));
        System.out.println("Ends With : " + path.endsWith("employees.csv"));


        // =========================
        // RESOLVE
        // =========================

        Path folder = Path.of("data");

        Path employeePath = folder.resolve("employees.csv");

        System.out.println("Resolved Path : " + employeePath);


        // =========================
        // NORMALIZE
        // =========================

        Path messyPath = Path.of("day-19/data/employees/../employees/employees.csv");

        System.out.println("Before Normalize: " + messyPath);

        System.out.println("After Normalize: " + messyPath.normalize());


        // =========================
        // CREATE DIRECTORY & FILE
        // =========================

        try {

            // Create the parent folder
            Files.createDirectories(path.getParent());

            // Create employees.csv
            if (Files.notExists(path)) {
                Files.createFile(path);
                System.out.println("employees.csv created successfully.");
            } else {
                System.out.println("employees.csv already exists.");
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}