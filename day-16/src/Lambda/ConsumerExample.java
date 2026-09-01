package Lambda;

import java.util.function.Consumer;
public class ConsumerExample {

    public static void main(String[] args) {

        Consumer<String> print = text -> System.out.println(text);

        Consumer<String> uppercase = text -> System.out.println(text.toUpperCase());

        Consumer<Integer> square = number -> System.out.println(number * number);

        print.accept("Hello Java");

        uppercase.accept("functional interface");

        square.accept(5);
    }
}