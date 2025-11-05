package com.plaralsight.streams;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Program {
    private static final List<Person> people = loadPeople(); //source
    private static final Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        System.out.println("Welcome to the people search tool.\n");
        System.out.print("Type a first or last name to search: ");
        String name = scanner.nextLine().trim();

        List<Person> matches = people.stream()
                .filter(p -> p.getFirstName().toLowerCase().contains(name)
                || p.getLastName().toLowerCase().contains(name)).collect(Collectors.toList());



        if (matches.isEmpty()) {
            System.out.println("Sorry matches not found");
        }else {
            System.out.println("Match Confirmed");
            matches.forEach(System.out :: println);
        }

       double avgAge = people.stream()
               .mapToInt(Person ::getAge)
               .average()
               .orElse(0);

        int oldest = people.stream()
                .mapToInt(Person::getAge)
                .max()
                .orElse(0);

        int youngest = people.stream()
                .mapToInt(Person::getAge)
                .min()
                .orElse(0);

        System.out.println("Average of all people: " + avgAge);
        System.out.println("Oldest Age of all people: " + oldest);
        System.out.println("Youngest Age of all people: " + youngest);

        scanner.close();
    }

    private static List<Person> loadPeople() {
        return new ArrayList<>(Arrays.asList(
                new Person("Peter", "Parker", 28),
                new Person("Tony", "Stark", 45),
                new Person("Steve", "Rogers", 105),
                new Person("Natasha", "Romanoff", 35),
                new Person("Bruce", "Banner", 42),
                new Person("Thor", "Odinson", 1500),
                new Person("Wanda", "Maximoff", 29),
                new Person("Stephen", "Strange", 44),
                new Person("Carol", "Danvers", 38),
                new Person("Scott", "Lang", 40),
                new Person("Clark", "Kent", 35),
                new Person("Bruce", "Wayne", 38),
                new Person("Diana", "Prince", 3000),
                new Person("Barry", "Allen", 30),
                new Person("Arthur", "Curry", 37),
                new Person("Hal", "Jordan", 34),
                new Person("Oliver", "Queen", 36),
                new Person("Selina", "Kyle", 32),
                new Person("Victor", "Stone", 25),
                new Person("Kara", "Danvers", 24)
        ));
    }
}
