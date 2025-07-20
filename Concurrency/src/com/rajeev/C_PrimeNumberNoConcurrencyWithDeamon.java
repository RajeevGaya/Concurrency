package com.rajeev;

import java.util.Scanner;

public class C_PrimeNumberNoConcurrencyWithDeamon {
    public static void main(String[] args) {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter n to get the total prime number");
            int n = sc.nextInt();
            if (n == 0)
                break;
            Runnable r = new Runnable() {
                @Override
                public void run() {
                    int number = PrimeNumberUtil.calculatePrime(n);
                    System.out.println("Total Value =" + number);
                }
            };
            Thread thread = new Thread(r);
            thread.setDaemon(true);
            thread.start();
            // sc.close();
        }
    }
}
