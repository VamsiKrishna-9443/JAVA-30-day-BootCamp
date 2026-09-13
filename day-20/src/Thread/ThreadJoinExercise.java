package Thread;

public class ThreadJoinExercise {

    public static void main(String[] args)
            throws InterruptedException {

        Thread worker = new Thread(() -> {

            for (int i = 1; i <= 5; i++) {

                System.out.println(i);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        });

        worker.start();
        worker.join();

        System.out.println("Worker completed!");
    }
}
