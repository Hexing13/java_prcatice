package com.hexing.threads;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * Created by hexing on 16-3-12.
 */
class Producer1 implements Runnable
{
    private Queue queue;
    int max;
    String name;
    public Producer1(Queue queue,int max,String name){
        this.queue = queue;
        this.name = name;
        this.max = max;
    }

    @Override
    public void run() {
        while (true){
            synchronized (queue){
                while (max==queue.size()){
                    try {
                        System.out.println("queue is full");
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("queue ia tacked");
                Random random = new Random();
                int i = random.nextInt();
                queue.add(i);
                queue.notifyAll();
            }
        }
    }
}

class Costomer1 implements Runnable
{
    private Queue queue;
    int max;
    String name;
    public Costomer1(Queue queue,int max,String name){
        this.queue = queue;
        this.name = name;
        this.max = max;
    }

    @Override
    public void run() {
        while (true){
            synchronized (queue){
                while (queue.isEmpty()){
                    try {
                        System.out.println("queue is empty");
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("queue has ");
                queue.remove();
                queue.notifyAll();
            }
        }

    }
}

public class ProducerConsumerInJava {
    public static void main(String[] args) throws InterruptedException {
        LinkedList queue = new LinkedList();
        new Thread(new Producer1(queue,10,"producer")).start();
        new Thread(new Costomer1(queue,10,"producer")).start();
    }
}
