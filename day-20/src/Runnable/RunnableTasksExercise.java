package Runnable;

public class RunnableTasksExercise {

    public static void main(String[] args)
            throws InterruptedException {

        Runnable downloadTask = () -> System.out.println(
                "Downloading... | " + Thread.currentThread().getName()
        );

        Runnable processTask = () -> System.out.println(
                "Processing... | " + Thread.currentThread().getName()
        );

        Runnable uploadTask = () -> System.out.println(
                "Uploading... | " + Thread.currentThread().getName()
        );

        Thread downloadThread =
                new Thread(downloadTask, "Download-Thread");

        Thread processThread =
                new Thread(processTask, "Process-Thread");

        Thread uploadThread =
                new Thread(uploadTask, "Upload-Thread");

        downloadThread.start();
        processThread.start();
        uploadThread.start();

        downloadThread.join();
        processThread.join();
        uploadThread.join();
    }
}
