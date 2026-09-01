package Lambda;

import java.util.function.Supplier;
public class SupplierExample {

    public static void main(String[] args) {

        Supplier<String> message = () -> "Hello Java";

        Supplier<Integer> number = () -> 100;

        Supplier<Double> randomNumber = () -> { return 2.4;};


        System.out.println(message.get());

        System.out.println(number.get());

        System.out.println(randomNumber.get());
    }
}