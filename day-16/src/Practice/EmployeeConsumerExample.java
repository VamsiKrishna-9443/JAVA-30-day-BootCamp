package Practice;

import java.util.function.Consumer;

public class EmployeeConsumerExample
{
    public static void main(String[] args) {

        Employees employee = new Employees("bhoomika",35000);

        Consumer<Employees>  printEmployee = emp -> {
            System.out.println("Employee name : " + emp.getName());
            System.out.println("Salary : " + emp.getMonthlySalary());
        };

        printEmployee.accept(employee);
    }
}
