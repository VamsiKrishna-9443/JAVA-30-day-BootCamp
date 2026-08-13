import java.util.*;
public class SUM
{
    public static  int add(int a,int b)
    {
        return a + b;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Numbers :");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int sum = add(a,b);
        System.out.println("Sum of the Two Numbers :"+sum);
    }
}
