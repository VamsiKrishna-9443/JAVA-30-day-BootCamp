package Practice;

import java.util.function.Function;
public class EmployeeFunctionExample
{
    public static void main(String[] args)
    {
        Employees e1 = new Employees("pawan kalyan",50000);

        Function<Employees,Double> getAnnualSalary = emp -> emp.getMonthlySalary() * 12;

        double salary = getAnnualSalary.apply(e1);
        System.out.println("Employee :" + e1.getName());
        System.out.println("Annual Salary : " + salary);
    }
}
