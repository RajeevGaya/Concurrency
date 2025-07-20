package com.rajeev;

import java.util.Arrays;
import java.util.List;

public class Unit1Exerise {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
            new Person("Abhi", "Kumar", 10),
            new Person("Ramesh", "chok", 32),
            new Person("Rajeev", "Ranjan", 30),
            new Person("Divya", "Chinki", 37),
            new Person("Dinesh", "Singh", 45)
        );
        System.out.println(people);
        //Step 1: Sort by last name
        //Step 2:- create a method that prints all elements in the list
        //Step 3 :- Print the record in which last name beging with c
        
    }
}
