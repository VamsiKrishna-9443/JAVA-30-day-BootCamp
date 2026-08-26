import java.util.HashSet;
import java.util.Set;

public class SetExample {

    public static void main(String[] args) {

        Set<String> names = new HashSet<>();

        // 1. add()
        names.add("Vamsi");
        names.add("Rahul");
        names.add("Krishna");

        // Duplicate
        names.add("Vamsi");

        System.out.println("Set: " + names);

        // 2. contains()
        System.out.println("Contains Vamsi? "
                + names.contains("Vamsi"));

        // 3. remove()
        names.remove("Rahul");

        System.out.println("After removing Rahul: " + names);

        // 4. size()
        System.out.println("Size: " + names.size());

        // 5. isEmpty()
        System.out.println("Is Empty? " + names.isEmpty());

        // 6. iteration
        System.out.println("Using for-each:");

        for (String name : names) {
            System.out.println(name);
        }

        // 7. clear()
        names.clear();

        System.out.println("After clear: " + names);

        // 8. isEmpty()
        System.out.println("Is Empty? " + names.isEmpty());
    }
}