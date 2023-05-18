package practice_5;

public class Singleton4 {
    private Singleton4() {
    }

    private static class SingletonHolder {
        public static final Singleton4 HOL = new Singleton4();
    }

    public static Singleton4 getInstance() {
        return SingletonHolder.HOL;
    }

}