package com.rajeev;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class I_CallableExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Printed from runnable");
            }
        };

        Callable<String> c = new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("Printed from Callable");
                Thread.sleep(2000);
                return "value from Callable";
            }
        };

        // new Thread(c);
        //this was not , to run callable we have to use Exector service
        ExecutorService service = Executors.newFixedThreadPool(1);
        //submit work for both callable as well runnable
        // service.submit(c);
        Future<String> ret = service.submit(c);
        System.out.println("These things in the main thread");
        System.out.println("Exdecuting more thread in the main thread before returing callable");
        String value=ret.get();
        System.out.println(value);
        
    }
}
