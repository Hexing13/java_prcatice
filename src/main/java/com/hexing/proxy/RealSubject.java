package com.hexing.proxy;

/**
 * Created by hexing on 16-3-7.
 */
public class RealSubject implements Subject{
    @Override
    public void request() {
        System.out.println("真实角色");
    }
}
