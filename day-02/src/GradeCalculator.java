import java.util.*;
public class GradeCalculator {
    static void GradeChecker(int marks)
    {
        if(marks >= 90)
        {
            System.out.println("GRADE A");
        }
        else if(marks >= 75)
        {
            System.out.println("GRADE B");
        }
        else if(marks >=  60)
        {
            System.out.println("GRADE C");
        }
        else if(marks >= 45)
        {
            System.out.println("GRADE D");
        }
        else
        {
            System.out.println("Failed");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the MARKS:");
        int marks = sc.nextInt();
        GradeChecker(marks);
    }
}
