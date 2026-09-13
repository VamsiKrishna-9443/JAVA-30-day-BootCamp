package Thread;

public class ThreadDemo {

    public static void main(String[] args) {

        MyThread thread = new MyThread();

        thread.start();

        System.out.println("Main thread: " + Thread.currentThread().getName());
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Worker thread: " + Thread.currentThread().getName());
    }
}