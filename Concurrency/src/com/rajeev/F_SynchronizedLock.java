package com.rajeev;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Counter3 implements Runnable {
    private int value = 0;
    private Lock lock = new ReentrantLock();

    public void increment() {
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        value++;
    }

    public void decrement() {
        value--;
    }

    public int getValue() {
        return value;
    }

    @Override
    public void run() {
        // acquire a lock
        // lock.lock();
        // this.increment();
        // System.out.println(Thread.currentThread().getName() + "...Inc.." +
        // this.getValue());
        // this.decrement();
        // System.out.println(Thread.currentThread().getName() + "...Dec.." +
        // this.getValue());
        // lock.unlock();
        // release a lock
        try {
            lock.lock();
            this.increment();
            System.out.println(Thread.currentThread().getName() + "...Inc.." + this.getValue());
            this.decrement();
            System.out.println(Thread.currentThread().getName() + "...Dec.." + this.getValue());
        } finally {
            lock.unlock();
        }

    }
}

public class F_SynchronizedLock {
    public static void main(String[] args) {
        Counter3 counter = new Counter3();
        new Thread(counter, "One").start();
        new Thread(counter, "Two").start();
        new Thread(counter, "Three").start();
        new Thread(counter, "Four").start();
        Counter3 counter2 = new Counter3();
        new Thread(counter2, "Conter 2 Instance").start();
    }
}
