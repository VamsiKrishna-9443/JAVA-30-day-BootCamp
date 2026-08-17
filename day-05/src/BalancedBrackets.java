import java.util.*;

public class BalancedBrackets {

    public static boolean isValid(String s) {

        Stack<Character> st = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                st.push(')');
            } else if (ch == '{') {
                st.push('}');
            } else if (ch == '[') {
                st.push(']');
            }
             else
             {
                if (st.isEmpty() || st.pop() != ch) {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter brackets: ");
        String s = sc.nextLine();

        if (isValid(s)) {
            System.out.println("Balanced");
        } else {
            System.out.println("Not Balanced");
        }
    }
}