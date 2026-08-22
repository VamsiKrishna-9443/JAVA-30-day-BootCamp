public class MainClass {
    public static void main(String[] args) {
        Son s = new Son();
        s.play();
        s.show();
        System.out.println(s.a);
        System.out.println(s.b);

        System.out.println();
        System.out.println("Father Class Object:");
        Father f = new Father();
        System.out.println(f.a);
        f.show();
    }
}
