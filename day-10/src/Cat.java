abstract class Pet {

    // Abstract method
    abstract void sound();

    // Normal method
    void eat() {
        System.out.println("Animal eats");
    }
}

class Cat extends Pet {
    @Override
    void sound() {
        System.out.println("Cat meows");
    }
    public static void main(String[] args) {
        Cat c = new Cat();
        c.sound();
        c.eat();
    }
}