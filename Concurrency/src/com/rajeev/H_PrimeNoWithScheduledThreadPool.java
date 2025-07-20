package com.rajeev;

import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class H_PrimeNoWithScheduledThreadPool {
    public static void main(String[] args) {
        
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
        ScheduledExecutorService scheduledExecutor = Executors.newScheduledThreadPool(1);
        Runnable reporteRunnable= ()->{
            System.out.println("****Running report******");
            System.out.println("Active Threads :- "+executorService.getActiveCount());
            System.out.println("Completed Thread :- "+executorService.getCompletedTaskCount());
            System.out.println("Time "+new Date());
        };
        scheduledExecutor.scheduleAtFixedRate(reporteRunnable, 1, 5, TimeUnit.SECONDS);
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
                    System.out.println(Thread.currentThread().getName() + " Total Value =" + number);
                }
            };
            executorService.execute(r);
           
        }
    }
}
