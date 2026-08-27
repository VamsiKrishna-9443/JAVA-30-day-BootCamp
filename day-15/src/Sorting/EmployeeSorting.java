package Sorting;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmployeeSorting {

    public static void main(String[] args) {

        // Create Employee List
        List<Employee> employees = new ArrayList<>();

        // Add employees
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


        // =====================================================
        // 1. SORT BY NAME USING COMPARABLE
        // =====================================================

        System.out.println("\n======================================");
        System.out.println("SORTED BY NAME");
        System.out.println("======================================");

        Collections.sort(employees);

        for (Employee employee : employees) {
            employee.display();
        }


        // =====================================================
        // 2. SORT BY SALARY - ASCENDING
        // =====================================================

        System.out.println("\n======================================");
        System.out.println("SORTED BY SALARY - ASCENDING");
        System.out.println("======================================");

        employees.sort(
                Comparator.comparing(
                        Employee::getSalary
                )
        );

        for (Employee employee : employees) {
            employee.display();
        }


        // =====================================================
        // 3. SORT BY SALARY - DESCENDING
        // =====================================================

        System.out.println("\n======================================");
        System.out.println("SORTED BY SALARY - DESCENDING");
        System.out.println("======================================");

        employees.sort(
                Comparator.comparing(
                        Employee::getSalary
                ).reversed()
        );

        for (Employee employee : employees) {
            employee.display();
        }


        // =====================================================
        // 4. SORT BY JOINING DATE - ASCENDING
        // =====================================================

        System.out.println("\n======================================");
        System.out.println("SORTED BY JOINING DATE - ASCENDING");
        System.out.println("======================================");

        employees.sort(
                Comparator.comparing(
                        Employee::getJoiningDate
                )
        );

        for (Employee employee : employees) {
            employee.display();
        }


        // =====================================================
        // 5. SORT BY JOINING DATE - DESCENDING
        // =====================================================

        System.out.println("\n======================================");
        System.out.println("SORTED BY JOINING DATE - DESCENDING");
        System.out.println("======================================");

        employees.sort(
                Comparator.comparing(
                        Employee::getJoiningDate
                ).reversed()
        );

        for (Employee employee : employees) {
            employee.display();
        }


        // =====================================================
        // 6. MULTI-LEVEL SORTING
        // =====================================================

        System.out.println("\n======================================");
        System.out.println("SALARY → NAME → JOINING DATE");
        System.out.println("======================================");

        employees.sort(
                Comparator.comparing(
                                Employee::getSalary
                        )
                        .thenComparing(
                                Employee::getName
                        )
                        .thenComparing(
                                Employee::getJoiningDate
                        )
        );

        for (Employee employee : employees) {
            employee.display();
        }
    }
}