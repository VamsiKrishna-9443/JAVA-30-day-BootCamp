package Execrise;

import java.util.HashMap;

// Program to use Employee objects in HashMap
public class EmployeeHashMap
{
    int id;
    String name;

    EmployeeHashMap(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(obj instanceof EmployeeHashMap)
        {
            EmployeeHashMap e = (EmployeeHashMap) obj;
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
        HashMap<EmployeeHashMap, String> map = new HashMap<>();

        EmployeeHashMap e1 = new EmployeeHashMap(101, "Vamsi");
        EmployeeHashMap e2 = new EmployeeHashMap(101, "Vamsi");

        map.put(e1, "Java Developer");

        System.out.println(e1.equals(e2));
        System.out.println(map.get(e2));
        System.out.println(e1.hashCode());

    }
}