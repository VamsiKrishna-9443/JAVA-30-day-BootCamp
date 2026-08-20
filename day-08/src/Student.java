class Student {

    String name;
    int age;
    int rollNo;

    static String college = "SVCE";

    Student(String name, int age, int rollNo) {
        this.name = name;
        this.age = age;
        this.rollNo = rollNo;
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Roll No: " + rollNo);
        System.out.println("College: " + college);
    }

    static void showCollege() {
        System.out.println("College: " + college);
    }

    public static  void main(String[] args)
    {
        Student s1 = new Student("Vamsi", 22, 101);
        Student s2 = new Student("Rahul", 21, 102);
        s1.display();
        System.out.println();

        s2.display();
        Student.showCollege();

    }
}