package practice_2;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Stream;


public class Main {
    public static void main(String[] args) {
        List<Human> a = new ArrayList<>();
        a.add(new Human(19, "Ramal", "Guseynov", LocalDate.of(2003, 6, 17), 71));
        a.add(new Human(20, "Anna", "Kruglova", LocalDate.of(2002, 12, 29), 39));
        a.add(new Human(19, "Ekaterina", "Petrova", LocalDate.of(2003, 10, 9), 40));
        a.add(new Human(19, "Darya", "Krendikova", LocalDate.of(2004, 1, 31), 40));
        System.out.println(a);
        Stream<Human> stream = a.stream();
        stream.sorted(Comparator.comparingInt(o -> o.firstName.charAt(1))).forEach(System.out::println);
        System.out.println();
        stream = a.stream();
        stream.filter(o -> o.weight % 10 == 0).forEach(System.out::println);
        System.out.println();
        stream = a.stream();
        stream.sorted(Comparator.comparingInt(o -> o.age * o.weight)).forEach(System.out::println);
        System.out.println();
        stream = a.stream();
        System.out.println(stream.mapToInt(x -> x.weight).sum());
    }
}
