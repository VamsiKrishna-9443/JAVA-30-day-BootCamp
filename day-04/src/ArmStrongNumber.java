import java.util.Scanner;

public class ArmStrongNumber
{
    public static boolean checkArmStrongNumber(int n)
    {
        int temp = n;
        int sum = 0;

        while(temp > 0)
        {
            int digit  = temp % 10;
            sum = sum + (digit * digit * digit);
            temp = temp / 10;
        }
        if(n == sum)
        {
            return true;
        }
        return false;
    }
   public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       System.out.println("Enter the number : ");
       int n = sc.nextInt();
       if(checkArmStrongNumber(n))
       {
           System.out.println("Armstrong number");
       }
       else
       {
           System.out.println("Not Armstrong Number");
       }
    }
}
