package com.rajeev;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        int []x = {24,45,719,103,65,203,98};
        int []y= new int[x.length];
       for (int i = 0; i < x.length-1; i++) {
          int temp=x[i]%100;
          int a=temp/10;
        //   System.out.println(temp+".."+(temp/10));
        int index=i;
          for(int j=i+1;j<x.length;j++){
             int temp1=x[j]%100;
             int b=temp1/10;
             if(a==0 && b==0){
                if(x[i]>x[j]){
                   y[i]=x[j];
                }else if(x[i]<x[j]){
                   y[i]=x[i];
                }else{
                  y[i]=x[i];
                }
             }else if(a==0 && b>0){
                y[i]=x[i];
             }else if (a>=0 && b==0) {
                y[i]=x[j];
             }
             
             if(temp == temp1){
                y[i]=x[i];
             }else if(temp>temp1){
                y[i]=x[j];
             }else{
                y[i]=x[i];
             }
             int t1=x[j];
             x[j]=x[i];
             x[i]=t1;
             System.out.println(x[i]+".."+y[i]+"...."+a+"..."+b+".."+temp+".."+temp1+".."+x[i]+".."+x[j]);
          }
       }

       for (int i : y) {
        System.out.println("@"+i);
       }
       System.out.println("..");
       for (int i : x) {
        System.out.println("@"+i);
       }
    }
}
