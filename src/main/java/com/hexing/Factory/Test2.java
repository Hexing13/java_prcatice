package com.hexing.Factory;

/**
 * Created by hexing on 15-11-16.
 */
public class Test2 {
    public static void main(String[] args) {
        BmFactory factory = new Bm1Factory();
        BM bm1 = factory.createBm();
        bm1.create();
    }
}
