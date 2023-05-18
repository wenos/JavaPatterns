package practice_6.Builder;

public class Main {
    public static void main(String[] args) {
        Car MyCar = new MyCarBuilder().addColor("red").addPrice(999999999).addModel("Lightning McQueen").build();
        System.out.println(MyCar);
    }
}
