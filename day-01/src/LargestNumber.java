import java.util.*;
public class LargestNumber
{
    public static int Largest(int[] arr)
    {
        int n = arr.length;
        int maxi = Integer.MIN_VALUE;

        for(int i = 0 ; i < n ; i ++)
        {
            if(arr[i] > maxi)
            {
                maxi = arr[i];
            }
        }
        return maxi;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of the array:");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("enter the elements into the array :");
        for(int i  = 0  ; i < arr.length ; i++)
        {
            arr[i] = sc.nextInt();
        }

        int maxi = Largest(arr);
        System.out.println("Largest Number :" + maxi);
    }
}
