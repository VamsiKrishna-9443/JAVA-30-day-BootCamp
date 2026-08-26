import java.util.HashSet;

public class HashSetExample {

    public static void main(String[] args) {

        HashSet<String> products = new HashSet<>();

        // 1. add()
        products.add("Laptop");
        products.add("Mouse");
        products.add("Keyboard");

        // Duplicate
        products.add("Laptop");

        System.out.println("Products: " + products);

        // 2. contains()
        System.out.println("Contains Laptop? " + products.contains("Laptop"));

        // 3. remove()
        products.remove("Mouse");

        System.out.println("After remove: " + products);

        // 4. size()
        System.out.println("Size: " + products.size());

        // 5. isEmpty()
        System.out.println("Is Empty? " + products.isEmpty());

        // 6. iteration
        System.out.println("Products:");

        for (String product : products) {
            System.out.println(product);
        }

        // 7. clear()
        products.clear();

        System.out.println("After clear: " + products);

        // 8. isEmpty()
        System.out.println("Is Empty? " + products.isEmpty());
    }
}