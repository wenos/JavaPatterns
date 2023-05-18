package practice_4;

public class MyThread extends Thread {
    String name;
    MyThread (String name) {
        this.name = name;
    }
    public void run() {
        for (int i = 0; i < 10; ++i) {
            System.out.println(i + " " + name);
        }
    }
}
