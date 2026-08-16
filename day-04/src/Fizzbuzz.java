import java.util.*;
public class Fizzbuzz {
    public static  void checkFizzbuzz(int n)
    {
        for(int i = 1 ; i <= n;i++)
        {
            if(i % 3 == 0 && i % 5 == 0)
            {
                System.out.println("Fizzbuzz");
            } else if (i % 3 == 0)
            {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            }
            else{
                System.out.println(i + " ");
            }
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Number");
        int n = sc.nextInt();
        checkFizzbuzz(n);
    }

}
