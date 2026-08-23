package Execrise;

import java.util.HashSet;

// Program to use Employee objects in HashSet
public class EmployeeHashSet
{
    int id;
    String name;

    EmployeeHashSet(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(obj instanceof EmployeeHashSet)
        {
            EmployeeHashSet e = (EmployeeHashSet) obj;
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

    @Override
    public String toString()
    {
        return id + " " + name;
    }

    public static void main(String[] args)
    {
        HashSet<EmployeeHashSet> set = new HashSet<>();

        EmployeeHashSet e1 = new EmployeeHashSet(101, "Vamsi");
        EmployeeHashSet e2 = new EmployeeHashSet(101, "Vamsi");
        EmployeeHashSet e3 = new EmployeeHashSet(102, "Rahul");

        set.add(e1);
        set.add(e2);
        set.add(e3);

        System.out.println(set);
    }
}