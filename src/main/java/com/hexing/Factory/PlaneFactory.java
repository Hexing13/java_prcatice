package com.hexing.Factory;

/**
 * Created by hexing on 15-8-18.
 */
public class PlaneFactory extends Vfactory{
    @Override
    public Moveable creat() {
        return new Plane();
    }
}
