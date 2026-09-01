package stream;

import Stream.Employees;

import java.util.Comparator;
import java.util.List;

public class SortedExample {

    public static void main(String[] args) {

        List<Employees> employees = List.of(

                new Employees(1, "Vamsi", "IT",
                        60000, List.of("Java")),

                new Employees(2, "Rahul", "HR",
                        45000, List.of("Excel")),

                new Employees(3, "Kiran", "IT",
                        75000, List.of("Spring")),

                new Employees(4, "Arjun", "Finance",
                        55000, List.of("Accounting"))
        );

        // here we use Comparator interface
        employees.stream()
                .sorted(Comparator.comparing(Employees::getSalary))
                .forEach(System.out::println);

        System.out.println("IN Descending Order :");
        employees.stream()
                .sorted(Comparator.comparing(Employees::getSalary).reversed())
                .forEach(System.out::println);
    }
}