package pracite_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Function<Integer> g = (a, b) -> {
            while (a != 0 && b != 0) {
                if (a > b) {
                    a = a % b;
                } else {
                    b = b % a;
                }
            }
            return b + a;
        };
        Scanner scanner = new Scanner(System.in);
        System.out.println(g.sum(scanner.nextInt(), scanner.nextInt()));
    }
}

