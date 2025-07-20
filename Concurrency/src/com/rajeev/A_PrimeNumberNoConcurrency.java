package com.rajeev;

import java.util.Scanner;

public class A_PrimeNumberNoConcurrency {
    public static void main(String[] args) {
        int number;
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter n to get the total prime number");
            int n = sc.nextInt();
            if (n == 0)
                break;
            number = PrimeNumberUtil.calculatePrime(n);
            System.out.println("Total Value =" + number);
            // sc.close();
        }
    }
}
