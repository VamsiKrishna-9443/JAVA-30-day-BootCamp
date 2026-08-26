import java.util.LinkedList;

public class LinkedListExample {

    public static void main(String[] args) {

        LinkedList<String> products = new LinkedList<>();

        // 1. add()
        products.add("Laptop");
        products.add("Mouse");
        products.add("Keyboard");

        System.out.println("Products: " + products);

        // 2. addFirst()
        products.addFirst("Monitor");

        System.out.println("After addFirst: " + products);

        // 3. addLast()
        products.addLast("Printer");

        System.out.println("After addLast: " + products);

        // 4. getFirst()
        System.out.println("First: "
                + products.getFirst());

        // 5. getLast()
        System.out.println("Last: "
                + products.getLast());

        // 6. get()
        System.out.println("Index 2: "
                + products.get(2));

        // 7. set()
        products.set(2, "Gaming Keyboard");

        System.out.println("After set: "
                + products);

        // 8. removeFirst()
        products.removeFirst();

        System.out.println("After removeFirst: "
                + products);

        // 9. removeLast()
        products.removeLast();

        System.out.println("After removeLast: "
                + products);

        // 10. remove(object)
        products.remove("Mouse");

        System.out.println("After removing Mouse: "
                + products);

        // 11. contains()
        System.out.println("Contains Laptop? "
                + products.contains("Laptop"));

        // 12. indexOf()
        System.out.println("Index of Laptop: "
                + products.indexOf("Laptop"));

        // 13. size()
        System.out.println("Size: "
                + products.size());

        // 14. peek()
        System.out.println("Peek: "
                + products.peek());

        // 15. poll()
        System.out.println("Poll: "
                + products.poll());

        System.out.println("After poll: "
                + products);

        // 16. push()
        products.push("Tablet");

        System.out.println("After push: "
                + products);

        // 17. pop()
        System.out.println("Pop: "
                + products.pop());

        System.out.println("After pop: "
                + products);

        // 18. clear()
        products.clear();

        System.out.println("After clear: "
                + products);
    }
}