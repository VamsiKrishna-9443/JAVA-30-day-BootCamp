package HashCode;

public class Pen
{
    public static void main(String[] args)
    {
        Pen p = new Pen();
        Pen r = p;
        String s = "banglore";
        String s2 = "banglore";
        System.out.println(p.hashCode());
        System.out.println(r.hashCode());
        System.out.println(s.hashCode());
        System.out.println(s2.hashCode());
    }
}
