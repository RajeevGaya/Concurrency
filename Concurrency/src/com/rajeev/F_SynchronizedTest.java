package com.rajeev;

class Counter1 implements Runnable {
    private int value = 0;
    private Integer i = 10;

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
        // synchronized (i) {
        synchronized (i) {
            this.increment();
            System.out.println(Thread.currentThread().getName() + "...Inc.." + this.getValue());
            this.decrement();
            System.out.println(Thread.currentThread().getName() + "...Dec.." + this.getValue());
        }
    }
}

// syncro block
/*
 * 1. Thread tries to get access to the monitor lock 2. if thread get it, it
 * executes the block 3. Release the monitor lock when exiting the block 4.Any
 * other thread need to wait( can't get monitor lock)
 */
public class F_SynchronizedTest {
    public static void main(String[] args) {
        Counter1 counter = new Counter1();
        new Thread(counter, "One").start();
        new Thread(counter, "Two").start();
        new Thread(counter, "Three").start();
        new Thread(counter, "Four").start();
        Counter1 counter2 = new Counter1();
        new Thread(counter2, "Counter 2 ").start();
    }
}
