import java.util.*;
public class AnagramString
{
    public static boolean checkAnagram(String s , String r)
    {
        if(s.length() != r.length())
        {
            return false;
        }
        char[] a = s.toCharArray();
        char[] b = r.toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        return Arrays.equals(a,b);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the String 1 :");
        String s =  sc.nextLine();
        System.out.println("Enter the String 2 :");
        String r =  sc.nextLine();

        if(checkAnagram(s,r))
        {
            System.out.println("Valid Anagram");
        }
        else
        {
            System.out.println("Not Valid Anagram");
        }
    }
}
