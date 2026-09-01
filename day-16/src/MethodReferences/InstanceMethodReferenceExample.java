package MethodReferences;

import java.util.function.Consumer;

class Printer {

    public void print(String message) {

        System.out.println(
                "Message: " + message
        );
    }
}

public class InstanceMethodReferenceExample {

    public static void main(String[] args) {

        Printer printer = new Printer();

        // Lambda
        Consumer<String> lambda =
                message -> printer.print(message);

        // Method Reference
        Consumer<String> methodReference =
                printer::print;


        System.out.println("Using Lambda:");

        lambda.accept("Hello Java");


        System.out.println();

        System.out.println("Using Method Reference:");

        methodReference.accept("Hello Method Reference");
    }
}