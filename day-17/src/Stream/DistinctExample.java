package Stream;

import java.util.List;

public class DistinctExample {

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


        // distinct() - gets only distinct Departments
        employees.stream()
                .map(Employees::getDepartment)
                .distinct()
                .forEach(System.out::println);

        //using flatmap and distinct ,sorted
        System.out.println("SKills :");
        employees.stream().flatMap(employee -> employee.getSkills().stream()).distinct().sorted()
                .forEach(System.out :: println);
    }
}