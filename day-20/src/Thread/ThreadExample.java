package Thread;

public class ThreadExample {

    public static void main(String[] args) {

        // Thread 1
        Thread thread1 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Thread 1: " + i);
            }
        });

        // Thread 2
        Thread thread2 = new Thread(() -> {
            for (int i = 6; i <= 10; i++) {
                System.out.println("Thread 2: " + i);
            }
        });

        // Start both threads
        thread1.start();
        thread2.start();
    }
}