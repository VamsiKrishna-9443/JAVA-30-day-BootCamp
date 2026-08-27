package Sorting;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparatorExample {

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();

        employees.add(
                new Employee(
                        101,
                        "Vamsi",
                        60000,
                        LocalDate.of(2024, 5, 10)
                )
        );

        employees.add(
                new Employee(
                        102,
                        "Rahul",
                        50000,
                        LocalDate.of(2023, 2, 15)
                )
        );

        employees.add(
                new Employee(
                        103,
                        "Anil",
                        70000,
                        LocalDate.of(2025, 1, 20)
                )
        );

        employees.add(
                new Employee(
                        104,
                        "Kiran",
                        55000,
                        LocalDate.of(2022, 8, 5)
                )
        );


        // Comparator for salary
        Comparator<Employee> salaryComparator =
                (e1, e2) ->
                        Double.compare(
                                e1.getSalary(),
                                e2.getSalary()
                        );


        // Sort employees by salary
        employees.sort(salaryComparator);


        System.out.println(
                "Employees sorted by salary:"
        );

        for (Employee employee : employees) {
            employee.display();
        }
    }
}