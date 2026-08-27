package WildCard;

import java.util.ArrayList;
import java.util.List;

class Animal {

    public void sound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {

    @Override
    public void sound() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {

    @Override
    public void sound() {
        System.out.println("Cat meows");
    }
}

public class GenericInheritance {

    public static void printAnimals(
            List<? extends Animal> animals) {

        for (Animal animal : animals) {
            animal.sound();
        }
    }

    public static void main(String[] args) {

        List<Dog> dogs = new ArrayList<>();

        dogs.add(new Dog());
        dogs.add(new Dog());

        List<Cat> cats = new ArrayList<>();

        cats.add(new Cat());
        cats.add(new Cat());

        System.out.println("Dogs:");

        printAnimals(dogs);

        System.out.println();

        System.out.println("Cats:");

        printAnimals(cats);
    }
}