package com.hexing.Factory;

/**
 * Created by hexing on 15-11-16.
 */
public class Bm1Factory implements BmFactory{
    @Override
    public BM createBm() {
        return new BM1();
    }
}
