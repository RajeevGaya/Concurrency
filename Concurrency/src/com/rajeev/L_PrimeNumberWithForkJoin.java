package com.rajeev;

import java.util.concurrent.ForkJoinPool;

//Accept in input array of number
//Calculate the n'th prime(where n is value of i in the array[i])
//Add all the nth prime 
public class L_PrimeNumberWithForkJoin {

    public void runForkJoinExample() {
        int[] inputNumbers = { 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        CalculatePrimeTask calculatePrimeTask = new CalculatePrimeTask(inputNumbers, 0, inputNumbers.length - 1);
        Integer result = forkJoinPool.invoke(calculatePrimeTask);
        System.out.println("The sum of prime is :- " + result);
    }

    public static void main(String[] args) {
        new L_PrimeNumberWithForkJoin().runForkJoinExample();

    }
}
