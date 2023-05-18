package practice_6.Builder;

public class MyCarBuilder implements CarBuilder {
    Car MyCar;

    MyCarBuilder() {
        this.MyCar = new Car();
    }

    @Override
    public CarBuilder addColor(String color) {
        this.MyCar.color = color;
        return this;
    }

    @Override
    public CarBuilder addModel(String model) {
        this.MyCar.model = model;
        return this;
    }

    @Override
    public CarBuilder addPrice(int price) {
        this.MyCar.price = price;
        return this;
    }

    @Override
    public Car build() {
        return this.MyCar;
    }

}