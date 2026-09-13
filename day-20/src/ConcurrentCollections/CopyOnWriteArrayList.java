package ConcurrentCollections;


class CopyOnWriteArrayList {

    public static void main(String[] args) throws InterruptedException {

        java.util.concurrent.CopyOnWriteArrayList<String> list =  new java.util.concurrent.CopyOnWriteArrayList<>();

        Thread writer = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                list.add("Item-" + i);
            }
        });

        Thread reader = new Thread(() -> {

            for (int i = 0; i < 5; i++) {

                System.out.println(list);

                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        writer.start();
        reader.start();

        writer.join();
        reader.join();

        System.out.println(
                "Final list: " + list
        );
    }
}