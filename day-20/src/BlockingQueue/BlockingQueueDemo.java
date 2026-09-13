package BlockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueDemo {

    public static void main(String[] args)
            throws InterruptedException {

        BlockingQueue<String> queue = new LinkedBlockingQueue<>(5);

        Thread producer = new Thread(() -> {

            try {

                for (int i = 1; i <= 10; i++) {

                    String task = "Task-" + i;

                    queue.put(task);

                    System.out.println("Produced: " + task);
                }

            } catch (InterruptedException e) {

                Thread.currentThread().interrupt();
            }
        });

        Thread consumer = new Thread(() -> {

            try
            {
                for (int i = 1; i <= 10; i++) {
                    String task = queue.take();
                    System.out.println("Consumed: " + task);
                    Thread.sleep(500);
                }

            }
            catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();

        System.out.println("Processing completed");
    }
}