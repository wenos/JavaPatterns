package practice_7;

public class OrdinaryCook implements Cook {
    @Override
    public String toCook(Kitchen kitchen) {
        if (kitchen.isActive) {
            return "Cooks";
        }
        return "No cooks";
    }
}
