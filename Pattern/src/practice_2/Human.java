package practice_2;

import java.time.LocalDate;

public class Human {
    int age;
    String firstName;
    String lastName;
    LocalDate birthDate;
    int weight;

    Human(int age, String firstName, String lastName, LocalDate birthDate, int weight) {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.weight = weight;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return age + " "  + firstName + " " + lastName + " " + birthDate + " " + weight;
    }
}
