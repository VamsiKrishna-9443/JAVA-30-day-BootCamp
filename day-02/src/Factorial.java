import java.util.*;
public class Factorial {
    public static int factorial(int n)
    {
        int fact = 1;
        for(int i = 1 ; i <= n; i++)
        {
            fact  = fact * i;
        }
        return fact;
    }
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Number :");
        int n = sc.nextInt();

        int fact = factorial(n);
        System.out.println("Factorial of number :" + fact);
    }
}
