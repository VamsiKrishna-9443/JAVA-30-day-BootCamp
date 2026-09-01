package MethodReferences;

import java.util.function.Function;

public class ArbitraryMethodReferenceExample {

    public static void main(String[] args) {

        // Lambda
        Function<String, String> lambda =
                text -> text.toUpperCase();

        // Method Reference
        Function<String, String> methodReference =
                String::toUpperCase;


        System.out.println("Using Lambda:");

        System.out.println(
                lambda.apply("hello java")
        );


        System.out.println();

        System.out.println("Using Method Reference:");

        System.out.println(
                methodReference.apply("hello java")
        );
    }
}