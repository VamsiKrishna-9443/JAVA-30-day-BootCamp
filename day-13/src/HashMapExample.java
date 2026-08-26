import java.util.HashMap;

public class HashMapExample {

    public static void main(String[] args) {

        HashMap<Integer, String> products = new HashMap<>();

        // 1. put()
        products.put(101, "Laptop");
        products.put(102, "Mouse");
        products.put(103, "Keyboard");

        System.out.println("Products: " + products);

        // 2. get()
        System.out.println("Product 101: " + products.get(101));

        // 3. containsKey()
        System.out.println("Contains ID 102? " + products.containsKey(102));

        // 4. containsValue()
        System.out.println("Contains Laptop? " + products.containsValue("Laptop"));

        // 5. update existing key
        products.put(101, "Gaming Laptop");

        System.out.println("After update: " + products);

        // 6. getOrDefault()
        System.out.println("Product 999: " + products.getOrDefault(999, "Product Not Found"));

        // 7. putIfAbsent()
        products.putIfAbsent(104, "Monitor");

        System.out.println("After putIfAbsent: "
                + products);

        // 8. replace()
        products.replace(102, "Wireless Mouse");

        System.out.println("After replace: "
                + products);

        // 9. remove()
        products.remove(103);

        System.out.println("After remove: "
                + products);

        // 10. keySet()
        System.out.println("Keys: "
                + products.keySet());

        // 11. values()
        System.out.println("Values: "
                + products.values());

        // 12. entrySet()
        System.out.println("Entries:");

        for (HashMap.Entry<Integer, String> entry : products.entrySet())
        {
            System.out.println("ID = " + entry.getKey() + ", Product = " + entry.getValue());
        }

        // 13. size()
        System.out.println("Size: "
                + products.size());

        // 14. isEmpty()
        System.out.println("Is Empty? "
                + products.isEmpty());

        // 15. clear()
        products.clear();

        System.out.println("After clear: "
                + products);

        // 16. isEmpty()
        System.out.println("Is Empty? "
                + products.isEmpty());
    }
}