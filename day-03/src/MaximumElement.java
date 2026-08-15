import java.util.*;
public class MaximumElement
{
    public static void maxiAndMinElement(int[] arr)
    {
        int n = arr.length;
        int maxi =  Integer.MIN_VALUE;
        for(int i  = 0 ; i < n;i++)
        {
            if(arr[i] > maxi)
            {
                maxi = arr[i];
            }
        }

        int mini = Integer.MAX_VALUE;
        for(int i  = 0 ; i < n;i++)
        {
            if(arr[i] < mini)
            {
                mini = arr[i];
            }
        }
        System.out.println("Maximum element in the array:"+ maxi);
        System.out.println("Minimum element in the array:"+ mini);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the Size of the array");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("enter the elements into the array:");
        for(int i = 0 ; i < n ;i ++)
        {
            arr[i] = sc.nextInt();
        }
        maxiAndMinElement(arr);
    }
}
