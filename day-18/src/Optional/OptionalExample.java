package Optional;

import java.util.Optional;

public class OptionalExample {

    public static void main(String[] args) {

        // ------------------------------------------------
        // 1. Optional.of()
        // ------------------------------------------------

        Optional<String> name = Optional.of("Vamsi");

        System.out.println("Optional.of(): " + name);


        // ------------------------------------------------
        // 2. Optional.ofNullable()
        // ------------------------------------------------

        String employeeName = null;

        Optional<String> optionalName = Optional.ofNullable(employeeName);

        System.out.println("Optional.ofNullable(): " + optionalName);


        // ------------------------------------------------
        // 3. Optional.empty()
        // ------------------------------------------------

        Optional<String> emptyName = Optional.empty();

        System.out.println("Optional.empty(): " + emptyName);


        // ------------------------------------------------
        // 4. isPresent()
        // ------------------------------------------------

        System.out.println("Is name present? " + name.isPresent());


        // ------------------------------------------------
        // 5. isEmpty()
        // ------------------------------------------------

        System.out.println("Is emptyName empty? " + emptyName.isEmpty());


        // ------------------------------------------------
        // 6. get()
        // ------------------------------------------------

        System.out.println("Value using get(): " + name.get());


        // ------------------------------------------------
        // 7. orElse()
        // ------------------------------------------------

        String result1 = emptyName.orElse("Unknown");

        System.out.println("Using orElse(): " + result1);


        // ------------------------------------------------
        // 8. orElseGet()
        // ------------------------------------------------

        String result2 = emptyName.orElseGet(() -> "Default Employee");

        System.out.println("Using orElseGet(): " + result2);


        // ------------------------------------------------
        // 9. ifPresent()
        // ------------------------------------------------

        name.ifPresent(value -> System.out.println("Using ifPresent(): " + value));


        // ------------------------------------------------
        // 10. ifPresentOrElse()
        // ------------------------------------------------

        name.ifPresentOrElse(value -> System.out.println("Value exists: " + value), () -> System.out.println("Value does not exist"));


        // ------------------------------------------------
        // 11. filter()
        // ------------------------------------------------

        Optional<String> filteredName = name.filter(value -> value.length() > 3);

        System.out.println("Using filter(): " + filteredName);


        // ------------------------------------------------
        // 12. map()
        // ------------------------------------------------

        Optional<Integer> nameLength = name.map(value -> value.length());

        System.out.println("Name length using map(): " + nameLength);


        // ------------------------------------------------
        // 13. flatMap()
        // ------------------------------------------------

        Optional<String> upperName = name.flatMap(value -> Optional.of(value.toUpperCase()));

        System.out.println("Using flatMap(): " + upperName);


        // ------------------------------------------------
        // 14. or()
        // ------------------------------------------------

        Optional<String> anotherName = Optional.empty();

        Optional<String> finalName = anotherName.or(() -> Optional.of("Default Name"));

        System.out.println("Using or(): " + finalName);


        // ------------------------------------------------
        // 15. orElseThrow()
        // ------------------------------------------------

        Optional<String> employee = Optional.of("Vamsi");

        String employeeValue = employee.orElseThrow();

        System.out.println("Using orElseThrow(): " + employeeValue);



        Optional<String> employee1 = Optional.empty();

        String employeeValue1 = employee1.orElseThrow();

        System.out.println("Using orElseThrow(): " + employeeValue1);
    }
}