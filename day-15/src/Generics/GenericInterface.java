package Generics;

// Generic interface
interface Repository<T> {

    void save(T data);

    T get();
}

// generic class implementing generic interface
class DataRepository<T>
        implements Repository<T> {

    private T data;

    @Override
    public void save(T data) {
        this.data = data;
    }

    @Override
    public T get() {
        return data;
    }

    public <V> void print(V value) {
        System.out.println(value);
    }
}


public class GenericInterface {

    public static void main(String[] args) {

        DataRepository<String> repository =
                new DataRepository<>();

        repository.save("Hello Java");

        String value = repository.get();

        System.out.println(value);

        repository.print(100);

        repository.print(25.5);
    }
}