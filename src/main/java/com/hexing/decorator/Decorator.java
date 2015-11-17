package com.hexing.decorator;

/**
 * Created by hexing on 15-11-17.
 */
public class Decorator implements Sourceable{
    private Sourceable source;
    public Decorator(Sourceable source){
        this.source = source;
    }
    @Override
    public void method() {
        System.out.println("装饰前");
        source.method();
        System.out.println("装饰后");
    }

    public static void main(String[] args) {
        Sourceable sourceable = new Source();
        Sourceable sourceable1 = new Decorator(sourceable);
        sourceable1.method();
    }
}
