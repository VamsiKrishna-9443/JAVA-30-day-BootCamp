package ConcurrentCollections;

import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteDemo {

    public static void main(String[] args)
            throws InterruptedException {

        CopyOnWriteArrayList<String> list =
                new CopyOnWriteArrayList<>();

        Thread writer = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                list.add("Item-" + i);
            }
        });

        Thread reader = new Thread(() -> {

            for (int i = 0; i < 5; i++) {
                System.out.println(list);
                try
                {
                    Thread.sleep(200);
                }
                catch (InterruptedException e)
                {
                    Thread.currentThread().interrupt();
                }
            }
        });

        writer.start();
        reader.start();

        writer.join();
        reader.join();

        System.out.println("Final list: " + list);
    }
}