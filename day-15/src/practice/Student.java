package practice;

class Student {

    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Studentid = " + id + " name = " + name ;
    }
}