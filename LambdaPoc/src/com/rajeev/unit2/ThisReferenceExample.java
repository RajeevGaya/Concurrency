package com.rajeev.unit2;

public class ThisReferenceExample {
    public void doProcess(int i, Process p) {
        p.process(i);
    }
    
    public void execute(){
        doProcess(10, new Process(){
            @Override
            public void process(int i) {
              System.out.println("Value of i = "+i);
              System.out.println(this);
              //here this is reference to instance that we have ctretae referenceExample
              //so it will work
            }  
            public String toString(){
                return "Execute inner classs tostring";
            }
        });
    }
    public static void main(String[] args) {
        ThisReferenceExample referenceExample = new ThisReferenceExample();
        referenceExample.execute();
        // referenceExample.doProcess(10, i -> {
        //     System.out.println("Value of i = " + i);
        //     // System.out.println(this);//Here if we use lambda then this keuyword will use
        //     // as outer class
        //     // instead of inner class, so inner method is main i.e static and in static we
        //     // can;t use this
        // });
        // referenceExample.doProcess(10, new Process(){
        // @Override
        // public void process(int i) {
        // System.out.println("Value of i ="+i);
        // System.out.println(this);
        // }
        // public String toString(){
        // return "This is anonymonpous inner class";
        // }
        // });
        
    }

    @Override
    public String toString() {
        return "ThisReferenceExample []";
    }
}
