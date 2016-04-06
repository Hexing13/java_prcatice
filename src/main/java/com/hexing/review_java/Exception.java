package com.hexing.review_java;

/**
 * Created by hexing on 15-11-18.
 */
public class Exception {
    public static void main(String[] args) {
       try {
           int re = 2/0;
       }catch (ArithmeticException e){
           e.printStackTrace();
       }

        System.out.println("after runtimeexception");
    }
}
