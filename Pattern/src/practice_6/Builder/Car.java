package practice_6.Builder;

public class Car {
    int price = 0;
    String model = "defolt";
    String color = "defolt";
    Car() {

    }

    @Override
    public String toString() {
        return model + " " + color + " " + price;
    }
}
