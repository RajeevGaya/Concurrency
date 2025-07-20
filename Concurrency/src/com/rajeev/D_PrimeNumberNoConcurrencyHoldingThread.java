package com.rajeev;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class D_PrimeNumberNoConcurrencyHoldingThread {
    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();

        Runnable statusReporter = () -> {
            try {

                while (true) {
                    Thread.sleep(5000);
                    printThread(threads);
                }
            } catch (InterruptedException e) {
                System.out.println("Interrupt");
            }
        };
        Thread reporterThread = new Thread(statusReporter);
        reporterThread.start();
        while (true) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            // if (n == 0) {
            // reporterThread.interrupt();
            // break;
            // }
            if (n == 0) {
                System.out.println("Waiting for all thread to finish");
                try {
                    waitForThreads(threads);
                    System.out.println("Done ! " + threads.size() + " Primes calculated");
                } catch (InterruptedException e) {
                    System.out.println("Got interrupt when eaiting for thread");
                }
                break;
            }
            Runnable r = new Runnable() {
                @Override
                public void run() {
                    int number = PrimeNumberUtil.calculatePrime(n);
                    System.out.println("Result = " + number);
                }
            };
            Thread thread = new Thread(r);
            threads.add(thread);
            thread.setDaemon(true);
            thread.start();
        }
    }

    private static void printThread(List<Thread> threads) {
        System.out.println("Thread Status " + threads.size());
        // threads.forEach(t -> {
        // System.out.println(t.getState());
        // });
        threads.forEach(thread -> {
            System.out.println(
                    thread.getId() + ".." + thread.getName() + ".." + thread.getPriority() + ".." + thread.getState()
                            + ".." + thread.isDaemon() + ".." + thread.getThreadGroup() + ".." + thread.isAlive());
        });
    }

    public static void waitForThreads(List<Thread> threads) throws InterruptedException {
        for (Thread thread : threads) {
            thread.join();
        }
    }
}
