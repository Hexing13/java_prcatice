package com.hexing.threads;

/**
 * Created by hexing on 15-8-4.
 */
public class Info {
    public static void main(String[] args) throws InterruptedException {
        Study s = new Study();
        Thread t1 = new Thread(s,"IT");
        Study s2 = new Study();
        Thread t2 = new Thread(s2,"IT2");

        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        t2.start();
        Thread.sleep(10);
        s.stop();
        s2.stop();
    }
}
