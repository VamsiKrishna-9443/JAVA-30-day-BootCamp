package WildCard;

import java.util.ArrayList;
import java.util.List;

public class UpperBoundExample {

    // UpperBound Wildcard
    // Some unknown type that is Number or a subclass of Number.
    public static void printNumbers(List<? extends Number> numbers) {
        for (Number number : numbers) {
            System.out.println(number);
        }
    }

    public static void main(String[] args) {

        List<Integer> integers = new ArrayList<>();
        integers.add(10);
        integers.add(20);
        integers.add(30);

        List<Double> doubles = new ArrayList<>();
        doubles.add(10.5);
        doubles.add(20.5);
        doubles.add(30.5);

        System.out.println("Integers:");

        printNumbers(integers);

        System.out.println();

        System.out.println("Doubles:");

        printNumbers(doubles);
    }
}