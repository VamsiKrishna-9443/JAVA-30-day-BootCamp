package Practice;

public class Employees
{
    private String name;
    private double monthlySalary;

    public Employees(String name , double monthlySalary)
    {
        this.name = name;
        this.monthlySalary = monthlySalary;
    }

    public String getName()
    {
        return name;
    }

    public double getMonthlySalary()
    {
        return monthlySalary;
    }
}
