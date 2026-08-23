package practice;

// Program to handle NullPointerException
public class NullPointerDemo
{
    public static void main(String[] args)
    {
        try
        {
            String name = null;

            System.out.println(name.length());
        }
        catch(NullPointerException e)
        {
            System.out.println("Object contains null value");
        }
    }
}