package com.hexing.java;

/**
 * Created by hexing on 16-3-12.
 */
public class Try {
    public static void main(String[] args) {
        try {
            System.out.println("try");
            System.exit(0);
        }catch (Exception e){
            System.out.println("catch");
        }finally {
            System.out.println("finally");
        }
    }
}
