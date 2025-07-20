package com.rajeev;

public class Greeter {
    // public void greet() {
    // System.out.println("Hello World!");
    // }
    public void greet(Greeting greeting) {
        greeting.perform();
    }

    public static void main(String[] args) {
        Greeter greeter = new Greeter();
        // greeter.greet();
        // HelloWorldGreeting helloWorldGreeting = new HelloWorldGreeting();
        // greeter.greet(helloWorldGreeting);
        // myLambda lambda=()->System.out.println("Hello");
        Greeting helloWorldGreeting  = new HelloWorldGreeting();
        Greeting gr1=()->System.out.println("Hello Rajeev");
        gr1.perform();
        Greeting innerGreeing = new Greeting(){
            @Override
            public void perform() {
               System.out.println("Inner or nyonomonous Greeting ");
            }   
        };
        innerGreeing.perform();
        greeter.greet(innerGreeing);
        greeter.greet(helloWorldGreeting);
        myLambda lambda=()->"Hello";
        System.out.println(lambda);
        add myAdd = (x,y)->x+y;
        System.out.println(myAdd);
        // Greeting gr1=()->System.out.println("Rajeev");
    }
}
/** 
 * Here We have declared 2 method so it not be functional interface
 * functional interface is that which has obly method
**/
interface myLambda{
//    public void foo();
   public String foo1();
}
interface add{
    public int sum(int a,int b);
}