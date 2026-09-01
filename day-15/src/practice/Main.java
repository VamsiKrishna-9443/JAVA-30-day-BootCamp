package practice;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Object> objects = new ArrayList<>();

        objects.add(new Worker(101, "Vamsi"));
        objects.add(new Student(201, "Rahul"));

        for (Object object : objects) {
            System.out.println(object);
        }
    }
}