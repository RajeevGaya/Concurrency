package com.rajeev.unit2;

import java.util.function.BiConsumer;

public class ExceptionHandlerEx {
    public static void main(String[] args) {
        int[] someNumbers = { 1, 2, 3, 4 };
        int key = 0;//1
        // process(someNumbers, key, (x, y) -> System.out.println(x + y));
        System.out.println();
        // process(someNumbers, key, (x, y) -> System.out.println(x / y));
        // process(someNumbers, key, (x, y) -> {
        // try {
        // System.out.println(x / y);
        // } catch (Exception e) {
        // e.printStackTrace();
        // }
        // });
        
        process(someNumbers, key, wrapperLambda((v, k) -> System.out.println(v / k)));
        System.out.println("gkjhli");
    }

    // private static void process(int[] someNumbers, int key, BiConsumer<Integer,
    // Integer> consumer) {
    // for (int i : someNumbers) {
    // // try {
    // // consumer.accept(i, key);
    // // } catch (ArithmeticException e) {
    // // e.printStackTrace();
    // // }
    // System.out.println("process");
    // consumer.accept(i, key);
    // }
    // }
    private static void process(int[] someNumbers, int key, BiConsumer<Integer, Integer> consumer) {
        for (int i : someNumbers) {
            consumer.accept(i, key);
        }
    }

    // private static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer,
    // Integer> consumer) {
    // return (v, k) -> {
    // System.out.println("Executing from wrapper");
    // consumer.accept(v, k);
    // };
    // }
    private static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer, Integer> consumer) {
        return (v, k) -> {
            try {
                consumer.accept(v, k);
            } catch (Exception e) {
                System.out.println("Airthmatic Exception caught in wrapper lambda");
            }
        };
    }
}
