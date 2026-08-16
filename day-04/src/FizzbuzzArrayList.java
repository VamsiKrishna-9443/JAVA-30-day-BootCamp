import java.util.*;
public class FizzbuzzArrayList
{
    public  static  ArrayList<String> fizzbuzzCheck(int n)  // ArrayList Stores them in memory
    {
        ArrayList<String> res = new ArrayList<>(n);
        for(int i = 1 ; i <= n ; i++)
        {
            if(i % 3 == 0 && i % 5 == 0)
            {
                res.add("Fizzbuzz");
            } else if (i % 3 == 0)
            {
                res.add("Fizz");
            } else if (i % 5 == 0) {
                res.add("Buzz");
            }
            else{
                res.add(Integer.toString(i));
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number :");
        int n = sc.nextInt();
        ArrayList<String> result = fizzbuzzCheck(n);
        for(String s : result)
        {
            System.out.println(s + " ");
        }
    }
}
