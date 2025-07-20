package com.rajeev;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class K_PrimeNumberWithSemaphore {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        //here 2 arg is true i.e fair is true so instead of waitinh thread get execution on
        // random it will be on FCFS
        // Semaphore semaphore = new Semaphore(3,true);

        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter n to get the total prime number");
            int n = sc.nextInt();
            if (n == 0)
                break;
            Runnable r = new Runnable() {
                @Override
                public void run() {
                    try {
                        // semaphore.acquire(2);
                        // The above method pass 2 passes permit
                        semaphore.acquire();
                        //alternative of acquire is blow method which npt throw exception
                        // semaphore.acquireUninterruptibly();
                        System.out.println("Now calculated for " + n);
                        int number = PrimeNumberUtil.calculatePrime(n);
                        System.out.println("Total Value =" + number);
                    } catch (InterruptedException e) {
                        System.out.println("Interrupted while acquiring");
                    } finally {
                        semaphore.release();
                    }
                }
            };
            Thread thread = new Thread(r);
            thread.start();
            // sc.close();
        }
    }
}
