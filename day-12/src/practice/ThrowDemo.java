package practice;

// Program to use throw keyword
public class ThrowDemo
{
    public static void main(String[] args)
    {
        int age = 15;

        try
        {
            if(age < 18)
            {
                throw new ArithmeticException("Age is less than 18");
            }

            System.out.println("Eligible");
        }
        catch(ArithmeticException e)
        {
            System.out.println(e.getMessage());
        }
    }
}