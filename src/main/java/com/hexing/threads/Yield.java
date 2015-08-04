package com.hexing.threads;

/**
 * Created by hexing on 15-8-4.
 */

class Y implements Runnable{
    int i = 1;
    @Override
    public void run() {
        for(int i = 1; i < 500; i++)
            System.out.println("join..."+i);
    }
}

public class Yield {

    public static void main(String[] args) {
        Y y = new Y();
        Thread t = new Thread(y);
        t.start();

        for(int i = 1; i < 1000;i++){
            if(i % 2 == 0)
                Thread.yield();
            System.out.println("main..."+i);
        }

    }
}