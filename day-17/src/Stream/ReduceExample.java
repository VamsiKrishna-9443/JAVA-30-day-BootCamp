package Stream;

import java.util.List;

public class ReduceExample {
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

        double totalSalary = employees.stream().map(Employees::getSalary).reduce(0.0,(salary1,salary2) -> salary1 + salary2);
        System.out.println("Total Salary :" + totalSalary);

        double highestSalary = employees.stream().map(Employees:: getSalary).reduce(0.0,Math::max);
        System.out.println("highest salary :"+highestSalary);
    }
}
