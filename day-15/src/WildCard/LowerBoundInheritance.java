package WildCard;

import java.util.ArrayList;
import java.util.List;

public class LowerBoundInheritance {

    public static void addDogs(
            List<? super Dog> animals) {

        animals.add(new Dog());
        animals.add(new Dog());
    }

    public static void main(String[] args) {

        List<Animal> animals = new ArrayList<>();

        addDogs(animals);

        System.out.println("Animals:");

        for (Object animal : animals) {
            System.out.println(
                    animal.getClass().getSimpleName()
            );
        }
    }
}