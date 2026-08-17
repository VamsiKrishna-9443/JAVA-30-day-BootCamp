public class ReturnTypes {

    static int square(int n) {
        return n * n;
    }

    static String getName() {
        return "Vamsi";
    }

    static boolean isEven(int n) {
        return n % 2 == 0;
    }

    public static void main(String[] args) {

        System.out.println(square(5));
        System.out.println(getName());
        System.out.println(isEven(10));
    }
}