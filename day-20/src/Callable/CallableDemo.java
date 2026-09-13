package Callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo {

    public static void main(String[] args)
            throws ExecutionException, InterruptedException {

        ExecutorService executor = Executors.newSingleThreadExecutor();

        try {

            Callable<Integer> task = () -> {

                System.out.println("Calculating...");

                Thread.sleep(1000);

                return 100 + 200;
            };

            Future<Integer> future =
                    executor.submit(task);

            Integer result =
                    future.get();

            System.out.println("Result: " + result);

        } finally {

            executor.shutdown();
        }
    }
}
