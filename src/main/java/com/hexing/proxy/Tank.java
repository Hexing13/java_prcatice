package com.hexing.proxy;

/**
 * Created by hexing on 15-8-17.
 */
public class Tank implements MoveAble{
    @Override
    public void move() {
        System.out.println("坦克在移动...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
