package com.rajeev;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Unit1ExeriseSolutionJava7 {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
            new Person("Abhi", "Kumar", 10),
            new Person("Ramesh", "chok", 32),
            new Person("Rajeev", "Ranjan", 30),
            new Person("Divya", "Chinki", 37),
            new Person("Dinesh", "Singh", 45)
        );
        Collections.sort(people, new Comparator<Person>(){
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getLastName().toUpperCase().compareTo(o2.getLastName().toUpperCase());
            }   
        });
        printList(people);
        
        printConditionally(people);
        System.out.println();
        printConditionally(people, new Condition(){
            @Override
            public boolean test(Person p) {
                return p.getLastName().trim().toUpperCase().charAt(0)=='C';
            }  
        });
        System.out.println();
        printConditionally(people, new Condition(){
            @Override
            public boolean test(Person p) {
                return p.getFirstName().trim().startsWith("R");
            }  
        });
        System.out.println();
        printConditionally(people, new Condition(){
            @Override
            public boolean test(Person p) {
                return p.getFirstName().trim().startsWith("R");
            }  
        });
    }
    public static void printList(List<Person> people){
        for (Person person : people) {
            System.out.println(person);
        }
        System.out.println("*******");
    }
    public static void printConditionally(List<Person> people){
        for (Person person : people) {
            if(person.getLastName().trim().toUpperCase().charAt(0)=='C')
            System.out.println(person);
        }
    }
    public static void printConditionally(List<Person> people,Condition condition){
        for (Person person : people) {
            if(condition.test(person))
            System.out.println(person);
        }
    }
}

interface Condition{
    boolean test(Person p);
}