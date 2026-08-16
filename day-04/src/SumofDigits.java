import java.util.*;
public class SumofDigits
{
    public static int sum(int n)
    {
        int total = 0 ;
        int temp = n;
        int digit;
        while(temp > 0)
        {
            digit  = temp  % 10;
            total += digit;
            temp = temp / 10;
        }
        return total;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Number :");
        int n = sc.nextInt();
        int total =  sum(n);
        System.out.println("Total Sum of Digit:"+total);
    }
}
