package Generics;

// Generic Class
class Box<T>{
    private T value;

    public void setValue(T value)
    {
        this.value = value;
    }
    public  T getValue()
    {
        return value;
    }
}

public class BoxMain
{
   public static void main(String[] args) {

       //Generics.Box to Integer
       Box<Integer> intBox =  new Box<>();
       intBox.setValue(100);
       Integer intBoxValue = intBox.getValue();
       System.out.println("Integer Value : " + intBoxValue);

       //Generics.Box to  String
       Box<String> strBox =  new Box<>();
       strBox.setValue("java");
       String strBoxValue = strBox.getValue();
       System.out.println("String Value : " + strBoxValue);

       //Generics.Box to double
       Box<Double> doubleBox = new Box<>();
       doubleBox.setValue(4.2);
       Double doubleValue = doubleBox.getValue();
       System.out.println("Double Value : " + doubleValue);

    }
}