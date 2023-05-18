package practice_6.AbstractFactory;

public class Breakfast {
    public static void main(String[] args) {
        Food br = new FoodFactory();
        Tomato t = br.getTomato();
        Potato p = br.getPotato();
        t.createTomato(12);
        p.createPotato(12);
    }
}