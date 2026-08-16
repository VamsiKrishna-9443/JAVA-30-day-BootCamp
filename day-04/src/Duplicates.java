import java.util.*;
public class Duplicates
{

    public static ArrayList<Integer> findDuplicates(ArrayList<Integer> arr)
    {
        ArrayList<Integer> duplicates = new ArrayList<>();
        for(int i = 0 ; i < arr.size() ; i++)
        {
            for(int j = i + 1 ; j < arr.size();j++)
            {
                if(arr.get(i).equals(arr.get(j)) && !duplicates.contains(arr.get(i)))
                {
                    duplicates.add(arr.get(i));
                }
            }
        }
        return duplicates;
    }
   public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size :");
       int n = sc.nextInt();
       ArrayList<Integer> arr = new ArrayList<>(n);
       System.out.println("Enter the Elements into ArrayList :");
       for(int i  = 0 ; i < n ; i++)
       {
           arr.add(sc.nextInt());
       }

       ArrayList<Integer> result = findDuplicates(arr);
       System.out.println(result);
    }
}
