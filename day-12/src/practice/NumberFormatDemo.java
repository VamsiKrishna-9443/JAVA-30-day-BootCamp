package practice;

// Program to handle NumberFormatException
public class NumberFormatDemo
{
    public static void main(String[] args)
    {
        try
        {
            String value = "abc";

            int number = Integer.parseInt(value);

            System.out.println(number);
        }
        catch(NumberFormatException e)
        {
            System.out.println("Invalid number format");
        }
    }
}