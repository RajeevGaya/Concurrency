package com.rajeev;

import java.time.Duration;
import java.util.Date;

public class PrimeNumberUtil {

    public static int calculatePrime(int n) {
        int number;
        int numberOfPrimesFound;
        int i;
        number = 1;
        numberOfPrimesFound = 0;
        Date date = new Date();

        while (numberOfPrimesFound < n) {
            number++;
            for (i = 2; i <= number && number % i != 0; i++) {
            }
            if (i == number) {
                numberOfPrimesFound++;
            }
        }
  
        System.out.println(((new Date().getTime()-date.getTime())/1000)+" second");
        return number;
    }
}
