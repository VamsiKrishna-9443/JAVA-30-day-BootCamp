package utils;

public class StringUtils {

    private StringUtils() {
        // Prevent object creation
    }

    public static String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public static boolean isPalindrome(String str) {
        String reversed = reverse(str);
        return str.equalsIgnoreCase(reversed);
    }

    public static int countCharacters(String str) {
        return str.length();
    }

    public static String toUpperCase(String str) {
        return str.toUpperCase();
    }
}