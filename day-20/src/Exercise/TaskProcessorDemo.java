package Exercise;

public class TaskProcessorDemo {

    public static void main(String[] args)
            throws InterruptedException {

        TaskProcessor processor = new TaskProcessor(3);

        for (int i = 1; i <= 10; i++) {
            processor.submit(new Task(i, "Task-" + i));
        }

        processor.shutdown();
    }
}