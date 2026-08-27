package  WildCard;
import java.util.ArrayList;
import java.util.List;

public class LowerBoundExample {

    //LowerBound wildcard
    public static void addNumbers(List<? super Integer> list) {
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println(list);
    }

    public static void main(String[] args) {

        List<Integer> integers = new ArrayList<>();

        System.out.println("Integer List:");
        addNumbers(integers);


        List<Number> numbers = new ArrayList<>();

        System.out.println("Number List:");
        addNumbers(numbers);


        List<Object> objects = new ArrayList<>();

        System.out.println("Object List:");
        addNumbers(objects);
    }
}