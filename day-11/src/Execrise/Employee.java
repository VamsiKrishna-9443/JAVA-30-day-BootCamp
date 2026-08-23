package Execrise;

// Program to Override equals() and hashCode()
public class Employee
{
    int id;
    String name;

    Employee(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(obj instanceof Employee)
        {
            Employee e = (Employee) obj;
            return this.id == e.id;
        }
        else
        {
            return false;
        }
    }

    @Override
    public int hashCode()
    {
        return id;
    }

    public static void main(String[] args)
    {
        Employee e1 = new Employee(101, "Vamsi");
        Employee e2 = new Employee(101, "Vamsi");

        System.out.println(e1.equals(e2));
        System.out.println(e1.hashCode());
        System.out.println(e2.hashCode());
    }
}