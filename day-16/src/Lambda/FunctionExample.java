package Lambda;

import java.util.function.Function;
public class FunctionExample {

    public static void main(String[] args) {


        //Function(T,R) objectname = t -> transform
        Function<String, Integer> getLength = text -> text.length();

        Function<Integer, Integer> square = number -> number * number;

        Function<String, String> uppercase = text -> text.toUpperCase();

        System.out.println(getLength.apply("Vamsi"));

        System.out.println(square.apply(5));

        System.out.println(uppercase.apply("java"));
    }
}