package com.hexing.threads;

/**
 * Created by hexing on 15-8-4.
 */
class Rabbit extends Thread
{
    public void run(){
        for (int i = 1; i< 20; i++)
        System.out.println("兔子：" + i + "步");
    }
}

class Tortoise extends Thread
{
    public void run(){
        for (int i = 1; i< 20; i++)
            System.out.println("乌龟：" + i + "步");
    }
}

public class Thread1 {
    public static void main(String[] args) {
        Rabbit rabbit = new Rabbit();
        Tortoise tortoise = new Tortoise();
        rabbit.start();
        tortoise.start();
        for (int i = 1; i < 30; i++)
            System.out.println("main ==>:" + i + "步");
    }
}
