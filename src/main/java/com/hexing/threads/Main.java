package com.hexing.threads;

/**
 * Created by hexing on 15-11-2.
 */
class Counter{
    private int c = 0;
    public synchronized void increment(){
        System.out.println(" before increment,c = "+c);
        c++;
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(" after increment,c = "+c);
    }
    public synchronized void decrement(){
        System.out.println(" before decrement,c = "+c);
        c--;
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(" after decrement,c = "+c);

    }
    public int value(){return c;}
}
class ThreadA implements Runnable
{
    private Counter c;
    public ThreadA(Counter c){
        this.c = c;
    }
    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            this.c.increment();
        }
    }
}

class ThreadB implements Runnable
{
    private Counter c;
    public ThreadB(Counter c){
        this.c = c;
    }
    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            this.c.decrement();
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Counter c = new Counter();
        ThreadA a = new ThreadA(c);
        ThreadB b = new ThreadB(c);
        Thread aa = new Thread(a);
        Thread bb = new Thread(b);
        aa.start();
        bb.start();
    }
}
