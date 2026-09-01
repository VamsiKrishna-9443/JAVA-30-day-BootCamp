package MethodReferences;

import java.util.function.Function;

class Calculator {

    static int square(int number) {
        return number * number;
    }

    static int cube(int number) {
        return number * number * number;
    }

    static int doubleValue(int number) {
        return number * 2;
    }
}

public class StaticMethodReferenceExample {

    public static void main(String[] args) {

        // Lambda
        Function<Integer, Integer> squareLambda = number -> Calculator.square(number);

        // Method Reference
        Function<Integer, Integer> squareMethodReference = Calculator::square;

        System.out.println("Using Lambda: " + squareLambda.apply(5));

        System.out.println("Using Method Reference: " + squareMethodReference.apply(5));


        // Cube
        Function<Integer, Integer> cube =
                Calculator::cube;

        System.out.println("Cube: "
                + cube.apply(3));


        // Double
        Function<Integer, Integer> doubleValue =
                Calculator::doubleValue;

        System.out.println("Double: "
                + doubleValue.apply(10));
    }
}