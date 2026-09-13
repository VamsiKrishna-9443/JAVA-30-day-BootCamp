package Exercise;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskProcessor {

    private final ExecutorService executor;

    private final ConcurrentHashMap<Integer, String> results = new ConcurrentHashMap<>();

    public TaskProcessor(int numberOfThreads) {

        executor = Executors.newFixedThreadPool(numberOfThreads);
    }

    public void submit(Task task) {
        executor.submit(() -> process(task));
    }

    private void process(Task task)
    {
        results.put(task.getId(), "PROCESSING");
        System.out.println("Started: " + task + " | Thread: " + Thread.currentThread().getName());

        try {
            Thread.sleep(1000);
            results.put(task.getId(), "COMPLETED");

        }
        catch (InterruptedException e) {

            results.put(task.getId(), "INTERRUPTED");

            Thread.currentThread().interrupt();
        }

        System.out.println("Completed: " + task);
    }

    public void printResults() {

        System.out.println("Results: " + results);
    }

    public void shutdown() {
        executor.shutdown();
    }
}