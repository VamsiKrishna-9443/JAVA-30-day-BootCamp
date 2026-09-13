package Callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultipleCallableDemo {

    public static void main(String[] args)
            throws Exception {

        ExecutorService executor =
                Executors.newFixedThreadPool(3);

        try {

            Callable<Integer> task1 = () -> 100;
            Callable<Integer> task2 = () -> 200;
            Callable<Integer> task3 = () -> 300;

            Future<Integer> result1 =
                    executor.submit(task1);

            Future<Integer> result2 =
                    executor.submit(task2);

            Future<Integer> result3 =
                    executor.submit(task3);

            int total =
                    result1.get()
                    + result2.get()
                    + result3.get();

            System.out.println("Total = " + total);

        } finally {

            executor.shutdown();
        }
    }
}
