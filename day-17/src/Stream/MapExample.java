package stream;

import Stream.Employees;

import java.util.List;

public class MapExample {

    public static void main(String[] args) {

        List<Employees> employees = List.of(
                new Employees(1, "Vamsi", "IT",
                        60000, List.of("Java", "SQL")),

                new Employees(2, "Rahul", "HR",
                        45000, List.of("Excel", "Communication")),

                new Employees(3, "Kiran", "IT",
                        75000, List.of("Java", "Spring")),

                new Employees(4, "Arjun", "Finance",
                        55000, List.of("Excel", "Accounting"))
        );

        System.out.println("Names : ");
        employees.stream()
                .map(employee -> employee.getName())
                .forEach(System.out::println);

        System.out.println("Salary : ");
        employees.stream().map(Employees::getSalary).forEach(System.out::println);
    }
}