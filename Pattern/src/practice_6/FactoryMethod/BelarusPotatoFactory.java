package practice_6.FactoryMethod;

public class BelarusPotatoFactory implements PotatoFactory{

    @Override
    public Potato createPotato() {
        return new BelarusPotato();
    }
}
