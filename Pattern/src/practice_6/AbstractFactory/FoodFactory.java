package practice_6.AbstractFactory;

public class FoodFactory implements Food{

    @Override
    public Tomato getTomato() {
        return new RussianTomato();
    }

    @Override
    public Potato getPotato() {
        return new RussianPotato();
    }
}
