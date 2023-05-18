package practice_6.AbstractFactory;

public class RussianTomato implements Tomato {
    @Override
    public void createTomato(int a) {
        System.out.println("Creates " + a + " Tomato");
    }
}
