package HashCode;

public class Pencil
{
    @Override
    public int hashCode()
    {
        return 123;
    }
    public static void main(String[] args) {
        Pencil p = new Pencil();
        System.out.println(p.hashCode());
    }
}
