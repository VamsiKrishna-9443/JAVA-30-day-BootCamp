package Equals;

public class Customer
{
    int age;
    String name;
    Customer(int age , String name)
    {
        this.age = age;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(obj instanceof Customer)
        {
            Customer s = (Customer) obj;
            return  this.age == s.age & this.name == s.name;
        }
        else
        {
            return  false;
        }
    }

    public static void main(String[] args) {
        Customer s1 = new Customer(10,"Vamsi");
        Customer s2 = new Customer(10,"Vamsi");

        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(new Customer(10,"Vamsi")));

        if(s1.equals(s2))
        {
            System.out.println("Data is Same");
        }
        else {
            System.out.println("Data is Different");
        }
    }
}
