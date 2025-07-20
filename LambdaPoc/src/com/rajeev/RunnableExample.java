package com.rajeev;

public class RunnableExample {
    public static void main(String[] args) {
        Thread th = new Thread(new Runnable(){
            @Override
            public void run() {
              System.out.println("Printed inside Runnable");
            } 
        });
        th.run();

        Thread lth = new Thread(()->System.out.println("Printed Lambda Runnable"));
        lth.run();
    }
}
