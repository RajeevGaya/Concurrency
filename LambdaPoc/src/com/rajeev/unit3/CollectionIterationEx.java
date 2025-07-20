package com.rajeev.unit3;

import java.util.Arrays;
import java.util.List;

import com.rajeev.Person;

public class CollectionIterationEx {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(new Person("Abhi", "Kumar", 10), new Person("Ramesh", "chok", 32),
                new Person("Rajeev", "Ranjan", 30), new Person("Divya", "Chinki", 37),
                new Person("Dinesh", "Singh", 45));
        for (Person person : people) {
            System.out.println(person);
        }
        System.out.println();
        // people.forEach(p->System.out.println(p));
        people.forEach(System.out::println);
    }
}
