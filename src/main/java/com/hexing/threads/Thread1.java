package com.hexing.threads;

/**
 * Created by hexing on 15-8-4.
 */

class tuzi extends Thread{
    public tuzi(String name){
        super(name);
    }
    public void run(){
        for(int i = 1; i < 20;i++){
            System.out.println(Thread.currentThread().getName()+i+"步");
        }
    }
}

//class wugui extends Thread{
//    public wugui(String name){
//        super(name);
//    }
//    public void run(){
//        for(int i = 1; i < 20;i++){
//            System.out.println(Thread.currentThread().getName()+i+"步");
//        }
//    }
//}

public class Thread1 {
    public static void main(String[] args) {
        new tuzi("兔子1").start();
        new tuzi("兔子2").start();
        for(int i = 1; i < 20;i++){
            System.out.println(Thread.currentThread().getName()+i+"步");
        }
    }
}
