package com.hexing.threads;

/**
 * Created by hexing on 15-8-4.
 */
class Code implements Runnable
{

    @Override
    public void run() {
        for(int i = 1; i < 100; i++)
            System.out.println(Thread.currentThread().getName()+i+"步");
    }
}

public class Thread2 {
    public static void main(String[] args) {
        Code code = new Code();
        new Thread(code,"a").start();
        new Thread(code,"b").start();
        for(int i = 1; i < 100; i++)
            System.out.println(Thread.currentThread().getName()+i+"步");
    }
}
