package com.rajeev.unit2;

public class ClousureExample {
    public static void main(String[] args) {
        int a=20;
        int b=25;
        // b=23;
        //we can't change the value Final concept
        doProcess(a, new Process(){
            @Override
            public void process(int i) {
                System.out.println(i+b+"@");
            }
        });

        doProcess(a, (x)->System.out.println(x+b+4));
        doProcess(a, x->System.out.println(x+b));
    }

    public static void doProcess(int i, Process p){
        p.process(i);
    }
}

interface Process{
  void process(int i);
}