package com.rajeev;

import java.util.concurrent.RecursiveTask;

public class CalculatePrimeTask extends RecursiveTask<Integer> {
    int[] array;
    int start;
    int end;

    public CalculatePrimeTask(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    public CalculatePrimeTask() {
    }

    @Override
    protected Integer compute() {
        if (start == end) {
            System.out.println(array[start]+"A:"+PrimeNumberUtil.calculatePrime(array[start]));
            return PrimeNumberUtil.calculatePrime(array[start]);
        }
        if (end - start == 1) {
            System.out.println(array[start]+"B:"+PrimeNumberUtil.calculatePrime(array[start]));
            System.out.println(array[end]+"C:"+PrimeNumberUtil.calculatePrime(array[end]));
            return PrimeNumberUtil.calculatePrime(array[start]) + PrimeNumberUtil.calculatePrime(array[end]);
        }
        int mid = (start + end) / 2;
        System.out.println("abh");
        CalculatePrimeTask subTask1 = new CalculatePrimeTask(array, start, mid);
        CalculatePrimeTask subTask2 = new CalculatePrimeTask(array, mid + 1, end);
        invokeAll(subTask1, subTask2);
        return subTask1.join() + subTask2.join();
    }

}
