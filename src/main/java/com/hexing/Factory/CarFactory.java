package com.hexing.Factory;

/**
 * Created by hexing on 15-8-18.
 */
public class CarFactory extends Vfactory{
    @Override
    public Moveable creat() {
        return new Car();
    }
}
