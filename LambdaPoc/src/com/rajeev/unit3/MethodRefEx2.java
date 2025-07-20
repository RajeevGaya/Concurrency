package com.rajeev.unit3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.rajeev.Person;

public class MethodRefEx2 {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(new Person("Abhi", "Kumar", 10), new Person("Ramesh", "chok", 32),
                new Person("Rajeev", "Ranjan", 30), new Person("Divya", "Chinki", 37),
                new Person("Dinesh", "Singh", 45));
        Collections.sort(people,
                (p1, p2) -> p1.getLastName().trim().toUpperCase().compareTo(p2.getLastName().toUpperCase().trim()));

        performConditionally(people, p -> true, p -> System.out.println(p));
        System.out.println();
        performConditionally(people, p -> true, System.out::println);// p->method(p), Here consumer identified and print
                                                                     // if arg and that print both are same

    }

    public static void performConditionally(List<Person> people, Predicate<Person> predicate,
            Consumer<Person> consumer) {
        for (Person person : people) {
            if (predicate.test(person))
                consumer.accept(person);
        }
    }
}
