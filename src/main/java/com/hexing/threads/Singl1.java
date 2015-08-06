package com.hexing.threads;

/**
 * Created by hexing on 15-8-5.
 */
class Jvm1{
    private Jvm1(){}
    private static class J2
    {
        private static Jvm1 j1 = new Jvm1();
    }
    public static Jvm1 getJ1() {
        return J2.j1;
    }
}

public class Singl1 {
    public static void main(String[] args) {
        System.out.println(Jvm1.getJ1());
    }
}
