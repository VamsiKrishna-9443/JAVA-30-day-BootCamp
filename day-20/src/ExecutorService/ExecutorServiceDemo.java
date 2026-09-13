package ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceDemo {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 10; i++) {

            int taskNumber = i;
            executor.submit(() -> {
                System.out.println("Task " + taskNumber + " executed by " + Thread.currentThread().getName());
                try
                {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e)
                {
                    Thread.currentThread().interrupt();
                }
            });
        }
        executor.shutdown();
    }
}
