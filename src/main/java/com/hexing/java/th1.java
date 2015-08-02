package com.hexing.java;

/**
 * Created by hexing on 15-7-30.
 */
public class th1 extends Thread{
    String s;
    public th1(String s){
        this.s = s;
    }
    public void run(){
        for(int i = 0; i < 10; i++)
            System.out.println(s+"新线程："+i);
    }

    public static void main(String[] args) {
        Thread t = Thread.currentThread();
        th1 t1 = new th1("1");
        th1 t2 = new th1("2");
        th1 t3= new th1("3");
        t1.start();
        t2.start();
        t3.start();
            try {
                t.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        System.out.println("haha");
    }
}
