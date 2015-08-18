package com.hexing.proxy;

public class TankTimeProxy implements com.hexing.proxy.MoveAble{
    MoveAble t;
    public TankTimeProxy(MoveAble t){
        super();
        this.t = t;
    }
    @Override
    public void move() {
        long start = System.currentTimeMillis();
        t.move();
        long end = System.currentTimeMillis();
        System.out.println("运行时间："+(end-start));
    }
}
