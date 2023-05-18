package practice_6.Prototype;

public class Main {
    public static void main(String[] args) {
        Car a = new Car("A", 1200000);
        Car b = (Car) a.copy();
        Car c = (Car) a.copy();
        System.out.println(b);
        c.price = 10;
        System.out.println(c);

    }
}
