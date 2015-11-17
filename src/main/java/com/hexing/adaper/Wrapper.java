package com.hexing.adaper;

/**
 * Created by hexing on 15-11-17.
 */
public class Wrapper implements Target{
    private Adaptee adaptee;

    public Wrapper(Adaptee adaptee){
        this.adaptee = adaptee;
    }

    @Override
    public void sample1() {
        this.adaptee.sample1();
    }

    @Override
    public void sample2() {
        System.out.println("对象适配器");
    }

    public static void main(String[] args) {
        Adaptee adaptee1 = new Adaptee();
        Target target = new Wrapper(adaptee1);
        target.sample1();
        target.sample2();
    }
}
