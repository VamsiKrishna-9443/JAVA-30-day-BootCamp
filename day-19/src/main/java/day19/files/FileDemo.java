package main.java.day19.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileDemo {

    public static void main(String[] args) {

        Path folder = Path.of("day-19/data/files");
        Path file = folder.resolve("employees.txt");

        try {

            // 1. Create directories
            Files.createDirectories(folder);
            System.out.println("File path: " + file.toAbsolutePath());
            // 2. Check directory
            System.out.println("Directory exists: " + Files.exists(folder));

            // 3. Create file
            if (!Files.exists(file))
            {
                Files.createFile(file);
                System.out.println("File created");
            }

            // 4. Check file
            System.out.println("Is regular file: " + Files.isRegularFile(file));

            // 5. Write String
            Files.writeString(file,
                        "101,Vamsi,50000\n"
                            + "102,Rahul,60000\n"
                            + "103,Krishna,70000");

            // 6. Read String
            String content = Files.readString(file);

            System.out.println("\nFile Content:");
            System.out.println(content);

            // 7. Read all lines
            List<String> lines = Files.readAllLines(file);
            System.out.println("\nReading Line By Line:");
            for (String line : lines)
            {
                System.out.println(line);
            }

            // 8. Copy file
            Path backup = folder.resolve("employees-backup.txt");

            Files.copy(file, backup, java.nio.file.StandardCopyOption.REPLACE_EXISTING);

            System.out.println("\nFile copied");

            // 9. Move file
            Path movedFile = folder.resolve("employees-moved.txt");

            Files.move(backup, movedFile, java.nio.file.StandardCopyOption.REPLACE_EXISTING);

            System.out.println("File moved");

            // 10. Delete moved file
            Files.deleteIfExists(movedFile);

            System.out.println("Moved file deleted");


        } catch (IOException e) {

            System.out.println(
                    "File operation failed: "
                            + e.getMessage()
            );
        }
    }
}