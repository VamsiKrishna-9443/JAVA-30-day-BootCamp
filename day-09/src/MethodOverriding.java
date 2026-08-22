public class MethodOverriding
{
    static class Vehicle{
        void start()
        {
            System.out.println("Vehicle Started");
        }
    }
    static class Car extends Vehicle{
        @Override
        void start()
        {
            System.out.println("Car Started");
        }
    }

    public static void main(String[] args) {
        System.out.println("Car Objects :");
        Car c = new Car();
        c.start();

        System.out.println("Vehicle Objects :");
        Vehicle v = new Vehicle();
        v.start();
    }
}
