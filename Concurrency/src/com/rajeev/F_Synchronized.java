package com.rajeev;

class Counter implements Runnable {
    private int value = 0;

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
        this.increment();
        System.out.println(Thread.currentThread().getName() + "...Inc.." + this.getValue());
        this.decrement();
        System.out.println(Thread.currentThread().getName() + "...Dec.." + this.getValue());
    }
}

public class F_Synchronized {
    public static void main(String[] args) {
        Counter counter = new Counter();
        new Thread(counter, "One").start();
        new Thread(counter, "Two").start();
        new Thread(counter, "Three").start();
        new Thread(counter, "Four").start();
    }
}
