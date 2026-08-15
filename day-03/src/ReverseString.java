import java.util.*;
public class ReverseString
{
    static String reverse(String s)
    {
        String rev = "";
        for(int i = s.length() - 1; i >=0 ;i--)
        {
            rev += s.charAt(i);
        }
        return rev;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String :");
        String s = sc.nextLine();
        
        String rev = reverse(s);
        System.out.println("Reverse String :"+rev);
    }
}
