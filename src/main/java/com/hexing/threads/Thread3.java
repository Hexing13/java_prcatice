package com.hexing.threads;

/**
 * Created by hexing on 15-8-4.
 */
class Piao implements Runnable{
    int num = 30;
    @Override
    public synchronized void run() {
        while (true){
            if(num <= 0){
                break;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+ num--);
        }
    }
}
public class Thread3 {
    public static void main(String[] args) {
        Piao piao = new Piao();
        Thread thread1 = new Thread(piao,"线程一");
        Thread thread2 = new Thread(piao,"线程二");
        Thread thread3 = new Thread(piao,"线程三");

        thread1.start();
        thread2.start();
        thread3.start();

        System.out.println("结束！！！");
    }
}
