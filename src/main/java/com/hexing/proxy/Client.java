package com.hexing.proxy;

/**
 * Created by hexing on 15-8-17.
 */
public class Client {
    public static void main(String[] args) {
        MoveAble m = (MoveAble) Proxy.newProxyInstance(MoveAble.class);
        m.move();
    }
}
