import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {

    public static void main(String[] args) {

        Queue<String> queue = new LinkedList<>();

        // 1. add()
        queue.add("Vamsi");
        queue.add("Rahul");
        queue.add("Krishna");

        System.out.println("Queue: " + queue);

        // 2. offer()
        queue.offer("Ravi");

        System.out.println("After offer: " + queue);

        // 3. peek()
        System.out.println("Front element: "
                + queue.peek());

        // 4. element()
        System.out.println("Front using element(): "
                + queue.element());

        // 5. poll()
        System.out.println("Removed: "
                + queue.poll());

        System.out.println("Queue after poll: " + queue);

        // 6. remove()
        System.out.println("Removed: "
                + queue.remove());

        System.out.println("Queue after remove: " + queue);

        // 7. contains()
        System.out.println("Contains Krishna? "
                + queue.contains("Krishna"));

        // 8. size()
        System.out.println("Size: " + queue.size());

        // 9. isEmpty()
        System.out.println("Is Empty? " + queue.isEmpty());

        // 10. iteration
        System.out.println("Queue elements:");

        for (String name : queue) {
            System.out.println(name);
        }

        // 11. clear()
        queue.clear();

        System.out.println("After clear: " + queue);
    }
}