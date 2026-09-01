package stream;

import Stream.Employees;
import com.sun.security.jgss.GSSUtil;

import java.util.List;
import java.util.stream.Collectors;

public class FlatMapExample {

    public static void main(String[] args) {

        List<Employees> employees = List.of(

                new Employees(1, "Vamsi", "IT",
                        60000, List.of("Java", "SQL", "Spring")),

                new Employees(2, "Rahul", "HR",
                        45000, List.of("Excel", "Communication")),

                new Employees(3, "Kiran", "IT",
                        75000, List.of("Java", "AWS", "Docker"))
        );

        List<String> skills =employees.stream()
                .flatMap(employee -> employee.getSkills().stream()).distinct().sorted()
                .toList();
        System.out.println(skills);
    }
}