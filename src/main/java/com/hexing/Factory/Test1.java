package com.hexing.Factory;

/**
 * Created by hexing on 15-8-18.
 */
public class Test1 {
    public static void main(String[] args) {
        Vfactory factory = new PlaneFactory();
        Moveable m = factory.creat();
        m.run();
    }
}
