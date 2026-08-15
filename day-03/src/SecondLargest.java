import java.util.*;
public class SecondLargest
{
    public static  void secondLargest(int[] arr)
    {
        int n = arr.length;
        int largest = Integer.MIN_VALUE;
        int secondlargest = Integer.MIN_VALUE;

        for(int i = 0 ; i < n ; i++)
        {
            if(arr[i] > largest)
            {
                secondlargest = largest;
                largest = arr[i];
            }
            else if(secondlargest != largest && secondlargest < largest)
            {
                secondlargest = arr[i];
            }
        }
        System.out.println("Largest :"+largest);
        System.out.println("SecondLargest :"+secondlargest);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array :");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("enter the elements into the array:");
        for(int i  = 0;i  < n ;i++)
        {
            arr[i] = sc.nextInt();
        }
        secondLargest(arr);
    }
}
