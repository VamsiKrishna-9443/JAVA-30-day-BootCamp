package practice;

import java.util.ArrayList;
import java.util.List;

public class MainClass
{
    public static void main(String[] args) {
        List<Worker> workers = new ArrayList<>();

        workers.add(new Worker(101,"vamsi"));
        workers.add(new Worker(102,"Bhoomika"));

        for(Worker worker : workers)
        {
            System.out.println(worker);
        }

        //
        List<Student> students = new ArrayList<>();
        students.add(new Student(200,"AAshitha"));
        students.add(new Student(201,"itachi"));


        for(Student s : students)
        {
            System.out.println(s);
        }

    }
}
