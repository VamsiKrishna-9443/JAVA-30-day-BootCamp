package Sorting;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableExample {

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

        employees.add(
                new Employee(
                        105,
                        "Arjun",
                        60000,
                        LocalDate.of(2023, 6, 10)
                )
        );


        System.out.println("Before sorting:");

        for (Employee employee : employees) {
            employee.display();
        }


        // Comparable
        // Employee.compareTo() sorts by name

        Collections.sort(employees);


        System.out.println("\nAfter sorting by name:");

        for (Employee employee : employees) {
            employee.display();
        }
    }
}