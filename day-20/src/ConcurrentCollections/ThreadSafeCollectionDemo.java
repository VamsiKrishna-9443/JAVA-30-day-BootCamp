package ConcurrentCollections;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.List;

public class ThreadSafeCollectionDemo {

    public static void main(String[] args) throws InterruptedException {

        List<Integer> list = new CopyOnWriteArrayList<>();

        Thread thread1 = new Thread(() -> {

            for (int i = 0; i < 1000; i++) {
                list.add(i);
            }
        });

        Thread thread2 = new Thread(() -> {

            for (int i = 1000; i < 2000; i++) {
                list.add(i);
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Expected size: 2000");
        System.out.println("Actual size: " + list.size());
    }
}