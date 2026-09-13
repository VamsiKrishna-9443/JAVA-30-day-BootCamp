package Thread;

public class MainThreadDemo {

    public static void main(String[] args) {
        System.out.println("Hello from: " + Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getId());
        System.out.println(Thread.currentThread().getPriority());
    }
}