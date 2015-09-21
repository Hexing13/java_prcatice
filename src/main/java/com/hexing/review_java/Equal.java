package com.hexing.review_java;

/**
 * Created by hexing on 15-9-14.
 */
public class Equal {
    public static void main(String[] args) {
        Long a1 = Long.parseLong("100");
        Long a2 = Long.parseLong("100");
        System.out.println( a1 == a2);

        Long b1 = Long.parseLong("200");
        Long b2 = Long.parseLong("200");
        System.out.println( b1 == b2);
    }
}
