package Practice;

import java.util.function.Predicate;

public class EmployeePredicateExample
{
    public static void main(String[] args) {
        Employees employee1 = new Employees("Vamsi", 15000);
        Employees employee2 = new Employees("gopala", 20000);
        Employees employee3 = new Employees("surya", 10000);
        Employees employee4 = new Employees("nisyal", 9000);

        Predicate<Employees> eligibleForBonus = employee -> employee.getMonthlySalary() > 10000;

        System.out.println(employee1.getName() + " : " + eligibleForBonus.test(employee1));
        System.out.println(employee2.getName() + " : " + eligibleForBonus.test(employee2));
        System.out.println(employee4.getName() + " : " + eligibleForBonus.test(employee4));
    }
}
