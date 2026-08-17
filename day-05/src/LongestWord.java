import java.util.*;
public class LongestWord
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Sentence :");
        String s = sc.nextLine();

        String[] words = s.split("\\s+"); //means split where ever one or more spaces occur

        String longest = "";
        for(String word : words)
        {
            if(word.length() > longest.length())
            {
                longest = word;
            }
        }

        System.out.println("Longest Word :" + longest);
        System.out.println("Length of the Longest Word :" + longest.length());
    }
}
