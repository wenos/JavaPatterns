package practice_6.FactoryMethod;

public class RussianPotatoFactory implements PotatoFactory{
    @Override
    public Potato createPotato() {
        return new RussianPotato();
    }
}
