package LocalDate_and_Time;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Optional;

public class EmployeeTenureCalculator {

    public static void main(String[] args) {

        Employee employee = new Employee(101, "Vamsi", LocalDate.of(2023, 5, 18));

        Optional<Employee> optionalEmployee = Optional.ofNullable(employee);

        optionalEmployee.ifPresent(emp -> {

            System.out.println("Employee ID: " + emp.getId());

            System.out.println("Employee Name: " + emp.getName());

            System.out.println("Joining Date: " + emp.getJoiningDate());

            LocalDate today = LocalDate.now();
            LocalDate leavingDate = LocalDate.of(2026,5,18);

            System.out.println("Today's Date: " + today);
            System.out.println("Leaving Date :" + leavingDate);

            Period tenure = Period.between(emp.getJoiningDate(), today);
            Period tenurePeriod = Period.between(emp.getJoiningDate(),leavingDate);

            System.out.println("Employee Tenure: " + tenure.getYears() + " Years " + tenure.getMonths() + " Months " + tenure.getDays() + " Days");
            System.out.println("TENURE PERIOD");
            System.out.println("Employee Tenure: " + tenurePeriod.getYears() + " Years " + tenurePeriod.getMonths() + " Months " + tenurePeriod.getDays() + " Days");
        });

        LocalDateTime start = LocalDateTime.of(2026, 9, 1, 9, 0);

        LocalDateTime end = LocalDateTime.of(2026, 9, 1, 17, 30);

        Duration workingTime = Duration.between(start, end);

        System.out.println("Working Time: " + workingTime.toHours() + " Hours " + (workingTime.toMinutes() % 60) + " Minutes");
    }
}