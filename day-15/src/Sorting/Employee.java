package Sorting;

import java.time.LocalDate;

public class Employee implements Comparable<Employee> {

    private int id;
    private String name;
    private double salary;
    private LocalDate joiningDate;

    public Employee(
            int id,
            String name,
            double salary,
            LocalDate joiningDate) {

        this.id = id;
        this.name = name;
        this.salary = salary;
        this.joiningDate = joiningDate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    // Natural ordering = Name
    @Override
    public int compareTo(Employee other) {
        return this.name.compareTo(other.name);
    }

    public void display() {
        System.out.println(
                "ID: " + id +
                        " | Name: " + name +
                        " | Salary: " + salary +
                        " | Joining Date: " + joiningDate
        );
    }
}