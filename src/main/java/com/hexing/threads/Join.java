package com.hexing.threads;

/**
 * Created by hexing on 15-8-4.
 */
class S implements Runnable{
    int i = 1;
    @Override
    public void run() {
        for(int i = 1; i < 500; i++)
            System.out.println("join..."+i);
    }
}

public class Join {
    public static void main(String[] args) throws InterruptedException {
        S s = new S();
        Thread t = new Thread(s);
        t.start();

        for(int i = 1; i < 1000;i++){
            if(i == 50)
                t.join();
            System.out.println("main..."+i);
        }

    }
}
