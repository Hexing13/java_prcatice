package com.hexing.adaper;

/**
 * Created by hexing on 15-11-17.
 */
public class Adaper extends Adaptee implements Target{
    @Override
    public void sample2() {
        System.out.println("目标角色");
    }

    public static void main(String[] args) {
        Target target = new Adaper();
        target.sample1();
        target.sample2();
    }
}
