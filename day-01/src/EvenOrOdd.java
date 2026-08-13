import  java.util.*;
public class EvenOrOdd
{
    public  static void checkNumber(int n) {
        if(n % 2 == 0)
        {
            System.out.println(n + " is a Even Number");
        }
        else
        {
            System.out.println(n + "  is a Odd Number");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Number :");
        int n = sc.nextInt();

        checkNumber(n);
    }


}
