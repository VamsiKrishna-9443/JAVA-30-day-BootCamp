package Generics;
class Pair<K,V>
{
    private K key;
    private V value;

    public Pair(K key , V value)
    {
        this.key = key;
        this.value = value;
    }

    public K getKey()
    {
        return key;
    }
    public V getValue()
    {
        return value;
    }
}
public class PairMain
{
    public static void main(String[] args) {
        Pair<Integer,String> names = new Pair<>(1,"Vamsi");
        System.out.println(names.getKey());
        System.out.println(names.getValue());

        Pair<String,String> students = new Pair<>("Aash","Bhoom");
        System.out.println(students.getKey());
        System.out.println(students.getValue());
    }
}
