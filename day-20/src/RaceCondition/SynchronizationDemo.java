package RaceCondition;

public class SynchronizationDemo {

    static int count = 0;

    public static synchronized void increment() {
        count++;
    }

    public static void main(String[] args)
            throws InterruptedException {

        Thread thread1 = new Thread(() -> {

            for (int i = 0; i < 100000; i++) {
                increment();
            }
        });

        Thread thread2 = new Thread(() -> {

            for (int i = 0; i < 100000; i++) {
                increment();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(
                "Expected: 200000"
        );

        System.out.println(
                "Actual: " + count
        );
    }
}