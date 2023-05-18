package practice_6.FactoryMethod;

import javax.sound.sampled.Port;

public class Main {
    public static void main(String[] args) {
        PotatoFactory a = new RussianPotatoFactory();
        Potato b = a.createPotato();
        b.output();
    }
}
