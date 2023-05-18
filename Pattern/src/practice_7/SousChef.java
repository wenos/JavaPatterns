package practice_7;

public class SousChef extends CookDecorator{

    public SousChef(Cook cook) {
        super(cook);
    }
    public String givesInstructions(Kitchen kitchen) {
        if (kitchen.isActive) {
            return ", gives instructions";

        }
        return ", not gives instructions";
    }

    @Override
    public String toCook(Kitchen kitchen) {
        return cook.toCook(kitchen) + givesInstructions(kitchen);
    }
}
