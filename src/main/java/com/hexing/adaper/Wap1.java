package com.hexing.adaper;

/**
 * Created by hexing on 15-11-17.
 */
public class Wap1 extends Wrap{
    @Override
    public void sample1() {
        System.out.println("接口适配器");
    }

    public static void main(String[] args) {
        Wrap wrap = new Wap1();
        wrap.sample1();
    }
}
