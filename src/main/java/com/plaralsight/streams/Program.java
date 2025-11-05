package com.plaralsight.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> people = new ArrayList<>();
        Person[] marvelCharacters = {
                new Person("Tony", "Stark", 48),
                new Person("Steve", "Rogers", 101),
                new Person("Natasha", "Romanoff", 35),
                new Person("Bruce", "Banner", 45),
                new Person("Thor", "Odinson", 1500),
                new Person("Clint", "Barton", 42),
                new Person("Wanda", "Maximoff", 29),
                new Person("Peter", "Parker", 16),
                new Person("Scott", "Lang", 30),
                new Person("Wasp", "Hope", 28)
        };
        System.out.println("Enter name to search; ");
        String search = scanner.nextLine().toLowerCase();

        List<Person> matches = new ArrayList<>();
        for(Person p : people) {
            if (p.getFirstName().toLowerCase().contains(search) || p.getLastName().toLowerCase().contains(search)) {
                matches.add(p);
            }
        }
        int totalAge = 0;
        int oldest = Integer.MIN_VALUE;
        int youngest = Integer.MAX_VALUE;

        for(Person p : people){
            int age = p.getAge();
            totalAge += age;
            if (age > oldest) oldest = age;
            if (age < youngest) youngest = age;
        }

        double average = (double) totalAge / people.size();

        System.out.println("\nAverage age: " + average);
        System.out.println("Oldest person age: " + oldest);
        System.out.println("youngest person age " + youngest);
    }
}
