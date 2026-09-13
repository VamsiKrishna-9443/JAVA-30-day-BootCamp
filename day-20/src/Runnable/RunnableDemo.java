package Runnable;

public class RunnableDemo {

    public static void main(String[] args) {

        Runnable task = () -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Task: " + i);
            }
        };

        Thread thread = new Thread(task);

        thread.start();
    }
}