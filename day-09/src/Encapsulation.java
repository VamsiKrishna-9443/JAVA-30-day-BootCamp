
public class Encapsulation
{
    private String name;
    private int age;
    public void setName(String name)
    {
        this.name = name;
    }
    public void setAge(int age)
    {
        this.age = age;
    }
    public String getName()
    {
        return name;
    }
    public int getAge() {
        return  age;
    }

    public static void main() {
        Encapsulation e = new Encapsulation();
        e.setName("Vamsi");
        e.setAge(21);

        System.out.println("Getter Methods :");
        System.out.println("Age  : " +e.getAge());
        System.out.println("Name : "  +e.getName());

    }
}

