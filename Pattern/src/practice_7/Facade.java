package practice_7;

public class Facade {
    public void work(boolean active) {
        Kitchen kitchen = new Kitchen(active);
        Cook b = new OrdinaryCook();
        System.out.println(b.toCook(kitchen));
        Cook a = new SousChef(new OrdinaryCook());
        System.out.println(a.toCook(kitchen));
    }
}
