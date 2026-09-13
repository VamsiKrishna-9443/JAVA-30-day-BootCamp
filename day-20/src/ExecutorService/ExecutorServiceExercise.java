package ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExercise {

    public static void main(String[] args) {

        ExecutorService executor =
                Executors.newFixedThreadPool(4);

        for (int i = 1; i <= 20; i++) {

            int taskNumber = i;

            executor.submit(() -> {

                System.out.println(
                        "Task " + taskNumber
                        + " executed by "
                        + Thread.currentThread().getName()
                );
            });
        }

        executor.shutdown();
    }
}
