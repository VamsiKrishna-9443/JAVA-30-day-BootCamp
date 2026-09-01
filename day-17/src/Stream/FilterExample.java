package Stream;

import Stream.Employees;

import java.util.List;

public class FilterExample {

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

        System.out.println("Traditional Method using the for loop and if for processing ");
        for(Employees emp : employees)
        {
            if(emp.getSalary() > 50000)
            {
                System.out.println(emp);
            }
        }
        System.out.println();
        System.out.println();
        System.out.println("Using Stream :");
        employees.stream()
                .filter(employee -> employee.getSalary() > 50000)
                .forEach(System.out::println);


        System.out.println("Using Stream :");
        employees.stream()
                .filter(employee -> employee.getSalary() > 50000).map(Employees::getName)
                .forEach(System.out::println);
    }
}