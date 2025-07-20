package com.rajeev.unit3;

public class MethodRefEx {
    public static void main(String[] args) {
        // Thread t = new Thread(()->printMessage());
        Thread t = new Thread(MethodRefEx::printMessage);//()-<method
        t.start();
    }
    public static void printMessage(){
        System.out.println("Hello");
    }
}
