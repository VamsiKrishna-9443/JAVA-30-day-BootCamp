package practice;

import java.io.FileReader;
import java.io.FileNotFoundException;

// Program to handle checked exception
public class CheckedExceptionDemo
{
    public static void main(String[] args)
    {
        try
        {
            FileReader file =
                    new FileReader("data.txt");

            System.out.println("File opened");
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not found");
        }
    }
}