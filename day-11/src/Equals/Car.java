package Equals;

// Program to Override a equals()
public class Car
{
    int cost;
    Car(int cost)
    {
        this.cost = cost;
    }

    @Override
    public  boolean equals(Object obj)
    {
        if(obj instanceof Car)
        {
            Car c = (Car) obj;
            return this.cost == c.cost;
        }
        else {
            return false;
        }
    }

    public static void main(String[] args) {
        Car c1 = new Car(100);
        Car c2 = new Car(100);
        System.out.println(c1.equals(c2));
    }
}
