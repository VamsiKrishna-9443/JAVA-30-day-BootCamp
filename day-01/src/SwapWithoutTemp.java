public class SwapWithoutTemp
{
    public static void main(String[] args) {
        int a = 10;
        int b = 5;

        System.out.println("Before Swapping :");
        System.out.println("a = "+a);
        System.out.println("b = "+b);

         a = a + b;    // a = 15;
         b = a - b ;   // b =  10;
         a = a - b;    // a = 5;

        System.out.println("After Swapping :");
        System.out.println("a = "+a);
        System.out.println("b = "+b);
    }
}
