package Generics;

import java.util.ArrayList;
import java.util.List;

public class WildcardExample {

    // using wilcard in the method parameter
    public static void printList(List<?> list) {
        for (Object value : list) {
            System.out.println(value);
        }
    }

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();

        names.add("Vamsi");
        names.add("Rahul");
        names.add("Anil");

        List<Integer> numbers = new ArrayList<>();

        numbers.add(10);
        numbers.add(20);
        numbers.add(30);

        System.out.println("Names:");
        printList(names);

        System.out.println();

        System.out.println("Numbers:");
        printList(numbers);
    }
}