package Stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingCountExample {

    public static void main(String[] args) {

        List<Employees> employees = List.of(

                new Employees(1, "Vamsi", "IT",
                        60000, List.of("Java")),

                new Employees(2, "Rahul", "HR",
                        45000, List.of("Excel")),

                new Employees(3, "Kiran", "IT",
                        75000, List.of("Spring")),

                new Employees(4, "Arjun", "Finance",
                        55000, List.of("Accounting")),

                new Employees(5, "Priya", "HR",
                        50000, List.of("Recruitment"))
        );

        Map<String, Long> employeeCount =
                employees.stream()
                        .collect(
                                Collectors.groupingBy(
                                        Employees::getDepartment,
                                        Collectors.counting()
                                )
                        );

        System.out.println(employeeCount);
    }
}