package Generics;

import java.util.*;
public class GenericMethod {
    public static <T> void printValue(T value)
    {
        System.out.println("Value : " + value);
    }

    //Generic Method with return value
    public static <T> T getValue(T value)
    {
        return value;
    }

    //generic Method with two return Values
    public static <K,V> void printPair(K key , V value)
    {
        System.out.println("Key : " + key);
        System.out.println("Value : " + value);
    }
    // generic method with list
    public static <T> void printList(List<T> list) {
        for (T value : list) {
            System.out.println(value);
        }
    }

    //generic Method with bounded type
    public static <T extends  Number> void printNumber(T number)
    {
        System.out.println("Number :" + number);
    }

    public static void main(String[] args) {
        GenericMethod.printValue(100);
        GenericMethod.printValue("Vamsi");
        GenericMethod.printValue("Krishna");
        GenericMethod.printValue(42.44);

        System.out.println("=======================================");
        System.out.println();
        String name = getValue("Bhoomika");
        Integer age = getValue(22);
        Double salary = getValue(5000.00);

        System.out.println(name);
        System.out.println(age);
        System.out.println(salary);

        System.out.println();
        printPair(101,"Krishna");

        List<String> names = new ArrayList<>();
        names.add("gopal");
        names.add("chandu");
        names.add("surya");
        names.add("bhanu");

        printList(names);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        System.out.println(numbers);

        printNumber(500);
        printNumber(600);
        printNumber(700);
        // printNumber("fgahh"); complie time error
    }
}
