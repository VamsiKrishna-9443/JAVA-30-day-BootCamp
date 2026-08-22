public class SuperExample {
    static  class Person
    {
        String name = "Vamsi";
        Person()
        {
            System.out.println("Person Constructor");
        }
        void display()
        {
            System.out.println("Person display Method");
        }
    }

    static  class Employee extends Person{
        String name = "Employee Krishna";

        Employee()
        {
            super();
            System.out.println("Employee Constructor");
        }
        void display()
        {
            System.out.println("Name of Employee :" + name);
            System.out.println("Name of Person   :" +super.name);

            super.display();
            System.out.println("Employee Display Method");
        }
    }

    public static void main(String[] args) {
        Employee e = new Employee();
        e.display();
    }
}
