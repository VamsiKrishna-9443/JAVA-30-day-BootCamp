import java.util.*;

public class TwoSumUsingHashMap {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter target: ");
        int target = sc.nextInt();

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int required = target - arr[i];
            if (map.containsKey(required)) {
                System.out.println("Pair found: " + required + " + " + arr[i] + " = " + target);
                System.out.println("Indices: " + map.get(required) + ", " + i);
                return;
            }
            map.put(arr[i], i);  // key : number value : index
        }
        System.out.println("No pair found.");
    }
}