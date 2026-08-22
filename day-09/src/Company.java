public class Company {

    static class Person {
        private String name;
        private int age;
        Person(String name, int age) {
            this.name = name;
            this.age = age;
            System.out.println("Person constructor");
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public int getAge() {
            return age;
        }
        public void setAge(int age) {
            this.age = age;
        }
        void displayRole() {
            System.out.println("I am a Person");
        }
    }

    static class Employee extends Person {
        private int employeeId;
        private double salary;
        Employee(String name, int age, int employeeId, double salary) {
            super(name, age);
            this.employeeId = employeeId;
            this.salary = salary;
            System.out.println("Employee constructor");
        }
        public int getEmployeeId() {
            return employeeId;
        }
        public void setEmployeeId(int employeeId) {
            this.employeeId = employeeId;
        }
        public double getSalary() {
            return salary;
        }
        public void setSalary(double salary) {
            this.salary = salary;
        }
        @Override
        void displayRole() {
            super.displayRole();
            System.out.println("I am an Employee");
        }
    }

    static class Manager extends Employee {
        private int teamSize;
        Manager(String name, int age, int employeeId, double salary, int teamSize) {
            super(name, age, employeeId, salary);
            this.teamSize = teamSize;
            System.out.println("Manager constructor");
        }
        public int getTeamSize() {
            return teamSize;
        }
        public void setTeamSize(int teamSize) {
            this.teamSize = teamSize;
        }
        @Override
        void displayRole() {
            super.displayRole();

            System.out.println("I am a Manager");
        }
    }

    public static void main(String[] args) {
        Manager manager = new Manager("Vamsi", 22, 101, 50000, 10);

        System.out.println();

        System.out.println("Name: " + manager.getName());
        System.out.println("Age: " + manager.getAge());
        System.out.println("Employee ID: " + manager.getEmployeeId());
        System.out.println("Salary: " + manager.getSalary());
        System.out.println("Team Size: " + manager.getTeamSize());

        System.out.println();

        manager.displayRole();
        System.out.println();
        manager.setSalary(60000);
        System.out.println("Updated Salary: " + manager.getSalary());
    }
}