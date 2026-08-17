import java.util.HashMap;
import java.util.Map;

public class Hashing
{
    public static void main(String[] args) {
        HashMap<Integer,String> students = new HashMap<>();
        students.put(101,"Vamsi");
        students.put(102,"Rahul");
        students.put(103,"Aashitha");

        System.out.println(students);
        System.out.println("Get key returning Value :");
        System.out.println(students.get(101));
        System.out.println(students.get(102));

        System.out.println("Contains Key() :");
        System.out.println(students.containsKey(101));
        System.out.println(students.containsKey(104));

        System.out.println("ContainsValue () :");
        System.out.println(students.containsValue("Aashitha"));
        System.out.println(students.containsValue("itachi"));

        System.out.println("Remove() :");
        System.out.println("Before Removing :"+students);
        students.remove(102);
        System.out.println("After removing :"+students);

        System.out.println("Returning the number of key-value pairs"+students.size());
        System.out.println("KeySet() to return all the keys in the HashMap :");
        System.out.println(students.keySet());

        System.out.println("To Print Both Key and Value");
        for(Integer key : students.keySet()) {

            System.out.println(
                    key + " → " + students.get(key)
            );
        }
        System.out.println("Entry KeySet:");
        for(Map.Entry<Integer,String> entry : students.entrySet())
        {
            System.out.println(entry.getKey() + " " +entry.getValue());
        }
    }
}
