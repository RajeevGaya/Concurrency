package com.rajeev;

public class TypeInferenceExample {
    public static void main(String[] args) {
        // StringLengthLambda x =(String s)->s.length();
        // StringLengthLambda x =(s)->s.length();
        StringLengthLambda x =s->s.length();
        System.out.println(x.getLength("Rajeev"));
        printLambda(x, "Rajeev Ranjan");
        String s1="Rajeev Ranjan";
        printLambda(s12->s12.length());
        printLambda(s12->s12.length(),s1);

    }
    public static void printLambda(StringLengthLambda l,String str){
        System.out.println(l.getLength(str));
    }
    public static void printLambda(StringLengthLambda l){
        System.out.println(l.getLength("Rajeev Ranjan Singh"));
    }
}
interface StringLengthLambda{
    int getLength(String s);
}
