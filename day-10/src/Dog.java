class Animal {
    void sound()
    {
        System.out.println("Animal Makes a Sound");
    }
}
public class Dog extends Animal
{
    @Override
    void sound()
    {
        System.out.println("Dog makes a sound");
    }

    public static void main(String[] args) {
        Animal d = new Dog();
        d.sound();
    }
}
