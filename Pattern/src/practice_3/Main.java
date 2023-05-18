package practice_3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception {
        test_1();
        test_2();
    }

    public static void test_2() throws InterruptedException {
        Map<Integer, Integer> a = new HashMap<>();
        MyMap<Integer, Integer> b = new MyMap<>();
        Thread one = new Thread(()->{
            for (int i = 0; i < 5000; i++) {
                a.put(i, i);
                b.put(i, i);
            }
        });
        Thread two = new Thread(()->{
            for (int i = 0; i < 5000; i++) {
                a.put(i, i);
                b.put(i, i);
            }
        });
        one.start();
        two.start();
        Thread.sleep(3000);
        System.out.println(a.size());
        System.out.println(b.size());
    }

    public static void test_1() throws InterruptedException {
        Set<Integer> a = new HashSet<>();
        MySet<Integer> b = new MySet<>();
        Thread one = new Thread(()->{
            for (int i = 0; i < 5000; i++) {
                a.add(i);
                b.add(i);
            }
        });
        Thread two = new Thread(()->{
            for (int i = 0; i < 5000; i++) {
                a.add(i);
                b.add(i);
            }
        });
        one.start();
        two.start();
        Thread.sleep(3000);
        System.out.println(a.size());
        System.out.println(b.size());

    }
}
