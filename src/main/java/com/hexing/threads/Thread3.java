package com.hexing.threads;

/**
 * Created by hexing on 15-8-4.
 */
class Piao implements Runnable {
    private int num = 20;
    private boolean flag = true;

    @Override
    public void run() {
        while (true) {
          test();
        }
    }

    public void test(){
        synchronized (this){
        if (num <= 0) {
            flag = false;
            return;
        }
        try {
            Thread.sleep(320);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + num--);
        }
    }
}
public class Thread3 {
    public static void main(String[] args) {
        Piao piao = new Piao();
        Thread t1 = new Thread(piao,"黄牛甲");
        Thread t2 = new Thread(piao,"路人乙");
        Thread t3 = new Thread(piao,"工程师");



        t1.start();
        t3.start();
        t2.start();

        System.out.println("结束！！！");
    }
}
