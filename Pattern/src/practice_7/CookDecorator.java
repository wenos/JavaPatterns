package practice_7;

public class CookDecorator implements Cook{
    Cook cook;
    public CookDecorator(Cook cook) {
        this.cook = cook;
    }


    @Override
    public String toCook(Kitchen kitchen) {
        return cook.toCook(kitchen);
    }
}
