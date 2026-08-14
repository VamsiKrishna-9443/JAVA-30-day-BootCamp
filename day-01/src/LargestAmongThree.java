import java.util.*;
public class LargestAmongThree
{
    public static int findLargest(int a , int b , int c)
    {
        if(a  > b)
        {
            if( a > c)
            {
                return a;
            }
        }
        else if ( b > c)
        {
            return  b;
        }
        return c;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Three Numbers :");

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int largest = findLargest(a,b,c);
        System.out.println("Largest number :" + largest);
    }
}
