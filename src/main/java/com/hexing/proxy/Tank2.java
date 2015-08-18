package com.hexing.proxy;

/**
 * Created by hexing on 15-8-17.
 */
public class Tank2 extends Tank{
    @Override
    public void move() {
        long start = System.currentTimeMillis();
        super.move();
        long end = System.currentTimeMillis();
        System.out.println("运行时间："+(end-start));
    }
}
