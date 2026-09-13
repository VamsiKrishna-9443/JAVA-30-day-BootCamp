package ConcurrentCollections;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {

    public static void main(String[] args)
            throws InterruptedException {

        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                map.merge("Java", 1, Integer::sum);
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                map.merge("Java", 1, Integer::sum);
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Java count: " + map.get("Java"));
    }
}