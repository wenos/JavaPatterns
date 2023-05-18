package practice_6.Builder;

public interface CarBuilder {

    CarBuilder addColor(String color);
    CarBuilder addModel(String model);
    CarBuilder addPrice(int price);
    Car build();
}
