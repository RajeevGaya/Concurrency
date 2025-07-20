package com.rajeev;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class Unit1ExeriseSolutionJava8 {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
            new Person("Abhi", "Kumar", 10),
            new Person("Ramesh", "chok", 32),
            new Person("Rajeev", "Ranjan", 30),
            new Person("Divya", "Chinki", 37),
            new Person("Dinesh", "Singh", 45)
        );
        Collections.sort(people, (p1,p2)->p1.getLastName().trim().toUpperCase().compareTo(p2.getLastName().toUpperCase().trim()));
        // printList(people);
        printConditionally(people, p->true);
        System.out.println();
        printConditionally(people, p->p.getLastName().trim().toUpperCase().charAt(0)=='C');

        printConditionally(people, p-> p.getFirstName().trim().startsWith("R"));
        System.out.println();
        printConditionally(people,p->p.getAge()>25);
    }

    public static void printList(List<Person> people){
        for (Person person : people) {
            System.out.println(person);
        }
    }

    // public static void printConditionally(List<Person> people,Condition condition){
    //     for (Person person : people) {
    //         if(condition.test(person))
    //         System.out.println(person);
    //     }
    // }
    public static void printConditionally(List<Person> people,Predicate<Person> predicate){
        for (Person person : people) {
            if(predicate.test(person))
            System.out.println(person);
        }
    }
}
