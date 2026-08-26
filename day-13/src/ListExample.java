import java.util.ArrayList;
import java.util.List;

public class ListExample {

    public static void main(String[] args) {

        List<String> names = new ArrayList<>();
        // 1. add()
        names.add("Vamsi");
        names.add("Rahul");
        names.add("Krishna");
        names.add("Vamsi");

        System.out.println("Original List: " + names);

        // 2. add(index, element)
        names.add(1, "Ravi");

        System.out.println("After adding at index 1: " + names);

        // 3. get()
        System.out.println("Element at index 2: " + names.get(2));

        // 4. set()
        names.set(2, "Arjun");

        System.out.println("After update: " + names);

        // 5. remove(index)
        names.remove(1);

        System.out.println("After removing index 1: " + names);

        // 6. remove(object)
        names.remove("Vamsi");

        System.out.println("After removing Vamsi: " + names);

        // 7. contains()
        System.out.println("Contains Krishna? "
                + names.contains("Krishna"));

        // 8. indexOf()
        System.out.println("Index of Krishna: "
                + names.indexOf("Krishna"));

        names.add(1,"Vamsi");
        // 9. lastIndexOf()
        System.out.println("Last index of Vamsi: "
                + names.lastIndexOf("Vamsi"));

        // 10. size()
        System.out.println("Size: " + names.size());

        // 11. isEmpty()
        System.out.println("Is Empty? " + names.isEmpty());

        // 12. iteration
        System.out.println("Using for-each:");

        for (String name : names) {
            System.out.println(name);
        }

        // 13. clear()
        names.clear();

        System.out.println("After clear: " + names);

        // 14. isEmpty()
        System.out.println("Is Empty? " + names.isEmpty());
    }
}