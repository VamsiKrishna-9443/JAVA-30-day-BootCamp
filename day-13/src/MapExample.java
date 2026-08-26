import java.util.HashMap;
import java.util.Map;

public class MapExample {

    public static void main(String[] args) {

        Map<Integer, String> products = new HashMap<>();

        // 1. put()
        products.put(101, "Laptop");
        products.put(102, "Mouse");
        products.put(103, "Keyboard");

        System.out.println("Map: " + products);

        // 2. get()
        System.out.println("Product 101: " + products.get(101));

        // 3. containsKey()
        System.out.println("Contains key 102? " + products.containsKey(102));

        // 4. containsValue()
        System.out.println("Contains Laptop? " + products.containsValue("Laptop"));

        // 5. put() with existing key
        products.put(101, "Gaming Laptop");

        System.out.println("After updating 101: " + products);

        // 6. remove()
        products.remove(102);

        System.out.println("After removing 102: " + products);

        // 7. size()
        System.out.println("Size: " + products.size());

        // 8. isEmpty()
        System.out.println("Is Empty? " + products.isEmpty());

        // 9. keySet()
        System.out.println("Keys: " + products.keySet());

        // 10. values()
        System.out.println("Values: " + products.values());

        // 11. entrySet()
        System.out.println("Entries:");

        for (Map.Entry<Integer, String> entry
                : products.entrySet()) {

            System.out.println(
                    entry.getKey() + " → "
                            + entry.getValue()
            );
        }

        // 12. clear()
        products.clear();

        System.out.println("After clear: " + products);
    }
}