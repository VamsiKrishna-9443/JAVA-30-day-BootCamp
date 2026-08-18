import utils.MathUtils;
import utils.StringUtils;

public class Main {

    public static void main(String[] args) {

        System.out.println(MathUtils.add(10, 20));
        System.out.println(MathUtils.subtract(20, 5));
        System.out.println(MathUtils.multiply(5, 4));
        System.out.println(MathUtils.divide(20, 4));

        System.out.println("PI = " + MathUtils.PI);

        String word = "madam";

        System.out.println(StringUtils.reverse(word));
        System.out.println(StringUtils.isPalindrome(word));
        System.out.println(StringUtils.countCharacters(word));
        System.out.println(StringUtils.toUpperCase(word));
    }
}