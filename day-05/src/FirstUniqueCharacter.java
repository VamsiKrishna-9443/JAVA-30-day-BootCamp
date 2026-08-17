import java.util.*;

public class FirstUniqueCharacter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        HashMap<Character, Integer> freq = new HashMap<>();

        // Pass 1: Count characters
        for (char ch : str.toCharArray()) {

            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        // Pass 2: Find first unique character
        for (char ch : str.toCharArray()) {
            if (freq.get(ch) == 1) {

                System.out.println("First unique character: " + ch);
                return;
            }
        }
        System.out.println("No unique character found.");
    }
}