package Future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureDemo {

    public static void main(String[] args)
            throws Exception {

        ExecutorService executor = Executors.newSingleThreadExecutor();

        try {

            Future<String> future =
                    executor.submit(() -> {

                        Thread.sleep(1000);

                        return "Task result is ready";
                    });

            System.out.println("Task submitted.");
            System.out.println("Done before get(): " + future.isDone());

            String result =
                    future.get();

            System.out.println("Result: " + result);
            System.out.println("Done after get(): " + future.isDone());

        } finally {

            executor.shutdown();
        }
    }
}
