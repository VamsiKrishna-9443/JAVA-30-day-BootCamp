public class Inheritance {
    static class Person {
        String name = "Vamsi";
        void displayName() {
            System.out.println("Name: " + name);
        }
    }

    static class Employee extends Person {
        int salary = 30000;
        void displaySalary() {
            System.out.println("Salary: " + salary);
        }
    }

    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.displayName();
        emp.displaySalary();

        System.out.println("Employee Details :");
        System.out.println("Employee Name :"+emp.name);
        System.out.println("Employee Salary :"+emp.salary);
    }
}