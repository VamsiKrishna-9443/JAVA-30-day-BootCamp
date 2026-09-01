package Stream;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectExample {

    public static void main(String[] args) {

        List<Employees> employees = List.of(

                new Employees(1, "Vamsi", "IT",
                        60000, List.of("Java")),

                new Employees(2, "Rahul", "HR",
                        45000, List.of("Excel")),

                new Employees(3, "Kiran", "IT",
                        75000, List.of("Spring"))
        );


        //Stores in a List
        List<String> employeeNames =
                employees.stream()
                        .map(Employees::getName)
                        .collect(Collectors.toList());

        System.out.println(employeeNames);


        System.out.println("Storing in set :");

        //Stores in a Set
        Set<String> distinctEmployees = employees.stream().map(Employees::getDepartment).collect(Collectors.toSet());
        System.out.println(distinctEmployees);

    }
}