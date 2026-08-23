package practice;

// Program to use throws keyword
public class ThrowsDemo
{
    static void divide() throws ArithmeticException
    {
        int result = 10 / 0;

        System.out.println(result);
    }

    public static void main(String[] args)
    {
        try
        {
            divide();
        }
        catch(ArithmeticException e)
        {
            System.out.println("Cannot divide by zero");
        }
    }
}