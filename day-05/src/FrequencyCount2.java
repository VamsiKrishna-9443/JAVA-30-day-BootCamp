import java.util.*;
public class FrequencyCount2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the array elements:");
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int num : arr)
        {
            if(freq.containsKey(num))
            {
                freq.put(num,freq.get(num)+1);
            }
            else
            {
                freq.put(num,1);
            }
        }

        System.out.println("Frequency:");
        for(Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue());
        }
    }
}