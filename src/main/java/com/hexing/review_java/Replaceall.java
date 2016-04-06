package com.hexing.review_java;

/**
 * Created by hexing on 16-3-30.
 */
public class Replaceall {
    public static void main(String[] args) {
        float f = (float) 31.1;
        String str = "Hello__world____are__you_ok";
        str = str.replaceAll("[_]+","_");
        System.out.println(str);
    }
}
