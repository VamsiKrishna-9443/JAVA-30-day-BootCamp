class Employee {
    int id;
    String name;
    double salary;


    static String company = "ABC Technologies";

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary);
        System.out.println("Company: " + company);
    }

    static void showCompany() {
        System.out.println("Company: " + company);
    }

    public static void main(String[] args) {

        Employee e1 = new Employee(101, "Vamsi", 40000);

        Employee e2 = new Employee(102, "Rahul", 45000);
        e1.display();
        System.out.println();
        e2.display();

        Employee.showCompany();
    }
}