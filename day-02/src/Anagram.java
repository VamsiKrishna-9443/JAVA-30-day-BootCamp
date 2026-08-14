import java.util.*;

public class Anagram {
    public static boolean checkAnagram(String s,String r)
    {
        if(s.length() != r.length())
        {
            return false;
        }
        else {
            char[] a = s.toCharArray();
            char[] b = r.toCharArray();

            Arrays.sort(a);
            Arrays.sort(b);

            return Arrays.equals(a, b);
        }
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first String :");
        String s = sc.nextLine();
        System.out.println("Enter the second String :");
        String r = sc.nextLine();

        if(checkAnagram(s,r))
        {
            System.out.println("Valid Anagram");
        }
        else {
            System.out.println("Not Valid Anagram");
        }
    }
}
