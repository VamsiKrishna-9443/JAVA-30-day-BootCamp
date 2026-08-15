import  java.util.*;
public class Palindrome
{
    public static boolean checkPalindrome(String s)
    {
        String rev = "";
        for(int i = s.length() -1 ; i >=0 ;i--)
        {
            rev +=s.charAt(i);
        }
        if(rev.equals(s))
        {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the String:");
        String s = sc.nextLine();
        if(checkPalindrome(s))
        {
            System.out.println("String is a Palindrome ");
        }
        else
        {
            System.out.println("String is not a Palindrome");
        }

    }
}
