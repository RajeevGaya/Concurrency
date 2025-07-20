package com.rajeev.unit3;

import java.util.Arrays;
import java.util.List;

import com.rajeev.Person;

public class StreamEx {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(new Person("Abhi", "Kumar", 10), new Person("Ramesh", "chok", 32),
                new Person("Rajeev", "Ranjan", 30), new Person("Divya", "Chinki", 37),
                new Person("Dinesh", "Singh", 45));
     people.stream().forEach(p->System.out.println(p.getFirstName()));
     System.out.println();
    //  people.stream().forEach(System.out::println);
    people.stream()
    .filter(p->p.getLastName().trim().toUpperCase().startsWith("C"))
    .forEach(System.out::println);
    long count = people.parallelStream()
    .filter(p->p.getAge()>30)
    .count();
    //paralerl stram do faster but result will be the same even we use stream
    System.out.println(count);
    }
}
