package com.hexing.proxy;

/**
 * Created by hexing on 15-8-17.
 */
public class TankLogProxy implements MoveAble{
    MoveAble t;
    public TankLogProxy(MoveAble t){
        this.t = t;
    }
    @Override
    public void move() {
        System.out.println("开始...");
        t.move();
        System.out.println("结束...");
    }
}
