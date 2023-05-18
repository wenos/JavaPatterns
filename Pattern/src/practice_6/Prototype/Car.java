package practice_6.Prototype;

public class Car implements Copyable{
    int price;
    String model;
    Car(String model, int price) {
        this.price = price;
        this.model = model;
    }
    @Override
    public Object copy() {
        return new Car(this.model, this.price);
    }

    @Override
    public String toString() {
        return model + " " + price;
    }
}
