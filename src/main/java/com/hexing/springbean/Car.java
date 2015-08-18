package com.hexing.springbean;

/**
 * Created by hexing on 15-8-18.
 */
public class Car implements Moveable{
    @Override
    public void run(){
        System.out.println("冒着烟跑ing...");
    }
}
