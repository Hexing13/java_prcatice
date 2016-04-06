package com.hexing.review_java;

/**
 * Created by hexing on 15-11-20.
 */
abstract class P{
    public abstract void eat();
}

public class Classes {
    public static void main(String[] args) {
        P p = new P(){
            @Override
            public void eat() {
                System.out.println("eat");
            }
        };
        p.eat();
    }
}
