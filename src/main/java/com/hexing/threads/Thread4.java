package com.hexing.threads;

/**
 * Created by hexing on 15-8-4.
 */
class Piao1 implements Runnable {
    private int i = 0;
    @Override
    public void run() {
        synchronized (this){
            System.out.println(Thread.currentThread().getName()+i++);

        }
    }
}

public class Thread4 {
    public static void main(String[] args) {
        Piao1 piao1 = new Piao1();
        Thread t1 = new Thread(piao1,"黄牛甲");
        Thread t2 = new Thread(piao1,"路人乙");
        Thread t3 = new Thread(piao1,"工程师");

        t1.start();
        t3.start();
        t2.start();
    }
}
