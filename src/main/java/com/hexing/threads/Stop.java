package com.hexing.threads;

/**
 * Created by hexing on 15-8-4.
 */
class Study implements Runnable{
    private boolean flag = true;
    private int i = 1;
    @Override
    public void run() {
        while (flag){
            System.out.println(Thread.currentThread().getName()+"线程。。。"+ i++);
        }
    }

    public void stop(){
        this.flag = false;
    }
}

public class Stop {
    public static void main(String[] args) {
        Study s = new Study();
        Thread t = new Thread(s);
        t.start();
        for(int i = 0; i < 100; i++){
            if(i == 50)
                s.stop();
            System.out.println("main。。。"+i);
        }
    }
}
