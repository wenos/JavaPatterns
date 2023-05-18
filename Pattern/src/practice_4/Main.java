package practice_4;

import java.util.concurrent.ExecutorService;

public class Main {
    public static void main(String[] args) {
        ExecutorService ex = new MyExecutorService(5);
        for (int i = 0; i < 20; ++i) {
            ex.execute(new MyThread("A"));
            ex.execute(new MyThread("B"));
            ex.execute(new MyThread("C"));
            ex.execute(new MyThread("D"));
            ex.execute(new MyThread("E"));
        }
    }
}
