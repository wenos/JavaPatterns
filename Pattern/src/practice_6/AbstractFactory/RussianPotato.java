package practice_6.AbstractFactory;

public class RussianPotato implements Potato{

    @Override
    public void createPotato(int a) {
        System.out.println("Creates " + a + " potato");

    }
}
