package Equals;

// Without overiding the Equals()
public class Worker
{
    int age;
    Worker(int age)
    {
        this.age = age;
    }

    public static void main(String[] args) {
        Worker w1 = new Worker(20);
        Worker w2 = new Worker(20);
        System.out.println(w1.equals(w2));
    }
}
