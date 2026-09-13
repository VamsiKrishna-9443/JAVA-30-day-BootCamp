package Thread;

public class ThreadMethodsDemo {

    public static void main(String[] args)
            throws InterruptedException {

        Thread worker = new Thread(() -> {

            for (int i = 1; i <= 5; i++) {

                System.out.println("Worker: " + i);
                try
                {
                    Thread.sleep(500);
                }
                catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        worker.start();

        worker.join();

        System.out.println("Worker finished.");

        System.out.println("Main thread continues." );
    }
}