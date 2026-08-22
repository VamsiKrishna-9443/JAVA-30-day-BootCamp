public class MultiLevelInheritance {

    static class Person {
        void showPerson() {
            System.out.println("I am a Person");
        }
    }

    static class Employee extends Person {
        void showEmployee() {
            System.out.println("I am an Employee");
        }
    }

    static class Manager extends Employee {
        void showManager() {
            System.out.println("I am a Manager");
        }
    }

    public static void main(String[] args) {

        Manager manager = new Manager();
        manager.showPerson();
        manager.showEmployee();
        manager.showManager();
    }
}