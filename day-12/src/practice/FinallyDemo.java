package practice;

// Program to use finally block
public class FinallyDemo
{
    public static void main(String[] args)
    {
        try
        {
            int result = 10 / 2;

            System.out.println("Result: " + result);
        }
        catch(ArithmeticException e)
        {
            System.out.println("Arithmetic Exception");
        }
        finally
        {
            System.out.println("Finally block executed");
        }
    }
}