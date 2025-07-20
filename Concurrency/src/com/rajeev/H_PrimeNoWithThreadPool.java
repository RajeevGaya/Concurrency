package com.rajeev;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class H_PrimeNoWithThreadPool {
    public static void main(String[] args) {
        // ExecutorService executorService = Executors.newFixedThreadPool(3);
        // ExecutorService executorService = Executors.newCachedThreadPool();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
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
                    System.out.println(Thread.currentThread().getName()+" Total Value =" + number);
                }
            };
            executorService.execute(r);
        }
    }
}
