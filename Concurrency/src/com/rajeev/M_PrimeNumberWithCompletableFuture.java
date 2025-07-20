package com.rajeev;

import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class M_PrimeNumberWithCompletableFuture {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter n to get the total prime number");
            int n = sc.nextInt();
            if (n == 0)
                break;
            // CompletableFuture.supplyAsync(() -> "hello").thenAccept((String s) ->
            // System.out.println(s));
            // CompletableFuture.supplyAsync(() -> PrimeNumberUtil.calculatePrime(n))
            // .thenAccept((Integer retValue) -> System.out.println(retValue));
            // CompletableFuture.supplyAsync(() -> PrimeNumberUtil.calculatePrime(n))
            // .thenAccept(System.out::println);
            CompletableFuture.supplyAsync(() -> PrimeNumberUtil.calculatePrime(n), executorService)
                    .thenAccept(System.out::println);
        }
    }
}
