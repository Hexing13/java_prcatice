package com.hexing.Factory;

/**
 * Created by hexing on 15-11-16.
 */
public class Bm2Factory implements BmFactory{
    @Override
    public BM createBm() {
        return new BM2();
    }
}
