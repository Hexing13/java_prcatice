package com.hexing.decorator;

/**
 * Created by hexing on 15-11-17.
 */
public class Source implements Sourceable{
    @Override
    public void method() {
        System.out.println("被装饰");
    }
}
