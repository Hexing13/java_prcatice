package com.hexing.threads;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by hexing on 16-3-12.
 */
class Producer implements Runnable
{
    BlockingQueue sharedQueue = null;

    public Producer(BlockingQueue sharedQueue){
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10;i++){
            try {
                System.out.println("生产"+i);
                sharedQueue.put(i);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Costomer implements Runnable
{
    BlockingQueue sharedQueue = null;

    public Costomer(BlockingQueue sharedQueue){
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        try {
            while (true){
                System.out.println("消费"+sharedQueue.take());
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ProducerConsumerPattern {
    public static void main(String[] args) {
        BlockingQueue sharedQueue = new LinkedBlockingQueue();
        new Thread(new Producer(sharedQueue)).start();
        new Thread(new Costomer(sharedQueue)).start();
    }
}
