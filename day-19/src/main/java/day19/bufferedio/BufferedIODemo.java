package main.java.day19.bufferedio;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class BufferedIODemo {

    public static void main(String[] args) {

        Path path = Path.of("day-19/data/buffered/employees.txt");

        try {
            // Create directory
            Files.createDirectories(path.getParent());
            // -------------------------
            // WRITE
            // -------------------------

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(path.toFile())))
            {
                writer.write("101,Vamsi,50000");
                writer.newLine();

                writer.write("102,Bhoomika,60000");
                writer.newLine();

                writer.write("103,Aashitha,70000");
                writer.newLine();

                writer.flush();
            }

            System.out.println("Data written successfully.");

            // -------------------------
            // READ
            // -------------------------

            try (BufferedReader reader = new BufferedReader(new FileReader(path.toFile())))
            {
                String line;
                while ((line = reader.readLine()) != null)
                {
                    System.out.println(line);
                }
            }
            System.out.println("Data read successfully.");
        }
        catch (IOException e)
        {
            System.out.println("I/O Error: " + e.getMessage());
        }
    }
}