package Lambda;

import java.util.function.Predicate;
public class PredicateExample {

    public static void main(String[] args) {

        Predicate<Integer> isEven =
                number -> number % 2 == 0;

        Predicate<Integer> isPositive =
                number -> number > 0;

        Predicate<Integer> isAdult =
                age -> age >= 18;

        System.out.println(
                "10 is even: " + isEven.test(10)
        );

        System.out.println(
                "7 is even: " + isEven.test(7)
        );

        System.out.println(
                "10 is positive: " + isPositive.test(10)
        );

        System.out.println(
                "20 is adult: " + isAdult.test(20)
        );
    }
}